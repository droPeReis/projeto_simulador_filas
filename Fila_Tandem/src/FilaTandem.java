package Fila_Tandem.src;

public class FilaTandem {
    private FilaSimples fila1;
    private FilaSimples fila2;

    public FilaTandem(FilaSimples fila1, FilaSimples fila2) {
        this.fila1 = fila1;
        this.fila2 = fila2;
    }

    public void simular(double tempoMax) {
        double tempo = 0.0;
        double ultimoTempo = 0.0;
        double proximaChegada = fila1.gerarChegada(tempo);
        double proximaSaida1 = Double.POSITIVE_INFINITY;
        double proximaSaida2 = Double.POSITIVE_INFINITY;

        while (tempo < tempoMax) {
            double proximoEvento = Math.min(proximaChegada, Math.min(proximaSaida1, proximaSaida2));

            // acumulador de tempo das filas
            double delta = proximoEvento - ultimoTempo;
            fila1.acumulaTempo(delta);
            fila2.acumulaTempo(delta);

            tempo = proximoEvento;
            ultimoTempo = tempo;

            // counter de tempo
            if (tempo >= tempoMax) {
                break;
            }

            if (proximoEvento == proximaChegada) {
                fila1.chegada(tempo);
                proximaChegada = fila1.gerarChegada(tempo);
                if (proximaSaida1 == Double.POSITIVE_INFINITY) { // tratadores de eventos
                    proximaSaida1 = fila1.gerarSaida(tempo);
                }

            } else if (proximoEvento == proximaSaida1) {
                Cliente cliente = fila1.saida(tempo);
                if (cliente != null) {
                    fila2.chegadaDireta(cliente, tempo); // cliente chega na fila2
                    if (proximaSaida2 == Double.POSITIVE_INFINITY) {
                        proximaSaida2 = fila2.gerarSaida(tempo);
                    }
                }
                proximaSaida1 = fila1.temCliente() ? fila1.gerarSaida(tempo) : Double.POSITIVE_INFINITY;

            } else if (proximoEvento == proximaSaida2) {
                fila2.saida(tempo); // cliente sai da fila2
                proximaSaida2 = fila2.temCliente() ? fila2.gerarSaida(tempo) : Double.POSITIVE_INFINITY;
            }
        }

        double deltaFinal = tempoMax - ultimoTempo;
        if (deltaFinal > 0) {
            fila1.acumulaTempo(deltaFinal);
            fila2.acumulaTempo(deltaFinal);
        }

        System.out.println("=== Resultados Tandem ===");
        fila1.relatorio("Fila 1");
        fila2.relatorio("Fila 2");
        System.out.printf("Tempo global de simulacao: %.2f", tempo);
        // ver exatamento e que seria o tempo global de simulacao
    }
}