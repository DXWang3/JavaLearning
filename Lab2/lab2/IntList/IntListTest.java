package Lab2.lab2.IntList;
import static org.junit.Assert.*;
import org.junit.Test;

ppublic class IntListTest {

    /** Example test that verifies correctness of the IntList.list static
     *  method. The main point of this is to convince you that
     *  assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.list(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.list(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.list(1, 4, 9), L);
    }

    /** Do not use the new keyword in your tests. You can create
     *  lists using the handy IntList.list method.
     *
     *  Make sure to include test cases involving lists of various sizes
     *  on both sides of the operation. That includes the empty list, which
     *  can be instantiated, for example, with
     *  IntList empty = IntList.list().
     *
     *  Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     *  Anything can happen to A.
     */

    //TODO:  Create testSquareListRecursive()
    //TODO:  Create testDcatenate and testCatenate
    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.list(1, 2, 3);
        IntList S = IntList.list(2, 4, 6, 8, 10, 12);
        IntList G = IntList.squareListRecursive(L);
        IntList F = IntList.squareListRecursive(S);
        assertNotEquals(IntList.list(1, 4, 9), L);
        assertEquals(IntList.list(1, 4, 9), G);
        assertNotEquals(IntList.list(4, 16, 36, 64, 100, 144), S);
        assertEquals(IntList.list(4, 16, 36, 64, 100, 144), F);
    }

    @Test
    public void testDcatenate() {
        IntList A1 = IntList.list(1, 2, 3);
        IntList B1 = IntList.list(4, 5, 6);
        IntList A2 = IntList.list(2, 4, 6, 8, 10);
        IntList B2 = IntList.list(1, 3, 5, 7, 9);
        IntList.dcatenate(A1, B1);
        assertEquals(IntList.list(1, 2, 3, 4, 5, 6), A1);
        assertEquals(IntList.list(4, 5, 6), B1);
        IntList.dcatenate(A2, B2);
        assertEquals(IntList.list(2, 4, 6, 8, 10, 1, 3, 5, 7, 9), A2);
        assertEquals(IntList.list(1, 3, 5, 7, 9), B2);
        IntList.dcatenate(A1, A2);
        assertEquals(IntList.list(1, 2, 3, 4, 5, 6, 2, 4, 6, 8, 10, 1, 3, 5, 7, 9), A1);
        assertEquals(IntList.list(2, 4, 6, 8, 10, 1, 3, 5, 7, 9), A2);
        /**IntList.dcatenate(B1, B2);
         assertEquals(IntList.list(4, 5, 6, 1, 3, 5, 7, 9), B1);
         assertEquals(IntList.list(1, 3, 5, 7, 9), B2);*/


    }

    @Test
    public void testCatenate() {
        IntList A1 = IntList.list(1, 2, 3);
        IntList B1 = IntList.list(4, 5, 6);
        IntList A2 = IntList.list(2, 4, 6, 8, 10);
        IntList B2 = IntList.list(1, 3, 5, 7, 9);
        IntList S = IntList.catenate(A1, B1);
        IntList F = IntList.catenate(A2, B2);
        assertNotEquals(IntList.list(1, 2, 3, 4, 5, 6), A1);
        assertEquals(IntList.list(1, 2, 3), A1);
        assertEquals(IntList.list(4, 5, 6), B1);
        assertEquals(IntList.list(1, 2, 3, 4, 5, 6), S);
        assertNotEquals(IntList.list(2, 4, 6, 8, 10, 1, 3, 5, 7, 9), A2);
        assertEquals(IntList.list(2, 4, 6, 8, 10), A2);
        assertEquals(IntList.list(1, 3, 5, 7, 9), B2);
        assertEquals(IntList.list(2, 4, 6, 8, 10, 1, 3, 5, 7, 9), F);
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(IntListTest.class);
    }
}