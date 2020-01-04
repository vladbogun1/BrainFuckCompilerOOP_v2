package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        String command = (args.length > 0 && args[0] != null) ? args[0] :
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.++++++.";
        Compiler compiler = new Compiler(command);
        List<Command> commands = compiler.getProgramCommandsList();
        Executer executer = new Executer(commands);
        executer.executeCommands();
    }
}
