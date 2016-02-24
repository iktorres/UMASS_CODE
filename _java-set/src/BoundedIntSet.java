/**
 * Defines the API of a bounded sized set of non-negative ints.
 *
 * @author Eliot Moss
 *
 * Copyright 2015 Eliot Moss
 */

public interface BoundedIntSet {

  /**
   * @return an int giving the number of values present in the set
   */
  public int size ();

  /**
   * @return an int giving the maximum number of values the set can contain
   */
  public int capacity ();

  /**
   * Determines whether a given (presumed non-negative) value is in the set.
   * @param value an int giving the value whose presence should be tested
   * @return a boolean, true iff the value is in the set
   */
  public boolean contains (final int value);

  /**
   * removes a (presumed non-negative) value if it is in the set;
   * @param value an int giving the value to be removed
   * @return a boolean indicating whether the operation changed the set, i.e.,
   * true if the item was present, false if it was not
   */
  public boolean remove (final int value);

  /**
   * Adds a value to the set if it is not present.
   * @param value an int (presumed non-negative) giving the value to add
   * @return an int decribing what happened:
   *   0 means the value was present already
   *   1 means the value was not present, but no other value had to be discarded
   *     to make room for it
   *   2 means the value was not present, and some other value had to be discarded
   *     to make room for it
   */
  public int add (final int value);

}
