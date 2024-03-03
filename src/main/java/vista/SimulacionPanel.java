package vista;

import Logica.Jugador;
import Logica.MoverCarros;
import controlador.ControladorJugadores;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SimulacionPanel extends Panel {
    private ClasificacionPanel clasificacionPanel;
    private ControladorJugadores controladorJugadores;

    private ArrayList<CarreraPanel> panels;
    private Jugador[] jugadores;
    private MoverCarros hilo;
    private int pausa = 0;
    private JLabel partida;
    public SimulacionPanel(ControladorJugadores controladorJugadores) {
        this.controladorJugadores = controladorJugadores;
        this.jugadores = controladorJugadores.getJugadores();
        this.panels = new ArrayList<>();
        setPreferredSize(new Dimension(700, 680));
        setBackground(new Color(204, 255, 229));
        setLayout(new GridLayout(5,1));
        this.partida = new JLabel();
        this.partida.setSize(100,100);
        add(partida,BorderLayout.SOUTH);
        partida.setVisible(false);


        for (int i = 0; i < 5; i++) {
            CarreraPanel carreraPanel = new CarreraPanel();
            panels.add(carreraPanel);
            add(carreraPanel);

        }
        for (int i = 0; i < panels.size(); i++) {
            CarreraPanel panelAux = panels.get(i);
            panelAux.setIcons(i);

        }

        this.clasificacionPanel = controladorJugadores.getClasificacionPartida();
        ArrayList<CarreraPanel> panels1 = panels;
        clasificacionPanel.actualizar(panels1);
        add(clasificacionPanel, BorderLayout.SOUTH);
        partida.setVisible(false);

        add(partida,BorderLayout.SOUTH);
        partida.setVisible(false);




    }

    public void establecerPosicion(){
        pausa = pausa +1;
        setNumeroPartida();
        for (int i = 0; i < panels.size(); i++) {
            CarreraPanel panelAux = panels.get(i);
            panelAux.invisible();

        }
        if(pausa==1) {

            for (int i = 0; i < panels.size(); i++) {

                CarreraPanel panelAux = panels.get(i);
                hilo = new MoverCarros(panelAux.getCarro(), panelAux, controladorJugadores);
                hilo.start();

            }
        }
    }

    public void setNumeroPartida(){

        switch (pausa){
            case 1:
                ImageIcon numero = new ImageIcon(getClass().getResource("/img/1.jpeg"));
                Image image = numero.getImage();
                Image newImage = image.getScaledInstance(350,120,Image.SCALE_SMOOTH);
                numero.setImage(newImage);
                this.partida.setIcon(numero);
                partida.setVisible(true);

                break;
            case 2:
                System.out.println("#### ");
                ImageIcon numero1 = new ImageIcon(getClass().getResource("/img/2.jpeg"));
                Image image1 = numero1.getImage();
                Image newImage1 = image1.getScaledInstance(350,120,Image.SCALE_SMOOTH);
                numero1.setImage(newImage1);
                this.partida.setIcon(numero1);
                break;

            case 3:
                System.out.println("&&& ");
                ImageIcon numero2 = new ImageIcon(getClass().getResource("/img/3.jpeg"));
                Image image2 = numero2.getImage();
                Image newImage2 = image2.getScaledInstance(350,120,Image.SCALE_SMOOTH);
                numero2.setImage(newImage2);
                this.partida.setIcon(numero2);

                break;
            case 4:
                ImageIcon numero3 = new ImageIcon(getClass().getResource("/img/4.jpeg"));
                Image image3 = numero3.getImage();
                Image newImage3 = image3.getScaledInstance(350,120,Image.SCALE_SMOOTH);
                numero3.setImage(newImage3);
                this.partida.setIcon(numero3);

                break;
            case 5:
                ImageIcon numero4 = new ImageIcon(getClass().getResource("/img/5.jpeg"));
                Image image4 = numero4.getImage();
                Image newImage4 = image4.getScaledInstance(350,120,Image.SCALE_SMOOTH);
                numero4.setImage(newImage4);
                this.partida.setIcon(numero4);

                break;
        }
    }


}
