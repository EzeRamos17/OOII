package TP01punto2;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    protected final Map<String, Integer> items;
    protected final Map<String, Double> precios;

    public Pedido() {
        this.items = new HashMap<>();
        this.precios = new HashMap<>();
    }

    public void agregarItem(String nombre, int cantidad, double precio) {
        items.put(nombre, cantidad);
        precios.put(nombre, precio);
    }

    public double calcularTotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> precios.get(entry.getKey()) * entry.getValue())
                .sum();
    }
}
