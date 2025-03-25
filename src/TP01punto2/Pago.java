package TP01punto2;

public class Pago {
	private TarjetaDeCredito tarjeta;
    private Pedido pedido;
    private Propina propina;

    public Pago(TarjetaDeCredito tarjeta, Pedido pedido, Propina propina) {
        this.tarjeta = tarjeta;
        this.pedido = pedido;
        this.propina = propina;
    }

    public double calcularTotalConDescuentoYPropina() {
        // Separar las bebidas y los platos
        double totalBebidas = 0;
        double totalPlatos = 0;

        // Separar precios según tipo de producto
        for (Producto producto : pedido.Pedidos()) {
            if (producto.Tipo() == Producto.TipoProducto.BEBIDA) {
                totalBebidas += producto.Precio();
            } else if (producto.Tipo() == Producto.TipoProducto.PLATO) {
                totalPlatos += producto.Precio();
            }
        }

        // Aplicar descuentos según la tarjeta
        double descuentoBebidas = 0;
        double descuentoPlatos = 0;

        if (tarjeta instanceof Visa) {
            descuentoBebidas = totalBebidas * 0.03;  // 3% descuento sobre bebidas
        } else if (tarjeta instanceof Mastercard) {
            descuentoPlatos = totalPlatos * 0.02;  // 2% descuento sobre platos
        } else if (tarjeta instanceof ComarcaPlus) {
            // 2% descuento sobre el total completo
            double descuentoTotal = (totalBebidas + totalPlatos) * 0.02;
            totalBebidas -= descuentoTotal * (totalBebidas / (totalBebidas + totalPlatos));
            totalPlatos -= descuentoTotal * (totalPlatos / (totalBebidas + totalPlatos));
        }

        // Calcular el total después de descuentos
        double totalConDescuento = totalBebidas + totalPlatos - descuentoBebidas - descuentoPlatos;

        // Calcular propina
        double montoPropina = propina.calcularPropina(totalConDescuento);

        // Calcular el total final
        double totalFinal = totalConDescuento + montoPropina;
        
        // Redondear a dos decimales
        return Math.round(totalFinal * 100.0) / 100.0;
    }
}
