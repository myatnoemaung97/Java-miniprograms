package ui;

import logic.BooksTracker;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    BooksTracker booksTracker;

    public UserInterface(Scanner scanner, BooksTracker booksTracker) {
        this.scanner = scanner;
        this.booksTracker = booksTracker;
    }

    public void start() {
        while (true) {
            System.out.println("[1] - Add a new student  \n" +
                "[2] - Update the number of books read \n" +
                "[3] - Total and average numbers of books read by students\n" +
                "[4] - IDs of students who have read fewer than ten books\n" +
                "[5] - Details of gold, silver and bronze winners\n" +
                "[-1] - Quit");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                break;
            }
            if (input.equals("1")) {
                addStudent();
            } else if (input.equals("2")) {
                updateBooks();
            } else if (input.equals("3")) {
                totalAndAverage();
            } else if (input.equals("4")) {
                fewThanTenIDs();
            } else if (input.equals("5")) {
                goldSilverBronze();
            }
        }

    }

    private void menu() {
        System.out.println("[1] - Add a new student  \n" +
                "[2] - Update the number of books read \n" +
                "[3] - Total and average numbers of books read by students\n" +
                "[4] - IDs of students who have read fewer than ten books\n" +
                "[5] - Details of gold, silver and bronze winners\n" +
                "[-1] - Quit");
    }

    private void addStudent() {
        System.out.println("Student ID?");
        String id = scanner.nextLine();
        booksTracker.addStudent(id);
    }

    private void updateBooks() {
        System.out.println("Student ID?");
        String id = scanner.nextLine();
        System.out.println("Number of books?");
        int books = Integer.valueOf(scanner.nextLine());
        booksTracker.readBook(id, books);
    }

    private void totalAndAverage() {
        System.out.println("Total books: " + booksTracker.totalBooks() + "\n" +
                "Average books: " + booksTracker.averageBooks());
    }

    private void fewThanTenIDs() {
        String[] ids = booksTracker.fewerThanTenBooks();
        System.out.println("IDs of students with number of books read fewer than ten: ");
        Arrays.stream(ids)
                .forEach(System.out::println);
    }

    private void goldSilverBronze() {
        String[] ids = booksTracker.goldSilverBronze();
        System.out.println("Gold: " + ids[0] + "(" + booksTracker.findBooks(ids[0]) + ")");
        System.out.println("Silver: " + ids[1] + "(" + booksTracker.findBooks(ids[1]) + ")");
        System.out.println("Bronze: " + ids[2] + "(" + booksTracker.findBooks(ids[2]) + ")");
    }



}
