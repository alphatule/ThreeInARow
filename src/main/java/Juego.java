import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Juego {
    // Turno = True => Es turno del jugador / Jugador 1
    // Turno = False => Es turno de la maquina / Jugador 2
    private boolean turno;
    // El tablero deberia ser siempre un 3x3 pero podria variar para ampliar funcionalidad al juego.
    private short[][] tablero;
    // Config del juego
    private int tableroSize;

    public int getTableroSize() { return tableroSize; }

    public boolean isTurno() {
        return turno;
    }

    public short[][] getTablero() {
        return tablero;
    }

    // Creamos un nuevo tablero en blanco
    public void nuevaPartida() throws IOException {
        tableroSize = getConfigSize();
        short[][] tInit = new short[tableroSize][tableroSize];
        for (int i = 0; i < tableroSize; i++) {
            for (int j = 0; j < tableroSize; j++) {
                tInit[i][j] = 0;
            }
        }
        tablero = tInit;
        turno = true; // Colocamos el turno del jugador 1
    }

    // Indicamos la fila y columna donde el jugador (que tiene el turno) quiere colocar la ficha
    // por lo tanto deberiamos actualizar el tablero y el turno
    public boolean jugar(short fila, short columna)
    {
        if (tablero[fila][columna] != 0)
        {
            // Ya hay una ficha colocada
            return false;
        } else
        {
            // No hay ficha y la colocamos
            tablero[fila][columna] = (short) (turno ? 1 : 2);
            turno = !turno;
            return true;
        }
    }

    // Recogemos una fila y columna comrpobamos si es una jugada ganadora;
    // Devolvemos un booleano para saber si esta jugada es ganadora;
    // Hay que tener en cuenta que el tablero y el turno no se alteran
    public boolean jugadaGanadora(short fila, short columna)
    {
        short[][] tableroCopia = new short[tableroSize][tableroSize];

        for (int i = 0; i < tableroSize; i++) {
            for (int j = 0; j < tableroSize; j++) {
                tableroCopia[i][j] = tablero[i][j];
            }
        }

        // Colocamos la ficha en la posición indicada
        tableroCopia[fila][columna] = (short) (this.turno ? 1 : 2);

        // Verificamos si hay una jugada ganadora en todas las direcciones
        return chequearFila(tableroCopia, fila) ||
        chequearColumna(tableroCopia, columna) ||
        chequearDiagonalPrincipal(tableroCopia) ||
        chequearDiagonalSecundaria(tableroCopia);
    }

    public boolean esEmpate() {
        // Verificar si todas las casillas están ocupadas y no hay un ganador
        for (int i = 0; i < tableroSize; i++) {
            for (int j = 0; j < tableroSize; j++) {
                if (tablero[i][j] == 0) {
                    // Todavía hay casillas vacías, el juego no es un empate
                    return false;
                }
            }
        }
        // Si todas las casillas están ocupadas y no hay un ganador, es un empate
        return true; // !jugadaGanadora((short) 0, (short) 0); // Verifica si hay un ganador en cualquier posición (no importa la posición)
//        return !jugadaGanadora((short) 0, (short) 0); // Verifica si hay un ganador en cualquier posición (no importa la posición)
    }


    //Aplicamos nueva configuracion recibida del Main
    public void applyNewConfig(int size) throws IOException {
        if (size < 3 || size > 10) size = 3;
        String fileName = "boardSize.txt";
        File sC = new File(fileName);
        if (!sC.exists()) sC.createNewFile();
        if (sC.canRead())
        {
            FileWriter sConfig = new FileWriter(fileName);
            sConfig.write(String.valueOf(size));
            sConfig.close();
            Scanner cReader = new Scanner(sC);
            tableroSize = Integer.valueOf(cReader.nextLine());
        }
    }

    // Devolvemos un entero en el que miramos que medida tiene el tablero para crearlo
    private int getConfigSize() throws IOException {
        String fileName = "boardSize.txt";
        File sC = new File(fileName);
        if (!sC.exists()) return 3;
        else {
            Scanner cReader = new Scanner(sC);
            return Integer.valueOf(cReader.nextLine());
        }
    }

    private boolean chequearFila(short[][] tPrueba, int fila) {
        int ficha = tPrueba[fila][0];
        if (ficha == 0) return false;
        for (int j = 0; j < 3; j++) {
            if (tPrueba[fila][j] != ficha) {
                return false;
            }
        }
        return true;
    }

    private boolean chequearColumna(short[][] tPrueba, int columna) {
        int ficha = tPrueba[0][columna];
        if (ficha == 0) return false;
        for (int i = 0; i < 3; i++) {
            if (tPrueba[i][columna] != ficha) {
                return false;
            }
        }
        return true;
    }

    private boolean chequearDiagonalPrincipal(short[][] tPrueba) {
        int ficha = tPrueba[0][0];
        if (ficha == 0) return false;
        for (int i = 0; i < 3; i++) {
            if (tPrueba[i][i] != ficha) {
                return false;
            }
        }
        return true;
    }

    private boolean chequearDiagonalSecundaria(short[][] tPrueba) {
        int ficha = tPrueba[0][2];
        if (ficha == 0) return false;
        for (int i = 0; i < 3; i++) {
            if (tPrueba[i][2 - i] != ficha) {
                return false;
            }
        }
        return true;
    }
}
