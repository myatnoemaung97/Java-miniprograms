package ui;

import domain.Record;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Record record;

    public UserInterface(Scanner scanner, Record record) {
        this.scanner = scanner;
        this.record = record;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");

        while (true) {
            int point = Integer.valueOf(scanner.nextLine());
            if (point == -1) {
                break;
            }
            record.add(point);
        }

        printAverage();
        printPassingAverage();
        printPercentage();
        printGradeDistribution();
    }

    private void printAverage() {
        System.out.println("Point average (all): " + record.average());
    }

    private void printPassingAverage() {
        if (record.passingAverage() == -1) {
            System.out.println("Point average (passing): -");
            return;
        }

        System.out.println("Point average (passing): " + record.passingAverage());
    }

    private void printPercentage() {
        System.out.println("Pass percentage: " + record.passPercentage());
    }

    private void printGradeDistribution() {
        System.out.println("Grade distribution");
        for (int i = 5; i >= 0; i--) {
            System.out.println(i + ": " + printStars(record.howManyStars(i)));
        }
    }

    private static String printStars(int stars) {
        String str = "";
        StringBuilder builder = new StringBuilder(str);
        for (int i = 1; i<= stars; i++) {
            builder.append("*");
        }
        String newStr = builder.toString();
        return newStr;
    }
}
