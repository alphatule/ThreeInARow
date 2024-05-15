import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;

public class Main {
    static boolean enMenu = true;
    static Juego juego = new Juego();
    static TUI tui = new TUI();
    public static void main(String[] args) {
        mostarMenu();
    }

    private static void mostarMenu()
    {
        while (enMenu)
        {
            try
            {
                switch (tui.mostrarMenu())
                {
                    case 1:
                        // New Game
                        nuevaPartida();
                        break;
                    case 2:
                        // Load Game
                        menuCargarPartida();
                        break;
                    case 3:
                        // Configuration
                        enMenu = configuracion();
                    case 4:
                        // Exit
                        salir();
                        break;
                }
            } catch (NumberFormatException e)
            {
                // Volvemos al menu de nuevo :)
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void nuevaPartida() throws IOException {
        enMenu = false;
        boolean enPartida = true;
        juego.nuevaPartida();
        tui.mostrarTablero(juego.getTablero(), juego.isTurno());
        while (enPartida)
        {
            if (juego.esEmpate())
            {
                // Es empate tenemos que notificar al jugador
                tui.finDePartida(0);
                enPartida = false;
            }
            short[] jugada = tui.recogerJugada(juego.getTableroSize());
            if (jugada[0] == (short) -1 && jugada[1] == (short) -1)
            {
                // Guardar partida
                enPartida = false;
                juego.guardarPartida();
            }
            else
            {
                if (juego.jugadaGanadora(jugada[0], jugada[1]))
                {
                    // Es una jugada ganadora por lo que mostramos tablero y notificamos de que ha ganado
                    juego.jugar(jugada[0], jugada[1]);
                    tui.mostrarTablero(juego.getTablero(), juego.isTurno());
                    tui.finDePartida(juego.isTurno() ? 1 : 2);
                    enPartida = false;
                } else if (juego.jugar(jugada[0], jugada[1]))
                {
                    // Hemos colocado ficha y cambiado el turno
                    tui.mostrarTablero(juego.getTablero(), juego.isTurno());
                }
                else
                {
                    // No hemos podido colocar ficha porque esta ocupado, asi que avisamos y que se vuelva a ejecutar
                    tui.jugadaNoCorrecta();
                }
            }
        }
        enMenu = true;
        mostarMenu();
    }

    private static void menuCargarPartida() throws IOException {
        boolean enMenuCargarPartida = true;
        while (enMenuCargarPartida)
        {
            File[] archivos = juego.partidasGuardadas();
            short oSc = tui.mostrarMenuPartidasGuardadas(archivos);
            if (oSc == archivos.length)
            {
                // Opcion de salir
                mostarMenu();
                enMenuCargarPartida = false;
            } else {
                // Cargar numero oSc

                juego.cargarPartida(archivos[oSc]);
                tui.mostrarTablero(juego.getTablero(), juego.isTurno());
                boolean enPartida = true;
                while (enPartida)
                {
                    if (juego.esEmpate())
                    {
                        // Es empate tenemos que notificar al jugador
                        tui.finDePartida(0);
                        enPartida = false;
                    }
                    short[] jugada = tui.recogerJugada(juego.getTableroSize());
                    if (jugada[0] == (short) -1 && jugada[1] == (short) -1)
                    {
                        // Guardar partida
                        enPartida = false;
                        juego.guardarPartida();
                    }
                    else
                    {
                        if (juego.jugadaGanadora(jugada[0], jugada[1]))
                        {
                            // Es una jugada ganadora por lo que mostramos tablero y notificamos de que ha ganado
                            juego.jugar(jugada[0], jugada[1]);
                            tui.mostrarTablero(juego.getTablero(), juego.isTurno());
                            tui.finDePartida(juego.isTurno() ? 1 : 2);
                            enPartida = false;
                        } else if (juego.jugar(jugada[0], jugada[1]))
                        {
                            // Hemos colocado ficha y cambiado el turno
                            tui.mostrarTablero(juego.getTablero(), juego.isTurno());
                        }
                        else
                        {
                            // No hemos podido colocar ficha porque esta ocupado, asi que avisamos y que se vuelva a ejecutar
                            tui.jugadaNoCorrecta();
                        }
                    }
                }
                enMenu = true;
                mostarMenu();
            }
        }
    }

    private static boolean configuracion()
    {
        boolean enMenuConfig = true;
        while (enMenuConfig)
        {
            try
            {
                switch (tui.mostrarMenuConfig())
                {
                    case 1:
                        // Le pedimos al tui la informacion de la configuracion y la aplicamos directamente al juego
                        juego.applyNewConfig(tui.seleccionarTamanoTablero());
                    case 2:
                        // Exit
                        mostarMenu();
                        enMenuConfig = false;
                }
            } catch (NumberFormatException e)
            {
                // Volvemos al menu de nuevo :)
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    private static void salir() { enMenu = false; }
}