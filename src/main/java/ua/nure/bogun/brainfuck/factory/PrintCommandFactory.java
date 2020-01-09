package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.PrintCommand;

/**
 * Factory class for Print command
 */
public class PrintCommandFactory implements CommandFactory {
    /**
     * method is implementation of CommandFactory interface
     * @return new PrintCommand object
     */
    @Override
     public Command createCommand() {
        return new PrintCommand();
    }
}

