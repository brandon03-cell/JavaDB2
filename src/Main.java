import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:prueba.sqlite3";

        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            String sql= "select * from alumnos";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println(nombre + " " + edad);
            }
            System.out.println("Ejecución correcta xd");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}