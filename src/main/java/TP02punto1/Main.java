package TP02punto1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String archivoInscripciones = "inscripciones.txt";
        RegistroInscripciones registro = new RegistroInscripcionesArchivo(archivoInscripciones);
        var participante = new Participante("Juan Pérez", registro);
        LocalDate hoy = LocalDate.now();
        var concurso = new Concurso("Maratón de Programación", hoy, hoy.plusDays(7), 15);

        try {
            participante.inscribirseEn(concurso, hoy);
            System.out.println("Inscripción realizada correctamente. Verifica el archivo " + archivoInscripciones);
        } catch (Exception e) {
            System.out.println("Error en la inscripción: " + e.getMessage());
        }
    }
}
