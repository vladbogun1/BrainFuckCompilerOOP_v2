package ua.nure.bogun.brainfuck.commands;
/**
 * LoopBeginCommand class implements Command interface to execute some actions.
 * It stores position of starting loop for end of this loop.
 */
public class LoopBeginCommand implements Command {
    private int position;

    public LoopBeginCommand(int position) {
        this.position = position;
    }

    @Override
    public void execute() {
        // do nothing because all executions will be performed in LoopCommand
    }

    @Override
    public void setCount(int count) {
        // do nothing because all executions will be performed in LoopCommand
    }

    /**
     * @return stored position of loop beginning
     */
    public int getPosition() {
        return position;
    }
}
