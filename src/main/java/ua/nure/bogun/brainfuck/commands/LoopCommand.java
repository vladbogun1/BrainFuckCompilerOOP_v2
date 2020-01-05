package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Memory;

import java.util.List;
/**
 * LoopCommand class implements Command interface to execute some actions.
 * It stores instance of memory to make some operations on it.
 * Stores list of commands which it need execute in loop
 * Object store count integer, how many times command must be executed.
 */
public class LoopCommand implements Command {
    private Memory memory;
    private int count;
    private List<Command> loopCommands;

    public LoopCommand(List<Command> loopCommands) {
        this.memory = Memory.getInstance();
        this.count = 1;
        this.loopCommands = loopCommands;
    }

    /**
     * @param count set how many times repeat executions
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * make some operation in loop so many times as counter is
     */
    @Override
    public void execute() {
        int n = count;
        while (n > 0) {
            doLoop();
            n--;
        }
    }

    /**
     * execute all commands in loopCommands while pointer in memory points at byte>0
     */
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