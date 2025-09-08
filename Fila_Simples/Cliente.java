package Fila_Simples;

public class Cliente {
    private double arrivalTime; // momento da chegada
    private double serviceTime; // duração do atendimento
    private double startService; // quando realmente começou a ser atendido
    private double endService; // quando terminou o atendimento

    public Cliente(double arrivalTime, double serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setStartService(double startService) {
        this.startService = startService;
        this.endService = startService + serviceTime;
    }

    public double getStartService() {
        return startService;
    }

    public double getEndService() {
        return endService;
    }
}
