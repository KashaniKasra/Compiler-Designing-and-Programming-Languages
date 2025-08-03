# Phase 1 - AST Construction for CPY Language

This is the first phase of the compiler project for the CPY programming language. The objective of this phase is to construct an Abstract Syntax Tree (AST) from CPY source code to enable further evaluation and code generation in later stages.

---

## Project Structure

```
Phase 1/
├── src/
│   ├── main/
│   │   ├── ast/nodes/         → AST node definitions
│   │   ├── grammar/           → CPY language grammar using ANTLR
│   │   └── visitor/           → Visitor pattern implementation
│   └── SimpleLang.java        → Main class to run the compiler
├── tests/                     → CPY test cases for AST validation
└── utilities/                 → ANTLR tool
```

---

## Key Components

### 1. AST Node Definitions
Each syntactic construct in CPY (expressions, statements, loops, etc.) is defined as a separate class in `ast/nodes/`, with all nodes inheriting from a base class such as `Node`, `Expression`, or `Statement`.

### 2. ANTLR Grammar
The `SimpleLang.g4` file defines the grammar of CPY. Java actions are embedded to generate corresponding AST nodes during parsing.

### 3. Visitor Pattern
The visitor classes `Visitor` and `TestVisitor` are used to traverse the AST and implement semantic evaluation logic such as statement counting and expression depth analysis.

---

## Features Implemented

- [x] Complete AST class hierarchy
- [x] ANTLR grammar rules extended to build AST nodes
- [x] Counting number of statements per scope
- [x] Computing expression tree depth
- [x] Printing outputs in the required format

---

## Test Cases

The `tests/` directory includes 11 `.cpy` files that cover:

- Function and variable declarations
- Loops (`for`, `while`)
- Conditional statements (`if`, `else`)
- Binary and unary expressions
- Nested scopes and blocks

---

## How to Run

Compile the ANTLR grammar and run the compiler:

```bash
java -jar utilities/antlr-4.13.1-complete.jar -visitor -no-listener grammar/SimpleLang.g4
javac -cp utilities/antlr-4.13.1-complete.jar:. src/SimpleLang.java
java -cp utilities/antlr-4.13.1-complete.jar:. SimpleLang tests/01-func.cpy
```

---

## Important Notes

- Follow PEP8 indentation (4 spaces)
- Use `end` instead of `{}` for ending blocks
- Each statement ends with a newline instead of `;`
- Output must match sample outputs **exactly** (auto-graded)

---