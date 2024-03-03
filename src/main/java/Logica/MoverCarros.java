package Logica;

import controlador.ControladorJugadores;

import javax.swing.*;
import java.util.Random;

public class MoverCarros extends Thread {

    private JLabel figura;
    private JPanel panelPadre;
    private boolean pausado;
    private boolean detenido;
    private int dx;
    private Jugador[] jugadores;
    private ControladorJugadores controladorJugadores;




    public MoverCarros(JLabel figura, JPanel panelPadre , ControladorJugadores controladorJugadores) {
        this.controladorJugadores= controladorJugadores;
        this.jugadores= controladorJugadores.getJugadores();
        this.figura = figura;
        this.panelPadre = panelPadre;
        Random rand = new Random();
        this.dx = rand.nextInt(50) + 1; // Velocidad aleatoria entre 1 y 5
        if (rand.nextBoolean()) this.dx *= -1; // Dirección aleatoria

        // Asegurar que la figura comienza en el centro del panel
        int initialX = (panelPadre.getWidth() - figura.getWidth()) / 2;
        int initialY = (panelPadre.getHeight() - figura.getHeight()) / 2;

        figura.setLocation(0, 0);
    }

    public void run() {



        while (!detenido) {
            if (!pausado) {
                // Mover figura en el eje x
                int nextX = figura.getX() + dx;

                // Validar bordes
                if (nextX < 0) {
                    nextX = 0;
                    dx *= -1; // Cambiar dirección en el eje x
                } else if (nextX + figura.getWidth() > panelPadre.getWidth()) {
                    nextX = panelPadre.getWidth() - figura.getWidth();
                    dx *= -1; // Cambiar dirección en el eje x
                }

                figura.setLocation(nextX, figura.getY());
            }

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

    public void detener() {
        this.detenido = true;
    }
}

