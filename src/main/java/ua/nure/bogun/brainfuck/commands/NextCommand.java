package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Array;

public class NextCommand implements Command {
    private Array memory;
    private int count;

    public NextCommand() {
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
            doNext();
            n--;
        }
    }
    private void doNext(){
        memory.setPointer(memory.getPointer() + 1);
    }
}