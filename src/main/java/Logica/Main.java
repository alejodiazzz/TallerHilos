package Logica;


import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        Configuracion configuracion = new Configuracion("config.properties");

        // Crear jugadores
        Jugador[] jugadores = new Jugador[5];

        for (int i = 0; i < jugadores.length; i++) {
            String nombre = configuracion.obtenerValor("jugador" + (i + 1) + ".nombre");
            String ubicacion = configuracion.obtenerValor("jugador" + (i + 1) + ".ubicacion");
            int velocidad = Integer.parseInt(configuracion.obtenerValor("jugador" + (i + 1) + ".velocidad"));

            jugadores[i] = new Jugador(nombre, ubicacion, velocidad);
        }

        // Crear e iniciar hilos de Partida y HoraSegunUbicacion para cada jugador
        CyclicBarrier inicioPartidaBarrier = new CyclicBarrier(jugadores.length);

        Thread[] hilosPartida = new Thread[jugadores.length];
        Thread[] hilosHora = new Thread[jugadores.length];

        for (int i = 0; i < jugadores.length; i++) {
            hilosPartida[i] = new Partida(jugadores[i], inicioPartidaBarrier);
            hilosHora[i] = new HoraSegunUbicacion(jugadores[i], inicioPartidaBarrier);

            hilosPartida[i].start();
            hilosHora[i].start();
        }
        // Esperar a que ambos hilos terminen
        try {
            for (Thread hiloPartida : hilosPartida) {
                hiloPartida.join();
            }

            // Detener los hilos de HoraSegunUbicacion después de las partidas
            for (Thread hiloHora : hilosHora) {
                hiloHora.interrupt();
            }
        } catch (InterruptedException e) {
            System.err.println("Error al esperar a que los hilos de partida terminen: " + e.getMessage());
        }

        // Visualizar la clasificación al final
        CalcularPosicion calculadorPosicion = new CalcularPosicion();
        calculadorPosicion.ordenarJugadoresPorPuntajeYPartida(jugadores);

        System.out.println("\nClasificación Final:");
        for (Jugador jugador : jugadores) {
            System.out.println("Posición: " + jugador.getPosicion() + ". Jugador: " + jugador.getNombre() +
                    " - Partidas: " + jugador.getNumeroPartida() + " - Lanzamientos: " + jugador.getLanzamientos());
        }
    }
}
