package miprimeraaplicacioncs;

import java.sql.*;

public class HorarioBeans {

    private int Id_Horario;
    private String Hora_Inicio;
    private String Hora_Fin;
    private String Dias;
    accesobd bd;

    public HorarioBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");                   /*1*/
        bd.conectarBD();                                                         /*2*/
    /* 
        1/ 5TA
        2/ 4TA
        T= 5TA+4TA =9TA
    */
        
    }

    public int getId_Horario() {
        return Id_Horario;
    }

    public void setId_Horario(int Id_Horario) {
        this.Id_Horario = Id_Horario;                                           /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;                                         /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public String getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(String Hora_Fin) {
        this.Hora_Fin = Hora_Fin;                                               /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public String getDias() {
        return Dias;
    }

    public void setDias(String Dias) {
        this.Dias = Dias;                                                       /*1*/
       
        /* 
        1/ TA
        T= TA
    */
    }

    public int Incremento_Horario() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_horario) as num FROM horario;");          /*3*/
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

    public void Insertar_Horario() throws SQLException {
        String cadena = "insert into horario values('" + Incremento_Horario() + "','" + getHora_Inicio()
                + "','" + getHora_Fin() + "','" + getDias() + "')";                                        /*1*/
        bd.ActualizarBD(cadena);                                                                           /*2*/
        /*
        1/ TA
        2/ 3TA
        T= TA+3TA =3TA
    */
    }

    public void Actualizar_Horario() throws SQLException {
        String cadena = "update horario set horaInicio='" + getHora_Inicio() + "', horaFin= '" + getHora_Fin()
                + "', dias= '" + getDias() + "' where id_horario= '" + getId_Horario() + "'";              /*1*/
        bd.ActualizarBD(cadena);                                                                           /*2*/
            /* 
        1/ TA
        2/ 3TA
        T= TA+3TA =3TA
    */
    
    }

    public void Eliminar_Horario() throws SQLException {
        String cadena = "delete from horario where id_horario='" + getId_Horario() + "'";                 /*1*/
        bd.ActualizarBD(cadena);                                                                          /*2*/
            /* 
        1/ TA
        2/ 2TA
        T= TA+2TA =3TA
    */
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Horario() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from horario");                            /*1*/
        while (rs.next()) {                                                     /*2*/
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(3) + " ");
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
