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
        bd = new accesobd("localhost", "root", "", "hoteles");             /*1*/
        bd.conectarBD();                                                   /*2*/
    
    /* 
        1/ TA
        2/ TA
        T= TA+TA =2TA
    */
    }
   

    public int getId_Registro() {
        return Id_Registro;
    }

    public void setId_Registro(int Id_Registro) {
        this.Id_Registro = Id_Registro;                                    /*1*/
       
        /* 
        1/ TA
        T= TA
    */
        
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {                           
        this.Id_Cliente = Id_Cliente;                                      /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public int getId_Habitacion() {
        return Id_Habitacion;
    }

    public void setId_Habitacion(int Id_Habitacion) {                      
        this.Id_Habitacion = Id_Habitacion;                                /*1*/
       
        /* 
        1/ TA
        T= TA
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

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;                                  /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public String getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(String Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;                                        /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String Metodo) { 
        this.Metodo = Metodo;                                              /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public double getPago() {
        return Pago;
    }

    public void setPago(double Pago) {
        this.Pago = Pago;                                                  /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public int Incremento_Registro() throws SQLException {                             
        int inc ;                                                                      /*1*/
        ResultSet rs;                                                                  /*2*/
        rs = bd.consultaBD("SELECT max(id_registro) as num FROM registros;");          /*3*/      
        if (rs.next()) {                                                               /*4*/
            inc = rs.getInt(1) + 1;                                                    /*5*/
        } else {                                                                       /*6*/
            inc = 1;                                                                   /*7*/
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

    public void Insertar_Registro() throws SQLException {
        String cadena = "insert into registros values('" + Incremento_Registro() + "','" + getId_Cliente()
                + "','" + getId_Habitacion() + "','" + getId_Empleado() + "','" + getFecha_Inicio() + "','"
                + getFecha_Fin() + "','" + getMetodo() + "','" + getPago() + "')";                                /*1*/
        bd.ActualizarBD(cadena);                                                                                  /*2*/
        
         /* 
        1/ 3TA+TC+TO == 3TA+TC == TO+TA
        2/ TA
        TP = TA+3TA+TC+TO = 4TA+TC+TO
        TM = TA+3TA+TC = 4TA+TC
        TE = 4TA+TC+TO - 4TA+TC = TO
    */
        

    }

    public void Actualizar_Registro() throws SQLException {
        String cadena = "update registros set id_cliente='" + getId_Cliente() + "', id_habitacion= '" + getId_Habitacion()
                + "', id_empleado= '" + getId_Empleado() + "', fechaInicio= '" + getFecha_Inicio() + "', fechaFin= '" + getFecha_Fin()
                + "', Metodo= '" + getMetodo() + "', Pago= '" + getPago()
                + "' where id_registro= '" + getId_Registro() + "'";                             /*1*/
        bd.ActualizarBD(cadena);                                                                 /*2*/
    
    /* 
        1/ TA
        2/ TA
        T= TA+TA =2TA
    */
         
    }

    public void Eliminar_Registro() throws SQLException {
        String cadena = "delete from registros where id_registro='" + getId_Registro() + "'";    /*1*/
        bd.ActualizarBD(cadena);                                                                 /*2*/
    
        
    /* 
        1/ TA
        2/ TA
        T= TA+TA =2TA
    */
            
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);                                              /*1*/
       
    /* 
        1/ TA
        T= TA
        
    */
    }

    public void Consultar_Registro() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from registros");                          /*2*/
        while (rs.next()) {                                                     /*3*/
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
        /* 
        1/ TA
        2/ N*TC+TC == TC
        TP= TA+N*TC+TC 
        TM= TA+TC
        TE= TA+N*TC+TC - TA+TC = N*TC
        */
        
    }

}
