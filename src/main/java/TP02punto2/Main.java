package TP02punto2;

public class Main {
    public static void main(String[] args) {
        var pedido = new Pedido();
        pedido.agregarProducto(new Producto("Coca-Cola", 500, Producto.TipoProducto.BEBIDA));
        pedido.agregarProducto(new Producto("Milanesa", 1500, Producto.TipoProducto.PLATO));

        var tarjeta = new Visa();
        var propina = new Propina(0.1);
        RegistroPagos registro = new RegistroPagosDisco("historial_pagos.txt");

        var pago = new Pago(tarjeta, pedido, propina, registro);
        double total = pago.calcularTotalConDescuentoYPropina();
        System.out.println("Total pagado: $" + total);
    }
}
