package TP02punto4.Concurso;

import java.util.ArrayList;
import java.util.List;

public class ServicioEmailFake implements ServicioEmail {
    private final List<String[]> emailsEnviados = new ArrayList<>();

    @Override
    public void enviar(String destinatario, String asunto, String cuerpo) {
        emailsEnviados.add(new String[]{destinatario, asunto, cuerpo});
    }

    public List<String[]> getEmailsEnviados() {
        return emailsEnviados;
    }
}
