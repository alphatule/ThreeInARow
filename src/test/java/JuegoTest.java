import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;

class JuegoTest {
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "2,0"})
    void jugar_sin_ficha(short pos1, short pos2)
    {
        Juego j = new Juego();
        j.nuevaPartida();
        j.jugar(pos1, pos2);
        short[][] tInit = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        tInit[pos1][pos2] = 1;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                Assertions.assertEquals(tInit[i][k], j.getTablero()[i][k]);
            }
        }
        Assertions.assertArrayEquals(tInit, j.getTablero());
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,1", "0,2,10,0"})
    void jugar_con_ficha(short pos1, short pos2, short col1, short col2)
    {
        Juego j = new Juego();
        short[][] tInit = {{0,0,0},{0,0,0},{0,0,0}};

        j.nuevaPartida(); // Crea tablero y turno de X jugador
        j.jugar((short) 0, (short) 0);
        tInit[0][0] = 1;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                Assertions.assertEquals(tInit[i][k], j.getTablero()[i][k]);
            }
        }
        Assertions.assertArrayEquals(tInit, j.getTablero());
    }

    @org.junit.jupiter.api.Test
    void nuevaPartida()
    {
        Juego j = new Juego();
        j.nuevaPartida();
        short[][] tInit = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        Assertions.assertArrayEquals(tInit, j.getTablero());
        Assertions.assertEquals(true, j.isTurno());
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "2,0"})
    void juegadaGanadora(short fila, short columna)
    {
        Juego j = new Juego();
        j.nuevaPartida();
        Assertions.assertEquals(false, j.jugadaGanadora(fila, columna));
    }

    @ParameterizedTest
//    @CsvSource({"0,0,0,1", "0,2,2,0"})
    @CsvSource({"0,0,0,1"})
//    @CsvSource({"0,2,2,0"})
    void juegadaGanadora_2(short fila, short columna, short fila2, short columna2)
    {
        Juego j = new Juego();
        j.nuevaPartida();
        j.jugar(fila, columna);
        Assertions.assertEquals(false, j.jugadaGanadora(fila2, columna2));
        String a = "test";
    }


    @org.junit.jupiter.api.Test
    void juegadaGanadora_3__jugador1()
    {
        Juego j = new Juego();
        j.nuevaPartida();
        j.jugar((short) 0,(short) 0); // Jugador 1
        j.jugar((short) 1,(short) 0); // Jugador 2
        j.jugar((short) 0,(short) 1); // Jugador 1
        j.jugar((short) 1,(short) 1); // Jugador 2

        // Ultima jugada de jugador 1
        Assertions.assertEquals(true, j.jugadaGanadora((short) 0,(short) 2));
        // miramos que sea jugador 1 (true)
        Assertions.assertEquals(true, j.isTurno());
    }

    @org.junit.jupiter.api.Test
    void juegadaGanadora_3_jugador2()
    {
        Juego j = new Juego();
        j.nuevaPartida();
        j.jugar((short) 0,(short) 0); // Jugador 1
        j.jugar((short) 1,(short) 0); // Jugador 2
        j.jugar((short) 0,(short) 1); // Jugador 1
        j.jugar((short) 1,(short) 1); // Jugador 2
        j.jugar((short) 2,(short) 0); // Jugador 1

        // Ultima jugada de jugador 2
        Assertions.assertEquals(true, j.jugadaGanadora((short) 1,(short) 2));
        // miramos que sea jugador 2 (false)
        Assertions.assertEquals(false, j.isTurno());
    }
}