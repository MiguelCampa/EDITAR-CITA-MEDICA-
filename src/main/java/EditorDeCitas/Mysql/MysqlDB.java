package EditorDeCitas.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {

    private static final String URL =
            "jdbc:mysql://localhost:3306/edit_de_cita_medica"
            + "?useSSL=false&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "MHCA2407";

    // Constructor privado (buena práctica)
    private MysqlDB() {}

    /**
     * Devuelve una conexión a MySQL
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
