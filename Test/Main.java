package Test;

public class Main {
    public static void main(String[] args) {
        FilaSimples fila = new FilaSimples(
                1, // servidores
                5, // capacidade total
                2, 5, // chegadas [2,5]
                3, 5 // serviços [3,5]
        );

        fila.simular(100); // simula até o tempo 100
    }
}
