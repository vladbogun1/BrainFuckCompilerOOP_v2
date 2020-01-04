package ua.nure.bogun.brainfuck.commands;

import ua.nure.bogun.brainfuck.Array;

public class PrintCommand implements Command {
    private Array memory;
    private int count;

    public PrintCommand() {
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
            doPrint();
            n--;
        }
    }
    private void doPrint(){
        System.out.print(
                (char) memory.arr[memory.getPointer()]
        );
    }
}