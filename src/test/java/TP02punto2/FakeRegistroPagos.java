package TP02punto2;

public class FakeRegistroPagos implements RegistroPagos {
    private double ultimoMontoRegistrado = 0;

    @Override
    public void registrarPago(double monto) {
        this.ultimoMontoRegistrado = monto;
    }

    public double UltimoMontoRegistrado() {
        return ultimoMontoRegistrado;
    }
}
