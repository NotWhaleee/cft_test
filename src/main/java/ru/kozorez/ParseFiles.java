package ru.kozorez;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseFiles {
    List<String> integers = new ArrayList<>();
    List<String> doubles = new ArrayList<>();
    List<String> strings = new ArrayList<>();

    Statistics intStats = new Statistics(false);
    Statistics doubleStats = new Statistics(false);
    Statistics stringStats = new Statistics(true);


    //initialize scanners for each input file
    public Scanner[] initializeScanners(List<String> fileNames) {
        Scanner[] scanners = new Scanner[fileNames.size()];
        for (int i = 0; i < scanners.length; i++) {
            //try opening input files.
            // if there are problems opening a file, the program continues to run without it
            try {
                scanners[i] = new Scanner(new File(fileNames.get(i)));
            } catch (IOException exception) {
                System.err.println("Error opening file: " + fileNames.get(i));
                scanners[i] = null;
            }
        }
        return scanners;
    }

    //close open scanners
    public void closeScanners(Scanner[] scanners) {
        for (Scanner scanner : scanners) {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    //process input string
    public void processInput(String input) {
        //process integers
        try {
            long temp = Long.parseLong(input);
            integers.add(input);
            intStats.updateStats(temp);
            return;
        } catch (NumberFormatException e) {
            //not an integer
        }

        //process doubles
        try {
            double temp = Double.parseDouble(input);
            doubles.add(input);
            doubleStats.updateStats(temp);
            return;
        } catch (NumberFormatException e) {
            //not a double
        }

        //process strings
        strings.add(input);
        stringStats.updateStats(input);
    }

    //parse files for values
    public void parseFiles(List<String> fileNames) {
        Scanner[] scanners = initializeScanners(fileNames);

        //process input values
        while (true) {
            int numOfProcessedFiles = 0;

            //scan files 1 by 1
            for (Scanner value : scanners) {

                //if scanner had not reached end of file process input
                if (value != null && value.hasNextLine()) {
                    String input = value.nextLine().trim();
                    processInput(input);
                } else { //reached end of file
                    numOfProcessedFiles++;
                }
            }

            //processed all files. exit infinite cycle
            if (numOfProcessedFiles == fileNames.size()) break;
        }

        closeScanners(scanners);
    }
}
