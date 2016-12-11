# Lecture 1.2. Elements of Programming

Programming language provides:
- primitive expressions (simplest elements)
- ways to combine expressions
- ways to abstract expressions (giving name by which expression can be referred to)

Read-Eval-Print Loop (REPL)
- FP is a bit like using calculator
- REPL = interactive shell
- write expressions, get their results

Scala REPL:
  > sbt console

Evaluation
- Non-primitive expression is evaluated in order:
1. Take the leftmost operator
2. Evaluate its operands (left before right)
3. Apply the operator to the operands

- A name is evaluated by replacing it with right-hand side of its definition.
- Evaluation stops once it results in a value.

Example:

(2 * pi) * radius
(2 * 3.14159) * radius
6.28318 * radius
6.28318 * 10
62.8318

Parameters
- Definitions can have parameters
> def square(x: Double) = x * x  # parameter "x" of type Double

Parameter and Return Types
- type of function parameters is given after a colon, e.g. "x: Double"
- type of function's return follows parameters list:
> def power(x: Double, y: Int): Double = ...

Primitive types (as in Java, but capitalized)
- Int - 32-bit integer
- Double - 64-bit floating-point number
- Boolean - boolean values (true or false)

Evaluation of Function Application
- Applications of parametrized functions are evaluated in similar way as operators:
1. Evaluate all function arguments, from left to right
2. Replace the function application by the function's right-hand side, and at the same time
3. Replace the formal parameters of the function by the actual arguments

Example:

sumOfSquares(3, 2+2)
sumOfSquares(3, 4)
square(3) + square(4)
3 * 3 + square(4)
9 + square(4)
9 + 4 * 4
9 + 16
25

Substitution model
- scheme of expression evaluation
- all evaluation does is reduce expression to a value
- can be applied to all expression, as long as they have no side effects
- formalized substitution model is lambda-calculus
- it is a foundation of FP
- it can express every algorithm (Turing machine)

Side effect
- e.g. expression "c++" - return old value of c and at the same time increment its value

Termination
- not every expression reduce to a value (in a finite number of steps)
- example:

def loop: Into = loop
loop # this evaluates to itself ad infinitum

Changing the evaluation strategy
- intepreter reduces function arguments to values before rewritting the function application
- alternative evaluation: applying function to unreduced arguments

Example::

sumOfSquares(3, 2+2)
square(3) + square(2+2)
3 * 3 + square(2+2)
9 + square(2+2)
9 + 2+2 * 2+2
9 + 4 * 2+2
9 + 4 * 4
9 + 16
25

Call-by-name
- second example
- advantage: function argument is not evaluated if the corresponding parameter is not used in the evaluation of the function body

Call-by-value
- first example
- advantage: evaluates every function argument only once

Theorem of lambda-calculus:
- Both strategies reduce to the same final value as long as:
  + the reduced expression consists of pure functions
  + both evaluations terminate

Example (evaluation speed):

def test(x: Int, y: Int) = x * x

Evaluation with number of steps:

CBV
1. test(2, 3)  test(3+4, 8)   test(7, 2*4)    test(3+4, 2*4)
2. 2 * 2       test(7,8)      test(7,8)       test(7, 8)
3. 4           7*7            7*7             7*7
4.             49             49              49

CBN
1. test(2, 3)  test(3+4, 8)   test(7, 2*4)    test(3+4, 2*4)
2. 2 * 2       (3+4) * (3+4)  7*7             (3+4) * (3+4)
3. 4           7 * (3+4)      49              7*7
4.             7 * 7                          49
5.             49

Results:
                  CBV         CBN
test(2, 3)        4 steps     4 steps   = equal     
test(3+4, 8)      4 steps     5 steps   = CBV wins
test(7, 2*4)      4 steps     3 steps   = CBN wins
test(3+4, 2*4)    4 steps     4 steps   = equal
