package ru.kozorez;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Argumens {
    @Option(name = "-s", usage = "show short statistics")
    private boolean shortStat;

    @Option(name = "-f", usage = "show full statistics")
    private boolean fullStat;

    @Option(name = "-a", usage = "append to existing file")
    private boolean append;

    @Option(name = "-o", usage = "path to results files")
    private String path;

    @Option(name = "-p", usage = "output files prefix")
    private String prefix;

    // receives other command line parameters than options
    @Argument
    private List<String> fileNames = new ArrayList<>();

    //handles input arguments
    public void handleArgs() {
        //parse input files
        ParseFiles fileParser = new ParseFiles();
        fileParser.parseFiles(fileNames);

        //write result into output files
        WriteResults writeResults = new WriteResults();
        writeResults.writeResults(fileParser, path, prefix, append);

        //print stats
        if (fullStat) { //print full stats
            System.out.println("Full statistics for integers:");
            fileParser.intStats.printFull();
            System.out.println();
            System.out.println("Full statistics for floats:");
            fileParser.doubleStats.printFull();
            System.out.println();
            System.out.println("Full statistics for strings:");
            fileParser.stringStats.printFull();
            System.out.println();
        }
        if (shortStat) { //print short stats
            System.out.println("Short statistics for integers:");
            fileParser.intStats.printShort();
            System.out.println();
            System.out.println("Short statistics for floats:");
            fileParser.doubleStats.printShort();
            System.out.println();
            System.out.println("Short statistics for strings:");
            fileParser.stringStats.printShort();
            System.out.println();
        }
    }


    // parses the arguments form the command line.
    public void parseArgs(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);

        // size of the console
        parser.setUsageWidth(80);
        try {
            // parse the arguments.
            parser.parseArgument(args);

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java Main [options...] arguments...");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();
        }
    }
}
