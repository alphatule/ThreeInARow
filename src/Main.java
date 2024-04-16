import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int selection = 0;
            System.out.println("Welcome to Three In a row\n" +
                    "1. New Game\n" +
                    "2. Load Game\n" +
                    "3. Configuration\n" +
                    "4. Exit\n\n" +
                    "Select a option:");
            try {
                selection = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer input");
            }
            switch (selection) {
                case 1:
                    // New Game
                    break;
                case 2:
                    // Load Game
                    break;
                case 3:
                    // Configuration
                    break;
                case 4:
                    // Exit
                    break;
                default:
                    // Cualquier otro numero
            }
        }
    }
}