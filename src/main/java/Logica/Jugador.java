package Logica;

import javax.swing.*;
import java.util.concurrent.CyclicBarrier;

public class Jugador {
    private int posicion;
    private String nombre;
    private String ubicacion;
    private int numeroPartida;
    private int puntajeGeneral;
    private int puntaje;
    private int puntajeRestante;
    private int ultimoLanzamiento;
    private volatile boolean juegoTerminado;
    private int lanzamientos;
    private CyclicBarrier cyclicBarrier;
    private JTextArea reloj;
    private boolean inGame;

    public Jugador(String nombre, String ubicacion, CyclicBarrier cyclicBarrier) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numeroPartida = 0;
        this.puntaje = 0;
        this.juegoTerminado = false;
        this.lanzamientos = 0;
        this.puntajeGeneral = 0;
        this.ultimoLanzamiento = 0;
        this.puntajeRestante = 0;
        this.cyclicBarrier = cyclicBarrier;
        this.inGame = false;
    }

    public Jugador(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getLanzamientos() {
        return lanzamientos;
    }
    public void incrementarLanzamientos() {
        lanzamientos++;
    }
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void actualizarPartida(){
        numeroPartida++;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void reiniciar() {
        this.setPosicion(0);
        this.setPuntaje(0);
        this.setLanzamientos(0);
        this.setPuntajeRestante(0);
        this.setJuegoTerminado(false);
        actualizarPartida();
    }
    public void setLanzamientos(int i) {
        this.lanzamientos = i;
    }

    public void sumarPuntajeGeneral(int puntajePartida) {
        this.puntajeGeneral = puntajePartida+getPuntajeGeneral();

    }
    public int getPuntajeGeneral() {
        return puntajeGeneral;
    }
    public void setPuntajeGeneral(int puntajeGeneral) {
        this.puntajeGeneral = puntajeGeneral;
    }
    public int getUltimoLanzamiento() {
        return ultimoLanzamiento;
    }

    public void setUltimoLanzamiento(int ultimoLanzamiento) {
        this.ultimoLanzamiento = ultimoLanzamiento;
    }

    public JTextArea getReloj() {
        return reloj;
    }

    public void setReloj(JTextArea reloj) {
        this.reloj = reloj;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
    public int getPuntajeRestante() {
        return puntajeRestante;
    }

    public void setPuntajeRestante(int puntajeRestante) {
        this.puntajeRestante = puntajeRestante;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "posicion=" + posicion +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
