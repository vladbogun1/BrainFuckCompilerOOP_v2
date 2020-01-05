package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Memory;

/**
 * PrintCommand class implements Command interface to execute some actions.
 * It stores instance of memory to make some operations on it.
 * Object store count integer, how many times command must be executed.
 */
public class PrintCommand implements Command {
    private Memory memory;
    private int count;

    public PrintCommand() {
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
            doPrint();
            n--;
        }
    }

    /**
     * gets byte from memory by pointer and print it in console as character
     */
    private void doPrint(){
        System.out.print(
                (char) memory.arr[memory.getPointer()]
        );
    }
}