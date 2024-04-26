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
}