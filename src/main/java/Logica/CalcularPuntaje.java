package Logica;

public class CalcularPuntaje {
    public static String calcularPuntaje(Jugador jugador) {
        int lanzamiento = LanzamientoDados.lanzarDados();
        jugador.setPuntaje(jugador.getPuntaje() + lanzamiento);
        return "Jugador: " + jugador.getNombre() +
                " - Partida: " + jugador.getNumeroPartida() +
                " - Lanzamiento: " + lanzamiento +
                " - Puntaje Total: " + jugador.getPuntaje();
    }
}
