import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Scanner;

public class TUI {
    // Creamos una instancia hacia el scanner
    Scanner sc = new Scanner(System.in);

    // Mostramos menu y devolvemos la opcion seleccionada
    public short mostrarMenu()
    {
        System.out.println("Welcome to Tic Tac Toe\n" +
                "1. New Game\n" +
                "2. Load Game\n" +
                "3. Configuration\n" +
                "4. Exit\n\n" +
                "Select a option:");
        return (short) Integer.parseInt(sc.nextLine());
    }

    public short mostrarMenuConfig()
    {
        System.out.println("Config Tic Tac Toe\n" +
                "1. Medida del tablero\n" +
                "2. Volver atrás\n" +
                "Select a option:");
        return (short) Integer.parseInt(sc.nextLine());
    }

    // Pediremos al usuario medida del tablero
    // Por defecto: 3
    // Minimo: 3 | Maximo: 10

    public int seleccionarTamañoTablero()
    {
        int size;
        System.out.println("Medida tablero Tic Tac Toe\n" +
                "- Por defecto 3\n" +
                "- Min 3\n" +
                "- Max 10\n" +
                "Select a option:");

        try {
            size = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) { return seleccionarTamañoTablero(); }

        if (size < 3 || size > 10) return seleccionarTamañoTablero();
        else return size;
    }

    public int seleccionarTamañoTablero(int defaultSize)
    {
        int size;
        System.out.println("Medida tablero Tic Tac Toe\n" +
                "- Por defecto " + defaultSize + "\n" +
                "- Min 3\n" +
                "- Max 10\n" +
                "Select a option:");

        try {
            size = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) { return seleccionarTamañoTablero(defaultSize); }

        if (size < 3 || size > 10) return seleccionarTamañoTablero(defaultSize);
        else return size;
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
                    // Posicion de jugador 1 (jugador fisico)
                    System.out.print("X");
                } else if (tablero[fila][columna] == 2)
                {
                    // posicion de jugador 2 (jugador maquina)
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
        short fila = -1;
        short columna = -1;
        while (true)
        {
            try
            {
                while (fila < 1 || fila > 3)
                {
                    System.out.println("Fila (horizontal) de 1 a 3: ");
                    fila = (short) Integer.parseInt(sc.nextLine());
                }
                while (columna < 1 || columna > 3)
                {
                    System.out.println("Columna (vertical) de 1 a 3: ");
                    columna = (short) Integer.parseInt(sc.nextLine());
                }
                return (short[]) new short[]{(short) (fila-1), (short) (columna-1)};
            } catch (NumberFormatException e){}
        }
    }

    // Indica el ganador de la partida o empate
    public char[][] finDePartida()
    {
        throw new NotImplementedException();
    }
}
