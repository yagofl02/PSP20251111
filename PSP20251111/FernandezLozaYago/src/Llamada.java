public class Llamada {
    private final int pisoOrigen;
    private final int pisoDestino;

    public Llamada(int pisoOrigen, int pisoDestino) {
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    @Override
    public String toString() {
        return String.format("(Piso de Origen =%d, Piso de Destino=%d)", pisoOrigen, pisoDestino);
    }
}
