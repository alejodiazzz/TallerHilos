package vista;


import javax.swing.*;
import java.awt.*;

public class JugadorPanel extends JPanel {

    private JLabel nombre, lanzamiento, hora, faltantes, puntajeLanzamiento;
    private JTextArea reloj;

    public JugadorPanel(){
        setPreferredSize(new Dimension(280, 121));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.WHITE,1));

        this.nombre = new JLabel();
        this.nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(nombre, BorderLayout.NORTH);

        this.lanzamiento = new JLabel();
        this.puntajeLanzamiento = new JLabel();
        this.faltantes = new JLabel();

        this.lanzamiento.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.faltantes.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.puntajeLanzamiento.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(lanzamiento, BorderLayout.SOUTH);
        add(puntajeLanzamiento, BorderLayout.SOUTH);
        add(faltantes, BorderLayout.SOUTH);

        this.reloj = new JTextArea();
        reloj.setEditable(false);
        this.reloj.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.reloj.setPreferredSize(new Dimension(200, 50));
        add(reloj);

        this.hora = new JLabel();
        this.hora.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(hora, BorderLayout.CENTER);

    }

    public JLabel getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }

    public JLabel getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento, String puntaje, String faltan) {
        this.lanzamiento.setText("Lanzamiento: " + lanzamiento + " puntos: " + puntaje);
        this.faltantes.setText("Faltan: " + faltan);
    }

    public void setUltimoLanzamiento(String puntaje){
        this.puntajeLanzamiento.setText("Ultimos dados lanzados: " + puntaje);
    }

    public JTextArea getReloj() {
        return reloj;
    }

    public void setReloj(String reloj) {
        this.reloj.setText(reloj);
    }

    public JLabel getHora() {
        return hora;
    }

    public void setHora(String zona) {
        this.hora.setText("Zona: " + zona);
    }

}
