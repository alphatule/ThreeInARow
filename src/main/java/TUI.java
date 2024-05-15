import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
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

    public short mostrarMenuPartidasGuardadas(File[] partidas)
    {
        System.out.println("Selecciona la partida que quieres cargar:");
        for (int i = 0; i < partidas.length; i++) {
            // nombre archivo
            System.out.println(String.valueOf(i+1)+". "+partidas[i].getName());
        }
        System.out.println(String.valueOf(partidas.length+1)+". Salir");
        return (short) (Integer.parseInt(sc.nextLine())-1);
    }

    // Pediremos al usuario medida del tablero
    // Por defecto: 3
    // Minimo: 3 | Maximo: 10
    public int seleccionarTamanoTablero()
    {
        int size;
        System.out.println("Medida tablero Tic Tac Toe\n" +
                "- Por defecto 3\n" +
                "- Min 3\n" +
                "- Max 10\n" +
                "Select a option:");

        try {
            size = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) { return seleccionarTamanoTablero(); }

        if (size < 3 || size > 10) return seleccionarTamanoTablero();
        else return size;
    }

    public int seleccionarTamanoTablero(int defaultSize)
    {
        int size;
        System.out.println("Medida tablero Tic Tac Toe\n" +
                "- Por defecto " + defaultSize + "\n" +
                "- Min 3\n" +
                "- Max 10\n" +
                "Select a option:");

        try {
            size = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) { return seleccionarTamanoTablero(defaultSize); }

        if (size < 3 || size > 10) return seleccionarTamanoTablero(defaultSize);
        else return size;
    }

    // Muestra el tablero al completo y indica el turno del jugador
    public void mostrarTablero(short[][] tablero, boolean jugador)
    {
        // jugador = True => Es turno del jugador / Jugador 1
        // jugador = False => Es turno de la maquina / Jugador 2
//        System.out.println("tablero.length: "+tablero.length);
        // Primer bucle de fila
        // Segundo bucle de columnas

        // NEW
        System.out.println("Tablero:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("   ");
                } else if (tablero[i][j] == 1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" O ");
                }
                if (j < tablero[i].length-1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < tablero.length-1) {
                for (int j = 0; j < tablero.length; j++) {
                    if (j == tablero.length-1) System.out.print("---");
                    else System.out.print("---+");
                }
                System.out.println();
            }
        }
        System.out.println("Turno del jugador: " + (jugador ? "X/1" : "O/2"));

        // ANTIGUO
//        for (int fila = 0; fila < tablero.length; fila++) {
//            for (int columna = 0; columna < tablero[fila].length; columna++) {
//                if (tablero[fila][columna] == 0)
//                {
//                    // Posicion vacia
//                    System.out.print("0" + (columna == tablero.length-1 ?  " ︱" : ""));
//                } else if (tablero[fila][columna] == 1)
//                {
//                    // Posicion de jugador 1 (jugador fisico)
//                    System.out.print("X" + (columna == tablero.length-1 ?  " ︱" : ""));
//                } else if (tablero[fila][columna] == 2)
//                {
//                    // posicion de jugador 2 (jugador maquina)
//                    System.out.print("B" + (columna == tablero.length-1 ?  " ︱" : ""));
//                }
//            }
//            System.out.println("══ ══ ══");
//            System.out.println();
//        }
//        System.out.println("Ahora es turno de jugador " + (jugador ? 1 : 2));
    }

    // Devuelve la casilla fila y columna de donde se ha colocado la nueva jugada
    // aparte de pedirle al jugador la jugada actual.
    public short[] recogerJugada(int tamanoTablero)
    {
        short fila = -1;
        short columna = -1;
        while (true)
        {
            try
            {
                while (fila < 1 || fila > tamanoTablero)
                {
                    System.out.println("Fila (horizontal) de 1 a " + tamanoTablero + ": ");
                    fila = (short) Integer.parseInt(sc.nextLine());
                    if (fila == (short) 0) break;
                }
                while (columna < 1 || columna > tamanoTablero)
                {
                    System.out.println("Columna (vertical) de 1 a " + tamanoTablero + ": ");
                    columna = (short) Integer.parseInt(sc.nextLine());
                    if (columna == (short) 0) break;
                }
                if (fila == (short) 0 && columna == (short) 0) return (short[]) new short[]{(short) -1, (short) -1};
                else if (fila == (short) 0 || columna == (short) 0) {
                    fila = -1;
                    columna = -1;
                    Integer.parseInt("-asd");
                }
                return (short[]) new short[]{(short) (fila-1), (short) (columna-1)};
            } catch (NumberFormatException e){ System.out.println("Jugada erronea, la posicion indicada no es correcta."); }
        }
    }

    // Indica que la jugada realizada no es correcta
    public void jugadaNoCorrecta()
    {
        System.out.println("Jugada erronea, ya hay una ficha en la posicion.");
    }


    // Indica el ganador de la partida o empate
    public void finDePartida(int jugador)
    {
        // jugador = True => Es turno del jugador / Jugador 1
        // jugador = False => Es turno de la maquina / Jugador 2
        if (jugador == 0)
        {
            System.out.println("Ha sido empate.");
        }
        else
        {
            System.out.println("Ha ganado el Jugador " + jugador);
        }
    }
}
