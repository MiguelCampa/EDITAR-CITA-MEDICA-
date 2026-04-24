/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCitas.Main;

import EditrDeCitas.FrontEnd.Editor;
import EditorDeCita.Controles.EditarCitaController;
import EditorDeCitas.Servicio.CitaService;
import EditorDeCitas.Repository.CitaRepository;
import EditorDeCitas.Repository.ICitaRepository;
import EditorDeCitas.Mysql.MysqlDB;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                // Conexión a MySQL
                Connection conn = MysqlDB.getConnection();

                //  Repository
                ICitaRepository repo = new CitaRepository(conn);

                //  Service
                CitaService service = new CitaService(repo);

                //  Vista (TU JFrame)
                Editor view = new Editor();

                // Controller
                new EditarCitaController(view, service);

                //  Mostrar ventana
                view.setLocationRelativeTo(null);
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al iniciar la aplicación");
            }

        });
    }
}
