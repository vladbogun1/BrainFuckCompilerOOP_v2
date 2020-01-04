package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Array;

public class IncrementCommand implements Command {
    private Array memory;
    private int count;

    public IncrementCommand() {
        this.memory = Array.getInstance();
        this.count = 1;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public void execute() {
        int n = count;
        while (n > 0) {
            doIncrement();
            n--;
        }
    }
    private void doIncrement(){
        memory.arr[memory.getPointer()]++;
    }
}