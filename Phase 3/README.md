# Phase 3 - Type Checking & Vulnerability Analysis for CPY Language

This is the third and final phase of the CPY compiler project. It focuses on detecting **type errors** and **vulnerabilities** during static analysis using the AST generated in earlier phases.

---

## Project Structure

```
Phase 3/
├── src/
│   ├── main/
│   │   ├── ast/nodes/          → AST Node Classes
│   │   ├── grammar/            → ANTLR Grammar
│   │   └── visitor/            → TypeChecker & VulnAnalysis visitors
├── tests/                      → CPY test programs
└── utilities/                  → ANTLR tool
```

---

## Vulnerability Analysis

Implemented in `VulnAnalysis` visitor:

1. **Memory Leak**:
   - Detects memory allocated using `malloc` that is never freed using `free`.

2. **Uninitialized Variable Use**:
   - Identifies variables used before being assigned a value.

---

## Type Checking

Implemented in `TypeChecker` visitor:

1. **Argument Type Mismatch**:
   - Function argument types do not match parameter types.
   - Example: Passing a string to a function expecting an `int`.

2. **Non-Same Operand Types**:
   - Both operands of binary operations (e.g., `+`, `-`) must have the same type.
   - Example: `int + string` is invalid.

3. **Return Type Mismatch**:
   - Return value type must match the declared return type of the function.

---

## Error Reporting Format

All detected errors are stored in a `typeErrors` array and printed in the following format:

```text
Line:<LineNumber> -> <ErrorType>: <Details>
```

---

## How to Run

```bash
java -jar utilities/antlr-4.13.1-complete.jar -visitor -no-listener grammar/SimpleLang.g4
javac -cp utilities/antlr-4.13.1-complete.jar:. src/SimpleLang.java
java -cp utilities/antlr-4.13.1-complete.jar:. SimpleLang tests/your_test_file.cpy
```

---

## Notes

- Built-in functions like `printf`, `scanf`, etc. are **excluded** from undeclared checks.
- VulnAnalysis is only required for Computer Engineering students.
- The final implementation must combine results from:
  - Name analysis (Phase 2)
  - Optimizations (Phase 2)
  - Type analysis (Phase 3)
  - Vulnerability detection (Phase 3)

---