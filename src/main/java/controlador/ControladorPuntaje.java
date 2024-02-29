package controlador;

import Logica.Jugador;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ControladorPuntaje {
    public static void calcularPuntaje(Jugador jugador) {
        int lanzamiento = new Random().nextInt(6) + 1 + new Random().nextInt(6) + 1;
        int nuevoPuntaje = jugador.getPuntaje() + lanzamiento;
        jugador.setUltimoLanzamiento(nuevoPuntaje);
        jugador.setPuntaje(nuevoPuntaje);
    }

    public static void calcularPuntajeGeneral(Jugador[] jugadores) {
        // Ordenar los jugadores por posición final
        Arrays.sort(jugadores, Comparator.comparingInt(Jugador::getPosicion));

        for (int i = 0; i < jugadores.length; i++) {
            int puntajePartida = calcularPuntajePartida(i + 1);
            jugadores[i].sumarPuntajeGeneral(puntajePartida);

            System.out.println("Puntaje general de " + jugadores[i].getNombre() +
                    " después de las 5 partidas: " + jugadores[i].getPuntajeGeneral());
        }
    }

    private static int calcularPuntajePartida(int posicion) {
        switch (posicion) {
            case 1:
                return 500;
            case 2:
                return 400;
            case 3:
                return 300;
            case 4:
                return 200;
            case 5:
                return 100;
            default:
                return 0; // Manejar otras posiciones según sea necesario
        }
    }
}
