package TP01punto2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestauranteTest {

	@Test
    public void testCalculoCostoVisa() {
        var pedido = new Pedido();
        pedido.agregarItem("Bebida Cola", 2, 100);
        pedido.agregarItem("Plato Milanesa", 1, 500);

        var pago = new Pago(TarjetaDeCredito.VISA, pedido);
        assertEquals(680, pago.obtenerTotalDescuento(), 0.01);
    }

}
