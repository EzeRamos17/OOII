package TP02punto2;

public class Producto {
    private final String nombre;
    private final double precio;
    private final TipoProducto tipo;

    public Producto(String nombre, double precio, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public double Precio() {
        return precio;
    }

    public TipoProducto Tipo() {
        return tipo;
    }

    public enum TipoProducto {
        BEBIDA, PLATO
    }
}
