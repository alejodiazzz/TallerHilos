package Logica;

import java.util.Arrays;

public class CalcularPosicion {
    public void ordenarJugadoresPorPuntajeYPartida(Jugador[] jugadores) {
        if (jugadores != null && jugadores.length > 0) {
            Arrays.sort(jugadores, (jugador1, jugador2) -> {
                // Ordenar por puntaje total
                int comparadorPuntaje = Integer.compare(jugador2.getPuntaje(), jugador1.getPuntaje());
                if (comparadorPuntaje != 0) {
                    return comparadorPuntaje;
                }

                // Si el puntaje total es el mismo, ordenar por número de partidas
                return Integer.compare(jugador1.getNumeroPartida(), jugador2.getNumeroPartida());
            });

            asignarPosiciones(jugadores);
        }
        // Puedes agregar un mensaje de registro o lanzar una excepción si lo prefieres
    }

    private void asignarPosiciones(Jugador[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].setPosicion(i + 1);
        }
    }
}
