package ua.nure.bogun.brainfuck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MemoryGetPointerTest {
    private int input;
    private int expected;


    public MemoryGetPointerTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection programs() {
        return Arrays.asList(new Object[][]{
                {102, 102},
                {0, 0},
                {-29, 65506},
                {65555, 20}

        });
    }


    @Test
    public void testMemoryGetPointer() {
        Memory.getInstance().setPointer(input);
        assertEquals(
                "Memory.getPointer fails",
                expected,
               Memory.getInstance().getPointer()
        );
        Memory.removeInstance();
    }
}
