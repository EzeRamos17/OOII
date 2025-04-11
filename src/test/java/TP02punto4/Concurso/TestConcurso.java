package TP02punto4.Concurso;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConcurso {
    @Test
    public void UnParticipanteRecibeEmailAlInscribirse() {
        LocalDate hoy = LocalDate.now();
        var concurso = new Concurso("Concurso de test", hoy, hoy.plusDays(5), 10);
        var registroFake = new RegistroInscripcionesFake();
        var emailFake = new ServicioEmailFake();
        var participante = new Participante("Marta", registroFake, emailFake);

        participante.inscribirseEn(concurso, hoy);

        assertEquals(1, emailFake.getEmailsEnviados().size(), "Debe haberse enviado un email");

        String[] email = emailFake.getEmailsEnviados().get(0);
        assertEquals("Marta@email.com", email[0]);
        assertEquals("Inscripción confirmada", email[1]);
        assertTrue(email[2].contains("Concurso de test"));
    }
}
