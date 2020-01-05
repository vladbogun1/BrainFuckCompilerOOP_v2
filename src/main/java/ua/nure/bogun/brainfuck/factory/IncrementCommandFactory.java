package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.IncrementCommand;
/**
 * Factory class for Increment command
 */
public class IncrementCommandFactory implements CommandFactory {
    /**
     * method is implementation of CommandFactory interface
     * @return new IncrementCommand object.
     */
    @Override
    public Command createCommand() {
        return new IncrementCommand();
    }
}

