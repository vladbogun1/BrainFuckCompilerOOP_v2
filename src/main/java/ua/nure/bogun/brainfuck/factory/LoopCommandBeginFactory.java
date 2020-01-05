package ua.nure.bogun.brainfuck.factory;

import ua.nure.bogun.brainfuck.Context;
import ua.nure.bogun.brainfuck.commands.Command;

/**
 * Factory class for Loop command
 * this class doesn't create any object.
 * using this class program store loop start position in stack
 * Stack is stored in context so this class need link to the context.
 */
public class LoopCommandBeginFactory implements CommandFactory {
    private Context context;
    private int position;
    public LoopCommandBeginFactory(Context context){
        this.context = context;
    }

    /**
     * put this class object into context stack
     */
    @Override
    public Command createCommand() {
        position = context.getCommandsListPointer();
        context.getLoopStack().push(this);
        return null;
    }

    /**
     * @return stored position of loop beginning
     */
    public int getPosition(){
        return position;
    }
}
