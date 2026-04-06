package dao;

import modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private String url = "jdbc:sqlite:prueba.sqlite3";

    public void insertarAlumno(Alumno a) {
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "insert into alumnos (nombre, edad) values (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a.getNombre());
            pstmt.setInt(2, a.getEdad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "select * from alumnos";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                Alumno a = new Alumno(nombre, edad);
                alumnos.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumnos;
    }

    public List<Alumno> obtenerAlumnosConItoYMayores() {
        List<Alumno> alumnos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "select * from alumnos where nombre like '%ito' and edad >= 18";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                Alumno a = new Alumno(nombre, edad);
                alumnos.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumnos;

    }
}
