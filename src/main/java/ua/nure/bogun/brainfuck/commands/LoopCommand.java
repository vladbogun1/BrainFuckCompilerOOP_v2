package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Array;

import java.util.List;

public class LoopCommand implements Command {
    private Array memory;
    private int count;
    private List<Command> loopCommands;

    public LoopCommand() {
        this.memory = Array.getInstance();
        this.count = 1;
        this.loopCommands = null;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLoopCommands(List<Command> loopCommands) {
        this.loopCommands = loopCommands;
    }

    @Override
    public void execute() {
        int n = count;
        while (n > 0) {
            doLoop();
            n--;
        }
    }

    private void doLoop() {
        if (loopCommands != null && !loopCommands.isEmpty()) {
            while (memory.arr[memory.getPointer()] > 0) {
                for (Command command : loopCommands) {
                    command.execute();
                }
            }
        }
    }
}