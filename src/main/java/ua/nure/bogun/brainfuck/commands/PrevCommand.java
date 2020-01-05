package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Memory;
/**
 * PrevCommand class implements Command interface to execute some actions.
 * It stores instance of memory to make some operations on it.
 * Object store count integer, how many times command must be executed.
 */
public class PrevCommand implements Command {
    private Memory memory;
    private int count;

    public PrevCommand() {
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
            doPrev();
            n--;
        }
    }

    /**
     * set pointer in memory object to pointer-1
     */
    private void doPrev() {
        memory.setPointer(memory.getPointer() - 1);
    }
}