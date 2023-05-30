
import domain.FileReader;
import ui.UserInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();

        UserInterface ui = new UserInterface(scanner, fileReader);

        ui.start();

    }

}
