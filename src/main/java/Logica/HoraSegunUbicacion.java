package Logica;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HoraSegunUbicacion extends Thread {
    private Jugador jugador;
    private CyclicBarrier inicioPartidaBarrier;  // Sincronización del inicio de la partida
    private volatile boolean juegoTerminado = false;

    private static final int ACTUALIZACION_HORA_INTERVALO = 5000;

    public HoraSegunUbicacion(Jugador jugador, CyclicBarrier inicioPartidaBarrier) {
        this.jugador = jugador;
        this.inicioPartidaBarrier = inicioPartidaBarrier;
    }

    public void detenerJuego() {
        juegoTerminado = true;
    }

    private void mostrarHora() {
        System.out.println("Hora según la ubicación de " + jugador.getNombre() + ": " + obtenerHoraFicticia());
    }

    private String obtenerHoraFicticia() {
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
            mostrarHora();
            try {
                Thread.sleep(ACTUALIZACION_HORA_INTERVALO);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
