package Fila_Tandem.src;

import java.util.LinkedList;
import java.util.List;

public class FilaSimples {

    private int servers; // numero de servidores da fila
    private int capacity; // capacidade da fila
    private double minArrival; // tempo minimo de chegada de clientes nafila
    private double maxArrival; // tempo maximo de chegada de clientes na fila
    private double minService; // tempo minimo de atendimento de clientes na fila
    private double maxService; // tempo maximo de atendimento de clintes na fila
    private int custumers; // contabiliza a quantidade atual de clientes na fila
    private int loss;// contabiliza o numero de clientes perdidos na fila
    private int wins; // quantidade de cluentes atendidos
    private double times; // vetor dos tempos acumulados para cada estado da fila
    private LinkedList<Cliente> fila;
    private RandomGenerator aleatorio = new RandomGenerator(12345, 1103515245, 12345, 214748364);

    public FilaSimples(int server, int capacity, double minArrival, double maxArrival, double minService,
            double maxService,
            int custumers, int loss, int wins, double times) {
        this.fila = new LinkedList<Cliente>();
        this.servers = server;
        this.capacity = capacity;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.minService = minService;
        this.maxService = maxService;
        this.custumers = custumers;
        this.loss = loss;
        this.wins = wins;
        this.times = times;
    }

    public LinkedList<Cliente> getFila() {
        return fila;
    }

    public Cliente processarSaida(double tempo) {
        // quando termina o serviço
        if (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            cliente.setStartService(tempo);
            return cliente;
        }
        return null;
    }

    public void simular(double tempoMax, int entradas) {
        double tempo = 0.0;
        double proximaChegada = tempo + aleatorio.transforma(minArrival, maxArrival);
        double proximaSaida = Double.POSITIVE_INFINITY;

        int clientesSistema = 0;

        while (tempo < tempoMax) {
            if (proximaChegada <= proximaSaida) {
                tempo = proximaChegada;
                proximaChegada = tempo + aleatorio.transforma(minArrival, maxArrival);

                if (clientesSistema < capacity) {
                    clientesSistema++;
                    if (proximaSaida == Double.POSITIVE_INFINITY) {
                        proximaSaida = tempo + aleatorio.transforma(minService, maxService);
                    }
                } else {
                    loss++;
                }
            } else {
                tempo = proximaSaida;
                wins++;
                clientesSistema--;

                if (clientesSistema > 0) {
                    proximaSaida = tempo + aleatorio.transforma(minService, maxService);
                } else {
                    proximaSaida = Double.POSITIVE_INFINITY;
                }
            }
        }

        System.out.println("Atendidos: " + wins + " | Perdidos: " + loss);
    }

    // retorna a quantidade de clientes na fila
    public int status() {
        return custumers;
    }

    public int capacity() {
        return capacity;
    }

    // retorna a quantidade de servidores que a fila possui
    public int servers() {
        return servers;
    }

    public int loss() {
        return loss;
    }

    // aumenta a quantidade de cliente na fila em 1
    public void in() {
        if (status() < capacity()) {
            this.custumers++;
        }
    }

    // diminui a quantidade de cliente na fila em 1
    public void out() {
        if (status() > 0) {
            this.custumers--;
        }
    }

    public void setServer(int server) {
        this.servers = server;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getMinArrival() {
        return minArrival;
    }

    public void setMinArrival(double minArrival) {
        this.minArrival = minArrival;
    }

    public double getMaxArrival() {
        return maxArrival;
    }

    public void setMaxArrival(double maxArrival) {
        this.maxArrival = maxArrival;
    }

    public double getMinService() {
        return minService;
    }

    public void setMinService(double minService) {
        this.minService = minService;
    }

    public double getMaxService() {
        return maxService;
    }

    public void setMaxService(double maxService) {
        this.maxService = maxService;
    }

    public void setCustumers(int custumers) {
        this.custumers = custumers;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public double getTimes() {
        return times;
    }

    public void setTimes(double times) {
        this.times = times;
    }

}
