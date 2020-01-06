package ua.nure.bogun.brainfuck;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ua.nure.bogun.brainfuck.commands.DecrementCommandTest;
import ua.nure.bogun.brainfuck.commands.IncrementCommandTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainClassTest.class,
        MemoryGetPointerTest.class,
        MemorySetPointerTest.class,
        CompilerTest.class,
        ExecutorTest.class,
        ContextTest.class,
        DecrementCommandTest.class,
        IncrementCommandTest.class
})

public class RunTest extends Assert {

}
