package TP01;

import java.lang.invoke.VarHandle;
import java.time.LocalDate;
import java.util.Map;

public class Participante {
	private String nombre;
	private Integer puntos;
	private LocalDate fechaInscripcion;
	private Map<Concurso, LocalDate> inscripciones;
}
