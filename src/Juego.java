import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Juego {
    // Turno = False => Es turno de la maquina
    // Turno = True => Es turno del jugador
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
        throw new NotImplementedException();
    }

    // Indicamos la fila y columna donde el jugador (que tiene el turno) quiere colocar la ficha
    // por lo tanto deberiamos actualizar el tablero y el turno
    public void jugar(short fila, short columna)
    {
        throw new NotImplementedException();
    }

    // Recogemos una fila y columna comrpobamos si es una jugada ganadora;
    // Devolvemos un booleano para saber si esta jugada es ganadora;
    // Hay que tener en cuenta que el tablero y el turno no se alteral
    public boolean jugadaGanadora(short fila, short columna)
    {
        throw new NotImplementedException();
    }
}
