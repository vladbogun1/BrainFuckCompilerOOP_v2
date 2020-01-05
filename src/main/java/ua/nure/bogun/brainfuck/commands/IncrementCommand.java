package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Memory;
/**
 * IncrementCommand class implements Command interface to execute some actions.
 * It stores instance of memory to make some operations on it.
 * Object store count integer, how many times command must be executed.
 */
public class IncrementCommand implements Command {
    private Memory memory;
    private int count;

    public IncrementCommand() {
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
            doIncrement();
            n--;
        }
    }
    /**
     * set byte+=1 in memory on current pointer position
     */
    private void doIncrement(){
        memory.arr[memory.getPointer()]++;
    }
}