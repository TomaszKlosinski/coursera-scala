# Lecture 1.4. Conditionals and Value Definitions

Conditional Expressions
- conditional expression if-else expresses choosing between two alternatives
- like if-else in Java, but used for expressions, not statements

Example:

def abs(x: Int) = if (x >= 0) x else -x

if (x >= 0) x else -x is expression, not statement (no setting a variable and returning variable)
x >= 0 is expression (also called predicate) of type Boolean


Boolean Expressions (as in Java)
- can be composed of:
  true false    # Constants
  !b            # Negations
  b && b        # Conjunctions
  b || b        # Disjunctions
- and of the usual comparison operators:
  e <= e
  e >= e
  e < e
  e > e
  e == e
  e != e

Rewrite rules for Booleans

!true         -> false
!false        -> true
true && e     -> e
false && e    -> false
true || e     -> true
false || e    -> e

Note:
- && and || do not always need right operand to be evaluated
- it's called "short circuit evaluation"

Rewrite rules for if-else

if (b) e1 else e2

if (true) e1 else e2    -> e1
if (false) e1 else e2   -> e2


Value Definitions
- function parameters can be passed by values, or by name
- the same applies to Definitions

def form is "by name" (its right hand side is evaluated on each use)

val form is "by value" (its right hand side is evaluated at the point of definition and afterwards the name refers to the value)

Example:

val x = 2
val y = square(x)     -> y from this moment refers to 4, not square(2)


Value Definitions and Terminations

given: def loop: Boolean = loop

def x = loop    -> OK (x is just another name for loop)
val y = loop    -> tries to evaluate infinite loop

Exercise:
- Write functions "and" and "or" such that for all argument expressions x and y:

1. and(x, y) == x && y
2.  or(x, y) == x || y

Solutions:

1. def and(x: Boolean, y: => Boolean) = if (x) y else false
2. def or(x: Boolean, y: => Boolean) = if (x) true else y
