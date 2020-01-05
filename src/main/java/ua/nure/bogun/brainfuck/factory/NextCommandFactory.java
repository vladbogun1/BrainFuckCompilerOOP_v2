package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.NextCommand;
/**
 * Factory class for Next command
 */
public class NextCommandFactory implements CommandFactory {
    /**
     * method is implementation of CommandFactory interface
     * @return new NextCommand object.
     */
    @Override
    public Command createCommand() {
        return new NextCommand();
    }
}
