package TP02punto3.Restaurante;

import TP02punto3.acceso.RegistroPagosDB;

public class Main {
    public static void main(String[] args) {
        var pedido = new Pedido();
        pedido.agregarProducto(new Producto("Coca-Cola", 500, Producto.TipoProducto.BEBIDA));
        pedido.agregarProducto(new Producto("Milanesa", 1500, Producto.TipoProducto.PLATO));

        var tarjeta = new Visa();
        var propina = new Propina(0.1);
        RegistroPagos registroDB = new RegistroPagosDB();

        var pago = new Pago(tarjeta, pedido, propina, registroDB);
        double total = pago.calcularTotalConDescuentoYPropina();
        System.out.println("Total pagado: $" + total);
    }
}
