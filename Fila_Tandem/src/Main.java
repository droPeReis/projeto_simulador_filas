package Fila_Tandem;

public class Main {
    public static void main(String[] args) {
        // Fila 1: G/G/1/5 (chegadas [2,5], servicos [3,5])
        FilaSimples fila1 = new FilaSimples(1, 5, 2, 5, 3, 5);

        // Fila 2: G/G/1/3 (servicos [4,6]), sem chegadas externas
        FilaSimples fila2 = new FilaSimples(1, 3, 0, 0, 4, 6);

        FilaTandem tandem = new FilaTandem(fila1, fila2);
        tandem.simular(100);
    }
}