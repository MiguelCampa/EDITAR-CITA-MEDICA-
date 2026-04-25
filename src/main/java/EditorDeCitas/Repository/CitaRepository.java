/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCitas.Repository;

import EditorDeCitas.Model.*;

import java.sql.*;


public class CitaRepository implements ICitaRepository {

    private Connection connection;

    // Constructor
    public CitaRepository(Connection connection) {
        this.connection = connection;
    }

    //   Buscar cita por ID
    @Override
    public Cita buscarPorId(int id) {

        String query = "SELECT * FROM citas WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cita cita = new Cita();
                cita.setId(rs.getInt("id"));

                // Paciente
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("paciente_id"));
                cita.setPaciente(paciente);

                // Medico
                Medico medico = new Medico();
                medico.setId(rs.getInt("medico_id"));
                cita.setMedico(medico);

                // Fecha y hora
                cita.setFecha(rs.getDate("fecha").toLocalDate());
                cita.setHora(rs.getTime("hora").toLocalTime());

                // Otros datos
                cita.setMotivo(rs.getString("motivo"));
                cita.setEstado(EstadoCita.valueOf(rs.getString("estado")));

                return cita;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //  Actualizar cita
    @Override
    public boolean actualizar(Cita cita) {

        String query = "UPDATE citas SET fecha=?, hora=?, motivo=?, estado=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDate(1, Date.valueOf(cita.getFecha()));
            ps.setTime(2, Time.valueOf(cita.getHora()));
            ps.setString(3, cita.getMotivo());
            ps.setString(4, cita.getEstado().name());
            ps.setInt(5, cita.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
