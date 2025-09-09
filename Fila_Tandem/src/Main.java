package Fila_Tandem.src;

public class Main {
    public static void main(String[] args) {
        // Fila 1: G/G/2/3 (chegadas [1,4], servicos [3,4])
        FilaSimples fila1 = new FilaSimples(2, 5, 1, 4, 3, 4);

        // Fila 2: G/G/1/5 (servicos [2,3]), sem chegadas externas
        FilaSimples fila2 = new FilaSimples(1, 3, 0, 0, 2, 3);

        FilaTandem tandem = new FilaTandem(fila1, fila2);
        tandem.simular(1000);
    }
}