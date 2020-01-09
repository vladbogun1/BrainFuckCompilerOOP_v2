package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;

import java.util.List;

/**
 * Main class rule compiling and execution of Brainfuck programs
 * in order to make all java program runnable in console.
 */
public class MainClass {
    public static void main(String[] args) {
        String programString = (args.length > 0 && args[0] != null) ? args[0] :
                "++++++++++[>+>+++>+++++++>++++++++++<<<<-]" +
                        ">>>++++++++++++++.>+++++++++++++++++++++" +
                        ".---------.-----------.<<++.>>--.++++++++++++" +
                        ".--..------------.+++++++++++++.----------.<<" +
                        ".>>---.++++++++++++++++++.<<.>+++++++++++++.>-" +
                        ".<++++++.>+++.<++++++.--------.>-------.++++++.";
        Compiler compiler = new Compiler(programString);
        List<Command> commands = compiler.getContext().getCommandsList();
        Executor executor = new Executor(commands);
        executor.executeCommands();
    }
}
