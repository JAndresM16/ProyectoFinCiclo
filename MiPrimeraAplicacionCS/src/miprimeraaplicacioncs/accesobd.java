package miprimeraaplicacioncs;

import java.sql.*;

public class accesobd {

    private final String host;
    private final String user;
    private final String passwd;
    private final String bd;

    Connection conexion;

    public accesobd(String host, String user, String passwd, String bd) {
        this.host = host;
        this.user = user;
        this.passwd = passwd;
        this.bd = bd;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getBd() {
        return bd;
    }

    public void conectarBD() throws Exception {
        try {
            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            String cadena = "jdbc:mysql://" + getHost() + "/" + getBd();
            conexion = DriverManager.getConnection(cadena, getUser(), getPasswd());
        } catch (SQLException e) {
            System.out.println("Error a la conexion a la Base de Datos" + e.toString());
        }
    }

    public void ActualizarBD(String sql) throws SQLException {
        try {
            Statement stm = conexion.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Transaccion Exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la Transaccion " + e.toString());
        }

    }

    public ResultSet consultaBD(String sql) throws SQLException {
        ResultSet cursor;
        Statement stm = conexion.createStatement();
        cursor = stm.executeQuery(sql);
        return cursor;
    }

    public void cerrarBD() throws SQLException {
        conexion.close();
    }
}
