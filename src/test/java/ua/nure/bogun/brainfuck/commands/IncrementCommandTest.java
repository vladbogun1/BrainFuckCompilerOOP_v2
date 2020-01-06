package ua.nure.bogun.brainfuck.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class IncrementCommandTest {
    private final ByteArrayOutputStream OUTPUT_OUT = new ByteArrayOutputStream();
    private final ByteArrayOutputStream OUTPUT_ERR = new ByteArrayOutputStream();
    private final PrintStream ORIGIN_OUT = System.out;
    private final PrintStream ORIGIN_ERR = System.err;



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

    @Test
    public void testExecuteIncrementMethod() {
        IncrementCommand incrementCommand = new IncrementCommand();
        incrementCommand.execute();

        PrintCommand printCommand = new PrintCommand();
        printCommand.execute();
        char oldItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        incrementCommand.execute();

        printCommand.execute();
        char newItem = OUTPUT_OUT.toString().toCharArray()[0];
        OUTPUT_OUT.reset();
        assertEquals("IncrementCommand execution failed",oldItem+1,newItem);
    }
}