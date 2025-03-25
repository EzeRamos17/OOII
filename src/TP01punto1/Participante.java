package TP01punto1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante {
	private String nombre;
	private Integer puntos;
	private final List<Concurso> concursos;

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
