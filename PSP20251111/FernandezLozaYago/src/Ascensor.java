import java.util.*;

public class Ascensor implements Runnable {
    private final int id;
    private int pisoActual = 0;
    private final ControladorAscensores controlador;
    private char sentido = 'P';
    private final List<Persona> personasAscensor = new ArrayList<>();
    private static final int CAPACIDAD_MAX = 8;

    public Ascensor(int id, ControladorAscensores controlador) {
        this.id = id;
        this.controlador = controlador;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Llamada llamada = controlador.obtenerLlamada();
                if (llamada != null) {
                    atenderLlamada(llamada);
                }
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void atenderLlamada(Llamada llamada) throws InterruptedException {
        moverAscensorHasta(llamada.getPisoOrigen());
        System.out.printf("Ascensor %d Recoge persona en piso %d con destino %d %n",
                id, llamada.getPisoOrigen(), llamada.getPisoDestino());

        moverAscensorHasta(llamada.getPisoDestino());
        System.out.printf("Ascensor %d Persona bajó en piso %d%n",
                id, llamada.getPisoDestino());
    }

    private void moverAscensorHasta(int destino) throws InterruptedException {
        while (pisoActual != destino) {
            sentido = (pisoActual < destino) ? 'S' : 'B';
            pisoActual += (sentido == 'S') ? 1 : -1;
            System.out.printf("Ascensor %d Piso actual: %d con Sentido %c %n", id, pisoActual, sentido);
            Thread.sleep(200);
        }
        sentido = 'P';
    }

}
