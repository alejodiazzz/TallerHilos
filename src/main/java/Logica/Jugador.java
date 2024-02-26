package Logica;

public class Jugador {
    private int posicion;
    private String nombre;
    private String ubicacion;
    private int numeroPartida;

    public int getPuntajeGeneral() {
        return puntajeGeneral;
    }

    public void setPuntajeGeneral(int puntajeGeneral) {
        this.puntajeGeneral = puntajeGeneral;
    }

    private int puntajeGeneral;
    private int puntaje;
    private int velocidad;
    private volatile boolean juegoTerminado;
    private int lanzamientos;
    private HoraSegunUbicacion hiloHora;  // Referencia al hilo de HoraSegunUbicacion asociado al jugador

    public Jugador(String nombre, String ubicacion, int velocidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numeroPartida = 0;
        this.puntaje = 0;
        this.velocidad = velocidad;
        this.juegoTerminado = false;
        this.hiloHora = null;
        this.lanzamientos = 0;
        this.puntajeGeneral = 0;
        realizarLanzamiento();

    }
    public int getLanzamientos() {
        return lanzamientos;
    }
    public void incrementarLanzamientos() {
        lanzamientos++;
    }
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void actualizarPartida(){
        numeroPartida++;
    }
    public void realizarLanzamiento() {
        CalcularPuntaje.calcularPuntaje(this);
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void detenerJuego() {
        juegoTerminado = true;
        detenerHiloHora();
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    // Método para establecer el hilo de HoraSegunUbicacion asociado a este jugador
    public void setHiloHora(HoraSegunUbicacion hiloHora) {
        this.hiloHora = hiloHora;
    }
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    // Método para detener el hilo de HoraSegunUbicacion asociado a este jugador
    public void detenerHiloHora() {
        if (hiloHora != null && hiloHora.isAlive()) {
            hiloHora.detenerJuego();
            hiloHora.interrupt();

        }
    }
    public void reiniciar() {
        // Reiniciar los datos del jugador para una nueva partida
        this.setPosicion(0);
        this.setPuntaje(0);
        this.setLanzamientos(0);
        this.juegoTerminado = false;
        actualizarPartida();

    }


    private void setLanzamientos(int i) {
        this.lanzamientos = i;
    }

    public void sumarPuntajeGeneral(int puntajePartida) {
        puntajeGeneral = puntajePartida+puntajeGeneral;

    }
}
