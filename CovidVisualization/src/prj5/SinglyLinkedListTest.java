/**
 * 
 */
package prj5;

import java.util.Arrays;

/**
 * @author Hamza Saif
 * @version 2022.03.20
 *
 */
public class SinglyLinkedListTest extends student.TestCase {
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> list2;
    private SinglyLinkedList<String> emptyList;

    /**
     * set up
     */
    public void setUp() {
        list1 = new SinglyLinkedList<String>();
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        list2 = new SinglyLinkedList<String>();
        list2.add("banana");
        list2.add("apple");
        list2.add("kiwi");
        list2.add("mango");
        emptyList = new SinglyLinkedList<String>();
    }


    /**
     * test size()
     */
    public void testSize() {
        assertEquals(4, list1.size());
        list1.remove(1);
        assertEquals(3, list1.size());
        list1.clear();
        assertEquals(0, list1.size());
        assertEquals(0, emptyList.size());
    }


    /**
     * test add()
     */
    public void testAdd() {
        Object[] fruits = { "apple", "blueberry", "banana", "mango", "kiwi" };
        list1.add(1, "blueberry");
        assertTrue(Arrays.equals(list1.toArray(), fruits));
        list1.remove("blueberry");
        Object[] fruits2 = { "apple", "banana", "mango", "kiwi" };
        assertTrue(Arrays.equals(list1.toArray(), fruits2));
        list1.clear();
        list1.add("blueberry");
        Object[] fruits3 = { "blueberry" };
        assertTrue(Arrays.equals(list1.toArray(), fruits3));

        Exception exceptionA = null;
        try {
            list1.add(null);
            fail("add() is not throwing an exception when it should.");

        }
        catch (Exception e) {
            exceptionA = e;
        }
        assertTrue("add() is throwing the wrong type of exception",
            exceptionA instanceof IllegalArgumentException);

        Exception exceptionB = null;
        try {
            list1.add(-1, "lime");
            fail("add() is not throwing an exception when it should.");

        }
        catch (Exception e) {
            exceptionB = e;
        }
        assertTrue("add() is throwing the wrong type of exception",
            exceptionB instanceof IndexOutOfBoundsException);

        Exception exceptionC = null;
        try {
            list1.add(20, "lime");
            fail("add() is not throwing an exception when it should.");

        }
        catch (Exception e) {
            exceptionC = e;
        }
        assertTrue("add() is throwing the wrong type of exception",
            exceptionC instanceof IndexOutOfBoundsException);

        Exception exceptionD = null;
        try {
            list1.add(0, null);
            fail("add() is not throwing an exception when it should.");

        }
        catch (Exception e) {
            exceptionD = e;
        }
        assertTrue("add() is throwing the wrong type of exception",
            exceptionD instanceof IllegalArgumentException);
    }


    /**
     * test isEmpty()
     */
    public void testIsEmpty() {
        assertFalse(list1.isEmpty());
        list1.clear();
        assertTrue(list1.isEmpty());

    }


    /**
     * test remove()
     */
    public void testRemove() {
        Exception exceptionA = null;
        try {
            list1.remove(-1);
            fail("remove() is not throwing an exception when it should.");

        }
        catch (Exception e) {
            exceptionA = e;
        }
        assertTrue("remove() is not throwing an exception when it should",
            exceptionA instanceof IndexOutOfBoundsException);

        Exception exceptionB = null;
        try {
            list1.remove(20);
            fail("remove() is not throwing an exception when it should.");

        }
        catch (Exception e) {
            exceptionB = e;
        }
        assertTrue("remove() is throwing the wrong type of exception",
            exceptionB instanceof IndexOutOfBoundsException);

        list1.clear();
        Exception exceptionC = null;
        try {
            list1.remove(1);
            fail("remove() is throwing the wrong type of exception");

        }
        catch (Exception e) {
            exceptionC = e;
        }
        assertTrue("remove() is throwing the wrong type of exception",
            exceptionC instanceof IndexOutOfBoundsException);

    }


    /**
     * test get()
     */
    public void testGet() {
        assertEquals("mango", list1.get(2));
        list1.clear();
        list1.add("lemon");
        assertEquals("lemon", list1.get(0));
    }


    /**
     * test contains()
     */
    public void testContains() {
        assertFalse(list1.contains("cucumbers"));
        assertTrue(list1.contains("apple"));
        list1.clear();
        assertFalse(list1.contains("apple"));
        Exception exceptionC = null;
        try {
            list1.get(281);
            fail("get() is throwing the wrong type of exception");

        }
        catch (Exception e) {
            exceptionC = e;
        }
        assertTrue("get() is throwing the wrong type of exception",
            exceptionC instanceof IndexOutOfBoundsException);
    }


    /**
     * test clear()
     */
    public void testClear() {
        Object[] fruits = { "apple", "banana", "mango", "kiwi" };
        Object[] fruitsHalf = { "apple", "banana" };
        Object[] none = {};

        assertTrue(Arrays.equals(list1.toArray(), fruits));
        list1.clear();
        assertTrue(Arrays.equals(list1.toArray(), none));
        list1.add("apple");
        list1.add("banana");
        assertTrue(Arrays.equals(list1.toArray(), fruitsHalf));
        list1.clear();
        Exception exceptionC = null;
        try {
            list1.clear();
            fail("clear() is throwing the wrong type of exception");

        }
        catch (Exception e) {
            exceptionC = e;
        }
        assertTrue("clear() is throwing the wrong type of exception",
            exceptionC instanceof IllegalArgumentException);

    }


    /**
     * test lastIndexOf()
     */
    public void testLastIndexof() {
        assertEquals(3, list1.lastIndexOf("kiwi"));
        assertEquals(-1, list1.lastIndexOf("blueberry"));
    }


    /**
     * test toString()
     */

    public void testToString() {
        assertEquals("{apple, banana, mango, kiwi}", list1.toString());
        list1.clear();
        assertEquals("{}", list1.toString());
        list1.add("apple");
        list1.add("banana");
        assertEquals("{apple, banana}", list1.toString());

    }


    /**
     * test ToArray()
     */
    public void testToArray() {
        Object[] fruitArray = { "apple", "banana", "mango", "kiwi" };
        Object[] halfArray = { "apple", "banana" };
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(list1.toArray(), fruitArray));
        list1.clear();
        assertTrue(Arrays.equals(list1.toArray(), emptyArray));
        list1.add(0, "banana");
        list1.add(0, "apple");
        assertTrue(Arrays.equals(list1.toArray(), halfArray));
    }


    /**
     * test equals()
     */
    public void testEquals() {
        SinglyLinkedList<String> listCopy = new SinglyLinkedList<String>();
        listCopy.add("apple");
        listCopy.add("banana");
        listCopy.add("mango");
        listCopy.add("kiwi");
        assertTrue(list1.equals(list1)); // obj == this
        assertTrue(list1.equals(listCopy)); // obj == this

        assertFalse(list1.equals(null)); // obj == null
        String s = "hello";
        assertFalse(list1.equals(s)); // this.getClass() != obj.getClass()
        SinglyLinkedList<String> listCopy1 = new SinglyLinkedList<String>();
        listCopy1.add("apple");
        listCopy1.add("banana");
        listCopy1.add("mango");
        listCopy1.add("dragonfruit");
        assertFalse(list1.equals(listCopy1));


        SinglyLinkedList<String> listCopy2 = new SinglyLinkedList<String>();
        listCopy2.add("apple");
        listCopy2.add("banana");
        listCopy2.add("mango");
        assertFalse(list1.equals(listCopy1));

    }



}
