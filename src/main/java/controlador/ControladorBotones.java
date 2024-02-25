package controlador;

import vista.VentanaPrincipal;

import javax.swing.*;

public class ControladorBotones {
    private VentanaPrincipal ventanaPrincipal;

    public ControladorBotones(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        configAccionesBotones();
    }

    public void configAccionesBotones(){
        ventanaPrincipal.getBotonInfo().addActionListener(e ->{
            mostrarVentanaEmergente();
        });

//        panelPrincipal.getBotonEmpezarPartida().addActionListener( e -> {
//
//        });
    }

    //Aqui hay que colocar los relojes de los 5 jugadores, adicional sus datos(numero de partida y puntaje )
    private void mostrarVentanaEmergente() {

    }
}
