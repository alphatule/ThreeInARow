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
                    System.out.println("You chose: New Game");
                    break;
                case 2:
                    // Load Game
                    System.out.println("You chose: Load Game");
                    break;
                case 3:
                    // Configuration
                    System.out.println("You chose: Configuration");
                    break;
                case 4:
                    // Exit
                    System.out.println("You chose: Exit");
                    break;
                default:
                    // Cualquier otro numero
            }
        }
    }
}