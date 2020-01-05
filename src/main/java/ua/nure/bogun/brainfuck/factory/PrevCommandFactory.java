package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.PrevCommand;
/**
 * Factory class for Prev command
 */
public class PrevCommandFactory implements CommandFactory {

    /**
     * method is implementation of CommandFactory interface
     * @return new PrevCommand object.
     */
    @Override
    public Command createCommand() {
        return new PrevCommand();
    }
}
