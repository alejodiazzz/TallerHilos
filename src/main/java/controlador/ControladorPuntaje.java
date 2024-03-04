package controlador;

import Logica.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ControladorPuntaje {
    private ArrayList<Jugador> posiciones;
    private ControladorJugadores controladorJugadores;
    private boolean puntajeGeneralCalculado = false;
    public ControladorPuntaje(ControladorJugadores controladorJugadores) {
        this.controladorJugadores = controladorJugadores;
        this.posiciones = new ArrayList<>();
    }

    public void calcularPuntaje(Jugador jugador) {
        int lanzamiento = new Random().nextInt(6) + 1 + new Random().nextInt(6) + 1;
        int nuevoPuntaje = jugador.getPuntaje() + lanzamiento;
        jugador.setUltimoLanzamiento(lanzamiento);

        if( nuevoPuntaje >=100){
            posiciones.add(jugador);
            jugador.setPuntaje(100);
        }else{
            jugador.setPuntaje(nuevoPuntaje);
        }
    }

    public void calcularPuntajeGeneral() {
        if(posiciones.isEmpty()){return;}
        asignarPosiciones();
        // Ordenar los jugadores por posición final
        Arrays.sort(controladorJugadores.getJugadores(), Comparator.comparingInt(Jugador::getPosicion));
        for (int i = 0; i < posiciones.size(); i++) {
            int puntajePartida = calcularPuntajePartida(i + 1); // Agregar 1 para que la primera posición sea 1 en lugar de 0
            posiciones.get(i).sumarPuntajeGeneral(puntajePartida);
        }
        posiciones.clear();
    }


    private static int calcularPuntajePartida(int posicion) {
        switch (posicion) {
            case 1:
                return 50;
            case 2:
                return 40;
            case 3:
                return 30;
            case 4:
                return 20;
            case 5:
                return 10;
            default:
                return 0;
        }
    }

    public void ordenarJugadoresPuntaje() {
        Jugador[] jugadores = controladorJugadores.getJugadores();
        if (jugadores != null && jugadores.length > 0) {
            Arrays.sort(jugadores, (jugador1, jugador2) -> {
                int comparadorPuntaje = Integer.compare(jugador2.getPuntaje(), jugador1.getPuntaje());
                if (comparadorPuntaje != 0) {
                    return comparadorPuntaje;
                }
                return Integer.compare(jugador1.getNumeroPartida(), jugador2.getNumeroPartida());
            });
        }
    }

    private void asignarPosiciones() {
        for(int i = 0; i < posiciones.size(); i++){
            posiciones.get(i).setPosicion(i+1);
        }
    }

    public ArrayList<Jugador> getPosiciones() {
        return posiciones;
    }
}
