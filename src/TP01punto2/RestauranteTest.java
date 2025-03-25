package TP01punto2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestauranteTest {
	
	@Test
    public void testCalculoCostoVisa() {
		Producto bebida1 = new Producto("Coca-Cola", 50.0, Producto.TipoProducto.BEBIDA);
        Producto bebida2 = new Producto("Agua Mineral", 30.0, Producto.TipoProducto.BEBIDA);
        Producto plato1 = new Producto("Pizza Margarita", 150.0, Producto.TipoProducto.PLATO);
        Producto plato2 = new Producto("Ensalada César", 120.0, Producto.TipoProducto.PLATO);

        Pedido pedido = new Pedido();
        pedido.agregarProducto(bebida1);
        pedido.agregarProducto(bebida2);
        pedido.agregarProducto(plato1);
        pedido.agregarProducto(plato2);

        // Cliente paga con Visa y elige una propina del 2%
        TarjetaDeCredito tarjetaVisa = new Visa();
        Propina propina2Porc = new Propina(0.02);
        Pago pagoVisa = new Pago(tarjetaVisa, pedido, propina2Porc);

        // Cálculo esperado
        double totalEsperado = 354.55;

        // Verificar el total con descuento y propina
        assertEquals(totalEsperado, pagoVisa.calcularTotalConDescuentoYPropina(), 0.01);
    }
	
	@Test
	public void testCalculoCostoMastercard() {
		Producto bebida1 = new Producto("Coca-Cola", 50.0, Producto.TipoProducto.BEBIDA);
        Producto bebida2 = new Producto("Agua Mineral", 30.0, Producto.TipoProducto.BEBIDA);
        Producto plato1 = new Producto("Pizza Margarita", 150.0, Producto.TipoProducto.PLATO);
        Producto plato2 = new Producto("Ensalada César", 120.0, Producto.TipoProducto.PLATO);
        
        Pedido pedido = new Pedido();
        pedido.agregarProducto(bebida1);
        pedido.agregarProducto(bebida2);
        pedido.agregarProducto(plato1);
        pedido.agregarProducto(plato2);
        
        TarjetaDeCredito tarjetaMastercard = new Mastercard();
        var propina = new Propina(0.05);
        Pago pagoMastercardPago = new Pago(tarjetaMastercard, pedido, propina);
        
        double totalEsperado = 361.83;
        
        assertEquals(totalEsperado, pagoMastercardPago.calcularTotalConDescuentoYPropina(), 0.01);
	}
	
	@Test
	public void testCalculoCostoComarcaPlus() {
		var bebida1 = new Producto("Coca-Cola", 50.0, Producto.TipoProducto.BEBIDA);
        var bebida2 = new Producto("Agua Mineral", 30.0, Producto.TipoProducto.BEBIDA);
        var plato1 = new Producto("Pizza Margarita", 150.0, Producto.TipoProducto.PLATO);
        var plato2 = new Producto("Ensalada César", 120.0, Producto.TipoProducto.PLATO);
        
        var pedido = new Pedido();
        pedido.agregarProducto(bebida1);
        pedido.agregarProducto(bebida2);
        pedido.agregarProducto(plato1);
        pedido.agregarProducto(plato2);
        
        var tarjetaComarcaPlus = new ComarcaPlus();
        var propina = new Propina(0.03);
        var pagoComarcaPlus = new Pago(tarjetaComarcaPlus, pedido, propina);
        
        double totalEsperado = 353.26;
        
        assertEquals(totalEsperado, pagoComarcaPlus.calcularTotalConDescuentoYPropina(), 0.01);
	}
	
	@Test
	public void testCalculoCostoViedma() {
		var bebida1 = new Producto("Coca-Cola", 50.0, Producto.TipoProducto.BEBIDA);
        var bebida2 = new Producto("Agua Mineral", 30.0, Producto.TipoProducto.BEBIDA);
        var plato1 = new Producto("Pizza Margarita", 150.0, Producto.TipoProducto.PLATO);
        var plato2 = new Producto("Ensalada César", 120.0, Producto.TipoProducto.PLATO);
        
        var pedido = new Pedido();
        pedido.agregarProducto(bebida1);
        pedido.agregarProducto(bebida2);
        pedido.agregarProducto(plato1);
        pedido.agregarProducto(plato2);
        
        var tarjetaViedma = new Viedma();
        var propina = new Propina(0.02);
        var pagoViedma = new Pago(tarjetaViedma, pedido, propina);
        
        double totalEsperado = 357;
        
        assertEquals(totalEsperado, pagoViedma.calcularTotalConDescuentoYPropina(), 0.01);
	}
}
