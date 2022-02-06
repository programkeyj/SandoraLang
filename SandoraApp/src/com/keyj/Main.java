package com.keyj;

import com.keyj.parser.Lexer;
import com.keyj.parser.Parser;
import com.keyj.parser.Token;
import com.keyj.parser.ast.Statement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public final class Main {

    public static void main(String[] args) throws IOException {
        Path pathToFile = Paths.get("");
        String Debug = "";
        if (args.length > 0){
            if(args[0].equals("-Debug")){
                Debug = setDebug();
                pathToFile = getPathFromUser();
            }else {
                pathToFile = Paths.get(args[0]);
            }
            if(args.length > 1){
                Debug = args[1];
            }
        } else{
            pathToFile = getPathFromUser();
        }


        String input = "";
        while (input == "") {
            boolean existsOnLoad = Files.exists(pathToFile);
            boolean isFile = Files.isRegularFile(pathToFile);
            if (existsOnLoad && isFile) {
                try {
                    input = new String(Files.readAllBytes(pathToFile), "UTF-8");
                } catch (IOException e) {
                    System.out.printf("Error reading file! %s%n", e.getLocalizedMessage());
                    return;
                }
            } else {
                System.out.println("Entered file does not exist or incorrect!!!");
                pathToFile = getPathFromUser();
            }
        }

        final List<Token> tokens = new Lexer(input).tokenize();
        final Statement program = new Parser(tokens).parse();
        if (Debug.equals("-Debug")){
            System.out.println("[Debug on]");
            System.out.print("\n_[Started]_\n");
            for (Token token : tokens) {
                System.out.println(token);
            }
            System.out.println(program.toString());
        } else{
            System.out.println();
        }
        program.execute();
    }

    private static String WithoutDebug() {return "-debug";}

    private static String setDebug(){
        System.out.println("Setet to debug");
        return "-Debug";
    }

    private static Path getPathFromUser() {
        System.out.print("Enter full path to file:");
        Scanner scan = new Scanner(System.in);
        return Paths.get(scan.next());
    }

}
