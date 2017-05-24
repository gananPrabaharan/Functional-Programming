package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    //println(balance("(((hello)there)you)(".toList))
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
      def checkIfBracket (charsChar: List[Char], acc: Int): Int = {
        if (acc < 0) -1
        else if (charsChar.isEmpty) acc
        else if (charsChar.head == '(') checkIfBracket(charsChar.tail, acc+1)
        else if (charsChar.head == ')') checkIfBracket(charsChar.tail, acc-1)
        else checkIfBracket(charsChar.tail, acc)
      }

      checkIfBracket(chars, 0) == 0
    }
     
    
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (!coins.isEmpty && money > 0)
        countChange(money-coins.head, coins) + countChange(money, coins.tail)
      else 0

    }
}
