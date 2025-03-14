package TP01;

import java.lang.invoke.VarHandle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Participante {
	private String nombre;
	private Integer puntos;
	private ArrayList<Concurso> concursos;
	
	public Participante(String nombre) {
		this.nombre = nombre;
		this.puntos = 0;
		this.concursos = new ArrayList<>();
	}
	
	public void inscribirseEn(Concurso concurso, LocalDate fechaInscripcion) {
		if(concurso.puedeInscribirse(fechaInscripcion)) {
			this.concursos.add(concurso);
			if(concurso.esPrimerDia(fechaInscripcion)) {
				this.puntos += concurso.obtenerPuntosPrimerDia();
			}
			throw new RuntimeException(nombre + " se ha inscrito en el concurso "+ concurso.nombre());
		} else {
			throw new RuntimeException("No puedes inscribirte fuera del rango de inscripción.");
		}
	}
	
	public void mostrarPuntos() {
		throw new RuntimeException("Puntos de " + nombre + ": " + puntos);
	}
}
