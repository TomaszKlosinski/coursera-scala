# Lecture 3.3. Polymorphism

Cons-Lists
- immutable linked list
- fundamental data structure in FL
- constructed from:
  * Nil - empty list
  * Cons - cell containing an element and remainder of the list

Examples:

1. List(1, 2, 3)

  [ | ]
  /   \
 1    [ | ]
      /   \
     2    [ | ]
          /   \
         3    Nil

2. List(List(true, false), List(3))

             [ | ]
           /      \
          /        \
         /          \
        /            \
   [ | ]              [ | ]
  /     \            /     \
true    [ | ]     [ | ]     Nil
        /   \     /   \
    false   Nil  3    Nil


Cons-Lists in Scala
- Outline of a class hierarchy that represents list of integers

package abcd

trait IntList ...
class Cons(val head: Int, val tail: IntList) extends IntList ...
class Nil extends IntList ...

A list is either
- an empty list: new Nil
- or a list: new Cons(x, xs) consisting of a head element x and a tail list xs

Value Parameters
- abbrevation: (val head: Int, val tail: IntList) in the definition of Cons
- defines at the same time parameters and fields of a class
- is equivalen to:

class Cons (a_head: Int, a_tail: IntList) extends IntList {
  val head = a_head
  val tail = a_tail
}

Type Parameters
- It seems too narrow to define only lists with Int elements.
- We'd need another class hierarchy for each possible element type.
- Generalize the definition using a *type parameter*

package abcd

trait List[T]
class Cons[T](val head: T, val tail: List[T]) extends List[T]
class Nil[T] extends List[T]


Example (Implementation):

$ file List.scala

package xyz

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}


Generic Functions
- like classes, functions can have type parameters
- for instance, a function that creates a list consisting of single element:

def singleton[T](elem: T) = new Const[T](elem, new Nil[T])

Examples:

1. singleton[Int](1)

 [ | ]
 /   \
1    Nil


2. singleton[Boolean](true)

 [ | ]
 /   \
true  Nil


Type Inference
- scala compiler can usually deduce the correct type parameters from the value arguments of a functions call
- in most cases, type parameters can be left out:

1. singleton(1)     # compiler deduces singleton[Int](1)
2. singleton(true)  # compiler deduces singleton[Boolean](true)


Types and Evaluations
- type parameters do not affect evaluation in scala

- *type erasure*
  * we can assume that all type parameters and type arguments are removed before evaluating the program
  * used by: Java, Scala, Haskell, ML, OCaml
  * not used by (type parameters kept around at run time): C++, C#, F#


Polymorphism
- means that a function type comes "in many forms":
  * the function can be applied to arguments of many types, or
  * the type can have instances of many types

Two principal forms of Polymorphism:
- subtyping: instances of a subclass can be passed to a base class
- generics: instances of a function or class are created by type parametrization


Exercise:
- Write a functions "nth" that takes an integer n and a list and selects the n'th element of the list.
- Elements are numbered from 0.
- If index is outside the range from 0 to length of the list minus one, a IndexOutOfBoundsException should be thrown.


def nth[T](val n: Int, val list: List[T]): T = {
  if (xs.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) xs.head
  else nth(n - 1, xs.tail)
}
