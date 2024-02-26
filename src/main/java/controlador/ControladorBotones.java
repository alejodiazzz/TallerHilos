package controlador;

import Logica.*;
import vista.ClasificacionPanel;
import vista.VentanaPrincipal;

import javax.swing.*;
import java.util.concurrent.CyclicBarrier;

public class ControladorBotones {
    private VentanaPrincipal ventanaPrincipal;
    Jugador[] jugadores;

    public ControladorBotones(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        configAccionesBotones();
    }

    public void configAccionesBotones() {
        ventanaPrincipal.getBotonInfo().addActionListener(e -> {
            actualizarjugadores();
            mostrarVentanaEmergente();
        });

        ventanaPrincipal.getBotonEmpezarPartida().addActionListener(e -> {
            iniciarJuego();
        });
    }

    public void iniciarJuego() {



        // Visualizar la clasificación al final
        //CalcularPosicion calculadorPosicion = new CalcularPosicion();
        //calculadorPosicion.ordenarJugadoresPorPuntajeYPartida(jugadores);

        // Actualizar la interfaz gráfica después de la simulación
        ventanaPrincipal.iniciarSimulacion(jugadores);
    }
    private void actualizarjugadores(){
        // Crear jugadores
        Configuracion configuracion = new Configuracion("config.properties");

        jugadores = new Jugador[5];
        for (int i = 0; i < jugadores.length; i++) {
            String name = configuracion.obtenerValor("jugador" + (i + 1) + ".nombre");
            String ubicacion = configuracion.obtenerValor("jugador" + (i + 1) + ".ubicacion");
            int velocidad = Integer.parseInt(configuracion.obtenerValor("jugador" + (i + 1) + ".velocidad"));

            jugadores[i] = new Jugador(name, ubicacion, velocidad);
        }
    }

    private void mostrarVentanaEmergente() {
        iniciarJuego();
        //StringBuilder mensaje = new StringBuilder("Información de los jugadores:\n\n");
        if (ventanaPrincipal != null) {
            ventanaPrincipal.getClasificacionPanel().actualizarTabla();
            // Otro código relacionado con la ventana emergente...
        } else {
            System.err.println("La ventana principal es nula. Asegúrate de que esté inicializada correctamente.");
        }
        // Suponiendo que tienes una lista de jugadores en tu ClasificacionPanel
        ClasificacionPanel panel = new ClasificacionPanel();


        String mensaje = "";
        for (Jugador jugador : jugadores) {
            mensaje += "Jugador: " + jugador.getNombre() +
                    " - Partidas: " + jugador.getNumeroPartida() +
                    " - Puntaje: " + jugador.getPuntaje() +
                    "\n";
        }

        // Mostrar el mensaje utilizando JOptionPane
        JOptionPane.showMessageDialog(ventanaPrincipal, mensaje, "Información de Jugadores", JOptionPane.INFORMATION_MESSAGE);
    }

    // Suponiendo que tienes un método en tu ClasificacionPanel para obtener los jugadores
    private Jugador[] obtenerJugadores() {
        return ventanaPrincipal.getClasificacionPanel().getJugadores();
    }
}
