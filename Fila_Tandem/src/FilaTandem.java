package Fila_Tandem.src;

import java.util.LinkedList;
import java.util.List;

import java.util.*;

import java.util.*;

public class FilaTandem {
    private List<FilaSimples> estagios;

    public FilaTandem() {
        this.estagios = new ArrayList<>();
    }

    public void adicionarFila(FilaSimples fila) {
        estagios.add(fila);
    }

    public void simular(double tempoMax) {
        int entradas = 0;
        for (int i = 0; i < estagios.size(); i++) {
            FilaSimples fila = estagios.get(i);
            System.out.println("\n--- Simulando Fila " + (i + 1) + " ---");

            fila.simular(tempoMax, entradas); // cada fila recebe clientes

            entradas = fila.getAtendidos(); // atendidos viram chegadas da próxima
        }

        System.out.println("\n--- Resultados finais do tandem ---");
        for (int i = 0; i < estagios.size(); i++) {
            FilaSimples fila = estagios.get(i);
            System.out.println("Fila " + (i + 1) + " -> Atendidos: " +
                    fila.getAtendidos() + ", Perdidos: " + fila.getPerdidos());
        }
    }
}
