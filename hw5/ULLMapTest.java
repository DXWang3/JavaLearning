package hw5;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        assertEquals(um.get("Gracias"), "Dios Basado");

        um.put("whatsup", "bro");
        assertEquals(um.get("whatsup"), "bro");

        assertEquals(true, um.containsKey("whatsup"));
        assertEquals(true,um.containsKey("Gracias"));
        assertEquals(um.get("Gracias"), "Dios Basado");
    }


    @Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        while(umi.hasNext()){
            System.out.println(umi.next());
        }
    }

    @Test
    public void testInvert() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(1, "a");
        um.put(4, "h");
        um.put(0, "i");
        um.put(18, "p");

        ULLMap<String, Integer> inverse = ULLMap.invert(um);
        assertEquals(1, inverse.get("a"), 0.1);
        assertEquals(4, inverse.get("h"), 0.1);
        assertEquals(0, inverse.get("i"), 0.1);
        assertEquals(18, inverse.get("p"), 0.1);

    }


    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
} 