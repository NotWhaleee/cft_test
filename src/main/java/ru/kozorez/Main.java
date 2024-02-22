package ru.kozorez;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //process arguments
        Argumens argumens = new Argumens();
        try {
            argumens.parseArgs(args);
        } catch (IOException ioe) {
            //no-op
        }
        //handle arguments
        argumens.handleArgs();
    }
}
