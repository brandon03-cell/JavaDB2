import dao.AlumnoDAO;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println(alumnoDAO.obtenerAlumnosConItoYMayores());
    }
}