package cs220.parser

import scala.util.parsing.combinator._

import cs220.evaluator._

/** The result of parsing an expression. */
abstract class ExprParseResult

/**
 * The result of a successful parse of a program.
 * @param program the program tree
 */
case class ExprParseSuccess(program: Program) extends ExprParseResult

/**
 * The result of a failed parse of a program.
 * @param message the message indicating the failure
 */
case class ExprParseFailure(message: String) extends ExprParseResult

/**
 * This class defines a parser for simple arithmetic expression programs. Here
 * is an example of a program in this language:
 * {{{
 *   a = 12;
 *   b = 13;
 *   c = a + b * (b - a);
 *   c + 12 / 4;
 * }}}
 */
class Arith extends JavaTokenParsers {
  /**
   * Returns a parser that can parse a program.
   * @return a program parser
   */
  def prog: Parser[Program] = rep(dec | expr) ^^ {
    Program(_)
  }

  /**
   * Returns a parser that can parse variable declarations.
   * @return a declaration parser
   */
  def dec: Parser[Expr] = ident ~ "=" ~ expr ^^ {
    case v ~ "=" ~ e => Assign(Var(v), e)
  }

  /**
   * Returns a parser that can parse an expression.
   * @return an expression parser
   */
  def expr: Parser[Expr] = term ~ rep("+" ~ term | "-" ~ term) ^^ {
    case op ~ xs => xs.foldLeft(op) {
      case (x, "+" ~ y) => Add(x, y)
      case (x, "-" ~ y) => Sub(x, y)
    }
  }

  /**
   * Returns a parser that can parse a term expression.
   * @return a term parser
   */
  def term: Parser[Expr] = factor ~ rep("*" ~ factor | "/" ~ factor) ^^ {
    case op ~ xs => xs.foldLeft(op) {
      case (x, "*" ~ y) => Mul(x, y)
      case (x, "/" ~ y) => Div(x, y)
    }
  }

  /**
   * Returns a parser that can parse a factor expression.
   * @return a factor parser
   */
  def factor: Parser[Expr] =
      decimalNumber ^^ ((x) => Number(x.toInt)) |
      ident ^^ ((x) => Var(x)) |
      "(" ~ expr ~ ")" ^^ {
        case "(" ~ e ~ ")" => e
      }
}

/**
 * An `ExprParser` can parse programs of arithmetic expressions. A program has the
 * following form:
 * {{{
 *   a = 12;
 *   b = 13;
 *   c = a + b * (b - a)
 *   c + 12 / 4
 * }}}
 * It has a simple format consisting of a sequence of expressions that are either
 * assignments or expressions. The output of the program is the last expression
 * that is evaluated.
 */
object ExprParser extends Arith {
  /**
   * Parses an expression program given as a String.
   * It returns Some(e) where e is a [[cs220.evaluator.Program]] expression or
   * None if it was unable to parse input the program.
   *
   * @param program the program to parse
   * @return [[ExprParseSuccess]] if correctly parsed; [[ExprParseFailure]] if it fails
   */
  def parse(program: String): ExprParseResult =
    // parseAll takes the parse to use and the string to parse.
    parseAll(prog, program) match {
      case Success(result, _)  => ExprParseSuccess(result)
      case NoSuccess(msg, _)   => ExprParseFailure(msg)
    }
}
