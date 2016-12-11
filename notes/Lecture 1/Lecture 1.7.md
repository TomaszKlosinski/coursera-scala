# Lecture 1.7. Tail Recursion

Review: Evaluating a Function Application
- One simple rule: a function application f(e1, ..., en) is evaluated:
  + by evaluating the expressions e1, ..., en resulting in values v1, ..., vn then
  + by replacing the application with the body of the function f, in which
  + the actual parameters v1, ..., vn replace the formal parameters of function f.

Application Rewriting Rule
- This can be formalized as a rewriting of the program itself:

def f(x1, ..., xn) = B (body of the function)
...
f(v1, ..., vn)

->

def f(x1, ..., xn) = B
...
[v1/x1, ..., vn/xn] B

where [v1/x1, ..., vn/xn] B means:
- The expression B in which all occurrences of xi have been replaced by vi.

[v1/x1, ..., vn/xn] is called substitution.


Rewriting Example 1: GCD

- Consider gcd, the function that computes the greatest common divisor of two numbers.
- Implementation of gcd using Euclid's algorithm:

def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd(14, 21) is evaluated as follows:

gcd(14, 21)
-> if (21 == 0) 14 else gcd(21, 14 % 21)
-> if (false) 14 else gcd(21, 14 % 21)
-> gcd(21, 14 % 21)
-> gcd(21, 14)

-> if (14 == 0) 21 else gcd(14, 21 % 14)
-> gcd(14, 7)

-> if (7 == 0) 14 else gcd(7, 14 % 7)
-> if (false) 14 else gcd(7, 14 % 7)
-> gcd(7, 14 % 7)
-> gcd(7, 0)

-> if (0 == 0) 7 else gcd(0, 7 % 0)
-> if (true) 7 else gcd(0, 7 % 0)
-> 7


Rewriting Example 2: Factorial
- Consider factorial function:

def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(4) is evaluated as follows:

factorial(4)
-> if (4 == 0) 1 else 4 * factorial(4 - 1)
-> if (false) 1 else 4 * factorial(4 - 1)
-> 4 * factorial(4 - 1)
-> 4 * factorial(3)

->> 4 * (3 * factorial(2))

->> 4 * (3 * (2 * factorial(1)))

->> 4 * (3 * (2 * (1 * factorial(0))))

->> 4 * (3 * (2 * (1 * 1)))

->> 120


Question:
- What is the difference between GCD and Factorial?
- One important difference is that:
  + in GCD reduction sequence oscilities: it goes from gcd call to next gcd call.
  + in Factorial in each couple of steps we add one more element to our expressions

Tail Recursion
- Implementation Consideration: If a function calls itself as its last action, the function's stack frame can be reused. This is call tail recursion.
=> Tail recursive functions are iterative processes.

- In general, if the last action of a function consists of a calling a function (which may be the same function), one stack frame would be sufficient for both functions. Such call are called tail-calls.


1. Elements of FP in Scala:
  - athmetic and boolean opeartions
  - conditional expressions if-else
  - functions with recursion
  - nesting and lexical scope
2. Difference between CBN and CBV evaluation strategies.
3. Reason about program execution: reduce expressions using substitution model.
4. This model will be important tool in coming sessions.
