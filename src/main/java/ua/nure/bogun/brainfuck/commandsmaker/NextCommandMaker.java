package ua.nure.bogun.brainfuck.commandsmaker;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.NextCommand;

public class NextCommandMaker implements CommandMaker {
    @Override
    public Command createCommand() {
        return new NextCommand();
    }
}
