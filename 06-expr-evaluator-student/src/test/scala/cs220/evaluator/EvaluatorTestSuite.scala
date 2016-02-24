package cs220.evaluator

import cs220.parser._
import org.scalatest.FunSuite

class EvaluatorTestSuite extends FunSuite {

  test("Evaluation of a number expression") {
    val env = Environment
    val res = ExprParser.parse("39") match {
      case ExprParseSuccess(program) =>
        Evaluator.evalProgram(program, env)
      case ExprParseFailure(message) => fail()
      case _ => fail()
    }
    val EvaluationResult(v, e) = res
    assert(v == Value(39))
    assert(e == env)
  }

  test("Evaluation of a simple variable expression") {
    val env = Environment.extend(Var("x"), Value(39))
    val res = ExprParser.parse("x") match {
      case ExprParseSuccess(program) =>
        Evaluator.evalProgram(program, env)
      case ExprParseFailure(message) => fail()
      case _ => fail()
    }
    val EvaluationResult(v, e) = res
    assert(v == Value(39))
    assert(e == env)
  }

  test("Evaluation of a simple arithmetic expression") {
    val env = Environment.extend(Var("x"), Value(39))
    val res = ExprParser.parse("x + 10") match {
      case ExprParseSuccess(program) =>
        Evaluator.evalProgram(program, env)
      case ExprParseFailure(message) => fail()
      case _ => fail()
    }
    val EvaluationResult(v, e) = res
    // 39 + 10 == 49
    assert(v == Value(49))
    assert(e == env)
  }

  test("Evaluation of an assignment expression") {
    val env = Environment
    val res = ExprParser.parse("x = 39") match {
      case ExprParseSuccess(program) =>
        Evaluator.evalProgram(program, env)
      case ExprParseFailure(message) => fail()
      case _ => fail()
    }
    val EvaluationResult(v, e) = res
    assert(v == Value(39))
    e.lookup(Var("x")) match {
      case Some(Binding(_, v)) => assert(v == Value(39))
      case None => fail()
    }
  }
}