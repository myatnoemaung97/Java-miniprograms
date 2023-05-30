package ui;

import domain.FileReader;
import domain.Recipe;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {
    private Scanner scanner;
    private FileReader fileReader;

    public UserInterface(Scanner scanner, FileReader fileReader) {
        this.scanner = scanner;
        this.fileReader = fileReader;
    }

    public void start() {
        System.out.print("File to read: ");
        String file = scanner.nextLine();
        fileReader.readFile(file);

        System.out.println("Commands:\n" +
                "list - lists the recipes\n" +
                "stop - stops the program\n" +
                "find name - searches recipes by name\n" +
                "find cooking time - searches recipes by cooking time\n" +
                "find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                list();
            } else if (command.equals("find name")) {
                findName();
            } else if (command.equals("find cooking time")) {
                findCookingTime();
            } else if (command.equals("find ingredient")) {
                findIngredient();
            }
        }
    }

    private void list() {
        System.out.println("Recipes:");
        fileReader.getCookBook().getRecipes().stream().forEach(System.out::println);
    }

    private void findName() {
        System.out.print("Searched word: ");
        String name = scanner.nextLine();
        System.out.println("Recipes:");
        fileReader.getCookBook().getRecipes().stream()
                .filter(recipe -> recipe.getName().contains(name))
                .forEach(System.out::println);
    }

    private void findCookingTime() {
        System.out.print("Max cooking time: ");
        int time = Integer.valueOf(scanner.nextLine());
        System.out.println("Recipes:");
        fileReader.getCookBook().getRecipes().stream()
                .filter(recipe -> recipe.getDuration() <= time)
                .forEach(System.out::println);
    }

    private void findIngredient() {
        System.out.print("Ingredient:");
        String ingredient = scanner.nextLine();
        System.out.println("Recipes:");
        for(Recipe recipe: fileReader.getCookBook().getRecipes()) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }
}
