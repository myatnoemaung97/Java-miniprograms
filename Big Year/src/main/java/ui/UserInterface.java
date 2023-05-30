package ui;

import domain.Bird;
import domain.BirdBook;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private BirdBook birdBook;


    public UserInterface(Scanner scanner, BirdBook birdBook) {
        this.scanner = scanner;
        this.birdBook = birdBook;
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String input = scanner.nextLine();

            if (input.equals("Quit")) {
                break;
            } else if (input.equals("Add")) {
                add();
            } else if (input.equals("Observation")) {
                observation();
            } else if (input.equals("All")) {
                printAll();
            } else if (input.equals("One")) {
                printOne();
            }
        }

    }

    private void add() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Name in Latin: ");
        String latinName = scanner.nextLine();

        birdBook.add(new Bird(name, latinName));
    }

    private void observation() {
        System.out.print("Bird? ");
        String name = scanner.nextLine();
        if(!isABird(name)) {
            System.out.println("Not a bird!");
            return;
        }
        birdBook.getBird(name).watch();
    }

    private void printAll() {
        birdBook.getBirds().stream()
                .forEach(System.out::println);
    }

    private void printOne() {
        System.out.print("Bird? ");
        String name = scanner.nextLine();
        for (Bird bird: birdBook.getBirds()) {
            if (bird.getName().equals(name)) {
                System.out.println(bird);
            }
        }
    }

    private boolean isABird(String name) {
        for (Bird bird: birdBook.getBirds()) {
            if (bird.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
