package Fila_Tandem.src;

// Gera numeros aleatorios para tempos de chegada e servico
class RandomGenerator {
    private int seed;
    private final int a;
    private final int c;
    private final int m;

    public RandomGenerator(int seed, int a, int c, int m) {
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public double nextRandom() {
        this.seed = (a * seed + c) % m;
        return ((double) seed / m);
    }

    public double generateUniform(double min, double max) {
        this.seed = (a * seed + c) % m;
        return min + (max - min) * ((double) seed / m);
    }
}