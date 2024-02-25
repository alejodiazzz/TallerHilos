package vista;

import controlador.ControladorBotones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

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

}
