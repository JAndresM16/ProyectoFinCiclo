package miprimeraaplicacioncs;

import java.sql.*;

public class EmpleadoBeans {

    private int Id_Empleado;
    private int Id_cargo;
    private int Id_horario;
    private String cedula;
    private String nombres;
    private String telefono;
    private String direccion;
    accesobd bd;

    public EmpleadoBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");             /*1*/
        bd.conectarBD();                                                   /*2*/
        
    /* 
        1/ 5TA
        2/ 3TA
        T= 5TA+3TA =8TA
    */
    }

    public int getId_Empleado() {
        return Id_Empleado;
    }

    public void setId_Empleado(int Id_Empleado) {
        this.Id_Empleado = Id_Empleado;                                    /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public int getId_cargo() {
        return Id_cargo;
    }

    public void setId_cargo(int Id_cargo) {
        this.Id_cargo = Id_cargo;                                          /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public int getId_horario() {
        return Id_horario;
    }

    public void setId_horario(int Id_horario) {
        this.Id_horario = Id_horario;                                      /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;                                              /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;                                            /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;                                          /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;                                        /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public int Incremento_Empleado() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_empleado) as num FROM empleado;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Empleado() throws SQLException {
        String cadena = "insert into empleado values('" + Incremento_Empleado() + "','" + getId_cargo()
                + "','" + getId_horario() + "','" + getCedula() + "','" + getNombres() + "','"
                + getTelefono() + "','" + getDireccion() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Empleado() throws SQLException {
        String cadena = "update empleado set id_cargo='" + getId_cargo() + "', id_horario= '" + getId_horario()
                + "', cedula= '" + getCedula() + "', nombres= '" + getNombres() + "', telefono= '" + getTelefono()
                + "', direccion= '" + getDireccion() + "' where id_empleado= '" + getId_Empleado() + "'";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Empleado() throws SQLException {
        String cadena = "delete from empleado where id_empleado='" + getId_Empleado() + "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Empleado() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("SELECT e.cedula, e.nombres, c.cargo, h.horaInicio, h.horaFin, c.sueldo FROM empleado e JOIN cargo c ON e.id_cargo = c.id_cargo JOIN horario h ON e.id_horario = h.id_horario");
        while (rs.next()) {
            System.out.print(rs.getString("cedula") + " ");
            System.out.print(rs.getString("nombres") + " ");
            System.out.print(rs.getString("cargo") + " ");
            System.out.print(rs.getString("horaInicio") + " ");
            System.out.print(rs.getString("horaFin") + " ");
            System.out.print(rs.getDouble("sueldo") + " ");
            System.out.println("");
        }
    }

    public ResultSet consultarIDs() throws SQLException {
        return bd.consultaBD("SELECT id_empleado FROM empleado");
    }

}
