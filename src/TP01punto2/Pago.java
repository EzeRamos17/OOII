package TP01punto2;

import java.util.Map;

public class Pago {
	private final TarjetaDeCredito tarjeta;
	private final Pedido pedido;
	private double totalConDescuento;
	
	public Pago(TarjetaDeCredito tarjeta, Pedido pedido) {
		this.tarjeta = tarjeta;
		this.pedido = pedido;
		this.totalConDescuento = calcularTotalDescuento();
	}
	
	private double calcularTotalDescuento() {
		double totalPlatos = 0;
		double totalBebidas = 0;
		
		for (Map.Entry<String, Integer> entry : pedido.items.entrySet()) {
			String item = entry.getKey();
			double precio = pedido.precios.get(item) * entry.getValue();
			
			if (esBebida(item)) {
				totalBebidas += precio;
			} else {
				totalPlatos += precio;
			}
		}
		
		double descuentoBebidas = totalBebidas * tarjeta.obtenerDescuentoBebidas();
		double descuentoPlatos = totalPlatos * tarjeta.obtenerDescuentoPlatos();
		
		return totalPlatos + totalBebidas - descuentoBebidas - descuentoPlatos;
	}
	
	private boolean esBebida(String item) {
		return item.toLowerCase().contains("bebida");
	}
	
	public double obtenerTotalDescuento() {
		return totalConDescuento;
	}
}
