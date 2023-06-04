import domain.Student;
import logic.BooksTracker;
import ui.UserInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BooksTracker booksTracker = new BooksTracker();
        UserInterface ui = new UserInterface(scanner, booksTracker);
        ui.start();

        /*Map<Student, Integer> map= new HashMap<>();
        map.put(new Student("5"),0);
        System.out.println(map.get(new Student("5")));*/

    }
}