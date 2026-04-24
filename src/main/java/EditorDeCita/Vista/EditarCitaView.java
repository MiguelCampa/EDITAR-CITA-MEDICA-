/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCita.Vista;

import javax.swing.*;
import java.awt.*;

public class EditarCitaView extends JFrame {

    // 🔹 Campos
    private JTextField txtId;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtMotivo;
    private JComboBox<String> cbEstado;

    // 🔹 Botones
    private JButton btnBuscar;
    private JButton btnGuardar;

    public EditarCitaView() {

        setTitle("Editor de Citas Médicas");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {

        setLayout(new GridLayout(7, 2, 10, 10));

        // 🔹 ID
        add(new JLabel("ID Cita:"));
        txtId = new JTextField();
        add(txtId);

        btnBuscar = new JButton("Buscar");
        add(btnBuscar);
        add(new JLabel("")); // espacio vacío

        // 🔹 Fecha
        add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFecha = new JTextField();
        add(txtFecha);

        // 🔹 Hora
        add(new JLabel("Hora (HH:MM):"));
        txtHora = new JTextField();
        add(txtHora);

        // 🔹 Motivo
        add(new JLabel("Motivo:"));
        txtMotivo = new JTextField();
        add(txtMotivo);

        // 🔹 Estado
        add(new JLabel("Estado:"));
        cbEstado = new JComboBox<>(new String[]{
                "PROGRAMADA",
                "CANCELADA",
                "COMPLETADA"
        });
        add(cbEstado);

        // 🔹 Botón Guardar
        btnGuardar = new JButton("Guardar");
        add(btnGuardar);

        add(new JLabel("")); // espacio vacío
    }

    // 🔹 GETTERS (para el Controller)

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtHora() {
        return txtHora;
    }

    public JTextField getTxtMotivo() {
        return txtMotivo;
    }

    public JComboBox<String> getCbEstado() {
        return cbEstado;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
}
