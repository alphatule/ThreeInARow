import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;

public class Main {
    static boolean enMenu = true;
    static Juego juego = new Juego();
    static TUI tui = new TUI();
    public static void main(String[] args) {
        mostarMenu();
    }

    private static void mostarMenu()
    {
        while (enMenu)
        {
            try
            {
                switch (tui.mostrarMenu())
                {
                    case 1:
                        // New Game
                        nuevaPartida();
                    case 2:
                        // Load Game
                        cargarPartida();
                    case 3:
                        // Configuration
                        enMenu = configuracion();

                    case 4:
                        // Exit
                        salir();
                        break;
                    default:
                        // Cualquier otro numero
                        // seguira dando vueltas en el bucle
                }
            } catch (NumberFormatException e)
            {
                // Volvemos al menu de nuevo :)
            }
        }
    }

    private static void nuevaPartida()
    {
        juego.nuevaPartida();
    }

    private static void cargarPartida()
    {
        throw new NotImplementedException();
    }

    private static boolean configuracion()
    {
        boolean enMenuConfig = true;
        while (enMenuConfig)
        {
            try
            {
                switch (tui.mostrarMenuConfig())
                {
                    case 1:
                        // New Game
                        int size = tui.seleccionarTamañoTablero();
                        System.out.println("\n\n\n\n\n\n\n\nTamaño Elegido " + size);
                        File sC = new File("boardSize.txt");
                        if (sC.exists()) sC.createNewFile();

                        throw new NotImplementedException();
                    case 2:
                        // Exit
                        mostarMenu();
                        enMenuConfig = false;
                    default:
                        // Cualquier otro numero
                        // seguira dando vueltas en el bucle
                }
            } catch (NumberFormatException e)
            {
                // Volvemos al menu de nuevo :)
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    private static void salir()
    {
        enMenu = false;
    }
}