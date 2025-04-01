package TP02punto1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroInscripcionesArchivo implements RegistroInscripciones {
    private final String archivo;

    public RegistroInscripcionesArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void registrarInscripcion(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        String formatoFecha = fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        String linea = formatoFecha + ", " + idParticipante + ", " + idConcurso + "\n";

        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + archivo, e);
        }
    }
}
