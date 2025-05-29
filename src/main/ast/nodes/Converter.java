package main.ast.nodes;

import java.util.Stack;

public class Converter {
    public Converter() {}

    private int CountSpaces(String line) {
        int count = 0;

        while (count < line.length() && line.charAt(count) == ' ')
            count++;

        return count;
    }

    private String RightTrim(String line) {
        int i = line.length() - 1;

        while (i >= 0 && Character.isWhitespace(line.charAt(i)))
            i--;

        return line.substring(0, i + 1);
    }

    private String DeleteComment(String input) {
        StringBuilder output = new StringBuilder();
        boolean inBlockComment = false;

        String[] lines = input.split("\n");
        for (String line : lines) {
            String originalLine = line;

            if (inBlockComment) {
                output.append("\n");
                if (line.contains("*/")) {
                    inBlockComment = false;
                }
                continue;
            }

            int blockStart = line.indexOf("/*");
            int blockEnd = line.indexOf("*/");
            int lineComment = line.indexOf("//");

            if (blockStart != -1 && (blockEnd == -1 || blockEnd < blockStart)) {
                String before = line.substring(0, blockStart);
                if (!before.isBlank()) {
                    output.append(before).append("\n");
                } else {
                    output.append("\n");
                }
                inBlockComment = true;
                continue;
            }

            if (blockStart != -1 && blockEnd > blockStart) {
                String before = line.substring(0, blockStart);
                output.append(before).append("\n");
                continue;
            }

            if (lineComment != -1) {
                String before = line.substring(0, lineComment);
                output.append(before).append("\n");
                continue;
            }

            output.append(originalLine).append("\n");
        }

        return output.toString();
    }

    public String ConvertCPY(String input) {
        StringBuilder output = new StringBuilder();
        String[] lines = DeleteComment(input).split("\n");

        Stack<Integer> indentStack = new Stack<>();
        indentStack.push(0);

        for (String line : lines) {
            String trimmed = RightTrim(line);

            if (trimmed.isEmpty()) {
                output.append("\n");
                continue;
            }

            int currentIndent = CountSpaces(line);

            while ((currentIndent < indentStack.peek()) && (indentStack.size() > 2)) {
                output.append("}");
                indentStack.pop();
            }

            if (trimmed.equals("end")) {
                output.append("}\n");
                indentStack.clear();
                indentStack.push(0);
                continue;
            }

            if (trimmed.endsWith(":")) {
                String withoutColon = trimmed.substring(0, trimmed.length() - 1);
                output.append(withoutColon).append(" {\n");
                indentStack.push(currentIndent + 4);
            }
            else
                output.append(trimmed).append(";\n");
        }

        return output.toString();
    }
}