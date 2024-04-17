import java.util.Scanner;

public class TUI {
    private void newGame() {
        // Empezamos el juego
        System.out.println("You chose: New Game");
    }
    private void loadGame() {
        // Cargamos juego / partida
        System.out.println("You chose: Load Game");
    }
    private void configuration() {
        // Configuracion del juego
        System.out.println("You chose: Configuration");
    }
    private void exit() {
        // Salimos/acabamos la aplicacion
        System.out.println("You chose: Exit");
    }
    public short menu(){
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
                    this.newGame();
                    return 1;
                case 2:
                    // Load Game
                    this.loadGame();
                    return 2;
                case 3:
                    // Configuration
                    this.configuration();
                    return 3;
                case 4:
                    // Exit
                    this.exit();
                    return 4;
                default:
                    // Cualquier otro numero
                    // seguira dando vueltas en el bucle
            }
        }
    }
}
