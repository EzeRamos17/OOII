package TP02punto2;

public class Visa extends TarjetaDeCredito {
    public Visa() {
        this.descuento = 0.03;  // 3% de descuento
    }

    @Override
    public double calcularDescuento(double total) {
        return total * descuento;
    }
}
