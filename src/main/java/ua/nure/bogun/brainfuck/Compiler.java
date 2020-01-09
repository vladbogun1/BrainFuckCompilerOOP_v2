package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.factory.*;

import java.util.*;

/**
 * Compiler is set for creating all Commands
 * commands are stored in Context class
 */
public class Compiler {

    private static final Map<Character, CommandFactory> BRAINFUCK_LEXEMAS = new HashMap<>();
    private Context context;



    public Compiler(String programString) {
        context = new Context();
        setLexemes();
        char[] programCommands = stringToChars(programString);
        readCommands(programCommands);
    }

    /**
     * @param string
     * auxiliary method to convert string into char array
     * if string is null, empty char array will be also created
     * @return char array
     */
    private char[] stringToChars(String string){
        char[] charArr;
        try {
            charArr = string.toCharArray();
        } catch (NullPointerException e) {
            System.out.println("Command can not be null!");
            charArr = "".toCharArray();
        }
        return  charArr;
    }

    /**
     * @param charCommands
     * Method goes through array and call addCommand() method.
     * In order to reduce heap memory of java application,
     * method counts sequential same operations and send one operation and it's count.
     */
    private void readCommands(char[] charCommands) {
        int counter = 1;
        for (int i = 0; i < charCommands.length; i++) {
            char operation = charCommands[i];
            if (i + 1 < charCommands.length && operation == charCommands[i + 1]) {
                counter++;
            } else {
                addCommand(operation, counter);
                counter = 1;
            }
        }
    }

    /**
     * @param operation
     * Method find operation in lexemas map,
     * use factory classes to generate commands,
     * add new commands to context list
     * @param counter
     */
    private void addCommand(char operation, int counter) {
        CommandFactory commandFactory = BRAINFUCK_LEXEMAS.get(operation);
        if (commandFactory != null) {
            Command newCommand = commandFactory.createCommand();
            if(newCommand!=null) {
                newCommand.setCount(counter);
                context.getCommandsList().add(newCommand);
            }
        }
    }


    /**
     * during initialization Compiler class it set lexemas to static map object
     */
    private void setLexemes() {
        BRAINFUCK_LEXEMAS.put('>', new NextCommandFactory());
        BRAINFUCK_LEXEMAS.put('<', new PrevCommandFactory());
        BRAINFUCK_LEXEMAS.put('+', new IncrementCommandFactory());
        BRAINFUCK_LEXEMAS.put('-', new DecrementCommandFactory());
        BRAINFUCK_LEXEMAS.put('.', new PrintCommandFactory());
        BRAINFUCK_LEXEMAS.put('[', new LoopCommandBeginFactory(this.context));
        BRAINFUCK_LEXEMAS.put(']', new LoopCommandEndFactory(this.context));
    }

    /**
     * @return
     * getter for context (in order to get list of commands)
     */
    public Context getContext() {
        return context;
    }
}
