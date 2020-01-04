package ua.nure.bogun.brainfuck.commandsmaker;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.DecrementCommand;

public class DecrementCommandMaker implements CommandMaker {
    @Override
    public Command createCommand() {
        return new DecrementCommand();
    }
}
