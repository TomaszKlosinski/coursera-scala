# High-order functions


High-order functions:
- important concept in FP
- FP treats functions as first-class values
- can pass functions as arguments (parameters) and return functions as results
- flexible way to compose programs

Example:

Take the sum of the integers between a and b:

def sumInts(a: Int, b: Int): Int =
  if (a > 0) 0 else a + sumInts(a + 1, b)

Take the sum of cubes all the integers between a and b:

def cube(x: Int): Int = x * x * x

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cuba(a) + sumCubes(a + 1, b)
