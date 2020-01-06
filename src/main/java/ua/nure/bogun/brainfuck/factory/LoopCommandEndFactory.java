package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.Context;
import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.LoopBeginCommand;
import ua.nure.bogun.brainfuck.commands.LoopCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Factory class for Loop command
 * this class creates LoopCommand object.
 * Stack is stored in context so this class need link to the context.
 */
public class LoopCommandEndFactory implements CommandFactory {
    private Context context;
    private int position;

    public LoopCommandEndFactory(Context context){
        this.context = context;
    }

    /**
     * get List of commands from start loop and create new LoopCommand object
     * @return new LoopCommand object
     */
    @Override
    public Command createCommand() {
        position = context.getCommandsListPointer();
        return new LoopCommand(getCommands());
    }

    /**
     * it find loop start and create subList from start to the end of the loop.
     * delete from context list this commands because they wil be stored in LoopCommand list
     * @return List of Command objects
     */
    private List<Command> getCommands(){
        int start = getStartPointer();
        int end = position;
        List<Command> subCommands = new ArrayList<>(context.getCommandsList().subList(start,end));
        context.getCommandsList().subList(start,end).clear();
        return subCommands;
    }

    /**
     * it get last object in stack, return it position in context list,
     * or if there is no pair brace return -1
     * @return start position of loop in context list
     */
    private int getStartPointer(){
        Stack<LoopBeginCommand> loopBeginStack = context.getLoopStack();
        if(!loopBeginStack.isEmpty()){
            LoopBeginCommand start = loopBeginStack.pop();
            return start.getPosition();
        }
        return -1;
    }
}
