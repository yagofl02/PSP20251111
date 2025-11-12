import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ControladorAscensores {
    private final BlockingQueue<Llamada> llamadas = new LinkedBlockingQueue<>();

    public void llamarAscensor(Persona p) throws InterruptedException {
        Llamada llamada = new Llamada(p.getPisoOrigen(), p.getPisoDestino());
        llamadas.put(llamada);
        System.out.printf("Nueva llamada: %s%n", llamada);
    }

    public Llamada obtenerLlamada() throws InterruptedException {
        return llamadas.take();
    }

}
