package Fila_Simples;

import java.util.LinkedList;
import java.util.Queue;

class Fila_Simples {
    private Queue<Cliente> fila;
    private int servers;
    private int capacity; // capacidade da fila
    private double minArrival; // tempo minimo de chegada de clientes nafila
    private double maxArrival; // tempo maximo de chegada de clientes na fila
    private double minService; // tempo minimo de atendimento de clientes na fila
    private double maxService; // tempo maximo de atendimento de clintes na fila
    private int custumers; // contabiliza a quantidade atual de clientes na fila
    private int loss;// contabiliza o numero de clientes perdidos na fila
    private double times; // vetor dos tempos acumulados para cada estado da fila

    public Fila_Simples(int server, int capacity, double minArrival, double maxArrival, double minService,
            double maxService,
            int custumers, int loss, double times) {
        this.servers = server;
        this.capacity = capacity;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.minService = minService;
        this.maxService = maxService;
        this.custumers = custumers;
        this.loss = loss;
        this.times = times;
        this.fila = new LinkedList<Cliente>();
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