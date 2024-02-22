package ru.kozorez;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class WriteResults {

    //write results to files
    public void writeResults(ParseFiles fileParser, String path, String prefix, boolean append) {

        String intLoc = "integers.txt";
        String floatLoc = "floats.txt";
        String strLoc = "strings.txt";

        //add prefix if necessary
        if (prefix != null) {
            intLoc = prefix + intLoc;
            floatLoc = prefix + floatLoc;
            strLoc = prefix + strLoc;
        }

        //creates directory if it does not exist.
        // to create new dirs in the project directory path should not start with '/' symbol
        if (path != null) {
            try {
                File fileInts = new File(path + intLoc);
                fileInts.getParentFile().mkdirs();
            } catch (Exception e) {
                System.err.println("Error opening file");
            }
        } else {
            path = "";
        }

        //write integers to file
        if (!fileParser.integers.isEmpty()) {
            writeToFile(path + intLoc, append, fileParser.integers);
        }

        //write doubles to file
        if (!fileParser.doubles.isEmpty()) {
            writeToFile(path + floatLoc, append, fileParser.doubles);
        }

        //write strings to file
        if (!fileParser.strings.isEmpty()) {
            writeToFile(path + strLoc, append, fileParser.strings);
        }
    }


    //writes list to file
    private void writeToFile(String fileName, boolean append, List<String> result) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, append);
            for (String str : result) {
                fileWriter.write(str + System.lineSeparator());
            }
            fileWriter.close();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + fileName);
        }
    }
}
