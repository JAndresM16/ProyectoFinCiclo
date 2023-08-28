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
        bd = new accesobd("localhost", "root", "", "hoteles");
        bd.conectarBD();
    }

    public int getId_Factura() {
        return Id_Factura;
    }

    public void setId_Factura(int Id_Factura) {
        this.Id_Factura = Id_Factura;
    }

    public int getId_Registro() {
        return Id_Registro;
    }

    public void setId_Registro(int Id_Registro) {
        this.Id_Registro = Id_Registro;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int Incremento_Factura() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_factura) as num FROM factura;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Factura() throws SQLException {
        String cadena = "insert into factura values('" + Incremento_Factura() + "','" + getId_Registro()
                + "','" + getDescuento() + "','" + getIva() + "','" + getTotal() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Factura() throws SQLException {
        String cadena = "update factura set id_registro='" + getId_Registro() + "', descuento= '" + getDescuento()
                + "', iva= '" + getIva() + "', total= '" + getTotal()
                + "' where id_factura= '" + getId_Factura() + "'";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Factura() throws SQLException {
        String cadena = "delete from factura where id_factura='" + getId_Factura() + "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Factura() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from factura");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getInt(2) + " ");
            System.out.print(rs.getDouble(3) + " ");
            System.out.print(rs.getDouble(4) + " ");
            System.out.print(rs.getDouble(5) + " ");
            System.out.println("");
        }
    }

}
