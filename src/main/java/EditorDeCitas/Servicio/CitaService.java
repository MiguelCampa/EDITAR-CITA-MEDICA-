/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCitas.Servicio;

import EditorDeCitas.Model.Cita;
import EditorDeCitas.Model.EstadoCita;
import EditorDeCitas.Repository.ICitaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaService {

    private ICitaRepository repository;

    // Constructor
    public CitaService(ICitaRepository repository) {
        this.repository = repository;
    }

    // Buscar cita
    public Cita buscarCita(int id) {
        return repository.buscarPorId(id);
    }

    // Editar cita
    public boolean editarCita(Cita cita) {

        // Validaciones básicas

        if (cita == null) {
            System.out.println("La cita es nula");
            return false;
        }

        if (cita.getFecha() == null || cita.getHora() == null) {
            System.out.println("Fecha u hora vacías");
            return false;
        }

        if (cita.getMotivo() == null || cita.getMotivo().isEmpty()) {
            System.out.println("Motivo vacío");
            return false;
        }

        if (cita.getEstado() == null) {
            System.out.println("Estado no válido");
            return false;
        }

        // Regla: no permitir fechas pasadas
        if (cita.getFecha().isBefore(LocalDate.now())) {
            System.out.println("No puedes editar citas en fechas pasadas");
            return false;
        }

        // Regla: no permitir horas vacías o inválidas
        if (cita.getHora().equals(LocalTime.MIDNIGHT)) {
            System.out.println("Hora no válida");
            return false;
        }

        // Si pasa validaciones → guardar
        return repository.actualizar(cita);
    }
}