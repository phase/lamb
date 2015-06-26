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
        if(input.contains(";") {
            for(String s : input.split(";")) {
                processCommand(s);
            }
            return;
        }
        if(input.matches("[a-zA-Z][0-9a-zA-Z]*(\\s)?:(\\s)?(\")?[0-9a-zA-Z]*(\")?")) {
            String name = input.split(":")[0].replace("\\s+", "");
            String value = input.split(":")[1];
            intput = "var " + name + "=" + value;
        }
        System.out.println(engine.eval(input));
    }
}
