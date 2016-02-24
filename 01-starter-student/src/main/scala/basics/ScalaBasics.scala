package basics

/**
 * This is a singleton object containing the functions you need
 * to implement. Please make sure to read the documentation associated
 * with each function and provide a sensible implementation.
 */
object ScalaBasics {

  /**
   * Write a function called add that takes two Int parameters
   * and returns their sum.
   *
   * @param a operand a
   * @param b operand b
   * @return the sum
   */
  def add(a: Int, b: Int): Int = {
   a+b
  }

  /**
   * Write a function that returns the inclusive Range from start to end.
   *
   * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
   *
   * @param start the start of the range
   * @param end the end of the range
   * @return the inclusive Range from start to end
   */
  def inRange(start: Int, end: Int): Range = {
    start until end + 1
  }

  /**
   * Write a function that returns a Range of odd n odd integers starting at 1.
   *
   * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
   *
   * @param n the number of odd integers in the range
   * @return a Range of odd integers, excluding the last add integer
   */
  def oddRange(n: Int): Range = {
    var odd: Range = null
    if(n >= 1)
      odd = 1 until 2
    else {
      var count = 0
      var temp = 1
      val limit = n - 1
      while (count < limit) {
        temp += 2
        count += 1
      }
      odd = 1 until temp by 2
    }
    odd
  }

  /**
   * Write a function that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a while loop.
   * - You may use both immutable (val) and mutable (var) variables.
   * - You must use an if expression.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minWhile(r: Array[Int]): Int = {
    var count = 1;var min = r(0);val length = r.length
    var temp  = 0
    while(count < length) {
      temp = r(count)
      if(temp < min )
        min = temp
      count += 1
    }
    min
  }

  /**
   * Write a function that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for loop (not for comprehension).
   * - You may use both immutable (val) and mutable (var) variables.
   * - You may not use an if expression.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minFor(r: Array[Int]): Int = {
    val length = r.length - 1;var min = 0;var temp = 0
    length compare 0 match {
      case -1 => min = 0
      case  0 => min = 0
      case  1 =>
        min = r(0)
        for(i <- 1 to length) {
          temp = r(i)
          temp compare min match {
            case -1 => min = temp
            case  0 => min
            case  1 => min
          }
        }
    }
    min
  }

  /**
   * Write a function called minRecursive that returns the minimum integer in the Array r.
   *
   * Your implementation must conform to the following rules:
   *
   * - You may not use any loops.
   * - You may not use any mutable (var) or immutable (val) variables.
   *
   * HINT: You might want to look at the Scaladoc for Array to see some
   * useful methods you can use to solve this.
   *
   * @param r the array of integers
   * @return the minimum integer in the array
   */
  def minRecursive(r: Array[Int]): Int = {
    //_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
    // I thought this was the only way to do it.
    //&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*
    //Helper method that keeps track of everything
//    def minHelper(numbers: Array[Int],index1: Int,index2: Int): Int = {
//      if(numbers(index1) < numbers(index2) && index1 < numbers.length - 1
//        && index2 < numbers.length - 1) {
//        minHelper(numbers, index1, index2 + 1)
//      }
//      else {
//        if(index2 == numbers.length - 1) {
//          if (numbers(index1) < numbers(index2))
//            return index1
//          else
//            return index2
//        }
//        else
//          return minHelper(numbers,index2,index2+1)
//      }
//    }
    //&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*
    //&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*&*

//      if(r.length == 0)
//        return 0
//      else
//        return r(minHelper(r,0,1))
    //_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+

    // But I stand corrected this is a very elegant way to do recursion.
      if(r.length > 2)
        math.min(r.head,minRecursive(r.takeRight(r.length-1)))
      else
        math.min(r.head,r.tail.head)
  }

