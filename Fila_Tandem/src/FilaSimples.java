package Fila_Tandem.src;

import java.util.LinkedList;

public class FilaSimples {
    private int servers; // numero de servidores da fila (assumido 1 para esta simulacao)
    private int capacity; // capacidade maxima do sistema (incluindo servindo)
    private double minArrival; // tempo minimo de chegada de clientes na fila
    private double maxArrival; // tempo maximo de chegada de clientes na fila
    private double minService; // tempo minimo de atendimento de clientes na fila
    private double maxService; // tempo maximo de atendimento de clientes na fila
    private int customers; // quantidade atual de clientes no sistema
    private int loss; // numero de clientes perdidos
    private double[] times; // tempos acumulados para cada estado (0 a capacity)
    private LinkedList<Cliente> fila;
    // private RandomGenerator random = new RandomGenerator();
    private RandomGenerator randArrival;
    private RandomGenerator randService;

    // Cliente cliente = new Cliente(<>,<posicao>>);
    public FilaSimples(int servers, int capacity, double minArrival, double maxArrival, double minService,
            double maxService) {
        this.servers = servers;
        this.capacity = capacity;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.minService = minService;
        this.maxService = maxService;
        this.customers = 0;
        this.loss = 0;
        this.times = new double[capacity + 1];
        this.fila = new LinkedList<>();
        this.randArrival = new RandomGenerator(12345, 16807, 0, 2147483647);
        this.randService = new RandomGenerator(54321, 16807, 0, 2147483647);
    }

    public void chegada(double tempo) {
        double serviceTime = randService.generateUniform(minService, maxService);
        Cliente c = new Cliente(tempo, serviceTime);
        if (customers < capacity) {
            fila.add(c);
            customers++;
        } else {
            loss++;
        }
    }

    public void chegadaDireta(Cliente cliente, double tempo) {
        double serviceTime = randService.generateUniform(minService, maxService);
        cliente.setArrivalTime(tempo);
        cliente.setServiceTime(serviceTime);
        if (customers < capacity) {
            fila.add(cliente);
            customers++;
        } else {
            loss++;
        }
    }

    public Cliente saida(double tempo) {
        if (!fila.isEmpty()) {
            Cliente c = fila.poll();
            customers--;
            return c;
        }
        return null;
    }

    public double gerarChegada(double tempo) {
        return tempo + randArrival.generateUniform(minArrival, maxArrival);
    }

    public double gerarSaida(double tempo) {
        if (!fila.isEmpty()) {
            fila.peek().setStartService(tempo);
            return fila.peek().getEndService();
        }
        return Double.POSITIVE_INFINITY;
    }

    public boolean temCliente() {
        return !fila.isEmpty();
    }

    public int status() {
        return customers;
    }

    // delta = variacao do tmepo dos eventos
    public void acumulaTempo(double delta) {
        if (delta > 0) {
            times[status()] += delta;
        }
    }

    //
    public void relatorio(String nome) {
        System.out.println(nome + ":");
        System.out.println("Clientes perdidos: " + loss);
        double totalTempo = 0.0;
        for (double t : times) {
            totalTempo += t;
        }
        if (totalTempo > 0) {
            System.out.printf("Tempo acumulado: %.2f\n", totalTempo);
            System.out.println("Probabilidades de estados:");
            for (int i = 0; i <= capacity; i++) {
                double prob = times[i] / totalTempo;
                System.out.printf("P(%d) = %.4f\n", i, prob);
                System.out.printf("tempo total globalizado: %.2f\n", totalTempo);
                // ver melhor essa parte do tempo total
                // ver next fixes

            }
        } else {
            System.out.println("");
        }
    }

    /*
     * <PARA FAZR>
     * - Adicionar no relatorio a quantidade de clientes atendidos
     * - criar "wins" para contabilizar a quantidade de clientes atendidos
     * - Ver outras coisas para adicionar no relatorio
     */

}