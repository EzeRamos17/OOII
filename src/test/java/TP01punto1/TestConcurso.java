package TP01punto1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestConcurso {

    @Test
    void UnParticipanteSeInscribeEnElConcurso() {
        LocalDate hoy = LocalDate.now();
        var concurso = new Concurso("Concurso de test", hoy, hoy.plusDays(10), 10);

        var participante = new Participante("Hernan");

        participante.inscribirseEn(concurso, hoy);

        assertTrue(participante.estaInscriptoEn(concurso));
    }

    @Test
    void UnParticipanteSeInscribeElPrimerDia() {
        LocalDate hoy = LocalDate.now();
        var concurso = new Concurso("Concurso de test", hoy, hoy.plusDays(10), 10);

        var participante = new Participante("Hernan");

        //participante.inscribirseEn(concurso, hoy.plusDays(2)); //no pasa el test
        participante.inscribirseEn(concurso, hoy); //pasa el test
        //prueba
        //assertTrue(participante.estaInscriptoEn(concurso));//revisar los 10 puntos
        assertTrue(participante.tienePuntos(10), "El participante debería recibir 10 puntos por inscribirse el primer día.");
    }

    @Test
    void UnParticipanteNoPuedeInscribirseFueraDelRango() {
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        var concurso = new Concurso("Concurso de test", fechaInicio, fechaFin, 10);
        var participante = new Participante("Hernan");

        LocalDate fechaFueraDeRango = fechaFin.plusDays(1); // Un día después de la fecha de cierre

        Exception exception = assertThrows(RuntimeException.class, () -> participante.inscribirseEn(concurso, fechaFueraDeRango));
        assertEquals("No puedes inscribirte fuera del rango de inscripción.", exception.getMessage());
    }

}
