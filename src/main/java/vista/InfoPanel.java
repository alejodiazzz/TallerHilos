package vista;

import Logica.HoraSegunUbicacion;
import Logica.Jugador;
import controlador.ControladorJugadores;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

public class InfoPanel extends JPanel {
    private JugadorPanel jugador1;
    private JugadorPanel jugador2;
    private JugadorPanel jugador3;
    private JugadorPanel jugador4;
    private JugadorPanel jugador5;
    private ControladorJugadores controladorJugadores;
    private ArrayList<JugadorPanel> panels;
    private HashMap<String, JugadorPanel> panelReferencias;
    private HoraSegunUbicacion horaSegunUbicacion;

    public InfoPanel(ControladorJugadores controladorJugadores) {

        this.controladorJugadores = controladorJugadores;
        this.panels = new ArrayList<>();
        this.panelReferencias = new HashMap<>();

        setLayout(new GridLayout(5,1));
        setPreferredSize(new Dimension(280, 680));
        setBackground(new Color(204, 204, 204));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        for (int i = 0; i < 5; i++) {
            JugadorPanel jugadorPanel = new JugadorPanel();
            panels.add(jugadorPanel);
            add(jugadorPanel);
        }

        establecerDatosJugadores();
        horaSegunUbicacion = new HoraSegunUbicacion(controladorJugadores.getJugadores(), new CyclicBarrier(1));
        horaSegunUbicacion.start();

    }

    public void establecerDatosJugadores() {
            Jugador[] jugadores = controladorJugadores.getJugadores();
            for (int i = 0; i < jugadores.length && i < panels.size(); i++) {
                Jugador auxJugador = jugadores[i];
                JugadorPanel panelAux = panels.get(i);
                panelAux.setNombre(auxJugador.getNombre());
                panelAux.setLanzamiento(String.valueOf(auxJugador.getLanzamientos()), String.valueOf(auxJugador.getPuntaje()), String.valueOf(auxJugador.getPuntajeRestante()));
                panelAux.setUltimoLanzamiento(String.valueOf(auxJugador.getUltimoLanzamiento()));
                panelAux.setHora(auxJugador.getUbicacion());
                auxJugador.setReloj(panelAux.getReloj());
                panelReferencias.put(auxJugador.getNombre(), panelAux);
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

    public HashMap<String, JugadorPanel> getPanelReferencias() {
        return panelReferencias;
    }

    public void setPanelReferencias(HashMap<String, JugadorPanel> panelReferencias) {
        this.panelReferencias = panelReferencias;
    }
}
