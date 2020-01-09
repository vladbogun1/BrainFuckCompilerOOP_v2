package ua.nure.bogun.brainfuck.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.nure.bogun.brainfuck.Memory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NextCommandTest {
    private int input;
    private String expected;
    private final ByteArrayOutputStream OUTPUT_OUT = new ByteArrayOutputStream();
    private final ByteArrayOutputStream OUTPUT_ERR = new ByteArrayOutputStream();
    private final PrintStream ORIGIN_OUT = System.out;
    private final PrintStream ORIGIN_ERR = System.err;
    private static final String SEPARATOR = System.lineSeparator();

    public NextCommandTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(OUTPUT_OUT));
        System.setErr(new PrintStream(OUTPUT_ERR));
    }

    @After
    public void tearDown() {
        System.setOut(ORIGIN_OUT);
        System.setErr(ORIGIN_ERR);
    }

    @Parameterized.Parameters
    public static Collection programs() {
        return Arrays.asList(new Object[][]{
                {74, "KJ"},
                {82, "SR"},
                {99, "dc"},
                {64, "A@"}
        });
    }

    @Test
    public void testExecuteNextMethod() {
        NextCommand nextCommand = new NextCommand();
        IncrementCommand incrementCommand = new IncrementCommand();
        PrintCommand printCommand = new PrintCommand();



        incrementCommand.setCount(input+1);
        incrementCommand.execute();
        printCommand.execute();
        nextCommand.execute();
        incrementCommand.setCount(input);
        incrementCommand.execute();
        printCommand.execute();

        assertEquals("NextCommand execution failed", expected, OUTPUT_OUT.toString());
        Memory.removeInstance();
        OUTPUT_OUT.reset();
        OUTPUT_ERR.reset();

    }
}