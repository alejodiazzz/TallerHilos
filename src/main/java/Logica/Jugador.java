package Logica;

import controlador.ControladorPuntaje;

import javax.swing.*;
import java.util.concurrent.CyclicBarrier;

public class Jugador {
    private int posicion;
    private String nombre;
    private String ubicacion;
    private int numeroPartida;
    private int puntajeGeneral;
    private int puntaje;
    private int ultimoLanzamiento;
    private int velocidad;
    private volatile boolean juegoTerminado;
    private int lanzamientos;
    private JTextArea reloj;

    public Jugador(String nombre, String ubicacion, int velocidad, CyclicBarrier cyclicBarrier) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numeroPartida = 0;
        this.puntaje = 0;
        this.velocidad = velocidad;
        this.juegoTerminado = false;
        this.lanzamientos = 0;
        this.puntajeGeneral = 0;
        this.ultimoLanzamiento = 0;
        //realizarLanzamiento();
    }

    public Jugador(String nombre, String ubicacion, int velocidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.velocidad = velocidad;
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
    public void realizarLanzamiento() {
        ControladorPuntaje.calcularPuntaje(this);
    }

    public int getVelocidad() {
        return velocidad;
    }

//    public void detenerJuego() {
//        juegoTerminado = true;
//        detenerHiloHora();
//    }

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
        // Reiniciar los datos del jugador para una nueva partida
        this.setPosicion(0);
        this.setPuntaje(0);
        this.setLanzamientos(0);
        this.juegoTerminado = false;
        actualizarPartida();

    }
    private void setLanzamientos(int i) {
        this.lanzamientos = i;
    }

    public void sumarPuntajeGeneral(int puntajePartida) {
        puntajeGeneral = puntajePartida+puntajeGeneral;

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
}
