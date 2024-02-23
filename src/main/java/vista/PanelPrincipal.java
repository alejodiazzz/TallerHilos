package vista;

import controlador.ControladorBotones;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JFrame {

    private ControladorBotones controladorBotones;
    private JButton botonInfo, botonEmpezarPartida;
    private JLabel infoCabecera, tituloTablaGeneral, tituloTablaIndividual, nPartida;

    public PanelPrincipal(){
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
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(253,202,225));

        //Panel cabecera
        JPanel panelCabecera = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panelCabecera.setBackground(new Color(21,171,146));
        panelCabecera.setPreferredSize(new Dimension(1280, 40));
        panelCabecera.add(botonInfo);
        panelCabecera.add(Box.createHorizontalStrut(600));
        panelCabecera.add(infoCabecera);

        //Panel juego
        JPanel panelJuego = new JPanel(new BorderLayout());

        //Panel tabla de clasificicacion general
        JPanel panelTablaGeneral = new JPanel();
        panelTablaGeneral.setPreferredSize(new Dimension(300, 0));
        panelTablaGeneral.setBackground(new Color(204,153,255));

        //Panel simulador juego
        JPanel panelSimulacionJuego = new JPanel();
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

    public void inicializarBotones(){
        this.botonInfo = new JButton("Jugadores");
        botonInfo.setBackground(new Color(129,201,250));
    }
    public void inicializarLabels(){

        this.infoCabecera = new JLabel("Bienvenido a Rapidos y furiosos");

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
