package cs220.evaluator

import org.scalatest.FunSuite

class EnvironmentTestSuite extends FunSuite {

  test("An empty environment is empty") {
    val e = Environment
    try {
      assert(e.toList == Nil)
    }
    catch {
      case _: NotImplementedError => fail("You did not implement this method yet!")
    }
  }

  test("An empty environment extended by one binding has length 1") {
    try {
      val eo = Environment
      val ee = eo.extend(Var("x"), Value(45))
      assert(ee.toList.length == 1)
    }
    catch {
      case _: NotImplementedError => fail("You did not implement this method yet!")
    }
  }

  test("Extending an environment with (v -> e) will return e on lookup") {
    try {
      val v  = Var("x")
      val e  = Value(45)
      val eo = Environment
      val ee = eo.extend(v, e)
      ee.lookup(v) match {
        case Some(Binding(_, x)) => assert(x == e)
        case None                => fail
      }
    }
    catch {
      case _: NotImplementedError => fail("You did not implement this method yet!")
    }
  }

  test("An environment has the correct string representation") {
    try {
      val e = Environment.extend(Var("x"), Value(4))
                         .extend(Var("y"), Value(5))
                         .extend(Var("z"), Value(6))
      val s = "{x -> 4.0, y -> 5.0, z -> 6.0}"
      assert(e.toString == s)
    }
    catch {
      case _: NotImplementedError => fail("You did not implement this method yet!")
    }
  }

}