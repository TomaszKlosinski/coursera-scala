# Lecture 1.5. Example: square root with Newton's method

Task

/** Calculates the square root of parameter x \*/
def sqrt(x: Double): Double = ...

- use successive approximation using Newton's method

Newton's method

To compute sqrt(x)

1. Start with initial estimate (for instance y = 1)
2. Repeatedly improve the estimate by taking the mean of y and x/y

Example:

Estimation      Quotient              Mean
1               2 / 1 = 2             1.5
1.5             2 / 1.5 = 1.333       1.4167
1.4167          2 / 1.4167 = 1.4118   1.4142
1.4142          ...                   ...
...


Implementation

Define a function which computes one iteration step

def sqrtIteration(guess: Double, x: Double) = {
  if (isGoogEnough(guess, x)) guess
  else sqrtIteration(improve(guess, x), x)
}

Note: sqrtIteration is recurive, that is its right hand side calls itself.

In Scala:
- recursive functions require explicit return type
- for non-recursive functions return type is optional (although it's good practice to always provide return type, as it is good documentation for the function's user)

Implement additional functions:

def abs(x: Double) = if (x > 0) x else -x

def isGoodEnough(guess: Double, x: Double) = {
  abs(guess * guess - x) < 0.001
}

def improve(guess: Double, x: Double) = {
  (guess + x / guess) / 2
}

Finally:

def sqrt(x: Double) = sqrtIteration(1.0, x)


Exercise
1. isGoodEnough test is not very precise for small numbers and can lead to non-termination for big numbers. Why?
2. Design better isGoodEnough
3. Test it with very small and very big numbers, e.g.

  0.001
  0.1e-20
  1.0e20
  1.0e50


Solutions:
1. The problem is that this implementation takes an absolute difference. It asks whether the absolute difference between square of guess and x is less than some threshold value.

That's not very good for very, very small numbers because the number we want to find in the suqare root might be even smaller than that threshold. So, that, relatievly speaking, absolute value might be huge compared to the number we want to find.

For very large numbers we have the opposite problem, which is that very large floating point numbers can actually be further apart than this absolute value. That means it the 52-bits (...). It could be that the distance between one number and the next is actually larger than the threshold. And in that case the iteration can never stop, simply because there is no value that is ever good enough.  

2. We can solve both problems by making the test proportional to x. And that's simply done by dividing the absolute difference by the current value of x and make that smaller than the threshold value.

def isGoodEnough(guess: Double, x: Double) = {
  abs(guess * guess - x) / x < 0.001
}

3.
