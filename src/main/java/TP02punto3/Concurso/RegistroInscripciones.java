package TP02punto3.Concurso;

import java.time.LocalDateTime;

public interface RegistroInscripciones {
    void registrarInscripcion(LocalDateTime fechaHora, String idParticipante, String idConcurso);
}
