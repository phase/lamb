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
                    System.out.println(processCommand(line));
                }
            } finally {
                br.close();
            }
        } else {
            Console console = System.console();
            while(true) {
                String input = console.readLine(">> ");
                System.out.println(processCommand(input));
            }
        }
    }

    public String processCommand(String input) {
        if(input.contains(";") {
            for(String s : input.split(";")) {
                processCommand(s);
            }
            return;
        }
        if(input.matches("[a-zA-Z][0-9a-zA-Z]*(\\s)?:(\\s)?(\")?[0-9a-zA-Z]*(\")?")) {
            String name = input.split(":")[0].replace("\\s+", "");
            String value = input.split(":")[1];
            intput = "var " + name + " = " + value;
        }
        else if(input.matches("[a-zA-Z][0-9a-zA-Z]*:(λ[a-zA-Z](.)?)+(?s).*")) {
            String name = input.split(":")[0];
            String code = input.split(":")[1].split(".")[input.split(":")[1].split(".").length-1];
            String vars = input.replace("." + this.code, "").replace("λ", "");
            String[] variables = vars.split(".");
            StringBuilder v = new StringBuilder();
            for (int i = 1; i < args.length; i++)
                v.append(variables[i] + ",");
            v.setLength(v.length() - 1);
            input = "var " + name + " = function(" + v.toString() + "){" + code + "};";
        }
        return engine.eval(input);
    }
}
