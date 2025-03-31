package TP01punto2;

public class Viedma extends TarjetaDeCredito {
    public Viedma() {
        this.descuento = 0.0;  // Sin descuento
    }

    @Override
    public double calcularDescuento(double total) {
        return 0;  // No hay descuento
    }
}
