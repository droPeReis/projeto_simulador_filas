package Fila_Tandem.src;

// Representa m cliente com tempos de chegada e servico
public class Cliente {
    private double arrivalTime;
    private double serviceTime;
    private double startService;
    private double endService;

    public Cliente(double arrivalTime, double serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public void setStartService(double startService) {
        this.startService = startService;
        this.endService = startService + serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public double getStartService() {
        return startService;
    }

    public double getEndService() {
        return endService;
    }
}