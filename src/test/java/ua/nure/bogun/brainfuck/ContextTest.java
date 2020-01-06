package ua.nure.bogun.brainfuck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.nure.bogun.brainfuck.commands.Command;


import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ContextTest {
    private String input;
    private int expected;


    public ContextTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection programs() {
        return Arrays.asList(new Object[][]{
                {"+g+", 2},
                {"-+", 2},
                {"", 0}
        });
    }

    @Test
    public void testHowCompilerCreateCommands() {
        Compiler compiler = new Compiler(input);
        assertEquals(
                "Context.List fails",
                expected,
                compiler.getContext().getCommandsListPointer()
        );
    }
}

