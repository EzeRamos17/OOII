package TP02punto2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroPagosDisco implements RegistroPagos {
    private final String archivo;

    public RegistroPagosDisco(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void registrarPago(double monto) {
        try (FileWriter fw = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            pw.println(fechaHora + "||" + monto);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}
