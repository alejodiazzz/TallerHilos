package vista;

import controlador.ControladorBotones;
import controlador.ControladorJugadores;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JPanel panelPrincipal, panelCabecera, panelJuego, panelTablaGeneral, panelSimulacionJuego;
    private ControladorBotones controladorBotones;
    private JButton botonInfo, botonEmpezarPartida;
    private JLabel infoCabecera, tituloTablaGeneral, tituloTablaIndividual, nPartida, tokioDriftIcon;
    private ClasificacionPanel clasificacionPanel;
    private InfoPanel infoPanel;
    private SimulacionPanel simulacionPanel;
    private ImageIcon imageIcon;
    private ControladorJugadores controladorJugadores;

    public VentanaPrincipal(){
        this.controladorJugadores = new ControladorJugadores();
        inicializarBotones();
        inicializarLabels();
        configPaneles();
        this.controladorBotones = new ControladorBotones(this, controladorJugadores);
    }

    public void configPaneles(){
        setTitle("Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 750);

        //Panel principal
        this.panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(253,202,225));

        //Panel cabecera
        this.panelCabecera = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panelCabecera.setBackground(new Color(204,204,204));
        panelCabecera.setPreferredSize(new Dimension(1280, 40));
        Border bordeColor = BorderFactory.createLineBorder(new Color(255, 255, 255));
        panelCabecera.setBorder(bordeColor);
        panelCabecera.add(botonInfo);
        panelCabecera.add(Box.createHorizontalStrut(600));
        panelCabecera.add(infoCabecera);

        //Panel juego
        this.panelJuego = new JPanel(new BorderLayout());

        //Panel tabla de clasificicacion general
        this.panelTablaGeneral = new JPanel();
        panelTablaGeneral.setPreferredSize(new Dimension(300, 0));
        panelTablaGeneral.setBackground(new Color(204,204,204));

        //Agregar a panel tabla general
        //this.clasificacionPanel = new ClasificacionPanel();
        this.clasificacionPanel = controladorJugadores.getClasificacionGeneral();
        this.panelTablaGeneral.add(clasificacionPanel, BorderLayout.NORTH);
        this.panelTablaGeneral.add(tokioDriftIcon, BorderLayout.CENTER);
        this.panelTablaGeneral.add(botonEmpezarPartida, BorderLayout.CENTER);///ENfocate en esta linea, como hago que se haga abajo de la imagen, asi como esta se hace a un lado


        //Panel simulador juego
        this.panelSimulacionJuego = new JPanel();
        panelSimulacionJuego.setLayout(new BoxLayout(panelSimulacionJuego, BoxLayout.X_AXIS));
        panelSimulacionJuego.setBackground( new Color(56, 65, 60));

        //Agrego la configuracion de la simulacion
        //this.simulacionPanel = new SimulacionPanel();
        this.simulacionPanel = controladorJugadores.getSimulacionPanel();
        panelSimulacionJuego.add(simulacionPanel);

        //Agrego al panel principal de juego la info de jugadores
        //this.infoPanel = new InfoPanel();
        this.infoPanel = controladorJugadores.getInfoPanel();
        panelSimulacionJuego.add(infoPanel);
        
        JScrollPane scroll = new JScrollPane(panelSimulacionJuego);
        //Agragar al panel de juego
        panelJuego.add(panelTablaGeneral, BorderLayout.WEST);
        panelJuego.add(scroll, BorderLayout.CENTER);

        //Agregar al panel principal
        panelPrincipal.add(panelCabecera, BorderLayout.NORTH);
        panelPrincipal.add(panelJuego, BorderLayout.CENTER);

        //Panel contenido
        add(panelPrincipal);

        setVisible(true);
    }

    public void inicializarBotones(){
        //Boton que va a llevar a la seccion de informacion de los jugadores
        this.botonInfo = new JButton("Integrantes");
        botonInfo.setBackground(new Color(51,153,255));

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

    public ClasificacionPanel getClasificacionPanel() {
        return clasificacionPanel;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelCabecera() {
        return panelCabecera;
    }

    public void setPanelCabecera(JPanel panelCabecera) {
        this.panelCabecera = panelCabecera;
    }

    public JPanel getPanelJuego() {
        return panelJuego;
    }

    public void setPanelJuego(JPanel panelJuego) {
        this.panelJuego = panelJuego;
    }

    public JPanel getPanelTablaGeneral() {
        return panelTablaGeneral;
    }

    public void setPanelTablaGeneral(JPanel panelTablaGeneral) {
        this.panelTablaGeneral = panelTablaGeneral;
    }

    public JPanel getPanelSimulacionJuego() {
        return panelSimulacionJuego;
    }

    public void setPanelSimulacionJuego(JPanel panelSimulacionJuego) {
        this.panelSimulacionJuego = panelSimulacionJuego;
    }

    public ControladorBotones getControladorBotones() {
        return controladorBotones;
    }

    public void setControladorBotones(ControladorBotones controladorBotones) {
        this.controladorBotones = controladorBotones;
    }

    public JLabel getTokioDriftIcon() {
        return tokioDriftIcon;
    }

    public void setTokioDriftIcon(JLabel tokioDriftIcon) {
        this.tokioDriftIcon = tokioDriftIcon;
    }

    public void setClasificacionPanel(ClasificacionPanel clasificacionPanel) {
        this.clasificacionPanel = clasificacionPanel;
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

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
