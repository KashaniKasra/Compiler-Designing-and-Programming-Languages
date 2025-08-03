# Phase 2 - Name Analysis & Optimizations for CPY Language

This is the second phase of the CPY compiler project. It builds upon Phase 1 by implementing name analysis (symbol table generation and validation) and applying essential code optimizations.

---

## Project Structure

```
Phase 2/
├── src/
│   ├── main/
│   │   ├── ast/nodes/         → AST Nodes (from Phase 1)
│   │   ├── grammar/           → ANTLR Grammar
│   │   └── visitor/           → NameAnalyzer & Optimization Visitors
├── tests/                     → CPY test programs
└── utilities/                 → ANTLR tool
```

---

## Name Analysis

Implemented in the `NameAnalyzer` class using the visitor pattern:

- Tracks all variable and function declarations.
- Detects **undeclared variable usage**:
  ```
  Line:<LineNumber> -> <Variable> not declared
  ```
- Detects **undeclared function calls**:
  ```
  Line:<LineNumber> -> <Function> not declared
  ```
- Built-in functions like `printf` and `scanf` are **not reported** as undeclared.

---

## Optimizations (applied after name analysis)

Optimizations are implemented in a separate visitor. They include:

1. **Unused Variables and Parameters**
   - Removes variables/params never used after declaration.
   - Function signatures and all call-sites are updated accordingly.

2. **Dead Code After `return`**
   - Statements after a `return` inside a block are eliminated.

3. **Side-Effect-Free Statements**
   - Removes computations that do not affect output or state.

4. **Multiple Assignments**
   - If a variable is reassigned multiple times and earlier values are unused, only the last one is kept.

5. **`typedef` and Constant Replacement**
   - Replaces typedefs and constants with their actual types/values to simplify analysis and reduce abstraction.

---

## Reachability Analysis

- Only code reachable from the `main` function is retained in the final output.
- Any function or code not transitively reachable from `main` is eliminated.

---

## 🧪 Testing Guidelines

- All `.cpy` files in the `tests/` directory are valid CPY test cases.
- Outputs are automatically verified.
- Name analysis errors are printed directly.
- Optimizations must be reflected in the output.
- Whitespaces or shifted lines in the output are ignored in final grading.

---

## 🛠 How to Run

```bash
java -jar utilities/antlr-4.13.1-complete.jar -visitor -no-listener grammar/SimpleLang.g4
javac -cp utilities/antlr-4.13.1-complete.jar:. src/SimpleLang.java
java -cp utilities/antlr-4.13.1-complete.jar:. SimpleLang tests/your_test_file.cpy
```

---