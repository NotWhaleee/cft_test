package ru.kozorez;

public class Statistics {
    private double size = 0;
    private double min;
    private double max;
    private double sum = 0;
    private final boolean isString;

    public Statistics(boolean isString) {
        this.isString = isString;
    }

    //update statistics with every added value
    public void updateStats(long value) {
        size++;
        sum += value;

        if (size == 1) { //set min and max to value if it is the first elem
            min = value;
            max = value;
        } else {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
    }

    //update statistics with every added value
    public void updateStats(double value) {
        size++;
        sum += value;

        if (size == 1) { //set min and max to value if it is the first elem
            min = value;
            max = value;
        } else {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
    }

    //update statistics with every added value
    public void updateStats(String value) {
        size++;
        double length = value.length(); //length of the string

        if (size == 1) { //set min and max to the length of value if it is the first elem
            min = length;
            max = length;
        } else {
            if (length < min) {
                min = length;
            }
            if (length > max) {
                max = length;
            }
        }
    }

    //prints short statistics
    public void printShort() {
        System.out.println("Number of values: " + size);
    }

    //prints full statistics
    public void printFull() {
        if (isString) { //print statistics for strings
            System.out.println("Number of values: " + size);
            System.out.println("Size of the shortest string: " + min);
            System.out.println("Size of the largerst string: " + max);
        } else { //print statistics for numbers
            System.out.println("Number of values: " + size);
            System.out.println("The smallest number:" + min);
            System.out.println("The largest number:" + max);
            System.out.println("Sum: " + sum);
            if (size < 1) { //check for division by 0
                System.err.println("Size cannot be 0");
            } else {
                System.out.println("Avg: " + sum / size);
            }
        }
    }
}
