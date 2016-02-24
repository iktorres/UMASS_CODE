package cs220

import cs220.evaluator._
import cs220.parser._

import scala.io.Source

/**
 * Main application entry point.
 */
object Main {

  /**
   * This method "executes" an expression program contained in the file `file`.
   * @param file the expression file to execute
   * @return either an [[EvaluationResult]] or an error message
   */
  def execute(file: String): Either[EvaluationResult, String] = {
    // Read the file in as a string:
    val program = Source.fromFile(file).mkString
    // Parse the program and handle the success or failure:
    ExprParser.parse(program) match {
      // If we are successful we can evaluate the program:
      case ExprParseSuccess(p) => {
        val result = Evaluator.evalProgram(p, Environment)
        Left(result)
      }
      // If we fail then we capture the error message:
      case ExprParseFailure(message) =>
        Right(message)
    }
  }

  /**
   * Program main entry-point:
   * @param args the arguments to the program
   */
  def main(args: Array[String]) {
    if (args.length == 0) {
      println("Expected an expression program file.")
    } else {
      execute(args(0)) match {
        case Left(EvaluationResult(v,e))  => println("R = " + v + " with E = " + e)
        case Right(b) => println("ERROR: " + b)
      }
    }
  }
}
