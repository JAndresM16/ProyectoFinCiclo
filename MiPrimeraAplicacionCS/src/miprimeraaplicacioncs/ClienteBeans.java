package miprimeraaplicacioncs;

import java.sql.*;

public class ClienteBeans {

    private int Id_Cliente;
    private String Cedula_Ruc;
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    private String Telefono;
    accesobd bd;

    public ClienteBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles"); /*1*/
        bd.conectarBD();                                       /*2*/
        /* 
        1/ 5TA
        2/ 3TA
        T= 5TA+3TA =8TA
    */
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;  /*1*/
         /* 
        1/ TA
        T= TA
    */
    }

    public void setCedula_Ruc(String Cedula_Ruc) {
        this.Cedula_Ruc = Cedula_Ruc;  /*1*/
         /* 
        1/ TA
        T= TA
    */
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;  /*1*/
         /* 
        1/ TA
        T= TA
    */
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos; /*1*/
        /* 
        1/ TA
        T= TA
    */
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion; /*1*/
        /* 
        1/ TA
        T= TA
    */
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono; /*1*/
        /* 
        1/ TA
        T= TA
    */
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public String getCedula_Ruc() {
        return Cedula_Ruc;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public int Incremento_CLiente() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_cliente) as num FROM cliente;"); /*3*/
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

    public void Insertar_Cliente() throws SQLException {
        String cadena = "insert into cliente values('" + Incremento_CLiente() + "','" + getCedula_Ruc()
                + "','" + getNombres() + "','" + getApellidos() + "','" + getDireccion() + "','" + getTelefono() + "')"; /*1*/
        bd.ActualizarBD(cadena);                                                                                         /*2*/
         /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */
    }

    public void Actualizar_Cliente() throws SQLException {
        String cadena = "update cliente set cedula='" + getCedula_Ruc() + "', nombres= '" + getNombres()
                + "', apellidos= '" + getApellidos() + "', direccion= '" + getDireccion() + "', telefono= '" + getTelefono()
                + "' where id_cliente= '" + getId_Cliente() + "'";     /*1*/
        bd.ActualizarBD(cadena);                                       /*2*/
         /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */
    }

    public void Eliminar_Cliente() throws SQLException {
        String cadena = "delete from cliente where id_cliente='" + getId_Cliente() + "'"; /*1*/
        bd.ActualizarBD(cadena);                                                          /*2*/
        /* 
        1/ TA
        2/ 2TA
        T= TA+2TA =3TA
    */
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Cliente() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from Cliente"); /*1*/
        while (rs.next()) {                          /*2*/
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(4) + " ");
            System.out.print(rs.getString(5) + " ");
            System.out.print(rs.getString(6) + " ");
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

    public ResultSet obtenerClientes() throws SQLException {
        String sql = "SELECT id_cliente FROM cliente";
        return bd.consultaBD(sql);
    }

    public ResultSet obtenerCliente(int idCliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id_cliente = " + idCliente;
        return bd.consultaBD(sql);
    }

}
