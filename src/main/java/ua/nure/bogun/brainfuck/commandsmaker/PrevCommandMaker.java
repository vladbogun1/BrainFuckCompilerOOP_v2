package ua.nure.bogun.brainfuck.commandsmaker;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.PrevCommand;

public class PrevCommandMaker implements CommandMaker {
    @Override
    public Command createCommand() {
        return new PrevCommand();
    }
}
