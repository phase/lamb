package xyz.jadonfowler.lamb;

import java.io.*;
import java.util.*;
import javax.script.*;

public class Lamb {
    
    public ScriptEngine engine;
    public static Lamb instance;

    public static void main(String[] args) {
        instance = new Lamb();
    }

    public Lamb() {
        ScriptEngineManager m = new ScriptEngineManager();
        this.engine = m.getEngineByName("JavaScript");

        if(args.length > 0) {
            File file = new File(args[0]);
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                for(String line; (line = br.readLine()) != null;) {
                    processCommand(line);
                }
            } finally {
                br.close();
            }
        } else {
            Console console = System.console();
            String input = console.readLine(">> ");
            processCommand(input);
        }
    }

    public void processCommand(String input) {
        System.out.println(engine.eval(input));
    }
}
