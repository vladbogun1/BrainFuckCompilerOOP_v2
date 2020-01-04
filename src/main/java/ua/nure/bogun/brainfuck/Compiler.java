package ua.nure.bogun.brainfuck;

import ua.nure.bogun.brainfuck.commands.Command;
import ua.nure.bogun.brainfuck.commandsmaker.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compiler {
    private static final Map<Character, CommandMaker> BRAINFUCK_LEXEMAS = new HashMap<>();


    private List<Command> programCommandsList;


    public Compiler(String programString) {

        setLexemas();
        this.programCommandsList = new ArrayList<>();

        char[] charCommands;
        try {
            charCommands = programString.toCharArray();
        } catch (NullPointerException e) {
            System.out.println("Command can not be null!");
            charCommands = "".toCharArray();
        }
        readCommands(charCommands);
    }

    private void readCommands(char[] charCommands) {
        int counter = 1;
        for (int i = 0; i < charCommands.length; i++) {
            char operation = charCommands[i];
            if (i + 1 < charCommands.length && operation == charCommands[i + 1]) {
                counter++;
            } else {
                addCommand(operation,counter);
                counter = 1;
            }
        }
    }

    private void addCommand(char operation, int counter){
        CommandMaker commandMaker = BRAINFUCK_LEXEMAS.get(operation);
        if(commandMaker!=null){
            Command newCommand = commandMaker.createCommand();
            newCommand.setCount(counter);
            programCommandsList.add(newCommand);
        }
    }

    public List<Command> getProgramCommandsList() {
        return programCommandsList;
    }

    private void setLexemas(){
        BRAINFUCK_LEXEMAS.put('>', new NextCommandMaker());
        BRAINFUCK_LEXEMAS.put('<', new PrevCommandMaker());
        BRAINFUCK_LEXEMAS.put('+', new IncrementCommandMaker());
        BRAINFUCK_LEXEMAS.put('-', new DecrementCommandMaker());
        BRAINFUCK_LEXEMAS.put('.', new PrintCommandMaker());
        BRAINFUCK_LEXEMAS.put('[', new LoopCommandMaker());
    }
}
