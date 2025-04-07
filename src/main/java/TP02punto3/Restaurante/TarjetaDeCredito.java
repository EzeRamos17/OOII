package TP02punto3.Restaurante;

public abstract class TarjetaDeCredito {
    protected double descuento;

    public abstract double calcularDescuento(double total);

    public double Descuento() {
        return descuento;
    }
}
