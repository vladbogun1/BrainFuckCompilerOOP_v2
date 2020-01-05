package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.factory.LoopCommandBeginFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Context store compiled commands and stack for loop comands
 * stack keep position of loop start
 * it is no need to make setter methods because all objects are send as links
 */
public class Context {
    private List<Command> commandsList;
    private Stack<LoopCommandBeginFactory> loopStack;

    Context(){
        this.commandsList = new ArrayList<>();
        this.loopStack = new Stack<>();

    }

    public List<Command> getCommandsList() {
        return commandsList;
    }

    public Stack<LoopCommandBeginFactory> getLoopStack() {
        return loopStack;
    }

    /**
     * is used to get iterator which always view at the end of the list
     * @return pointer on lastObject+1 in commandsList
     */
    public int getCommandsListPointer() {
        return commandsList.size();
    }
}
