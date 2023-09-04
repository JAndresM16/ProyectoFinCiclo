package miprimeraaplicacioncs;

import java.sql.*;

public class CargoBeans {

    private int Id_Cargo;
    private String Cargo;
    private double Sueldo;
    accesobd bd;

    public CargoBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");                   /*1*/
        bd.conectarBD();                                                         /*2*/
        
    /* 
        1/ 5TA
        2/ 3TA
        T= 5TA+3TA =8TA
    */
    }

    public int getId_Cargo() {
        return Id_Cargo;
    }

    public void setId_Cargo(int Id_Cargo) {                               
        this.Id_Cargo = Id_Cargo;                                          /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;                                              /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;                                              /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public int Incremento_Cargo() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_cargo) as num FROM cargo;");     /*3*/
        if (rs.next()) {                                                   /*4*/
            inc = rs.getInt(1) + 1;                                        /*5*/
        } else {                                                           /*6*/
            inc = 1;                                                       /*7*/
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

    public void Insertar_Cargo() throws SQLException {
        String cadena = "insert into cargo values('" + Incremento_Cargo() + "','" + getCargo() + "','" + getSueldo() + "')";           /*1*/
        bd.ActualizarBD(cadena);                                                                                                       /*2*/
    /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */
    }

    public void Actualizar_Cargo() throws SQLException {
        String cadena = "update cargo set cargo='" + getCargo() + "', sueldo= '" + getSueldo()
                + "' where id_cargo= '" + getId_Cargo() + "'";                   /*1*/
        bd.ActualizarBD(cadena);                                                 /*2*/
        /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */
    
    }

    public void Eliminar_Cargo() throws SQLException {
        String cadena = "delete from cargo where id_cargo='" + getId_Cargo() + "'";                    /*1*/
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

    public void Consultar_Cargo() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from cargo");                              /*1*/
        while (rs.next()) {                                                     /*2*/
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getDouble(3) + " ");
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

}
