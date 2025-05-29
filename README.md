# C-Python Language Compiler

This project implements the **frontend of a compiler** for a C-Python-like language using Java. It includes a full-featured Abstract Syntax Tree (AST), grammar and parsing modules, semantic analysis via visitor pattern, and a robust symbol table implementation. This project was developed in two major phases.

---

## Phase 1 – Abstract Syntax Tree (AST) Construction

### Highlights:
- AST structure with inheritance and polymorphism for expressions, statements, declarations, etc.
- Covers all major C constructs: functions, loops, conditionals, arrays, pointers, typedefs, casts, etc.
- Nodes are grouped by category:
  - `expr/` – Expression types: unary, binary, function calls, literals
  - `node/` – Declarations, specifiers, parameters, designators
  - `stmt/` – Statement nodes including loops and jumps
- Implements a full AST builder for parsed grammar.

---

## Phase 2 – Semantic Analysis

### Core Features:
- **Visitor-based semantic pass** to analyze and transform the AST.
- Implements:
  - `NameAnalyzer` – Ensures all identifiers are declared before use.
  - `UnusedRemover` – Removes unused declarations from the AST.
  - `AfterReturnRemover` – Removes unreachable code after return statements.
  - `NoSideEffectRemover` – Detects and removes expressions with no side effects.
- **Symbol Table** with support for scoping, item resolution, and error handling:
  - `FunctionDefinitionSymbolTableItem`, `VariableDeclarationSymbolTableItem`, etc.
  - Custom exceptions for duplicate declarations and undeclared usage.

## 🛠️ Build & Run

1. Make sure Java is installed.
2. Use an IDE like IntelliJ or Eclipse to import the project.
3. Run `SimpleLang.java` with sample C code as input.

---

> Developed as part of the **Compiler Design Course**  
> Department of Electrical and Computer Engineering – University of Tehran  
> Fall 1403