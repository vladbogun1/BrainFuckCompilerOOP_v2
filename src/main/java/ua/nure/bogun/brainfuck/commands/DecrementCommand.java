package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Array;

public class DecrementCommand implements Command {
    private Array memory;
    private int count;

    public DecrementCommand() {
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
            doDecrement();
            n--;
        }
    }
    private void doDecrement(){
        if (memory.arr[memory.getPointer()] > 0) {
            memory.arr[memory.getPointer()]--;
        }
    }
}