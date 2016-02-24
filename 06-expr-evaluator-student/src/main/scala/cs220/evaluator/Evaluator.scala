package cs220.evaluator

/**
 * An EvaluationException represents a problem with an expression program.
 * An EvaluationException is thrown when there is a problem with
 * evaluating an expression program.
 */
class EvaluationException(msg: String) extends RuntimeException(msg)

/**
 * An EvaluationResult represents the result of an evaluation.
 */
case class EvaluationResult(value: Value, env: Environment)

/**
 * An AbstractEvaluator defines the operations that our evaluator
 * will use to evaluation [[Expr]] objects in an [[Environment]].
 */
abstract class AbstractEvaluator {
  /**
   * eval returns an [[EvaluationResult]] given an expression `expr` and
   * an environment `env`. It determines which of the other `eval` methods
   * to invoke based off of the type of [[Expr]].
   */
  def eval(expr: Expr, env: Environment): EvaluationResult

  /**
   * evalNumber evaluates a [[Number]] `num` in an [[Environment]] `env`.
   */
  def evalNumber(num: Number, env: Environment): EvaluationResult

  /**
   * evalVar evaluates a [[Var]] `v` in an [[Environment]] `env`.
   */
  def evalVar(v: Var, env: Environment): EvaluationResult

  /**
   * evalAdd evaluates an add expression in an [[Environment]] `env`.
   */
  def evalAdd(op: Add, env: Environment): EvaluationResult

  /**
   * evalSub evaluates an subtract expression in an [[Environment]] `env`.
   */
  def evalSub(op: Sub, env: Environment): EvaluationResult

  /**
   * evalMul evaluates a multiply expression in an [[Environment]] `env`.
   */
  def evalMul(op: Mul, env: Environment): EvaluationResult

  /**
   * evalDiv evaluates a divide expression in an [[Environment]] `env`.
   */
  def evalDiv(op: Div, env: Environment): EvaluationResult

  /**
   * evalAssign evaluates an assignment expression in an [[Environment]] `env`.
   */
  def evalAssign(op: Assign, env: Environment): EvaluationResult

  /**
   * evalProgram evaluates a program expression in an [[Environment]] `env`.
   */
  def evalProgram(prog: Program, env: Environment): EvaluationResult
}

// TODO: Part 5 - implement a simple evaluator.
class SimpleEvaluator extends AbstractEvaluator {
  def eval(expr: Expr, env: Environment): EvaluationResult = expr match {
    case Var(n) => evalVar(new Var(n),env)
    case Number(v) => evalNumber(new Number(v),env)
    case Add(l,r) => evalAdd(new Add(l,r),env)
    case Sub(l,r) => evalSub(new Sub(l,r),env)
    case Mul(l,r) => evalMul(new Mul(l,r),env)
    case Div(l,r) => evalDiv(new Div(l,r),env)
    case Assign(l,r) => evalAssign(new Assign(l,r),env)
    case Program(v) => evalProgram(new Program(v),env)
  }
  def evalNumber(num: Number, env: Environment): EvaluationResult = new EvaluationResult(new Value(num.value),env)
  def evalVar(v: Var, env: Environment): EvaluationResult = new EvaluationResult(env.lookup(v).get.a,env)
  def evalAdd(op: Add, env: Environment): EvaluationResult = new EvaluationResult(new Value(eval(op.left,env).value.i + eval(op.right,env).value.i),env)
  def evalSub(op: Sub, env: Environment): EvaluationResult = new EvaluationResult(new Value(eval(op.left,env).value.i - eval(op.right,env).value.i),env)
  def evalMul(op: Mul, env: Environment): EvaluationResult = new EvaluationResult(new Value(eval(op.left,env).value.i * eval(op.right,env).value.i),env)
  def evalDiv(op: Div, env: Environment): EvaluationResult = new EvaluationResult(new Value(eval(op.left,env).value.i / eval(op.right,env).value.i),env)
  def evalAssign(op: Assign, env: Environment): EvaluationResult = new EvaluationResult(new Value(eval(op.right,env).value.i),env.extend(op.left,eval(op.right,env).value))
  def evalProgram(prog: Program, env: Environment): EvaluationResult = prog.exprs match {
    case hd :: Nil => eval(hd,env)
    case hd :: tl => eval(Program(tl),eval(hd,env).env)
    case _ => throw new EvaluationException("hey you didnt do it right")
  }
}

/** A factory object for an evaluator. */
object Evaluator extends SimpleEvaluator
