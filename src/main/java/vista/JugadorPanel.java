package vista;


import javax.swing.*;
import java.awt.*;

public class JugadorPanel extends JPanel {

    private JLabel nombre, lanzamiento, hora, faltantes;
    private JTextArea reloj;

    public JugadorPanel(){
        setPreferredSize(new Dimension(280, 121));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.nombre = new JLabel();
        nombre.setText("alberto");
        this.nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(nombre, BorderLayout.NORTH);

        this.lanzamiento = new JLabel();
        this.faltantes = new JLabel();
        setLanzamiento("2","14", "78");
        this.lanzamiento.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.faltantes.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lanzamiento, BorderLayout.SOUTH);
        add(faltantes, BorderLayout.SOUTH);

        this.reloj = new JTextArea();
        setReloj("10;34");
        reloj.setEditable(false);
        this.reloj.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.reloj.setPreferredSize(new Dimension(200, 50));
        add(reloj);

        this.hora = new JLabel();
        setHora("Europe/madrid");
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
