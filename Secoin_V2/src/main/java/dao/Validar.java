
package dao;

import Conexion.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Validar {
    
    private static Connection getConnection() {
        return (Connection) ConnectionMySQL.getInstance();
    }
    
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel login(String usuario,String contraseña) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre Completo","N.Telefonico","DNI","Usuario","Contraseña"};

        String[] registro = new String[6];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL =  "SELECT u.id_usuario,p.nombre_completo,p.num_telefonico,p.dni_persona,"
                + "u.usuario,u.contraseña "
                + "FROM persona p INNER JOIN usuario u "
                + "ON p.id_persona = u.id_persona "
                + "WHERE u.usuario = '"+usuario
                +"' and u.contraseña = '"+contraseña+"'"; 

        try {
            
            Connection conn = (Connection) getConnection();
            PreparedStatement pst= conn.prepareCall(sSQL);
            ResultSet rs=pst.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_usuario");
                registro[1] = rs.getString("nombre_completo");
                registro[2] = rs.getString("num_telefonico");
                registro[3] = rs.getString("dni_persona");
                registro[4] = rs.getString("usuario");
                registro[5] = rs.getString("contraseña");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
