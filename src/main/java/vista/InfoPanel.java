package vista;

import Logica.HoraSegunUbicacion;
import Logica.Jugador;
import controlador.ControladorJugadores;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class InfoPanel extends JPanel {
    private JugadorPanel jugador1;
    private JugadorPanel jugador2;
    private JugadorPanel jugador3;
    private JugadorPanel jugador4;
    private JugadorPanel jugador5;
    private ControladorJugadores controladorJugadores;
    private ArrayList<JugadorPanel> panels;
    private HoraSegunUbicacion horaSegunUbicacion;

    public InfoPanel(ControladorJugadores controladorJugadores) {

        this.controladorJugadores = controladorJugadores;
        this.panels = new ArrayList<>();

        setPreferredSize(new Dimension(280, 680));
        setBackground(new Color(204, 204, 204));

        this.jugador1 = new JugadorPanel();
        panels.add(jugador1);
        this.jugador2 = new JugadorPanel();
        panels.add(jugador2);
        this.jugador3 = new JugadorPanel();
        panels.add(jugador3);
        this.jugador4 = new JugadorPanel();
        panels.add(jugador4);
        this.jugador5 = new JugadorPanel();
        panels.add(jugador5);
        establecerDatosIniciales();
        horaSegunUbicacion = new HoraSegunUbicacion(controladorJugadores.getJugadores(), new CyclicBarrier(1));
        horaSegunUbicacion.start();


        add(jugador1);
        add(jugador2);
        add(jugador3);
        add(jugador4);
        add(jugador5);

    }

    public void establecerDatosIniciales() {
        Jugador[] jugadores = controladorJugadores.getJugadores();
        for (int i = 0; i < jugadores.length && i < panels.size(); i++) {
            Jugador auxJugador = jugadores[i];
            JugadorPanel panelAux = panels.get(i);
            panelAux.setNombre(auxJugador.getNombre());
            panelAux.setLanzamiento(String.valueOf(auxJugador.getLanzamientos()), String.valueOf(auxJugador.getPuntaje()), "423");
            panelAux.setHora(auxJugador.getUbicacion());
            auxJugador.setReloj(panelAux.getReloj());
        }
    }

    public JugadorPanel getJugador1() {
        return jugador1;
    }

    public JugadorPanel getJugador2() {
        return jugador2;
    }

    public JugadorPanel getJugador3() {
        return jugador3;
    }


    public JugadorPanel getJugador4() {
        return jugador4;
    }

    public JugadorPanel getJugador5() {
        return jugador5;
    }

}
