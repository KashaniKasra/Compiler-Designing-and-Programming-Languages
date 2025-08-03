# CPY Compiler Project - Full Overview

This project implements a complete compiler for the **CPY language**, developed over three main phases. Each phase incrementally builds toward a full-featured static analysis tool using ANTLR and Java.

---

## Phases Summary

### Phase 1: AST Construction
- Builds the **Abstract Syntax Tree (AST)** from CPY source code.
- Grammar is defined using **ANTLR4** with embedded Java actions.
- All syntactic constructs (functions, loops, expressions, etc.) are converted into structured AST nodes.
- Implements:
  - AST node hierarchy
  - Grammar with AST generation
  - Visitor pattern
  - Statement counting per scope
  - Expression depth calculation


---

### Phase 2: Name Analysis & Optimization
- Implements a **symbol table** and **scoping rules** for variable/function declaration checks.
- Applies several **code optimizations**, including:
  - Dead code elimination
  - Unused variable/parameter removal
  - Simplification of multiple assignments
  - Constant inlining
- Includes **reachability analysis** to retain only code reachable from `main()`.


---

### Phase 3: Type Checking & Vulnerability Analysis
- Performs **static type checking**:
  - Argument type mismatch
  - Operand type mismatch in expressions
  - Return type mismatch
- Implements **vulnerability detection**:
  - Memory leaks (unfreed malloc)
  - Uninitialized variable usage


---

## Technologies Used

- Language: **Java**
- Grammar Tool: **ANTLR 4**
- Build: Manual compilation & execution
- Design: **Visitor Pattern** for all traversals

---

## How to Run

```bash
# Generate ANTLR classes
java -jar utilities/antlr-4.13.1-complete.jar -visitor -no-listener grammar/SimpleLang.g4

# Compile Java files
javac -cp utilities/antlr-4.13.1-complete.jar:. src/SimpleLang.java

# Run a sample test case
java -cp utilities/antlr-4.13.1-complete.jar:. SimpleLang tests/sample.cpy
```

---

## Developer

Kasra Kashani  
Compiler Design - University of Tehran  
Spring 1404