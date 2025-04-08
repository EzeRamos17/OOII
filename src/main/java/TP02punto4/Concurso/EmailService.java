package TP02punto4.Concurso;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailService {
    private final String username;
    private final String password;
    private final String host;
    private final String port;
    private final String from;

    public EmailService() {
        Properties config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("No se pudo encontrar el archivo config.properties");
            }
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer archivo de configuración", e);
        }

        this.username = config.getProperty("mail.username");
        this.password = config.getProperty("mail.password");
        this.host = config.getProperty("mail.host");
        this.port = config.getProperty("mail.port");
        this.from = config.getProperty("mail.from");
    }

    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar email", e);
        }
    }
}
