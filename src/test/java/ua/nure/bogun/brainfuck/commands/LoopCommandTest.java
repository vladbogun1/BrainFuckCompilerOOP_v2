package ua.nure.bogun.brainfuck.commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.nure.bogun.brainfuck.Memory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LoopCommandTest {
    private List<Command> input;
    private byte[] expected;


    public LoopCommandTest(List<Command> input, byte[] expected) {
        this.input = input;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection programs() {
        return Arrays.asList(new Object[][]{
                {
                        new ArrayList<>(
                                Arrays.asList(
                                        new IncrementCommand(),
                                        new DecrementCommand(),
                                        new PrintCommand(),
                                        new NextCommand()
                                )
                        ),
                        new byte[]{2, 1}
                },
                {
                        new ArrayList<>(
                                Arrays.asList(
                                        new IncrementCommand(),
                                        new IncrementCommand(),
                                        new PrintCommand(),
                                        new NextCommand()
                                )
                        ),
                        new byte[]{4, 3}
                },
                {
                        new ArrayList<>(
                                Arrays.asList(
                                        new DecrementCommand(),
                                        new DecrementCommand(),
                                        new PrintCommand(),
                                        new NextCommand()
                                )
                        ),
                        new byte[]{0, 0}
                }
        });
    }

    @Test
    public void testExecuteLoopMethod() {
        NextCommand nextCommand = new NextCommand();
        PrevCommand prevCommand = new PrevCommand();
        IncrementCommand incrementCommand = new IncrementCommand();

        incrementCommand.execute();
        incrementCommand.execute();
        nextCommand.execute();
        incrementCommand.execute();
        prevCommand.execute();

        LoopCommand loopCommand = new LoopCommand(input);
//        loopCommand.execute();
//        byte[] out = Memory.getInstance().arr;
//        for (int i = 0; i < out.length; i++) {
//            byte outputByte = out[i];
//            byte expectedByte = expected[i];
//            assertEquals(
//                    "LoopCommand.execute fails",
//                    expectedByte,
//                    outputByte
//            );
//            Memory.removeInstance();
//        }




    }
}