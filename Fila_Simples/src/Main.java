package Fila_Simples.src;

public class Main {
    public static void main(String[] args) {

        RandomGenerator ramdom = new RandomGenerator(12345, 1103515245, 12345, 214748364);

        FilaSimples fila = new FilaSimples(
                1, // servidores
                5, // capacidade total
                2, 5, // chegadas [2,5]
                3, 5 // serviços [3,5]
                , ramdom);

        fila.simular(100); // simula até o tempo 100

    }

}
