import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Scanner;

public class TUI {
    // Creamos una instancia hacia el scanner
    Scanner sc = new Scanner(System.in);

    // Mostramos menu y devolvemos la opcion seleccionada
    public short mostrarMenu()
    {
        System.out.println("Welcome to Three In a row\n" +
                "1. New Game\n" +
                "2. Load Game\n" +
                "3. Configuration\n" +
                "4. Exit\n\n" +
                "Select a option:");
        return (short) Integer.parseInt(sc.nextLine());
    }

    // Muestra el tablero al completo y indica el turno del jugador
    public void mostrarTablero(short[][] tablero, short jugador)
    {
        System.out.println("tablero.length: "+tablero.length);
        // Primer bucle de fila
        // Segundo bucle de columnas
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (tablero[fila][columna] == 0)
                {
                    // Posicion vacia
                    System.out.print(0);
                } else if (tablero[fila][columna] == 1)
                {
                    // Posicion de jugador 1
                    System.out.print("X");
                } else if (tablero[fila][columna] == 2)
                {
                    // posicion de jugador 2
                    System.out.print("B");
                }
            }
            System.out.println();
        }
    }

    // Devuelve la casilla fila y columna de donde se ha colocado la nueva jugada
    // aparte de pedirle al jugador la jugada actual.
    public short[] recogerJugada()
    {
        throw new NotImplementedException();
    }

    // Indica el ganador de la partida o empate
    public char[][] finDePartida()
    {
        throw new NotImplementedException();
    }
}
