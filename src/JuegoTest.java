import org.junit.jupiter.api.Assertions;

class JuegoTest {
    @org.junit.jupiter.api.Test
    void jugar()
    {
        Juego j = new Juego();
        j.jugar((short) 0, (short) 0);
        short[][] tInit = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        Assertions.assertEquals(tInit,j.getTablero());
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
        Assertions.assertEquals(j.isTurno(), false);
    }
}