package controlador;

import Logica.*;
import vista.ClasificacionPanel;
import vista.VentanaPrincipal;

import javax.swing.*;
import java.util.concurrent.CyclicBarrier;

public class ControladorBotones {
    private VentanaPrincipal ventanaPrincipal;
    private ControladorJugadores controladorJugadores;

    public ControladorBotones(VentanaPrincipal ventanaPrincipal, ControladorJugadores controladorJugadores) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.controladorJugadores = controladorJugadores;
        configAccionesBotones();
    }

    public void configAccionesBotones() {
        ventanaPrincipal.getBotonInfo().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Proyecto desarrollado por:\nJose Salamanca\nAlejandro Diaz");
        });

        ventanaPrincipal.getBotonEmpezarPartida().addActionListener(e -> {
            boolean todosFueraDelJuego = true;
            for (Jugador jugador : controladorJugadores.getJugadores()) {
                if (jugador.isInGame()) {
                    todosFueraDelJuego = false;
                    JOptionPane.showMessageDialog(null, "Partida en curso, espera que termine y vuelve intentarlo");
                    break;
                }
            }
            if (todosFueraDelJuego) {
                controladorJugadores.comenzarPartidaJugadores();
            }
        });
    }
}
