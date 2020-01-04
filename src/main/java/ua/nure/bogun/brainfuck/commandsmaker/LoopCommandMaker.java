package ua.nure.bogun.brainfuck.commandsmaker;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.LoopCommand;

public class LoopCommandMaker implements CommandMaker {
    @Override
    public Command createCommand() {
        return new LoopCommand();
    }
}

