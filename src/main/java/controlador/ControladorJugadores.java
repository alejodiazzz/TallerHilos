package controlador;

import Logica.Configuracion;
import Logica.Jugador;
import vista.ClasificacionPanel;
import vista.InfoPanel;
import vista.SimulacionPanel;

import java.util.concurrent.CyclicBarrier;

public class ControladorJugadores {
    private Configuracion configuracion;
    private ClasificacionPanel clasificacionGeneral, clasificacionPartida;
    private InfoPanel infoPanel;
    private SimulacionPanel simulacionPanel;
    private Jugador[] jugadores;
    public ControladorJugadores(){
        traerJugadores();
        clasificacionGeneral = new ClasificacionPanel(this, true);
        clasificacionPartida = new ClasificacionPanel(this, false);
        infoPanel = new InfoPanel(this);
        simulacionPanel = new SimulacionPanel(this);
    }
    private void traerJugadores(){
        // Crear jugadores
        this.configuracion = new Configuracion("config.properties");

        jugadores = new Jugador[5];
        for (int i = 0; i < jugadores.length; i++) {
            String name = configuracion.obtenerValor("jugador" + (i + 1) + ".nombre");
            String ubicacion = configuracion.obtenerValor("jugador" + (i + 1) + ".ubicacion");
            int velocidad = Integer.parseInt(configuracion.obtenerValor("jugador" + (i + 1) + ".velocidad"));

            CyclicBarrier inicioPartidoBarrier = new CyclicBarrier(1);

            jugadores[i] = new Jugador(name, ubicacion, velocidad, inicioPartidoBarrier);
        }
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public ClasificacionPanel getClasificacionGeneral() {
        return clasificacionGeneral;
    }

    public void setClasificacionGeneral(ClasificacionPanel clasificacionGeneral) {
        this.clasificacionGeneral = clasificacionGeneral;
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(InfoPanel infoPanel) {
        this.infoPanel = infoPanel;
    }

    public SimulacionPanel getSimulacionPanel() {
        return simulacionPanel;
    }

    public void setSimulacionPanel(SimulacionPanel simulacionPanel) {
        this.simulacionPanel = simulacionPanel;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public ClasificacionPanel getClasificacionPartida() {
        return clasificacionPartida;
    }

    public void setClasificacionPartida(ClasificacionPanel clasificacionPartida) {
        this.clasificacionPartida = clasificacionPartida;
    }
}
