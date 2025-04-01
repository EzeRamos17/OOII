package TP02punto1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroInscripcionesFake implements RegistroInscripciones {
    private final List<String> registros = new ArrayList<>();

    @Override
    public void registrarInscripcion(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        registros.add(fechaHora.toString() + ", " + idParticipante + ", " + idConcurso);
    }

    public List<String> Registros() {
        return registros;
    }

}
