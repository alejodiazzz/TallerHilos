package Logica;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Partida extends Thread {
    private Jugador jugador;


    private static int META = 100;
    private CyclicBarrier inicioPartidaBarrier;

    public Partida(Jugador jugador, CyclicBarrier inicioPartidaBarrier) {
        this.jugador = jugador;
        this.inicioPartidaBarrier = inicioPartidaBarrier;
    }
    public static int getMETA() {
        return META;
    }
    @Override
    public void run() {
        try {
            // Esperar a que todos los jugadores estén listos para iniciar
            inicioPartidaBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            return;
        }

        while (jugador.getPuntaje() < META && !jugador.isJuegoTerminado()) {
            CalcularPuntaje.calcularPuntaje(jugador);

            // Incrementar el contador de lanzamientos
            jugador.incrementarLanzamientos();

            // Mostrar puntaje y puntaje restante en cada lanzamiento
            int puntajeRestante = META - jugador.getPuntaje();
            System.out.println(jugador.getNombre() + " - Puntaje en la partida " + jugador.getNumeroPartida() +
                    ": " + jugador.getPuntaje() + " - Puntaje restante para llegar a la meta: " + puntajeRestante);

            if (jugador.getPuntaje() >= META) {
                System.out.println(jugador.getNombre() + " ha alcanzado la meta en la partida " + jugador.getNumeroPartida() +
                        " con " + jugador.getLanzamientos() + " lanzamientos.");

                // Asegurar que el hilo actual no esté interrumpido antes de usarlo
                if (!Thread.currentThread().isInterrupted()) {
                    // Detener el hilo de HoraSegunUbicacion asociado a este jugador
                    jugador.detenerHiloHora();
                }
            }

            // Ajustar el tiempo de espera después de cada lanzamiento exitoso
            int tiempoEspera = new Random().nextInt(3000) + 1000;
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        jugador.detenerJuego();
    }
}

