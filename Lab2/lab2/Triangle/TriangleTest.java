
package Lab2.lab2.Triangle;

/*
 * JUnit tests for the Triangle class
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author melaniecebula
 */
public class TriangleTest {
    /**  We've already created a testScalene method.  Please fill in testEquilateral, and additionally
     *   create tests for Isosceles, Negative Sides, and Invalid sides
     **/

    @Test
    public void negativeSides() {
        Triangle first = new Triangle(-60, 60, 60);
        Triangle second = new Triangle(60, -60, 60);
        Triangle third = new Triangle(60, 60, -60);
        String resultFirst = first.triangleType();
        String resultSecond = second.triangleType();
        String resultThird = third.triangleType();
        assertEquals("At least one length is less than 0!", resultFirst);
        assertEquals("At least one length is less than 0!", resultSecond);
        assertEquals("At least one length is less than 0!", resultThird);
    }

    @Test
    public void invalidSides() {
        Triangle first = new Triangle(50, 15, 15);
        Triangle second = new Triangle(15, 50, 15);
        Triangle third = new Triangle(15, 15, 50);
        String resultFirst = first.triangleType();
        String resultSecond = second.triangleType();
        String resultThird = third.triangleType();
        assertEquals("The lengths of the triangles do not form a valid triangle!", resultFirst);
        assertEquals("The lengths of the triangles do not form a valid triangle!", resultSecond);
        assertEquals("The lengths of the triangles do not form a valid triangle!", resultThird);
    }

    @Test
    public void testScalene() {
        Triangle t = new Triangle(30, 40, 50);
        String result = t.triangleType();
        assertEquals("Scalene", result);
    }

    @Test
    public void testEquilateral() {
        Triangle f = new Triangle(60, 60, 60);
        Triangle s = new Triangle(1, 1, 1);
        String resultF = f.triangleType();
        String resultS = s.triangleType();
        assertEquals("Equilateral", resultF);
        assertEquals("Equilateral", resultS);
    }

    @Test
    public void testIsosceles(){
        Triangle f = new Triangle(40, 40, 60);
        Triangle s = new Triangle(20, 30, 20);
        String resultF = f.triangleType();
        String resultS = s.triangleType();
        assertEquals("Isosceles", resultF);
        assertEquals("Isosceles", resultS);
    }

    //TODO: CREATE MORE TESTS

    public static void main(String[] args) {
        //TODO: RUN TESTS (Look in ArithmeticTest.java main method for help!)
        jh61b.junit.textui.runClasses(TriangleTest.class);
    }
}