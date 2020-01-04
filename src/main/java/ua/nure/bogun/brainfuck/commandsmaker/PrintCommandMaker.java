package ua.nure.bogun.brainfuck.commandsmaker;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.PrintCommand;

public class PrintCommandMaker implements CommandMaker {
    @Override
     public Command createCommand() {
        return new PrintCommand();
    }
}

