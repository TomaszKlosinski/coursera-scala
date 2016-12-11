# Lecture 1.3. Evaluation Strategies and Termination

CBV & CBN Termination
- if CBV evaluation of an expression e terminates, then CBN evaluation of e terminates too
- the other direction is not true

Example:

def first(x: Int, y:Int) = x

   CBN                  CBV
1. first(1, loop)       first(1, loop)
2. 1                    first(1, loop)
...
N.                      first(1, loop) # loop evaluates to itself ad infinitum


Scala:
- normally use CBV
  * because CBV is exponentially more efficient than CBN by avoiding repeated computations
- but if function parameter starts with '=>', it uses CBN

Example:

def constOne(x: Int, y: => Int) = 1

1. constOne(1+2, loop)       constOne(loop, 1+2)
2. constOne(3, loop)         constOne(loop, 1+2)
3. 1                         constOne(loop, 1+2)
...
N.                           constOne(loop, 1+2) # loop evaluates to itself ad infinitum
