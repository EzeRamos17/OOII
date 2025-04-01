package TP02punto2;

public class ComarcaPlus extends TarjetaDeCredito {
    public ComarcaPlus() {
        this.descuento = 0.02;  // 2% de descuento en total
    }

    @Override
    public double calcularDescuento(double total) {
        return total * descuento;
    }
}
