package vista;

import Logica.Jugador;
import controlador.ControladorJugadores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ClasificacionPanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private ControladorJugadores controladorJugadores;
    private boolean esTablaGeneral;

    public ClasificacionPanel(ControladorJugadores controladorJugadores, boolean esGeneral) {

        this.controladorJugadores = controladorJugadores;
        this.esTablaGeneral = esGeneral;

        setLayout(new BorderLayout());

        // Crear el modelo de la tabla con las columnas
        String[] columnNames = {"Nombre", "Puntaje"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Crear la tabla con el modelo
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Configurar apariencia de la tabla
        table.setRowHeight(30);
        table.setGridColor(new Color(255,204,0));
        table.setIntercellSpacing(new Dimension(10, 10));
        table.getTableHeader().setBackground(new Color(255,204,0));
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        //Precarga los datos de las dos tablas
        actualizarTabla(controladorJugadores.getJugadores());
    }
    private void agregarJugador(String nombre, int puntaje) {
        Vector<Object> row = new Vector<>();
        row.add(nombre);
        row.add(puntaje);
        tableModel.addRow(row);
    }

    public void actualizarTabla(Jugador[] jugadores) {
        tableModel.setRowCount(0);

        if(esTablaGeneral){
            for (Jugador jugador : jugadores) {
                if (jugador != null) {
                    agregarJugador(jugador.getNombre(), jugador.getPuntajeGeneral());
                }
            }
        }else{
            for (Jugador jugador : jugadores) {
                if (jugador != null) {
                    agregarJugador(jugador.getNombre(), jugador.getPuntaje());
                }
            }
        }


    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, super.getPreferredSize().height);
    }
}
