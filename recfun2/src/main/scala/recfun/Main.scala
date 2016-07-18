package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance0(chars: List[Char], acc: Int): Boolean = {
      if(chars.isEmpty && acc == 0) true
      else if(acc < 0) false
      else if(chars.isEmpty && acc != 0) false
      else if(chars.head == '(') balance0(chars.tail, acc+1)
      else if(chars.head == ')') balance0(chars.tail, acc-1)
      else if(!chars.tail.isEmpty) balance0(chars.tail, acc)
      else false
    }
    balance0(chars, 0)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChange0(money: Int, coins: List[Int], acc: Int): Int = {
      if(money == 0 || coins.isEmpty) 0
      else if(money % coins.head == 0) countChange0(money, coins.tail, acc+1)

    }

    countChange0(money, coins, 0)
  }
}
