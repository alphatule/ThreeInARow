import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Juego {
    // Turno = True => Es turno del jugador / Jugador 1
    // Turno = False => Es turno de la maquina / Jugador 2
    private boolean turno;
    // El tablero deberia ser siempre un 3x3 pero podria variar para ampliar funcionalidad al juego.
    private short[][] tablero;

    public boolean isTurno() {
        return turno;
    }

    public short[][] getTablero() {
        return tablero;
    }

    // Creamos un nuevo tablero en blanco
    public void nuevaPartida()
    {
        short[][] tInit = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        tablero = tInit;
        turno = true;

    }

    // Indicamos la fila y columna donde el jugador (que tiene el turno) quiere colocar la ficha
    // por lo tanto deberiamos actualizar el tablero y el turno
    public void jugar(short fila, short columna)
    {
        if (tablero[fila][columna] != 0)
        {
            // Ya hay una ficha colocada
//            return false;
        } else
        {
            // No hay ficha y la colocamos
            tablero[fila][columna] = (short) (turno ? 1 : 2);
            turno = !turno;
//            return true;
        }
    }

    // Recogemos una fila y columna comrpobamos si es una jugada ganadora;
    // Devolvemos un booleano para saber si esta jugada es ganadora;
    // Hay que tener en cuenta que el tablero y el turno no se alteran
    public boolean jugadaGanadora(short fila, short columna)
    {
        short[][] tableroCopia = new short[3][3];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tableroCopia[i][j] = tablero[i][j];
            }
        }

        // Colocamos la ficha en la posición indicada
        tableroCopia[fila][columna] = (short) (this.turno ? 1 : 2);

        // Verificamos si hay una jugada ganadora en todas las direcciones
        System.out.println(Boolean.toString(chequearFila(tableroCopia, fila)) +
                Boolean.toString(chequearColumna(tableroCopia, columna)) +
                        Boolean.toString(chequearDiagonalPrincipal(tableroCopia)) +
                                Boolean.toString(chequearDiagonalSecundaria(tableroCopia)));
        return chequearFila(tableroCopia, fila) ||
        chequearColumna(tableroCopia, columna) ||
        chequearDiagonalPrincipal(tableroCopia) ||
        chequearDiagonalSecundaria(tableroCopia);
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
