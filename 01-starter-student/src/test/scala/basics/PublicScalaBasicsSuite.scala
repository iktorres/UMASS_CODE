package basics

import basics.ScalaBasics._
import org.scalatest.FunSuite
import support.TreeTraversals

class PublicScalaBasicsSuite extends FunSuite {

  test("[1] The add function should return the addition of a and b") {
    for (i <- 1 to 1000) {
      val a = scala.util.Random.nextInt(1000)
      val b = scala.util.Random.nextInt(1000)
      val r = add(a, b)
      assert(a + b == r, s"Your add function produced the result $r from adding $a to $b")
    }
  }

  test("[2] The inRange function should return an inclusive range") {
    for (i <- 1 to 1000; j <- 1 to 1000 if j > i) {
      val r = inRange(i, j)
      assert(r.head == i, s"The first element in your range (${r.head}) does not match the expected value $i")
      assert(r.last == j, s"The last element in your range (${r.last}}) does not match the expected value $j")
      assert(r.length == j - i + 1, s"The length of your range is ${r.length}. It should be ${j - i + 1}")
    }
  }

  test("[4] The oddRange function should return a range of all odd integers from 1 to n") {
    for (n <- 1 to 1000) {
      val r = oddRange(n)
      assert(r.head == 1, "The first element in your range is not 1")
      for (v <- oddRange(n)) {
        assert(v % 2 == 1, s"You have a non-odd value $v in your range")
      }
    }
  }

  test("[5] The minWhile function should return the minimum integer in an array using a while loop") {
    TreeTraversals.getMethod("src/main/scala/basics/ScalaBasics.scala", "minWhile") match {
      case Some(method) =>
        assert(TreeTraversals.hasWhileLoop(method), "Your implementation did not include a while loop")
        assert(TreeTraversals.hasIfs(method), "Your implementation did not use an if expression")
      case None =>
        fail("The method minWhile does not exist")
    }
    assert(minWhile(Array(55, 6, 24, 32, 1, 16, 12)) == 1)
    assert(minWhile(Array(2, 3, 4, 5)) == 2)
    assert(minWhile(Array(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)) == 12)
  }

  test("[5] The minFor function should return the minimum integer in an array using a for loop") {
    TreeTraversals.getMethod("src/main/scala/basics/ScalaBasics.scala", "minFor") match {
      case Some(method) =>
        assert(TreeTraversals.hasForEach(method), "Your implementation did not include a for loop")
        assert(TreeTraversals.doesNotHaveIfs(method), "Your implementation used an if expression")
      case None =>
        fail("The method minFor does not exist")
    }
    assert(minFor(Array(55, 6, 24, 32, 1, 16, 12)) == 1)
    assert(minFor(Array(2, 3, 4, 5)) == 2)
    assert(minFor(Array(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)) == 12)
  }

  test("[5] The minRecursive function should return the minimum integer in an array using recursion") {
    TreeTraversals.getMethod("src/main/scala/basics/ScalaBasics.scala", "minRecursive") match {
      case Some(method) =>
        assert(!TreeTraversals.hasValDef(method), "Your implementation used a val declaration")
        assert(!TreeTraversals.hasVarDef(method), "Your implementation used a var declaration")
        assert(!TreeTraversals.hasLoops(method), "Your implementation should not use a loop")
        assert(TreeTraversals.hasIfs(method), "Your implementation requires an if expression")
      case None =>
        fail("The method minRecursive does not exist")
    }
    assert(minRecursive(Array(55, 6, 24, 32, 1, 16, 12)) == 1)
    assert(minRecursive(Array(2, 3, 4, 5)) == 2)
    assert(minRecursive(Array(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)) == 12)
  }

  test("[3] The base36 function should return the base 36 equivalent of the given BigInt") {
    assert(base36(BigInt("123456789")) == "21i3v9")
    assert(base36(BigInt("9876543212")) == "4jc8lik")
    assert(base36(BigInt("123456789123456789")) == "xrls1yk9rf9")
  }

  test("[5] The splitInHalf function should split a string in half") {
    def check(s: String, ls: String, rs: String) = {
      val (l, r) = splitInHalf(s)
      assert(l == ls, s"$l is not the same as $ls")
      assert(r == rs, s"$r is not the same as $rs")
    }
    check("racecar", "rac", "ecar")
    check("sloppy", "slo", "ppy")
  }

  test("[6] isPalindrome should return true if a string is a palindrome") {
    TreeTraversals.getMethod("src/main/scala/basics/ScalaBasics.scala", "isPalindrome") match {
      case Some(method) =>
        assert(!TreeTraversals.hasVarDef(method), "Your implementation used a var declaration")
        assert(TreeTraversals.hasForComp(method), "Your implementation must use a for comprehension")
        assert(!TreeTraversals.hasForEach(method), "You implementation must not use for loops")
        assert(!TreeTraversals.hasWhileLoop(method), "You implementation must not use a while loop")
      case None =>
        fail("The method isPalindrome does not exist")
    }

    val pp = Array(
      "racecar",
      "A car, a man, a maraca",
      "A Toyota's a Toyota",
      "In words, alas, drown I"
    )

    for (p <- pp) {
      assert(isPalindrome(p), s"$p is a palindrome")
    }
  }

  test("[3] sumChars should sum up the characters as integers from its parameters") {
    TreeTraversals.getMethod("src/main/scala/basics/ScalaBasics.scala", "sumChars") match {
      case Some(method) =>
        assert(TreeTraversals.hasVarDef(method), "Your implementation did not use a var declaration")
        assert(TreeTraversals.hasForEach(method), "You implementation must use a for loop")
      case None =>
        fail("The method isPalindrome does not exist")
    }
    assert(sumChars("chicken".toCharArray: _*) == 725, "chicken should sum to 725")
    assert(sumChars("the true sign of intelligence is not ...".toCharArray: _*) == 3601, "this should sum to 3601")
  }

  test("[7] wordCount should count the amount of words in an Array[String]") {
    val pp = Array("this is my test this is","yoda my name is.","may the force be with you")
    var myMap: Map[String,Int] = Map()
    myMap += ("this" -> 2)
    myMap += ("is" -> 2)
    myMap += ("my" -> 2)
    myMap += ("test" -> 1)
    myMap += ("yoda" -> 1)
    myMap += ("name" -> 1)
    myMap += ("is." -> 1)
    myMap += ("may" -> 1)
    myMap += ("the" -> 1)
    myMap += ("force" -> 1)
    myMap += ("be" -> 1)
    myMap += ("with" -> 1)
    myMap += ("you" -> 1)

    assert(wordCounter(pp) == myMap,"These maps should be equal fix it!!!")
  }

}
