import com.sun.org.apache.bcel.internal.generic.FALOAD;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class Main {
    static boolean enMenu = true;
    static Juego juego = new Juego();
    public static void main(String[] args) {
        TUI tui = new TUI();

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
                        configuracion();
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

    private static void configuracion()
    {
        throw new NotImplementedException();
    }

    private static void salir()
    {
        enMenu = false;
    }
}