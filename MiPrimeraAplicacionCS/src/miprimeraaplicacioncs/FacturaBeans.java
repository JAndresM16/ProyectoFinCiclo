package miprimeraaplicacioncs;

import java.sql.*;

public class FacturaBeans {

    private int Id_Factura;
    private int Id_Registro;
    private double descuento;
    private double iva;
    private double total;
    accesobd bd;

    public FacturaBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles"); /*1*/
        bd.conectarBD();                                       /*2*/

        /* 
        1/ 5TA
        2/ 3TA
        T= 5TA+3TA =8TA
    */
    }

    public int getId_Factura() {
        return Id_Factura;
    }

    public void setId_Factura(int Id_Factura) {
        this.Id_Factura = Id_Factura;                         /*1*/

        /* 
        1/ TA
        T= TA
    */
    }

    public int getId_Registro() {
        return Id_Registro;
    }

    public void setId_Registro(int Id_Registro) {
        this.Id_Registro = Id_Registro;                      /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;                         /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;                                    /*1*/
       
    /* 
        1/ TA
        T= TA
    */
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;                               /*1*/
       
    /* 
        1/ TA
        T= TA
    */ 
    }

    public int Incremento_Factura() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_factura) as num FROM factura;"); /*3*/
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

    public void Insertar_Factura() throws SQLException {
        String cadena = "insert into factura values('" + Incremento_Factura() + "','" + getId_Registro()
                + "','" + getDescuento() + "','" + getIva() + "','" + getTotal() + "')"; /*1*/
        bd.ActualizarBD(cadena);                                                         /*2*/
        /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */

    }

    public void Actualizar_Factura() throws SQLException {
        String cadena = "update factura set id_registro='" + getId_Registro() + "', descuento= '" + getDescuento()
                + "', iva= '" + getIva() + "', total= '" + getTotal()
                + "' where id_factura= '" + getId_Factura() + "'";                       /*1*/
        bd.ActualizarBD(cadena);                                                         /*2*/
        /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =4TA
    */
    }

    public void Eliminar_Factura() throws SQLException {
        String cadena = "delete from factura where id_factura='" + getId_Factura() + "'"; /*1*/
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

    public void Consultar_Factura() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from factura");                  /*1*/
        while (rs.next()) {                                           /*2*/
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getInt(2) + " ");
            System.out.print(rs.getDouble(3) + " ");
            System.out.print(rs.getDouble(4) + " ");
            System.out.print(rs.getDouble(5) + " ");
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
