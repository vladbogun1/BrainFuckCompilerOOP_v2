package ua.nure.bogun.brainfuck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.DecrementCommand;
import ua.nure.bogun.brainfuck.commands.IncrementCommand;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CompilerTest {
    private String input;
    private ArrayList<Command> expected;


    public CompilerTest(String input, ArrayList<Command> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection programs() {
        return Arrays.asList(new Object[][]{
                {"++",
                        new ArrayList<>(
                                Arrays.asList(
                                        new IncrementCommand(),
                                        new IncrementCommand()
                                )
                        )},
                {"-+",
                        new ArrayList<>(
                                Arrays.asList(
                                        new DecrementCommand(),
                                        new IncrementCommand()
                                )
                        )},
                {"", new ArrayList<>()}
        });
    }

    @Test
    public void testHowCompilerCreateCommands() {
        Compiler compiler = new Compiler(input);
        List<Command> output = compiler.getContext().getCommandsList();
        for (int i = 0; i < output.size(); i++) {
            Command outputCommand = output.get(i);
            Command expectedCommand = expected.get(i);
            assertEquals(
                    "Compiler.read&add fails",
                    expectedCommand.getClass(),
                    outputCommand.getClass()
            );
            Memory.removeInstance();
        }
    }
}