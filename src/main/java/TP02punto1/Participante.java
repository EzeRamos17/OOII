package TP02punto1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    private final List<Concurso> concursos;
    private final String nombre;
    private final RegistroInscripciones registroInscripciones;
    private Integer puntos;

    public Participante(String nombre, RegistroInscripciones registroInscripciones) {
        this.nombre = nombre;
        this.puntos = 0;
        this.concursos = new ArrayList<>();
        this.registroInscripciones = registroInscripciones;
    }

    public void inscribirseEn(Concurso concurso, LocalDate fechaInscripcion) {
        if (concurso.puedeInscribirse(fechaInscripcion)) {
            this.concursos.add(concurso);
            if (concurso.esPrimerDia(fechaInscripcion)) {
                this.puntos += concurso.obtenerPuntosPrimerDia();
            }
            registroInscripciones.registrarInscripcion(LocalDateTime.now(), nombre, concurso.nombre());

            System.out.println(nombre + " se ha inscrito en el concurso " + concurso.nombre());
        } else {
            throw new RuntimeException("No puedes inscribirte fuera del rango de inscripción.");
        }
    }

    public boolean tienePuntos(int cantidad) {
        return this.puntos == cantidad;
    }

    public boolean estaInscriptoEn(Concurso concurso) {
        return concursos.contains(concurso);
    }
}
