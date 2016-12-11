# Lecture 1.1. Programming Paradigms

Programming paradigm = concept + patterns

Main programming paradigms:
- imperative (most common)
- functional (new and fancy)
- logic (not well-known)

Object-oriented programming "paradigm" is orthogonal to these three main paradigms. It can be used in all three cases.

Imperative paradigm:
- modifications of mutable variables
- assignments to variables
- control structures (if-else, loops, break, continue, return, etc)

Imperative programs are like instruction sequences in Von Neumann's computer:
- mutable variables ~ memory cells
- variable dereferences ~ load instructions
- variable assignments ~ store instructions
- control structures ~ jumps

Reference: John Backus, Can programming be librated from the Von Neumann style?, Turing Award Lecture 1978

Problem: imperative paradigm doesn't scales up (Von Neumann bottleneck)
Solution:
- avoid conceptualizing programs and data structures word by word
- high-level abstractions (e.g. collections, polynomials, geometric shapes, strings, documents, etc)
- develop theories of high-level abstractions

Theory consists of:
- data types
- operations of these data types
- laws describing relationships between values and operations

Theories shouldn't describe mutations:
- mathematical theories don't do that
- programming theories unfortunately can do that

Problem: programming theories mutations
Solution:
- theories for operators as functions
- abstract and compose functions

Functional programming:
- in restricted sense:
  + programming without variables, assignments, control structures
  + examples: Haskell
- in wider sense:
  + focus on functions (as first-class citizens)
  + functions can be values that are produced, consumed and composed
  + examples: Scala

Functions as first-class citizens:
  - functions can be defined anywhere, including inside other functions
- they can be passed as parameters to functions and returned as results from functions
- there exists a set of operators to compose functions
