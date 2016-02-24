package cs220.evaluator

/**
 * A Binding represents a binding of a variable to a value.
 * @param v the variable
 * @param a the value
 */
case class Binding(v: Var, a: Value) {
  override def toString: String = v + " -> " + a
}

/**
 * An Environment holds bindings from variables to values.
 */
abstract class Environment {
  /**
   * lookup returns `Some(b)` for some binding `b` if the
   * variable `v` is found in the environment; None otherwise.
   * @param v the variable to lookup
   * @return `Some(b)` if variable is found; `None` otherwise
   */
  def lookup(v: Var): Option[Binding]

  /**
   * Extends the environment with a new binding v -> a.
   * @param v the variable
   * @param a the value
   * @return the new [[Environment]]
   */
  def extend(v: Var, a: Value): Environment

  /**
   * Returns the list of bindings.
   * @return the list of bindings
   */
  def toList: List[Binding]
}

/**
 * This is a class representing the *initial* environment. The
 * initial environment is empty.
 */
abstract class InitialEnvironment extends Environment {
  // TODO: Part 4 - implement the initial environment
  def lookup(v: Var): Option[Binding] = None
  def extend(v: Var, a: Value): Environment = new ExtendedEnvironment(new Binding(v,a),this)
  def toList: List[Binding] = Nil
  override def toString: String = "{}"
}

/**
 * An extended environment is an environment that is created
 * with a list of bindings and a previous environment.
 * @param bindings the list of bindings
 * @param prev the previous environment
 */
private class ExtendedEnvironment(val binding: Binding,
                                  val prev: Environment)
                                  extends Environment {
  // TODO: Part 4 - implement the extended environment
  def extend(v: Var, a: Value): Environment = new ExtendedEnvironment(new Binding(v,a),this)
  def lookup(v: Var): Option[Binding] = if(binding.v == v) Some(binding) else prev.lookup(v)
  def toList: List[Binding] = prev.toList :+ binding
  override def toString: String =
    "{" + toList.mkString(", ") + "}"
}

/** The initial empty environment */
object Environment extends InitialEnvironment
