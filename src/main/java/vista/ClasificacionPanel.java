package vista;

import Logica.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ClasificacionPanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;

    public ClasificacionPanel() {
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla con las columnas
        String[] columnNames = {"Nombre", "Puntaje"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Crear la tabla con el modelo
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Configurar apariencia de la tabla
        table.setRowHeight(30);
        table.setGridColor(new Color(204,153,255));
        table.setIntercellSpacing(new Dimension(10, 10));
        table.getTableHeader().setBackground(new Color(204,153,255));
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        //Valores precargados, hay que traer los datos del archivo
        agregarJugador("Toreto", 34);
        agregarJugador("Lisa", 89);
        agregarJugador("Mauro", 324);
        agregarJugador("Han", 23);
        agregarJugador("Random", 856);
    }

    private void agregarJugador(String nombre, int puntaje) {
        Vector<Object> row = new Vector<>();
        row.add(nombre);
        row.add(puntaje);
        tableModel.addRow(row);
    }

    public void actualizarTabla(Jugador[] jugadores) {
        tableModel.setRowCount(0);
        for (Jugador jugador : jugadores) {
            agregarJugador(jugador.getNombre(), jugador.getPuntaje());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, super.getPreferredSize().height);
    }
}
