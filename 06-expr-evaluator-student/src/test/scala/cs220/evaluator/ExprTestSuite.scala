package cs220.evaluator

import org.scalatest.FunSuite

class ExprTestSuite extends FunSuite {

  test("The Number class exists") {
    // This ensures that the student has created the Number
    // class in the cs220 package.
    assert (Number != null)
  }

  test("The Var class exists") {
    // This ensures that the student has created the Var
    // class in the cs220 package.
    assert (Var != null)
  }

  test("The Add class exists") {
    // This ensures that the student has created the Add
    // class in the cs220 package.
    assert (Add != null)
  }

  test("The Sub class exists") {
    // This ensures that the student has created the Sub
    // class in the cs220 package.
    assert (Sub != null)
  }

  test("The Mul class exists") {
    // This ensures that the student has created the Mul
    // class in the cs220 package.
    assert (Mul != null)
  }

  test("The Div class exists") {
    // This ensures that the student has created the Div
    // class in the cs220 package.
    assert (Div != null)
  }

  test("The Assign class exists") {
    // This ensures that the student has created the Assign
    // class in the cs220 package.
    assert (Assign != null)
  }

  test("The Program class exists") {
    // This ensures that the student has created the Program
    // class in the cs220 package.
    assert (Program != null)
  }

  test("Add expression generates the correct infix string form") {
    val e = Add(Number(12), Var("a"))
    assert(e.toString == "12 + a")
  }

  test("Sub expression generates the correct infix string form") {
    val e = Sub(Number(12), Var("a"))
    assert(e.toString == "12 - a")
  }

  test("Mul expression generates the correct infix string form") {
    val e = Mul(Number(12), Var("a"))
    assert(e.toString == "12 * a")
  }

  test("Div expression generates the correct infix string form") {
    val e = Div(Number(12), Var("a"))
    assert(e.toString == "12 / a")
  }

  test("Complicated expression generates the correct infix string form") {
    val p = Program(List(
      Assign(Var("a"), Number(25)),
      Assign(Var("b"), Number(12)),
      Assign(Var("c"), Number(6) ),
      Add(Mul(Var("a"), Var("b")),
          Div(Var("b"), Var("c")))
      // a = 25; b = 12; a * b + b / c
    ))
    print(p.toString)
    assert(p.toString == "a = 25\nb = 12\n" +
                         "c = 6\na * b + b / c")
  }

}