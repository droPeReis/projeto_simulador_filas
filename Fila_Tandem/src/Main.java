package Fila_Tandem.src;

public class Main {

    public static void main(String[] args) {
        simulador(1000);
    }

    public static RandomGenerator random = new RandomGenerator(12345, 1103515245, 12345, 214748364);

    public static void simulador(double tempoMax) {

        FilaSimples fila_1 = new FilaSimples(0, 5, 0, 0, 0, 0, 0, 0, 0);
        FilaSimples fila_2 = new FilaSimples(0, 0, 0, 0, 0, 0, 0, 0, 0);

        FilaTandem filas = new FilaTandem();
        filas.addFila(fila_1, 0);
        filas.addFila(fila_2, 1);

        double tempoPassado = 0;
        double tempoSimulado = 1000;

        double proximaChegada = tempoPassado + randomUniform(1.0, 4.0);
        double proximaSaida = Double.POSITIVE_INFINITY;

        while (tempoSimulado > tempoMax) {
            tempoSimulado--;
        }

    }

    private static double randomUniform(double min, double max) {

        return random.nextRandom();
    }

}
