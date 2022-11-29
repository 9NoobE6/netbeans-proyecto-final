/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import Conexion.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Persona;

/**
 *
 * @author ruben
 */
public class PersonaDAO implements Dao<Persona>{
    
    private static Connection getConnection() {
        return (Connection) ConnectionMySQL.getInstance();
    }
    
    private String sSQL = "";
    public Integer totalregistros;

    @Override
    public boolean create(Persona obj) {
        sSQL = "insert into persona (nombre_completo,num_telefonico,dni_persona)"
                + "values (?,?,?)";
        try {
            Connection conn = (Connection) getConnection();
            PreparedStatement pst= conn.prepareCall(sSQL);

            pst.setString(1, obj.getNombre_completo());
            pst.setString(2, obj.getNum_telefonico());
            pst.setString(3, obj.getDnipersona());
            
            int n = pst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    @Override
    public boolean update(Persona obj) {
        sSQL = "update persona set nombre_completo=?,num_telefonico=?,dni_persona=? "
                + "where id_persona=?";
        try{
            Connection conn = (Connection) getConnection();
            PreparedStatement pst= conn.prepareStatement(sSQL);
            
            pst.setString(1, obj.getNombre_completo());
            pst.setString(2, obj.getNum_telefonico());
            pst.setString(3, obj.getDnipersona());
            pst.setInt(4, obj.getIdpersona());
            
            int n = pst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
