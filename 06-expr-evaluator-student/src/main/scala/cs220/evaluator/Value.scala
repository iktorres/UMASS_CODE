package cs220.evaluator

/**
 * A [[Value]] represents a value that our evaluator returns. In
 * our simple language we only have one value which is a Number.
 * Here we represent it as a [[Double]]. Here is an example of
 * possible evaluations (=> means evaluates to):
 * {{{
 *   Number(5)                => Value(5.0)
 *   Add(Number(5),Number(4)) => Value(9.0)
 * }}}
 * @param i the value of the Value
 */
case class Value(i: Double) {
  /**
   * We override the toString method to simply return the
   * String of i.
   * @return the Value's String
   */
  override def toString: String = i.toString
}
