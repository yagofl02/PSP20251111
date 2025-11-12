public class Persona implements Runnable {
    private final String id;
    private final int pisoOrigen;
    private final int pisoDestino;
    private final ControladorAscensores controlador;

    public Persona(String id, int pisoOrigen, int pisoDestino, ControladorAscensores controlador) {
        this.id = id;
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
        this.controlador = controlador;
    }

    @Override
    public void run() {
        try {
            System.out.printf("La persona %s ,Esperando en el piso %d con destino %d%n", id, pisoOrigen, pisoDestino);
            controlador.llamarAscensor(null);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getId() {
        return id;
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}