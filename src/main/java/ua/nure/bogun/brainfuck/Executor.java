package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;

import java.util.List;

/**
 * Executor class initiate all operations,
 * Which is mentioned in list.
 * List is got as constructor parameter.
 */
public class Executor {
    private List<Command> commands;

    /**
     * @param commands List of commands that need to be executed
     */
    public Executor(List<Command> commands){
        this.commands = commands;
    }

    /**
     * Method for initiating all commands in the list.
     */
    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
        Memory.removeInstance();
    }
}
