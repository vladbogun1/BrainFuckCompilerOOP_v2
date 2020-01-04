package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Array;

public class PrevCommand implements Command {
    private Array memory;
    private int count;

    public PrevCommand() {
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
            doPrev();
            n--;
        }
    }

    private void doPrev() {
        memory.setPointer(memory.getPointer() - 1);
    }
}