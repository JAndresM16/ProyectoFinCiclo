package miprimeraaplicacioncs;

import java.sql.*;

public class HorarioBeans {

    private int Id_Horario;
    private String Hora_Inicio;
    private String Hora_Fin;
    private String Dias;
    accesobd bd;

    public HorarioBeans() throws Exception {
        bd = new accesobd("localhost", "root", "", "hoteles");
        bd.conectarBD();
    }

    public int getId_Horario() {
        return Id_Horario;
    }

    public void setId_Horario(int Id_Horario) {
        this.Id_Horario = Id_Horario;
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public String getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(String Hora_Fin) {
        this.Hora_Fin = Hora_Fin;
    }

    public String getDias() {
        return Dias;
    }

    public void setDias(String Dias) {
        this.Dias = Dias;
    }

    public int Incremento_Horario() throws SQLException {
        int inc;
        ResultSet rs;
        rs = bd.consultaBD("SELECT max(id_horario) as num FROM horario;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Horario() throws SQLException {
        String cadena = "insert into horario values('" + Incremento_Horario() + "','" + getHora_Inicio()
                + "','" + getHora_Fin() + "','" + getDias() + "')";
        bd.ActualizarBD(cadena);

    }

    public void Actualizar_Horario() throws SQLException {
        String cadena = "update horario set horaInicio='" + getHora_Inicio() + "', horaFin= '" + getHora_Fin()
                + "', dias= '" + getDias() + "' where id_horario= '" + getId_Horario() + "'";
        bd.ActualizarBD(cadena);
    }

    public void Eliminar_Horario() throws SQLException {
        String cadena = "delete from horario where id_horario='" + getId_Horario() + "'";
        bd.ActualizarBD(cadena);
    }

    public ResultSet consultaTabla(String sql) throws SQLException {
        return bd.consultaBD(sql);
    }

    public void Consultar_Horario() throws SQLException {
        ResultSet rs;
        rs = bd.consultaBD("select * from horario");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.println("");
        }
    }
}
