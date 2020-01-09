package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.Context;
import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commands.LoopBeginCommand;

/**
 * Factory class for Loop command
 * this class doesn't create any object.
 * using this class program store loop start position in stack
 * Stack is stored in context so this class need link to the context.
 */
public class LoopCommandBeginFactory implements CommandFactory {
    private Context context;

    public LoopCommandBeginFactory(Context context){
        this.context = context;
    }

    /**
     * put this class object into context stack
     */
    @Override
    public Command createCommand()  {
        int position = context.getCommandsListPointer();
        LoopBeginCommand command = new LoopBeginCommand(position);
        context.getLoopStack().push(command);
        return null;
    }



}
