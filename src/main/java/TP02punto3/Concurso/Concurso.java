package TP02punto3.Concurso;

import java.time.LocalDate;

public class Concurso {
    private final String nombre;
    private final LocalDate fechaInicioInscripcion;
    private final LocalDate fechaFinInscripcion;
    private final Integer puntosPrimerDia;

    public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, Integer puntosPrimerDia) {
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.puntosPrimerDia = puntosPrimerDia;
    }

    public Boolean esPrimerDia(LocalDate fecha) {
        return fecha.equals(fechaInicioInscripcion);
    }

    public Boolean puedeInscribirse(LocalDate fecha) {
        return !fecha.isBefore(fechaInicioInscripcion) && !fecha.isAfter(fechaFinInscripcion);
    }

    public Integer obtenerPuntosPrimerDia() {
        return puntosPrimerDia;
    }

    public String nombre() {
        return nombre;
    }
}
