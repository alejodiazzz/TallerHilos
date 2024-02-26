package vista;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JugadorPanel jugador1;
    private JugadorPanel jugador2;
    private JugadorPanel jugador3;
    private JugadorPanel jugador4;
    private JugadorPanel jugador5;


    public InfoPanel() {
        setPreferredSize(new Dimension(280, 680));
        setBackground(new Color(204, 204, 204));

        this.jugador1 = new JugadorPanel();

        this.jugador2 = new JugadorPanel();

        this.jugador3 = new JugadorPanel();

        this.jugador4 = new JugadorPanel();

        this.jugador5 = new JugadorPanel();


        add(jugador1);
        add(jugador2);
        add(jugador3);
        add(jugador4);
        add(jugador5);

    }

    public JugadorPanel getJugador1() {
        return jugador1;
    }

    public JugadorPanel getJugador2() {
        return jugador2;
    }

    public JugadorPanel getJugador3() {
        return jugador3;
    }


    public JugadorPanel getJugador4() {
        return jugador4;
    }

    public JugadorPanel getJugador5() {
        return jugador5;
    }

}
