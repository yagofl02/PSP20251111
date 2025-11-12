import java.util.Random;
import java.util.concurrent.*;

public class SimulacionAscensores {

    public static void main(String[] args) {
        ControladorAscensores controlador = new ControladorAscensores();

        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(new Ascensor(1, controlador));
        pool.execute(new Ascensor(2, controlador));

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            int origen = random.nextInt(21);
            int destino;
            do {
                destino = random.nextInt(21);
            } while (destino == origen);

            Persona persona = new Persona(String.format("P%03d", i), origen, destino, controlador);
            long delay = (long) (random.nextDouble() * 1500 + 500);
            scheduler.schedule(persona, delay, TimeUnit.MILLISECONDS);
        }

        System.out.println("Prueba: ");
    }
}
