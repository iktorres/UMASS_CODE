import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListBoundedIntSetTest {

  @BeforeClass
  public static void setUpClass () {
  }

  @Before
  public void setUp () {
    ListNode.clearCounters();
  }

  public static void assertNear (
      final long test,
      final int target,
      final int delta) {
    assertTrue(test >= (target-delta));
    assertTrue(test <= (target+delta));
  }

  public static void assertWithin (
      final long test,
      final int lo,
      final int hi) {
    assertTrue(lo <= test);
    assertTrue(test <= hi);
  }

  private static void assertCounters (
      final int constLo,
      final int constHi,
      final int getLo,
      final int getHi,
      final int setLo,
      final int setHi) {
    assertWithin(ListNode.constructorCalls(), constLo, constHi);
    assertWithin(ListNode.getNextCalls    (), getLo  , getHi  );
    assertWithin(ListNode.setNextCalls    (), setLo  , setHi  );
  }

  @Test
  public void testConstructor1 () {
    final ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    assertCounters(4, 4, 0, 0, 4, 4);
    assertEquals(0, s.size());
    assertEquals(4, s.capacity());
    assertFalse(s.contains(1));
    assertFalse(s.contains(2));
    assertFalse(s.contains(3));
    assertFalse(s.contains(4));
  }

  @Test
  public void testConstructor2 () {
    final ListBoundedIntSet s = new ListBoundedIntSet(new int[]{1, 2, 3, 4});
    // state 1 2 3 4
    assertCounters(4, 4, 0, 0, 4, 4);
    assertEquals(4, s.size());
    assertEquals(4, s.capacity());
    assertTrue(s.contains(1));
    assertTrue(s.contains(2));
    assertTrue(s.contains(3));
    assertTrue(s.contains(4));
  }

  @Test
  public void testSize () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    ListNode.clearCounters();
    assertEquals(0, s.size());
    assertCounters(0, 0, 0, 0, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, -1, -1, -1});
    // state 1 - - -
    ListNode.clearCounters();
    assertEquals(1, s.size());
    assertCounters(0, 0, 1, 1, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, 2, -1, -1});
    // state 1 2 - -
    ListNode.clearCounters();
    assertEquals(2, s.size());
    assertCounters(0, 0, 2, 2, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, 2, 3, -1});
    // state 1 2 3 -
    ListNode.clearCounters();
    assertEquals(3, s.size());
    assertCounters(0, 0, 3, 3, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, 2, 3, 4});
    // state 1 2 3 4
    ListNode.clearCounters();
    assertEquals(4, s.size());
    assertCounters(0, 0, 4, 4, 0, 0);
  }

  @Test
  public void testCapacity () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    ListNode.clearCounters();
    assertEquals(4, s.capacity());
    assertCounters(0, 0, 4, 4, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, -1, -1, -1});
    // state 1 - - -
    ListNode.clearCounters();
    assertEquals(4, s.capacity());
    assertCounters(0, 0, 4, 4, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, 2, -1, -1});
    // state 1 2 - -
    ListNode.clearCounters();
    assertEquals(4, s.capacity());
    assertCounters(0, 0, 4, 4, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, 2, 3, -1});
    // state 1 2 3 -
    ListNode.clearCounters();
    assertEquals(4, s.capacity());
    assertCounters(0, 0, 4, 4, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, 2, 3, 4});
    // state 1 2 3 4
    ListNode.clearCounters();
    assertEquals(4, s.capacity());
    assertCounters(0, 0, 4, 4, 0, 0);
  }

  @Test
  public void testContains () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -

    ListNode.clearCounters();
    assertFalse(s.contains(1));
    assertCounters(0, 0, 0, 0, 0, 0);

    s = new ListBoundedIntSet(new int[]{1, -1, -1, -1});
    // state 1 - - -
    ListNode.clearCounters();
    assertTrue(s.contains(1));
    assertCounters(0, 0, 0, 0, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.contains(2));
    assertCounters(0, 0, 1, 1, 0, 0);

    s = new ListBoundedIntSet(new int[]{2, 1, -1, -1});
    // state 2 1 - -
    ListNode.clearCounters();
    assertTrue(s.contains(2));
    assertCounters(0, 0, 0, 0, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.contains(3));
    assertCounters(0, 0, 2, 2, 0, 0);

    s = new ListBoundedIntSet(new int[]{3, 2, 1, -1});
    // state 3 2 1 -
    ListNode.clearCounters();
    assertTrue(s.contains(3));
    assertCounters(0, 0, 0, 0, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.contains(4));
    assertCounters(0, 0, 3, 3, 0, 0);

    s = new ListBoundedIntSet(new int[]{4, 3, 2, 1});
    // state 4 3 2 1
    ListNode.clearCounters();
    assertTrue(s.contains(4));
    assertCounters(0, 0, 0, 0, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.contains(5));
    assertCounters(0, 0, 4, 4, 0, 0);

    assertTrue(s.contains(1));
    assertTrue(s.contains(2));
    assertTrue(s.contains(3));
    assertTrue(s.contains(4));
  }

  @Test
  public void testAddNew () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    ListNode.clearCounters();
    assertEquals(1, s.add(1));
    // state 1 - - -
    assertEquals(1, s.add(2));
    // state 2 1 - -
    assertEquals(1, s.add(3));
    // state 3 2 1 -
    assertEquals(1, s.add(4));
    // state 4 3 2 1
    assertCounters(0, 0, 9, 14, 6, 8);
    assertTrue(s.contains(1));
    assertTrue(s.contains(2));
    assertTrue(s.contains(3));
    assertTrue(s.contains(4));
  }

  @Test
  public void testAddPresentNotFull () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    s.add(1);
    // state 1 - - -
    s.add(2);
    // state 2 1 - -
    s.add(3);
    // state 3 2 1 -
    ListNode.clearCounters();
    assertEquals(0, s.add(1));
    // state 1 3 2 -
    assertEquals(0, s.add(1));
    assertEquals(0, s.add(2));
    // state 2 1 3 -
    assertEquals(0, s.add(2));
    assertEquals(0, s.add(3));
    // state 3 2 1 -
    assertEquals(0, s.add(3));
    assertCounters(0, 0, 9, 12, 6, 9);
    assertTrue(s.contains(1));
    assertTrue(s.contains(2));
    assertTrue(s.contains(3));
  }

  @Test
  public void testAddPresentFull () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    s.add(1);
    // state 1 - - -
    s.add(2);
    // state 2 1 - -
    s.add(3);
    // state 3 2 1 -
    s.add(4);
    // state 4 3 2 1
    ListNode.clearCounters();
    assertEquals(0, s.add(1));
    // state 1 4 3 2
    assertEquals(0, s.add(1));
    assertEquals(0, s.add(2));
    // state 2 1 4 3
    assertEquals(0, s.add(2));
    assertEquals(0, s.add(3));
    // state 3 2 1 4
    assertEquals(0, s.add(3));
    assertEquals(0, s.add(4));
    // state 4 3 2 1
    assertEquals(0, s.add(4));
    assertCounters(0, 0, 12, 16, 8, 12);
    assertTrue(s.contains(1));
    assertTrue(s.contains(2));
    assertTrue(s.contains(3));
    assertTrue(s.contains(4));
  }

  @Test
  public void testAddNotPresentFull () {
    ListBoundedIntSet s = new ListBoundedIntSet(4);
    // state - - - -
    s.add(1);
    // state 1 - - -
    s.add(2);
    // state 2 1 - -
    s.add(3);
    // state 3 2 1 -
    s.add(4);
    // state 4 3 2 1
    ListNode.clearCounters();
    assertEquals(2, s.add(5));
    // state 5 4 3 2
    assertEquals(2, s.add(6));
    // state 6 5 4 3
    assertEquals(2, s.add(7));
    // state 7 6 5 4
    assertEquals(2, s.add(8));
    // state 8 7 6 5
    assertCounters(0, 0, 16, 24, 8, 12);
    assertFalse(s.contains(1));
    assertFalse(s.contains(2));
    assertFalse(s.contains(3));
    assertFalse(s.contains(4));
    assertTrue(s.contains(5));
    assertTrue(s.contains(6));
    assertTrue(s.contains(7));
    assertTrue(s.contains(8));
  }

  @Test
  public void testRemove () {
    ListBoundedIntSet s = new ListBoundedIntSet(new int[]{4, 3, 2, 1});
    // state 4 3 2 1

    ListNode.clearCounters();
    assertFalse(s.remove(5));
    assertCounters(0, 0, 4, 4, 0, 0);

    ListNode.clearCounters();
    assertTrue(s.remove(4));
    // state 3 2 1 -
    assertCounters(0, 0, 4, 4, 0, 0);
    ListNode.clearCounters();
    assertFalse(s.contains(4));
    assertCounters(0, 0, 3, 3, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.remove(4));
    assertCounters(0, 0, 3, 3, 0, 0);

    ListNode.clearCounters();
    assertTrue(s.remove(1));
    // state 3 2 - -
    assertCounters(0, 0, 3, 3, 0, 0);
    ListNode.clearCounters();
    assertFalse(s.contains(1));
    assertCounters(0, 0, 2, 2, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.remove(1));
    assertCounters(0, 0, 2, 2, 0, 0);

    ListNode.clearCounters();
    assertTrue(s.remove(3));
    // state 2 - - -
    assertCounters(0, 0, 2, 2, 0, 0);
    ListNode.clearCounters();
    assertFalse(s.contains(3));
    assertCounters(0, 0, 1, 1, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.remove(3));
    assertCounters(0, 0, 1, 1, 0, 0);

    ListNode.clearCounters();
    assertTrue(s.remove(2));
    // state - - - -
    assertCounters(0, 0, 1, 1, 0, 0);
    ListNode.clearCounters();
    assertFalse(s.contains(2));
    assertCounters(0, 0, 0, 0, 0, 0);

    ListNode.clearCounters();
    assertFalse(s.remove(2));
    assertCounters(0, 0, 0, 0, 0, 0);

    assertFalse(s.contains(1));
    assertFalse(s.contains(2));
    assertFalse(s.contains(3));
    assertFalse(s.contains(4));
  }

  @After
  public void tearDown () {
  }

  @AfterClass
  public static void tearDownClass () {
  }
}
