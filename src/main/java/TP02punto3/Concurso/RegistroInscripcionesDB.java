package TP02punto3.Concurso;

import TP02punto3.acceso.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegistroInscripcionesDB implements RegistroInscripciones {
    @Override
    public void registrarInscripcion(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        String sql = "INSERT INTO inscripciones (fecha_hora, id_participante, id_concurso) VALUES (?, ?, ?)";
        Connection conn = null;
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setTimestamp(1, Timestamp.valueOf(fechaHora));
            stmt.setString(2, idParticipante);
            stmt.setString(3, idConcurso);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al registrar la inscripción en la base de datos", e);
        }
    }
}
