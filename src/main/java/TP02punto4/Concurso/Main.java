//package TP02punto4.Concurso;
//
//import TP02punto1.RegistroInscripcionesArchivo;
//
//import java.time.LocalDate;
//
//public class Main {
//    public static void main(String[] args) {
//        RegistroInscripciones registro = new RegistroInscripcionesDB();
//        String archivoInscripciones = "inscripciones.txt";
//        TP02punto1.RegistroInscripciones registroArchivo = new RegistroInscripcionesArchivo(archivoInscripciones);
//        var participante = new Participante("Juan Pérez", registro);
//        LocalDate hoy = LocalDate.now();
//        var concurso = new Concurso("Maratón de Programación", hoy, hoy.plusDays(7), 15);
//
//        try {
//            participante.inscribirseEn(concurso, hoy);
//            System.out.println("Inscripción realizada correctamente en la base de datos.");
//        } catch (Exception e) {
//            System.out.println("Error en la inscripción: " + e.getMessage());
//        }
//    }
//}
