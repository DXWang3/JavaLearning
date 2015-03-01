package Homework361B;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your
     * tests.  To use your unit tests for your own implementation, comment
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        //tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE
    @Test
    public void testAddPositivePositive() {
        int a = 5;
        int b = 3;
        int c = 6;
        assertEquals(0, tester.add(0, 0));
        assertEquals(8, tester.add(a, b));
        assertEquals(11, tester.add(a, c));
        assertEquals(9, tester.add(b, c));
    }

    @Test
    public void testAddPositiveNegative() {
        int a = -10;
        int b = 15;
        int c = 10;
        int d = 5;
        assertEquals(5, tester.add(a, b));
        assertEquals(0, tester.add(a, c));
        assertEquals(-5, tester.add(a, d));
    }

    @Test
    public void testAddNegativeNegative() {
        int a = -10;
        int b = -15;
        int c = -10;
        assertEquals(-25, tester.add(a, b));
        assertEquals(-20, tester.add(a, c));
        assertEquals(-25, tester.add(b, c));
    }

    @Test
    public void testMultiplyPositivePositive() {
        int a = 15;
        int b = 2;
        int c = 5;
        assertEquals(0, tester.multiply(0, 0));
        assertEquals(30, tester.multiply(a, b));
        assertEquals(75, tester.multiply(a, c));
        assertEquals(10, tester.multiply(b, c));
    }

    @Test
    public void testMultiplyPositiveNegative() {
        int a = -10;
        int b = 4;
        int c = 5;
        int d = -20;
        assertEquals(-40, tester.multiply(a, b));
        assertEquals(-50, tester.multiply(a, c));
        assertEquals(-80, tester.multiply(b, d));
        assertEquals(-100, tester.multiply(c, d));
    }

    @Test
    public void testMultiplyNegativeNegative() {
        int a = -12;
        int b = -8;
        int c = -9;
        assertEquals(96, tester.multiply(a, b));
        assertEquals(108, tester.multiply(a, c));
        assertEquals(72, tester.multiply(b, c));
    }

    /**@Test
    public void testSaveAndPrint() {
    tester.saveEquation("5 * 5", 25);
    tester.saveEquation("2 + 2", 4);
    tester.saveEquation("3 + 3", 6);
    tester.printAllHistory();
    tester.printHistory(1);
    tester.undoEquation();
    assertEquals(4, tester.pastResults.result);
    tester.clearHistory();
    assertEquals(null, tester.pastResults);
    }*/

    @Test
    public void testSum() {
        tester.saveEquation("5 * 5", 25);
        tester.saveEquation("2 + 2", 4);
        tester.saveEquation("3 + 3", 6);
        assertEquals(35, tester.cumulativeSum());
    }

    @Test
    public void testProduct() {
        tester.saveEquation("5 * 5", 25);
        tester.saveEquation("2 + 2", 4);
        tester.saveEquation("3 + 3", 6);
        assertEquals(600, tester.cumulativeProduct());
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }
}