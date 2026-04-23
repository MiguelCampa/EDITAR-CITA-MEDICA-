package EditorDeCitas.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {

    private static final String URL      = 
            "jdbc:mysql://localhost:3306/edit_de_cita_medica"
            + "?useSSL=false&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";
    private static final String USER     = "root";  // Usuario de SQL
    private static final String PASSWORD = "MHCA2407";       // Contraseña de SQL

    private MysqlDB() {}

    /**
     * Devuelve una nueva conexión a MySQL.
     * El llamador es responsable de cerrarla (try-with-resources).
     * @throws SQLException si no se puede establecer la conexión
     */
    
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}