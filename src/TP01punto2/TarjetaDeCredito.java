package TP01punto2;

public enum TarjetaDeCredito {
	VISA(0.03, 0.00),
	MASTERCARD(0.00, 0.02),
	COMARCA_PLUS(0.02, 0.02),
	VIEDMA(0.00, 0.00);
	
	private final double descuentoBebidas;
	private final double descuentoPlatos;
	
	TarjetaDeCredito(double descuentoBebidas, double descuentoPlatos) {
		this.descuentoBebidas = descuentoBebidas;
		this.descuentoPlatos = descuentoPlatos;
	}
	
	public double obtenerDescuentoBebidas() {
		return descuentoBebidas;
	}
	
	public double obtenerDescuentoPlatos() {
		return descuentoPlatos;
	}
}
