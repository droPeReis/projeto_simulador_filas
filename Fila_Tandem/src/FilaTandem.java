package Fila_Tandem.src;

import java.util.LinkedList;
import java.util.List;

public class FilaTandem {

    private List<FilaSimples> filas;
    private int quantFilas;
    private int quantServicos;

    public FilaTandem() {
        this.quantFilas = 0;
        ;
        this.quantServicos = 0;
        this.filas = new LinkedList<FilaSimples>();
    }

    public void addFila(FilaSimples fila, int posicao) {
        filas.add(posicao, fila);
        quantFilas++;
    }

    public FilaSimples getFila(int index) {
        return filas.get(index);
    }

}