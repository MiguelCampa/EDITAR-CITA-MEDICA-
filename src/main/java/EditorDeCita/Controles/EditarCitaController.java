/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCita.Controles;

import EditorDeCitas.Model.Cita;
import EditorDeCitas.Model.EstadoCita;
import EditorDeCitas.Servicio.CitaService;
import EditorDeCita.Vista.EditarCitaView;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class EditarCitaController {

    private EditarCitaView view;
    private CitaService service;
    private Cita citaActual;

    // Constructor
    public EditarCitaController(EditarCitaView view, CitaService service) {
        this.view = view;
        this.service = service;
        initController();
    }

    // Inicializar eventos
    private void initController() {

        view.getBtnBuscar().addActionListener(e -> buscarCita());
        view.getBtnGuardar().addActionListener(e -> guardarCita());
    }

    //  Buscar cita
    private void buscarCita() {
        try {
            int id = Integer.parseInt(view.getTxtId().getText());


            citaActual = service.buscarCita(id);

            if (citaActual != null) {

                // Cargar datos en la vista
                view.getTxtFecha().setText(citaActual.getFecha().toString());
                view.getTxtHora().setText(citaActual.getHora().toString());
                view.getTxtMotivo().setText(citaActual.getMotivo());
                view.getCbEstado().setSelectedItem(citaActual.getEstado().name());

                JOptionPane.showMessageDialog(view, "Cita encontrada");

            } else {
                JOptionPane.showMessageDialog(view, "Cita no encontrada");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "ID inválido");
        }
    }

    //  Guardar cambios
    private void guardarCita() {

        if (citaActual == null) {
            JOptionPane.showMessageDialog(view, "Primero busca una cita");
            return;
        }

        try {
            // Obtener datos de la vista
            LocalDate fecha = LocalDate.parse(view.getTxtFecha().getText());
            LocalTime hora = LocalTime.parse(view.getTxtHora().getText());
            String motivo = view.getTxtMotivo().getText();
            EstadoCita estado = EstadoCita.valueOf(
                    view.getCbEstado().getSelectedItem().toString()
            );

            // Actualizar objeto
            citaActual.setFecha(fecha);
            citaActual.setHora(hora);
            citaActual.setMotivo(motivo);
            citaActual.setEstado(estado);

            // Guardar
            boolean actualizado = service.editarCita(citaActual);

            if (actualizado) {
                JOptionPane.showMessageDialog(view, "Cita actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(view, "Error al actualizar cita");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Datos inválidos");
        }
    }
}
