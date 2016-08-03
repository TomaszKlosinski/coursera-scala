# Lecture 1.6. Blocks and Lexical Scope

Nested funtions
- It's good functional programming style to split up a task into many small functions.
- But the names of these small functions (like sqrtIteration, improve, isGoodEnough) matter only for the implementation of the major function (like sqrt), not for its usage.
- Normally we would not like users to access these small functions directly.
- We can achieve that and it the same time avoid "name-space pollution" by putting auxciliary functions inside major function (like sqrt).

Blocks
- Delimited by braces { ... }
e.g.

  {
    val x = f(3)
    x * x
  }

- It contains a sequence of definitions of expressions.
- The last element of a block is an expression that defines its value.
- This return expression can be preceded by auxiliary definitions.
- Blocks are themselves expressions; a block may appear everywhere where expression can appear.

Blocks and Visibility
- The definitions inside a block are only visible from within a block.
- The definitions inside a block shadow definitions of the same name outside.

val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
}

Exercise: Scope Rules

val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + x

Lexical Scoping
- Definitions of outer blocks are visible inside a block unless they are shadowed.

Example:

def sqrt(x: Double) = {

  def sqrtIteration(guess: Double) =
    if (isGoodEnough(guess)) guess
    else sqrtIteration(improve(guess))

  def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

  def improve(guess: Double) =
    (guess + x / guess) / 2

  sqrtIteration(1.0)

}

Note: This way it is much cleaner. We have avoided the redudancy of passing the parameter x around everywhere by using the simple trick that the value of x actually visible inside all nested functions.

- This is another reason for nesting things: it's not just name space control, but it's also reusing outer definitions without passing them explicitly in parameters.

Semicolons
- In Scala semicolons at the end of the lines are optional.
- Most people would omit them.
- But if there are more than one statement on a line, they need to be seperated by semicolons:
e.g.

val y = x + 1; y * y

Semicolons and infix operators
- One issue with Scala semicolon convention is how to write expressions that span several lines.
- For instance:

someLongExpression
+ someOtherExpression

would be interpreted as two expressions:

someLongExpression;
+ someOtherExpression

Solution:
1. Write multi-line expression in paranthesis:

(someLongExpression
+ someOtherExpression)

2. Write the operator on the first line:

someLongExpression +
someOtherExpression
