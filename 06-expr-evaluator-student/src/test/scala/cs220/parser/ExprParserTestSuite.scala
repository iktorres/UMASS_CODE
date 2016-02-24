package cs220.parser

import cs220.evaluator._
import org.scalatest.FunSuite

class ExprParserTestSuite extends FunSuite {

  test("Parsing a number") {
    val e = Program(List(Number(45)))
    ExprParser.parse("45") match {
      case ExprParseSuccess(program) => assert(program == e)
      case ExprParseFailure(message) => fail(message)
      case _ => fail
    }
  }

  test("Parsing a variable") {
    val e = Program(List(Var("x")))
    ExprParser.parse("x") match {
      case ExprParseSuccess(program) => assert(program == e)
      case ExprParseFailure(message) => fail(message)
      case _ => fail
    }
  }

  test("Parsing an add expression") {
    val e = Program(List(Add(Number(4), Var("x"))))
    ExprParser.parse("4 + x") match {
      case ExprParseSuccess(program) => assert(program == e)
      case ExprParseFailure(message) => fail(message)
      case _ => fail
    }
  }

  test("Parsing an assignment expression") {
    val e = Program(List(Assign(Var("x"), Number(4))))
    ExprParser.parse("x = 4") match {
      case ExprParseSuccess(program) => assert(program == e)
      case ExprParseFailure(message) => fail(message)
      case _ => fail
    }
  }

}
