/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algo_lab_jargis_sir;

/**
 *
 * @author rumon
 */
import java.util.ArrayList;
import java.util.List;

public class MetaSorter {
    public static void main(String args) {
        int n = Integer.parseInt(args); // Taking n as a command-line argument
        System.out.println(n);
        String generatedProgram = generateSortProgram(n);
        System.out.println(generatedProgram);
    }

    public static String generateSortProgram(int n) {
        StringBuilder program = new StringBuilder();
        program.append("program sort(input,output);\n");
        program.append("var\n");

        // Generate variable declarations
        List<Character> variables = generateVariables(n);
        for (int i = 0; i < n; i++) {
            program.append("  ").append(variables.get(i)).append(" : integer;\n");
        }

        program.append("begin\n");

        // Generate readln statement
        program.append("  readln(");
        for (int i = 0; i < n; i++) {
            program.append(variables.get(i));
            if (i < n - 1) {
                program.append(",");
            }
        }
        program.append(");\n");

        // Generate if-then-else statements
        generateIfThenElseStatements(program, variables);

        // Generate writeln statements
        generateWritelnStatements(program, variables);

        program.append("end.");

        return program.toString();
    }

    private static List<Character> generateVariables(int n) {
        List<Character> variables = new ArrayList<>();
        char variable = 'a';
        for (int i = 0; i < n; i++) {
            variables.add(variable++);
        }
        return variables;
    }

    private static void generateIfThenElseStatements(StringBuilder program, List<Character> variables) {
        int n = variables.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                program.append("  if ").append(variables.get(i)).append(" > ").append(variables.get(j))
                        .append(" then\n");
                program.append("    begin\n");
                char temp = variables.get(i);
                variables.set(i, variables.get(j));
                variables.set(j, temp);
                program.append("    end\n");
                program.append("  else\n");
                program.append("    begin\n");
                program.append("    end;\n");
            }
        }
    }

    private static void generateWritelnStatements(StringBuilder program, List<Character> variables) {
        int n = variables.size();
        for (int i = 0; i < n; i++) {
            program.append("  writeln(").append(variables.get(i)).append(");\n");
        }
    }
}