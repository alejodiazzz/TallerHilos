package vista;

import Logica.*;
import controlador.ControladorBotones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import java.util.concurrent.CyclicBarrier;

public class VentanaPrincipal extends JFrame {

    private JPanel panelPrincipal, panelCabecera, panelJuego, panelTablaGeneral, panelSimulacionJuego;
    private ControladorBotones controladorBotones;
    private JButton botonInfo, botonEmpezarPartida;
    private JLabel infoCabecera, tituloTablaGeneral, tituloTablaIndividual, nPartida, tokioDriftIcon;
    private ClasificacionPanel clasificacionPanel;
    private ImageIcon imageIcon;

    public VentanaPrincipal(){
        inicializarBotones();
        inicializarLabels();
        configPaneles();
        this.controladorBotones = new ControladorBotones(this);
    }

    public void configPaneles(){
        setTitle("Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);

        //Panel principal
        this.panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(253,202,225));

        //Panel cabecera
        this.panelCabecera = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panelCabecera.setBackground(new Color(21,171,146));
        panelCabecera.setPreferredSize(new Dimension(1280, 40));
        panelCabecera.add(botonInfo);
        panelCabecera.add(Box.createHorizontalStrut(600));
        panelCabecera.add(infoCabecera);

        //Panel juego
        this.panelJuego = new JPanel(new BorderLayout());

        //Panel tabla de clasificicacion general
        this.panelTablaGeneral = new JPanel();
        panelTablaGeneral.setPreferredSize(new Dimension(300, 0));
        panelTablaGeneral.setBackground(new Color(204,153,255));

        //Agregar a panel tabla general
        this.clasificacionPanel = new ClasificacionPanel();
        this.panelTablaGeneral.add(clasificacionPanel, BorderLayout.CENTER);
        this.panelTablaGeneral.add(tokioDriftIcon, BorderLayout.CENTER);

        //Panel simulador juego
        this.panelSimulacionJuego = new JPanel();
        panelSimulacionJuego.setLayout(new BoxLayout(panelSimulacionJuego, BoxLayout.Y_AXIS));
        panelSimulacionJuego.setBackground( new Color(204, 255, 229));

        //Agragar al panel de juego
        panelJuego.add(panelTablaGeneral, BorderLayout.WEST);
        panelJuego.add(panelSimulacionJuego, BorderLayout.CENTER);

        //Agregar al panel principal
        panelPrincipal.add(panelCabecera, BorderLayout.NORTH);
        panelPrincipal.add(panelJuego, BorderLayout.CENTER);

        //Panel contenido
        add(panelPrincipal);

        setVisible(true);
    }

    public void ClasificacionPanel() {}


    public void inicializarBotones(){
        //Boton que va a llevar a la seccion de informacion de los jugadores
        this.botonInfo = new JButton("Jugadores");
        botonInfo.setBackground(new Color(129,201,250));

        //Boton que va a iniciar la simulacion
        this.botonEmpezarPartida = new JButton("Empezar");
        botonEmpezarPartida.setBackground(new Color(129,201,250));


    }
    public void inicializarLabels(){
        //Label cabecera
        this.infoCabecera = new JLabel("Bienvenido a Rapidos y furiosos");
        //Label numero de partida
        this.nPartida = new JLabel("Estas en la partida numero:");
        //Label Titulo tabla de clasisicacion
        this.tituloTablaGeneral = new JLabel("Clasificacion general");

        //Imagen
        this.tokioDriftIcon = new JLabel();
        this.imageIcon = new ImageIcon(getClass().getResource("/img/TokioDrift.png"));
        int maxWidth = 200;
        int maxHeight = 200;
        Image scaledImage = imageIcon.getImage().getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.tokioDriftIcon.setIcon(imageIcon);

    }

    public JButton getBotonInfo() {
        return botonInfo;
    }

    public void setBotonInfo(JButton botonInfo) {
        this.botonInfo = botonInfo;
    }

    public JButton getBotonEmpezarPartida() {
        return botonEmpezarPartida;
    }

    public void setBotonEmpezarPartida(JButton botonEmpezarPartida) {
        this.botonEmpezarPartida = botonEmpezarPartida;
    }

    public JLabel getInfoCabecera() {
        return infoCabecera;
    }

    public void setInfoCabecera(JLabel infoCabecera) {
        this.infoCabecera = infoCabecera;
    }

    public JLabel getTituloTablaGeneral() {
        return tituloTablaGeneral;
    }

    public void setTituloTablaGeneral(JLabel tituloTablaGeneral) {
        this.tituloTablaGeneral = tituloTablaGeneral;
    }

    public JLabel getTituloTablaIndividual() {
        return tituloTablaIndividual;
    }

    public void setTituloTablaIndividual(JLabel tituloTablaIndividual) {
        this.tituloTablaIndividual = tituloTablaIndividual;
    }

    public JLabel getnPartida() {
        return nPartida;
    }

    public void setnPartida(JLabel nPartida) {
        this.nPartida = nPartida;
    }

    public void iniciarSimulacion(Jugador[] jugadores) {

        clasificacionPanel.traerjugadores(jugadores);
       // Repetir la partida 5 veces
        for (int repeticion = 1; repeticion <= 5; repeticion++) {
            System.out.println("Repetición " + repeticion);

            // Crear e iniciar hilos de Partida y HoraSegunUbicacion para cada jugador
            CyclicBarrier inicioPartidaBarrier = new CyclicBarrier(jugadores.length);
            Thread[] hilosPartida = new Thread[jugadores.length];
            Thread[] hilosHora = new Thread[jugadores.length];

            for (int i = 0; i < jugadores.length; i++) {
                jugadores[i].reiniciar(); // Reiniciar datos del jugador para una nueva partida
                hilosPartida[i] = new Partida(jugadores[i], inicioPartidaBarrier);
                hilosHora[i] = new HoraSegunUbicacion(jugadores[i], inicioPartidaBarrier);
            }

            // Iniciar hilos de Partida y HoraSegunUbicacion
            for (int i = 0; i < jugadores.length; i++) {
                hilosPartida[i].start();
                hilosHora[i].start();
            }

            // Esperar a que ambos hilos terminen
            try {
                for (Thread hiloPartida : hilosPartida) {
                    hiloPartida.join();
                }

                // Detener los hilos de HoraSegunUbicacion después de las partidas
                for (Thread hiloHora : hilosHora) {
                    hiloHora.interrupt();
                }
            } catch (InterruptedException e) {
                System.err.println("Error al esperar a que los hilos de partida terminen: " + e.getMessage());
            }

            // Visualizar la clasificación al final
            CalcularPosicion calculadorPosicion = new CalcularPosicion();
            calculadorPosicion.ordenarJugadoresPorPuntajeYPartida(jugadores);
            CalcularPuntajeGeneral.calcularPuntajeGeneral(jugadores);
            clasificacionPanel.actualizarTabla();
            System.out.println("\nClasificación Final:");
            for (Jugador jugador : jugadores) {
                System.out.println("Posición: " + jugador.getPosicion() + ". Jugador: " + jugador.getNombre() +
                        " - Partidas: " + jugador.getNumeroPartida() + " - Lanzamientos: " + jugador.getLanzamientos());
            }
        }

        // También realizar otras actualizaciones en la interfaz según sea necesario.
        // Por ejemplo, mostrar mensajes, actualizar etiquetas, etc.
    }
    public ClasificacionPanel getClasificacionPanel() {
        return clasificacionPanel;
    }

}
