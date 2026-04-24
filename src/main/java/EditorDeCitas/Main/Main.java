/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorDeCitas.Main;

import EditorDeCitas.Mysql.MysqlDB;
import EditorDeCitas.Repository.CitaRepository;
import EditorDeCitas.Repository.ICitaRepository;
import EditorDeCitas.Servicio.CitaService;
import EditorDeCita.Controles.EditarCitaController;
import EditorDeCita.Vista.EditarCitaView;

import javax.swing.SwingUtilities;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                //  1. Conexión a la base de datos
                Connection connection = MysqlDB.getConnection();

                //   2. Repository
                ICitaRepository repository = new CitaRepository(connection);

                //  3. Service
                CitaService service = new CitaService(repository);

                //   4. Vista (TU UI personalizada)
                EditarCitaView view = new EditarCitaView();

                //  5. Controller (conecta todo)
                new EditarCitaController(view, service);

                //   6. Mostrar ventana
                view.setLocationRelativeTo(null);
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al iniciar la aplicación");
            }

        });
    }
}

