package TP02punto3.Restaurante;

public class Mastercard extends TarjetaDeCredito {
    public Mastercard() {
        this.descuento = 0.02;  // 2% de descuento
    }

    @Override
    public double calcularDescuento(double total) {
        return total * descuento;
    }
}
