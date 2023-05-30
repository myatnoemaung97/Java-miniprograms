package domain;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    private CookBook cookBook;
    public FileReader() {
        this.cookBook = new CookBook();
    }

    public void readFile(String file) {
        try {
            Scanner scanner = new Scanner(Paths.get(file));
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                int duration = Integer.valueOf(scanner.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.equals("")) {
                        break;
                    }
                    ingredients.add(line);
                }

                cookBook.add(new Recipe(name, duration, ingredients));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public CookBook getCookBook() {
        return cookBook;
    }
}
