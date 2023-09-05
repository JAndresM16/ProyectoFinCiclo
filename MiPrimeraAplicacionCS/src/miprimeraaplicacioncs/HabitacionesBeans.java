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
        bd = new accesobd("localhost", "root", "", "hoteles");     /*1*/
        bd.conectarBD();                                           /*2*/
        
    /* 
        1/ 5TA
        2/ 3TA
        T= 5TA+3TA =8TA
    */
    }

    public int getId_Habitacion() {
        return Id_Habitacion;
    }

    public void setId_Habitacion(int Id_Habitacion) {
        this.Id_Habitacion = Id_Habitacion;                        /*1*/
       
    /* 
        1/ TA
        T= TA
    */                              
    }

    public int getId_Empleado() {
        return Id_Empleado;
    }

    public void setId_Empleado(int Id_Empleado) {
        this.Id_Empleado = Id_Empleado;                           /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;                                     /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;                                        /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;                                    /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;                    /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(String Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;                    /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;                           /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public int Incremento_Habitaciones() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_habitacion) as num FROM habitaciones;");  /*3*/
        if (rs.next()) {                                                            /*4*/
            inc = rs.getInt(1) + 1;                                                 /*5*/
        } else {                                                                    /*6*/
            inc = 1;                                                                /*7*/
        }
        return inc;
        /* 
        3/ TA
        4/ TC
        5/ TA+TO
        7/ TA
       
        TP = TA+TC+TA+TO = 2TA+TC+TO
        TM = TA+TC+TA = 2TA+TC
        TE = 2TA+TC+TO - 2TA+TC = TO
    */
    }

    public void Insertar_Habitaciones() throws SQLException {
        String cadena = "insert into habitaciones values('" + Incremento_Habitaciones() + "','" + getId_Empleado()
                + "','" + getNumero() + "','" + getPiso() + "','" + getPrecio() + "','"
                + getDisponibilidad() + "','" + getFecha_Registro() + "','" + getDescipcion() + "')"; /*1*/
        bd.ActualizarBD(cadena);                                                                      /*2*/
        /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */

    }

    public void Actualizar_Habitaciones() throws SQLException {
        String cadena = "update habitaciones set id_empleado='" + getId_Empleado() + "', numero= '" + getNumero()
                + "', piso= '" + getPiso() + "', precio= '" + getPrecio() + "', disponibilidad= '" + getDisponibilidad()
                + "', fechaRegistro= '" + getFecha_Registro() + "', descripcion= '" + getDescipcion()
                + "' where id_habitaciones= '" + getId_Habitacion() + "'";                            /*1*/
        bd.ActualizarBD(cadena);                                                                      /*2*/
        /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */
    }

    public void Eliminar_Habitaciones() throws SQLException {
        String cadena = "delete from habitaciones where id_habitacion='" + getId_Habitacion() + "'";   /*1*/
        bd.ActualizarBD(cadena);                                                                       /*2*/
        /* 
        1/ TA
        2/ 2TA
        T= TA+2TA =3TA
    */
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Habitaciones() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from habitaciones");                                          /*1*/
        while (rs.next()) {                                                                        /*2*/
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
        /* 
        1/ 2TA
        2/ N*TC+TC
        TP= 2TA+N*TC+TC
        TM= 2TA+TC
        TE= 2TA+N*TC+TC - 2TA+TC = N*TC
    */
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
