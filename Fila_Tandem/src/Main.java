package Fila_Tandem.src;

public class Main {

        public static void main(String[] args) {
            // Fila 1: G/G/1/5 com chegadas entre 2..5, atendimento 3..5
            FilaSimples fila1 = new FilaSimples(1, 5, 2, 5, 3, 5, 0, 0, 0, 0);

            // Fila 2: G/G/1/3 com atendimento 4..6
            FilaSimples fila2 = new FilaSimples(1, 3, 2, 5, 4, 6, 0, 0, 0, 0);

            // Cria o tandem
            FilaTandem tandem = new FilaTandem();
            tandem.adicionarFila(fila1);
            tandem.adicionarFila(fila2);

            // Roda a simulação
            tandem.simular(100);
        }
    }

}
