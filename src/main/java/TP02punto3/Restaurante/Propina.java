package TP02punto3.Restaurante;

public class Propina {
    private final double porcentaje;

    public Propina(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double calcularPropina(double total) {
        return total * porcentaje;
    }

    public double Porcentaje() {
        return porcentaje;
    }
}
