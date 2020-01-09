package ua.nure.bogun.brainfuck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.nure.bogun.brainfuck.commands.Command;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExecutorTest {
    private String input;
    private String expected;
    private final ByteArrayOutputStream OUTPUT_OUT = new ByteArrayOutputStream();
    private final ByteArrayOutputStream OUTPUT_ERR = new ByteArrayOutputStream();
    private final PrintStream ORIGIN_OUT = System.out;
    private final PrintStream ORIGIN_ERR = System.err;
    private static final String SEPARATOR = System.lineSeparator();

    public ExecutorTest(String input, String expected) {
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
        return Arrays.asList(new Object[][] {
                { "++++++++[>++++[>++>+++>+++>+<<<<-]" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+" +
                        "++.------.--------.>>+.", "Hello World!" },
                { "+++++h+++[>++++[>++>+++>+++>+<<<<-]" +
                        ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+" +
                        "++.------.--------.>>+.", "Hello World!" },
                { "", "" },
                { null, "Command can not be null!" + SEPARATOR}

        });
    }


    @Test
    public void testExecutorClassWork() {
        Compiler compiler = new Compiler(input);
        List<Command> list = compiler.getContext().getCommandsList();
        Executor executor = new Executor(list);
        executor.executeCommands();
        assertEquals(expected,
                OUTPUT_OUT.toString());
        OUTPUT_OUT.reset();
        OUTPUT_ERR.reset();
    }
}
