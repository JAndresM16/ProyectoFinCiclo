package miprimeraaplicacioncs;

import java.sql.*;
//
public class accesobd {

    private final String host;
    private final String user;
    private final String passwd;
    private final String bd;

    Connection conexion;

    public accesobd(String host, String user, String passwd, String bd) {       
        this.host = host;                                                 /*1*/
        this.user = user;                                                 /*2*/
        this.passwd = passwd;                                             /*3*/
        this.bd = bd;                                                     /*4*/
    /* 
        1/ TA
        2/ TA
        3/ TA
        4/ TA

        T= TA+TA+TA+TA =4TA
    */
    
    
    }

    public String getHost() {
        return host;
    }
//
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
            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();             /*1*/
            String cadena = "jdbc:mysql://" + getHost() + "/" + getBd();                               /*2*/
            conexion = DriverManager.getConnection(cadena, getUser(), getPasswd());                    /*3*/
        } catch (SQLException e) {
            System.out.println("Error a la conexion a la Base de Datos" + e.toString());               
        }
    
    /* 
        1/ TA
        2/ TA
        3/ TA
        T= TA+TA+TA =3TA
    */
    
    }

    public void ActualizarBD(String sql) throws SQLException {
        try {
            Statement stm = conexion.createStatement();                                         /*1*/
            stm.executeUpdate(sql);                                                             /*2*/
            System.out.println("Transaccion Exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la Transaccion " + e.toString());
        }
    /* 
        1/ TA
        2/ TA
        T= TA+TA =2TA
    */
    }

    public ResultSet consultaBD(String sql) throws SQLException {
        ResultSet cursor ;                                                                    
        Statement stm = conexion.createStatement();                                            /*2*/
        cursor = stm.executeQuery(sql);                                                        /*3*/
        return cursor;
        
            /* 
        1/ TA
        2/ TA
        T= TA+TA+ =2TA
    */
    
    }

    public void cerrarBD() throws SQLException {
        conexion.close();
    }
}
