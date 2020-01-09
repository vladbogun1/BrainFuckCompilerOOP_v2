package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.DecrementCommand;
/**
 * Factory class for Decrement command
 */
public class DecrementCommandFactory implements CommandFactory {
    /**
     * method is implementation of CommandFactory interface
     * @return new DecrementCommand object.
     */
    @Override
    public Command createCommand() {
        return new DecrementCommand();
    }
}
