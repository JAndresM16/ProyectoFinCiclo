package miprimeraaplicacioncs;

import java.sql.*;

public class RegistrarBeans {

    private int Id_Registro;
    private int Id_Cliente;
    private int Id_Habitacion;
    private int Id_Empleado;
    private String Fecha_Inicio;
    private String Fecha_Fin;
    private String Metodo;
    private double Pago;
    accesobd bd;

    public RegistrarBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");
        bd.conectarBD();
    }

    public int getId_Registro() {
        return Id_Registro;
    }

    public void setId_Registro(int Id_Registro) {
        this.Id_Registro = Id_Registro;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public int getId_Habitacion() {
        return Id_Habitacion;
    }

    public void setId_Habitacion(int Id_Habitacion) {
        this.Id_Habitacion = Id_Habitacion;
    }

    public int getId_Empleado() {
        return Id_Empleado;
    }

    public void setId_Empleado(int Id_Empleado) {
        this.Id_Empleado = Id_Empleado;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(String Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String Metodo) {
        this.Metodo = Metodo;
    }

    public double getPago() {
        return Pago;
    }

    public void setPago(double Pago) {
        this.Pago = Pago;
    }

    public int Incremento_Registro() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_registro) as num FROM registros;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Registro() throws SQLException {
        String cadena = "insert into registros values('" + Incremento_Registro() + "','" + getId_Cliente()
                + "','" + getId_Habitacion() + "','" + getId_Empleado() + "','" + getFecha_Inicio() + "','"
                + getFecha_Fin() + "','" + getMetodo() + "','" + getPago() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Registro() throws SQLException {
        String cadena = "update registros set id_cliente='" + getId_Cliente() + "', id_habitacion= '" + getId_Habitacion()
                + "', id_empleado= '" + getId_Empleado() + "', fechaInicio= '" + getFecha_Inicio() + "', fechaFin= '" + getFecha_Fin()
                + "', Metodo= '" + getMetodo() + "', Pago= '" + getPago()
                + "' where id_registro= '" + getId_Registro() + "'";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Registro() throws SQLException {
        String cadena = "delete from registros where id_registro='" + getId_Registro() + "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Registro() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from registros");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getInt(2) + " ");
            System.out.print(rs.getInt(3) + " ");
            System.out.print(rs.getInt(4) + " ");
            System.out.print(rs.getString(5) + " ");
            System.out.print(rs.getString(6) + " ");
            System.out.print(rs.getString(7) + " ");
            System.out.print(rs.getDouble(8) + " ");
            System.out.println("");
        }
    }

}
