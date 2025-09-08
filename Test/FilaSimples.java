package Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FilaSimples {
    private Queue<Cliente> fila;
    private int servers;
    private int capacity;
    private double minArrival;
    private double maxArrival;
    private double minService;
    private double maxService;

    private int custumers;
    private int loss;
    private int atendidos;

    public FilaSimples(int servers, int capacity, double minArrival, double maxArrival,
            double minService, double maxService) {
        this.fila = new LinkedList<>();
        this.servers = servers;
        this.capacity = capacity;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.minService = minService;
        this.maxService = maxService;
        this.custumers = 0;
        this.loss = 0;
        this.atendidos = 0;
    }

    private double randomUniform(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public void simular(double tempoMax) {
        double tempo = 0.0;
        double proximaChegada = tempo + randomUniform(minArrival, maxArrival);
        double proximaSaida = Double.POSITIVE_INFINITY;

        while (tempo < tempoMax) {
            if (proximaChegada <= proximaSaida) {
                // Chegada
                tempo = proximaChegada;
                proximaChegada = tempo + randomUniform(minArrival, maxArrival);

                if (custumers < capacity) {
                    Cliente cliente = new Cliente(tempo, randomUniform(minService, maxService));
                    custumers++;

                    if (proximaSaida == Double.POSITIVE_INFINITY) {
                        cliente.setStartService(tempo);
                        proximaSaida = cliente.getEndService();
                    } else {
                        fila.add(cliente);
                    }
                } else {
                    loss++;
                }
            } else {
                // Saída
                tempo = proximaSaida;
                atendidos++;
                custumers--;

                if (!fila.isEmpty()) {
                    Cliente cliente = fila.poll();
                    cliente.setStartService(tempo);
                    proximaSaida = cliente.getEndService();
                } else {
                    proximaSaida = Double.POSITIVE_INFINITY;
                }
            }
        }

        System.out.println("Tempo simulação: " + tempoMax);
        System.out.println("Clientes atendidos: " + atendidos);
        System.out.println("Clientes perdidos: " + loss);
    }
}
