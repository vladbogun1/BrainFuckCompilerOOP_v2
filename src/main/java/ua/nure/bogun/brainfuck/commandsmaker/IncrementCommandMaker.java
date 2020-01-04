package ua.nure.bogun.brainfuck.commandsmaker;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.IncrementCommand;

public class IncrementCommandMaker implements CommandMaker {
    @Override
    public Command createCommand() {
        return new IncrementCommand();
    }
}

