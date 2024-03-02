package Logica;

import controlador.ControladorJugadores;
import controlador.ControladorPuntaje;
import vista.JugadorPanel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Partida extends Thread {
    private AtomicBoolean partidaTerminada = new AtomicBoolean(false);
    private Runnable onPartidaTerminada;
    private Jugador jugador;
    private static int META = 100;
    private CyclicBarrier inicioPartidaBarrier;
    private ControladorPuntaje controladorPuntaje;
    private JugadorPanel jugadorPanel;
    private ControladorJugadores controladorJugadores;

    public Partida(Jugador jugador, CyclicBarrier inicioPartidaBarrier, JugadorPanel jugadorPanel, ControladorJugadores controladorJugadores) {
        this.jugador = jugador;
        this.inicioPartidaBarrier = inicioPartidaBarrier;
        this.jugadorPanel = jugadorPanel;
        this.controladorJugadores = controladorJugadores;
        this.controladorPuntaje = controladorJugadores.getControladorPuntaje();
    }
    public static int getMETA() {
        return META;
    }

    @Override
    public void run() {
        try {
            inicioPartidaBarrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
            return;
        }

        while (jugador.getPuntaje() < META && !jugador.isJuegoTerminado()) {

            controladorPuntaje.calcularPuntaje(jugador);

            jugador.incrementarLanzamientos();

            int puntajeRestante = META - jugador.getPuntaje();
            jugador.setPuntajeRestante(puntajeRestante);

            jugadorPanel.setUltimoLanzamiento("" +jugador.getUltimoLanzamiento());
            jugadorPanel.setLanzamiento(""+jugador.getLanzamientos(), ""+jugador.getPuntaje(),""+jugador.getPuntajeRestante());
            int tiempoEspera = new Random().nextInt(3000) + 1000;
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            controladorPuntaje.ordenarJugadoresPuntaje();
            controladorJugadores.getClasificacionPartida().actualizarTabla(controladorJugadores.getJugadores(), false);

            if (jugador.getPuntaje() >= META) {
                jugador.setJuegoTerminado(true); // Detener el juego si el puntaje supera META
                break;
            }
        }
    }
    public AtomicBoolean getPartidaTerminada() {
        return partidaTerminada;
    }

}

