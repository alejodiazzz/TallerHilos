package vista;

import Logica.Jugador;
import Logica.MoverCarros;
import controlador.ControladorJugadores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class ClasificacionPanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private ControladorJugadores controladorJugadores;
    private boolean esTablaGeneral;
    private int puntaje;
    private ArrayList<CarreraPanel> panels;

    public ClasificacionPanel(ControladorJugadores controladorJugadores, boolean esGeneral) {

        this.controladorJugadores = controladorJugadores;
        this.esTablaGeneral = esGeneral;

        setLayout(new BorderLayout());

        // Crear el modelo de la tabla con las columnas
        String[] columnNames = {"Posicion","Nombre", "Puntaje"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Crear la tabla con el modelo
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);

        // Configurar apariencia de la tabla
        table.setRowHeight(30);
        table.setGridColor(new Color(255,204,0));
        table.setIntercellSpacing(new Dimension(10, 10));
        table.getTableHeader().setBackground(new Color(255,204,0));
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        add(table.getTableHeader(), BorderLayout.PAGE_START);
        add(table, BorderLayout.CENTER);

        //Precarga los datos de las dos tablas
        actualizarTabla(controladorJugadores.getJugadores(), true);
        actualizarTabla(controladorJugadores.getJugadores(), false);
    }
    private void agregarJugador(String  posicion, String nombre, int puntaje) {
        Vector<Object> row = new Vector<>();
        row.add(posicion);
        row.add(nombre);
        row.add(puntaje);
        tableModel.addRow(row);
    }

    public void actualizarTabla(Jugador[] jugadores, boolean esTablaGeneral) {
        tableModel.setRowCount(0);

        if(esTablaGeneral){
            for (int i = 0; i < jugadores.length; i++) {
                Jugador jugador = jugadores[i];
                if (jugador != null) {
                    agregarJugador(""+(i + 1), jugador.getNombre(), jugador.getPuntajeGeneral());
                }
            }
        }else{
            for (int i = 0; i < jugadores.length; i++) {
                Jugador jugador = jugadores[i];

                if (jugador != null) {

                    agregarJugador(""+(i+1), jugador.getNombre(), jugador.getPuntaje());
                    if (jugador.getPuntaje() > 99 && i<panels.size()) {

                            panels.get(i).visible();

                    }
                }
            }
        }


    }



    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, super.getPreferredSize().height);
    }

    public void actualizar(ArrayList<CarreraPanel> panels1) {
        this.panels = panels1;
    }
}
