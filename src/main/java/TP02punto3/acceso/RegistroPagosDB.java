package TP02punto3.acceso;

import TP02punto3.Restaurante.RegistroPagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroPagosDB implements RegistroPagos {
    private static final String INSERT_SQL = "INSERT INTO pagos (monto) VALUES (?)";

    @Override
    public void registrarPago(double monto) {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setDouble(1, monto);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar el pago en la base de datos", e);
        }
    }
}
