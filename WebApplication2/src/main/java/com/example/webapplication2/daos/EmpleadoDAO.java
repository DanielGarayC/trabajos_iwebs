package com.example.webapplication2.daos;
import com.example.webapplication2.beans.Empleado;

import java.sql.*;
import java.util.ArrayList;
public class EmpleadoDAO{
    public ArrayList<Empleado> obtenerListaEmpleados(){
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getString(1));
                empleado.setFirst_name(rs.getString(2));
                empleado.setLast_name(rs.getInt(3));

                listaEmpleados.add(empleado);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return listaEmpleados;

    }
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO empleados (id, nombre, apellido) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, empleado.getId());
            statement.setString(2, empleado.getFirst_name());
            statement.setString(3, empleado.getLast_name());
            statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void editarEmpleado(Empleado empleado) throws SQLException {
        try {
            String user = "root";
            String pass = "rootroot";
            String url = "jdbc:mysql://127.0.0.1:3306/hr";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "UPDATE empleados SET nombre=?, puesto=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, empleado.getId());
            statement.setString(2, empleado.getFirst_name());
            statement.setInt(3, empleado.getLast_name());
            statement.executeUpdate();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally{
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