  /**
   * Return the base 36 equivalent of the BitInt b.
   *
   * HINT: Poke around Scaladoc to find a way of doing this in Scala.
   *
   * @param b a big integer
   * @return the base 36 equivalent
   */
  def base36(b: BigInt): String = {
    // simplest answer is: b.toString(36) .
    val myBase      = new Array[String](36)
    var temp        = 10
    var num: BigInt = b
    var base        = ""
    var number      = 0
    for(i <- 0 to 9)
      myBase(i) = "" + i
    for(i <- 65 to 90) {
      myBase(temp) = ("" + i.toChar).toLowerCase
      temp += 1
    }
    while(num > 0) {
      number = (num % 36).toString.toInt
      base += myBase(number)
      num /= 36
    }
    base.reverse
  }

  /**
   * Splits the String s in half.
   *
   * This function returns a tuple (f, e), where the f is the first
   * half of the string and e is the last half of the string.
   *
   * For example,
   *   splitInHalf("abcdef") => ("abc", "def")
   *   splitInFalf("abcde")  => ("ab", "cde")
   *
   * Your implementation must conform to the following rules:
   *
   * - You may not use any loops.
   * - You may not use recursion.
   * - You may not use any mutable (var) or immutable (val) variables.
   *
   * HINT: You might find something useful in the String and StringOps Scaladoc.
   *
   * @param s the string to split
   * @return the split string as a tuple
   */
  def splitInHalf(s: String): (String, String) = {
    (s.slice(0,s.length/2),s.slice(s.length/2,s.length))
  }

  /**
   * Determines if the given string s is a palindrome.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for comprehension.
   * - You may not use any other loops.
   * - You may not use any mutable (var) variables.
   *
   * You should normalize the string s before determining if
   * it is a palindrome. That is, you should not distinguish
   * between upper and lowercase, you should not consider
   * spaces, and you should eliminate the punctuation
   * characters . ? , ; ! - '.
   *
   * HINT: You should consult the Scaladoc for String and
   * StringOps to help you with your solution.
   *
   * @param s the potential palindrome
   * @return true if s is a palindrome; false otherwise
   */
  def isPalindrome(s: String): Boolean = {
    val str       = s.toLowerCase.replaceAll("[ .?,;!-']","")
    val rev       = str.reverse
    val myLetters = new Array[(Char,Char)](str.length)
    //println("Length -> " + s.length + " , " + str.length)
    val index     = Array[Int](0)
    for(i <- str) yield {
      myLetters(index(0)) = (str(index(0)),rev(index(0)))
      index(0) += 1
    }
    for((charElement,charElementRev) <- myLetters) yield
      if(charElement != charElementRev)
        return false
    return true
  }

  /**
   * Sum the characters (as integers) provided as arguments to this method.
   *
   * Your implementation must conform to the following rules:
   *
   * - You must use a for loop
   * - You may use any mutable (var) variables.
   *
   * @param cc 0 or more characters
   * @return the sum of the ASCII integers corresponding with the character.
   */
  def sumChars(cc: Char*): Int = {
    val len = cc.length - 1
    var sum = 0
    for(i <- 0 to len) {
      sum += cc(i).toInt
    }
    sum
  }

  /**
   * Counts the number of space delimited words in the provided array of strings.
   *
   * This function takes an array of strings that represent lines in a text file.
   * This function must return a Map from String to Int where the String is a
   * word found across all lines and the Int is the number of times that word
   * was seen. For example:
   *
   * wordCount(Array("this is a sentence.", "this is a sentence too!"))
   *
   * would return
   *
   * Map("this" -> 2,
   *     "is" -> 2,
   *     "a" -> 2,
   *     "sentence." -> 1,
   *     "sentence" -> 1,
   *     "too!" -> 1)
   *
   * You may assume that all words are delimited by spaces. You need not worry
   * about punctuation. You can implement this however you wish.
   *
   * @param lines the lines of a text file
   * @return a map from words to the number of times that word was seen
   */
  def wordCounter(lines: Array[String]): Map[String, Int] = {
    val len = lines.length - 1
    var temp: Array[String] = null
    var len2 = 0
    var count = 1
    var words: Map[String,Int] = Map()
    for(i <- 0 to len) {
      temp = lines(i).split(" ")
      len2 = temp.length - 1
      for(j <- 0 to len2) {
        if (words.contains(temp(j))) {
          count = words(temp(j)) + 1
        }
        else {
          count = 1
        }
        words += (temp(j) -> count)
      }
    }
    words
  }

}
