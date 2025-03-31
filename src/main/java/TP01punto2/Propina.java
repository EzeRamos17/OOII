package TP01punto2;

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
