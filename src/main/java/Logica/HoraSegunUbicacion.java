package Logica;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HoraSegunUbicacion extends Thread {
    private Jugador[] jugadores;
    private CyclicBarrier inicioPartidaBarrier;  // Sincronización del inicio de la partida
    private volatile boolean juegoTerminado = false;
    private JTextArea textArea = null;
    private static final int ACTUALIZACION_HORA_INTERVALO = 1000;

    public HoraSegunUbicacion(Jugador[] jugadores, CyclicBarrier inicioPartidaBarrier) {
        this.jugadores = jugadores;
        this.inicioPartidaBarrier = inicioPartidaBarrier;
    }

    public void detenerJuego() {
        juegoTerminado = true;
    }

    private String obtenerHora(Jugador jugador) {
        ZoneId zone = ZoneId.of(jugador.getUbicacion());
        LocalTime romeTime = LocalTime.now(zone);
        return ""+romeTime;
//        ZoneId zonaHoraria = ZoneId.of(jugador.getUbicacion());
//        return LocalDateTime.now(zonaHoraria).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
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
        while (!juegoTerminado && !Thread.currentThread().isInterrupted()) {

            for (Jugador aux: jugadores){
                aux.getReloj().setText(obtenerHora(aux));
            }
            try {
                Thread.sleep(ACTUALIZACION_HORA_INTERVALO);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
