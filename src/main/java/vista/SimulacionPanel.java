package vista;

import java.awt.*;

public class SimulacionPanel extends Panel {
    private ClasificacionPanel clasificacionPanel;
    public SimulacionPanel() {
        setPreferredSize(new Dimension(700, 680));
        setBackground(new Color(204, 255, 229));
        setLayout(new BorderLayout());

        this.clasificacionPanel = new ClasificacionPanel();
        add(clasificacionPanel, BorderLayout.SOUTH);
    }
}
