package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;

import java.util.List;

public class Executer {
    private List<Command> commands;
    public Executer(List<Command> commands){
        this.commands = commands;
    }
    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
