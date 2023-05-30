
import domain.Record;
import ui.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Record record = new Record();
        UserInterface UI = new UserInterface(scanner, record);

        UI.start();

    }
}
