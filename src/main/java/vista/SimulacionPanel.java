package vista;

import controlador.ControladorJugadores;

import java.awt.*;

public class SimulacionPanel extends Panel {
    private ClasificacionPanel clasificacionPanel;
    private ControladorJugadores controladorJugadores;
    public SimulacionPanel(ControladorJugadores controladorJugadores) {
        this.controladorJugadores = controladorJugadores;

        setPreferredSize(new Dimension(700, 680));
        setBackground(new Color(204, 255, 229));
        setLayout(new BorderLayout());

        this.clasificacionPanel = controladorJugadores.getClasificacionPartida();
        add(clasificacionPanel, BorderLayout.SOUTH);
    }
}
