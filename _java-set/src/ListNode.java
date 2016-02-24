/**
 * A node of a list used in ListSet
 *
 * @author: Eliot Moss
 *
 * Copyright 2015 by Eliot Moss
 */

public class ListNode {

  /**
   * A pointer to the next node in the list
   */
  private ListNode next = null;

  /**
   * The value associated with this node;
   * ordinarily, values are non-negative,
   * so -1 indicates a not-yet-used node
   */
  int value = -1;

  /**
   * counts the number of constructor calls
   */
  private static long constructorCalls = 0L;

  /**
   * counts the number of getNext calls
   */
  private static long getNextCalls = 0L;

  /**
   * counts the number of getNext calls
   */
  private static long setNextCalls = 0L;

  public static void clearCounters () {
    constructorCalls = 0L;
    getNextCalls     = 0L;
    setNextCalls     = 0L;
  }

  /**
   * all the fields are initialized in their declarations,
   * but we need the explicit constructor in order to count
   * constructor calls
   */
  public ListNode () {
    ++constructorCalls;
  }

  /**
   * the obvious getter for the next field
   * @return the next ListNode in the list
   */
  public ListNode getNext () {
    ++getNextCalls;
    return next;
  }

  /**
   * the obvious setter for the next field
   * @param the ListNode desired to be next after this one
   */
  public void setNext (final ListNode next) {
    ++setNextCalls;
    this.next = next;
  }

  /**
   * @return a long giving the number of calls to the constructor so far
   */
  public static long constructorCalls () {
    return constructorCalls;
  }

  /**
   * @return a long giving the number of calls of getNext so far
   */
  public static long getNextCalls () {
    return getNextCalls;
  }

  /**
   * @return a long giving the number of calls of setNext so far
   */
  public static long setNextCalls () {
    return setNextCalls;
  }

  /**
   * prints the counter values on System.out
   */
  public static void showCounts () {
    System.out.printf(
      "constructorCalls = %d, getNextCalls = %d, setNextCalls = %d%n",
      ListNode.constructorCalls(),
      ListNode.getNextCalls(),
      ListNode.setNextCalls());
  }

}
