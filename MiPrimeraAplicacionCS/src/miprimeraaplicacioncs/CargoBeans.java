package miprimeraaplicacioncs;

import java.sql.*;

public class CargoBeans {

    private int Id_Cargo;
    private String Cargo;
    private double Sueldo;
    accesobd bd;

    public CargoBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");
        bd.conectarBD();
    }

    public int getId_Cargo() {
        return Id_Cargo;
    }

    public void setId_Cargo(int Id_Cargo) {
        this.Id_Cargo = Id_Cargo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public int Incremento_Cargo() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_cargo) as num FROM cargo;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Cargo() throws SQLException {
        String cadena = "insert into cargo values('" + Incremento_Cargo() + "','" + getCargo() + "','" + getSueldo() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Cargo() throws SQLException {
        String cadena = "update cargo set cargo='" + getCargo() + "', sueldo= '" + getSueldo()
                + "' where id_cargo= '" + getId_Cargo() + "'";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Cargo() throws SQLException {
        String cadena = "delete from cargo where id_cargo='" + getId_Cargo() + "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Cargo() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from cargo");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getDouble(3) + " ");
            System.out.println("");
        }
    }

}
