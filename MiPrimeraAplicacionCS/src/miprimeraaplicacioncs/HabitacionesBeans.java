package miprimeraaplicacioncs;

import java.sql.*;

public class HabitacionesBeans {

    private int Id_Habitacion;
    private int Id_Empleado;
    private int numero;
    private int piso;
    private double precio;
    private String disponibilidad;
    private String Fecha_Registro;
    private String descipcion;
    accesobd bd;

    public HabitacionesBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");
        bd.conectarBD();
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(String Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public int Incremento_Habitaciones() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_habitacion) as num FROM habitaciones;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Habitaciones() throws SQLException {
        String cadena = "insert into habitaciones values('" + Incremento_Habitaciones() + "','" + getId_Empleado()
                + "','" + getNumero() + "','" + getPiso() + "','" + getPrecio() + "','"
                + getDisponibilidad() + "','" + getFecha_Registro() + "','" + getDescipcion() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Habitaciones() throws SQLException {
        String cadena = "update habitaciones set id_empleado='" + getId_Empleado() + "', numero= '" + getNumero()
                + "', piso= '" + getPiso() + "', precio= '" + getPrecio() + "', disponibilidad= '" + getDisponibilidad()
                + "', fechaRegistro= '" + getFecha_Registro() + "', descripcion= '" + getDescipcion()
                + "' where id_habitaciones= '" + getId_Habitacion() + "'";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Habitaciones() throws SQLException {
        String cadena = "delete from habitaciones where id_habitacion='" + getId_Habitacion() + "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Habitaciones() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from habitaciones");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getInt(2) + " ");
            System.out.print(rs.getInt(3) + " ");
            System.out.print(rs.getInt(4) + " ");
            System.out.print(rs.getDouble(5) + " ");
            System.out.print(rs.getString(6) + " ");
            System.out.print(rs.getString(7) + " ");
            System.out.print(rs.getString(8) + " ");
            System.out.println("");
        }
    }

    public ResultSet obtenerHabitacionesOcupadas() throws SQLException {
        String sql = "SELECT numero, fechaInicio, fechaFin, disponibilidad FROM habitaciones WHERE disponibilidad = 'No'";
        return bd.consultaBD(sql);
    }

    public ResultSet obtenerHabitacionesDisponibles() throws SQLException {
        // Realizar la consulta a la base de datos para obtener las habitaciones disponibles
        String sql = "SELECT numero, fechaInicio, fechaFin, disponibilidad FROM habitaciones WHERE disponibilidad = 'Si'";
        return bd.consultaBD(sql);
    }

    public void actualizarDisponibilidad(int idHabitacion, String disponibilidad) throws SQLException {
        try {
            bd = new accesobd("localhost", "root", "", "hoteles");
            bd.conectarBD();

            String updateSql = "UPDATE habitaciones SET disponibilidad = ? WHERE id_habitacion = ?";
            PreparedStatement statement = bd.conexion.prepareStatement(updateSql);
            statement.setString(1, disponibilidad);
            statement.setInt(2, idHabitacion);
            statement.executeUpdate();

            System.out.println("Actualización de disponibilidad exitosa");
        } catch (Exception e) {
            System.out.println("Error al actualizar la disponibilidad: " + e.toString());
        } finally {
            if (bd != null) {
                bd.cerrarBD();
            }
        }
    }
}
