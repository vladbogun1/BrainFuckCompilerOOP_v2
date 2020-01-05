package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.commands.Command;

/**
 * Interface to create objects using factory pattern
 */
public interface CommandFactory {
    Command createCommand();
}
