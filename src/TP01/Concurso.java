package TP01;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;
	private Integer puntosPrimerDia;
	
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
