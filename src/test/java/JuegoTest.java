import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        Assertions.assertArrayEquals(j.getTablero(), tInit);
        Assertions.assertEquals(j.isTurno(), true);
    }
}