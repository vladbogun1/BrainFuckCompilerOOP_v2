package ua.nure.bogun.brainfuck.commands;

public interface Command {
    void execute();
    void setCount(int count);
}
