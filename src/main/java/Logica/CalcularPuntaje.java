package Logica;

public class CalcularPuntaje {
    public static void calcularPuntaje(Jugador jugador) {
        int lanzamiento = LanzamientoDados.lanzarDados();
        jugador.setPuntaje(jugador.getPuntaje() + lanzamiento);

    }
}
