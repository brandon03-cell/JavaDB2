import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:prueba.sqlite3";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            String sql= "create table alumnos (" +
                    "id integer primary key autoincrement," +
                    "nombre text," +
                    "edad integer)";
            stmt.execute(sql);
            System.out.println("Ejecución correcta xd");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}