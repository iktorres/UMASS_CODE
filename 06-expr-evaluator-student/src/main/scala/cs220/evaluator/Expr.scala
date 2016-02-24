package cs220.evaluator

sealed abstract class Expr

/*
  TODO: Part 1: Implement expression types.
  This part of the assignment requires you to implement the expression
  types for each of the expressions that our evaluator will support.
  In particular:

  - Var       : variables
  - Number    : numbers
  - Add       : the addition expression (left + right)
  - Sub       : the subtraction expression (left - right)
  - Mul       : the multiplication expression (left * right)
  - Div       : the division expression (left / right)
  - Assign    : the assignment expression (v = expression)
  - Program   : the program expression (list of expression)
*/
case class Var(name: String) extends Expr {
  override def toString: String = "" + name
}

case class Number(value: Int) extends Expr {
  override def toString: String = "" + value.toString
}

case class Add(left: Expr,right: Expr) extends Expr {
  override def toString: String = "" + left.toString + " + " + right.toString
}

case class Sub(left: Expr, right: Expr) extends Expr {
  override def toString: String = "" + left.toString + " - " + right.toString
}

case class Mul(left: Expr, right: Expr) extends Expr {
  override def toString: String = "" + left.toString + " * " + right.toString
}

case class Div(left: Expr, right: Expr) extends Expr {
  override def toString: String = "" + left.toString + " / " + right.toString
}

case class Assign(left: Var, right: Expr) extends Expr {
  override def toString: String = "" + left.toString + " = " + right.toString
}

case class Program(exprs: List[Expr]) extends Expr {
  override def toString: String = exprs.mkString("\n")
}
