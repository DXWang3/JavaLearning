package hw4.synthesizer;

import edu.princeton.cs.introcs.StdAudio;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the GuitarString class.
 *
 * @author Josh Hug
 */

public class TestGuitarString {
    @Test
    public void testPluckTheAString() {
        double CONCERT_A = 440.0;
        GuitarString aString = new GuitarString(CONCERT_A);
        aString.pluck();
        for (int i = 0; i < 50000; i += 1) {
            StdAudio.play(aString.sample());
            aString.tic();
        }
    }

    /** Calls tests for GuitarString. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestGuitarString.class);
    }
}