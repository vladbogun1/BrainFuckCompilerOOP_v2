package ua.nure.bogun.brainfuck.commands;

/**
 * Interface for command pattern
 */
public interface Command {

    /**
     * method for doing some operations
     */
    void execute();


    /**
     * method for setting how many times make execute operations
     */
    void setCount(int count);
}
