package Fila_Simples.src;

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

    public double getEndService() {
        return endService;
    }
}
