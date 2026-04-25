/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCitas.Repository;

import EditorDeCitas.Model.Cita;

public interface ICitaRepository {

    // Buscar una cita por ID
    Cita buscarPorId(int id);

    // Actualizar una cita
    boolean actualizar(Cita cita);
}

