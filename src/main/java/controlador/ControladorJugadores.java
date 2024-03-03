package controlador;

import Logica.Configuracion;
import Logica.Jugador;
import Logica.Partida;
import vista.ClasificacionPanel;
import vista.InfoPanel;
import vista.SimulacionPanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class ControladorJugadores {
    private Configuracion configuracion;
    private ClasificacionPanel clasificacionGeneral, clasificacionPartida;
    private ControladorPuntaje controladorPuntaje;
    private Partida partida;
    private InfoPanel infoPanel;
    private SimulacionPanel simulacionPanel;
    private Jugador[] jugadores;
    private int hilosTerminados = 0;
    public ControladorJugadores(){
        traerJugadores();
        this.clasificacionGeneral = new ClasificacionPanel(this, true);
        this.clasificacionPartida = new ClasificacionPanel(this, false);
        this.infoPanel = new InfoPanel(this);
        this.simulacionPanel = new SimulacionPanel(this);
        this.controladorPuntaje = new ControladorPuntaje(this);
    }
    private void traerJugadores(){
        // Crear jugadores
        this.configuracion = new Configuracion("config.properties");

        jugadores = new Jugador[5];
        for (int i = 0; i < jugadores.length; i++) {
            String name = configuracion.obtenerValor("jugador" + (i + 1) + ".nombre");
            String ubicacion = configuracion.obtenerValor("jugador" + (i + 1) + ".ubicacion");

            CyclicBarrier inicioPartidoBarrier = new CyclicBarrier(1);

            jugadores[i] = new Jugador(name, ubicacion, inicioPartidoBarrier);
        }
    }

    public void comenzarPartidaJugadores() {
        simulacionPanel.establecerPosicion();
        controladorPuntaje.calcularPuntajeGeneral();

        if(!controladorPuntaje.getPosiciones().isEmpty()){
            controladorPuntaje.getPosiciones().forEach(jugador -> System.out.println("Nombre "+ jugador.getNombre()+" EL puntaje es: " + jugador.getPuntajeGeneral()));
        }
        Jugador[] auxJugadores = jugadores;
        Arrays.sort(auxJugadores, Comparator.comparing(Jugador::getPuntajeGeneral).reversed());
        clasificacionGeneral.actualizarTabla(auxJugadores, true);
        for (Jugador jugador : jugadores) {
            jugador.reiniciar();
            this.partida = new Partida(jugador, jugador.getCyclicBarrier(), infoPanel.getPanelReferencias().get(jugador.getNombre()), this);
            partida.start();
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

    public void setHilosTerminados() {
        this.hilosTerminados++;
    }

    public int getHilosTerminados() {
        return hilosTerminados;
    }

    public ControladorPuntaje getControladorPuntaje() {
        return controladorPuntaje;
    }

    public void setControladorPuntaje(ControladorPuntaje controladorPuntaje) {
        this.controladorPuntaje = controladorPuntaje;
    }
}
