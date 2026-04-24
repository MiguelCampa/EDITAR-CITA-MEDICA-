/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCitas.Servicio;

import EditorDeCitas.Model.Cita;

import EditorDeCitas.Repository.ICitaRepository;



public class CitaService {

    private ICitaRepository repository;

    // Constructor
    public CitaService(ICitaRepository repository) {
        this.repository = repository;
    }

    // ? Buscar cita
    public Cita buscarCita(int id) {
        return repository.buscarPorId(id);
    }

    // ✏ Editar cita
    public boolean editarCita(Cita cita) {

        //  Validaciones básicas

        if (cita == null) {
            System.out.pri
