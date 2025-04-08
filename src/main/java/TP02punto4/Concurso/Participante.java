package TP02punto4.Concurso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    private final List<Concurso> concursos;
    private final RegistroInscripciones registro;
    private String nombre;
    private Integer puntos;

    public Participante(String nombre, RegistroInscripciones registro) {
        this.nombre = nombre;
        this.puntos = 0;
        this.concursos = new ArrayList<>();
        this.registro = registro;
    }

    public void inscribirseEn(Concurso concurso, LocalDate fechaInscripcion) {
        if (concurso.puedeInscribirse(fechaInscripcion)) {
            this.concursos.add(concurso);
            if (concurso.esPrimerDia(fechaInscripcion)) {
                this.puntos += concurso.obtenerPuntosPrimerDia();
            }
            registro.registrarInscripcion(LocalDateTime.now(), this.nombre, concurso.nombre());
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
