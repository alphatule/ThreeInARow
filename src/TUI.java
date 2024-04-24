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
    public void mostrarTablero(char[][] tablero, short jugador)
    {
        throw new NotImplementedException();
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
