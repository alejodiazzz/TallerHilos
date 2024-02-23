package controlador;

import vista.PanelPrincipal;

public class ControladorBotones {
    private PanelPrincipal panelPrincipal;

    public ControladorBotones(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        configAccionesBotones();
    }

    public void configAccionesBotones(){
        panelPrincipal.getBotonInfo().addActionListener( e ->{
            System.out.println("sirve");
        });

//        panelPrincipal.getBotonEmpezarPartida().addActionListener( e -> {
//
//        });
    }
}
