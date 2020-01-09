package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Memory;
/**
 * NextCommand class implements Command interface to execute some actions.
 * It stores instance of memory to make some operations on it.
 * Object store count integer, how many times command must be executed.
 */
public class NextCommand implements Command {
    private Memory memory;
    private int count;

    public NextCommand() {
        this.memory = Memory.getInstance();
        this.count = 1;
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
            doNext();
            n--;
        }
    }

    /**
     * set pointer in memory object to pointer+1
     */
    private void doNext(){
        memory.setPointer(memory.getPointer() + 1);
    }
}