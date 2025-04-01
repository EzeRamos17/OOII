package TP02punto2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

        double totalConDescuento = totalBebidas + totalPlatos - descuentoBebidas - descuentoPlatos;
        double montoPropina = propina.calcularPropina(totalConDescuento);
        double totalFinal = Math.round((totalConDescuento + montoPropina) * 100.0) / 100.0;

        guardarEnArchivo(totalFinal);
        return totalFinal;
    }

    private void guardarEnArchivo(double monto) {
        try (FileWriter fw = new FileWriter("historial_pagos.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            pw.println(fechaHora + " || " + monto);
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}

