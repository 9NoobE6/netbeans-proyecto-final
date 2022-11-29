/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author ruben
 */
public class UsuarioDAO implements Dao<Usuario>{

    private static Connection getConnection() {
        return (Connection) ConnectionMySQL.getInstance();
    }
    
    private String sSQL = "";
    public Integer totalregistros;
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean create(Usuario obj) {
        sSQL = "insert into usuario (id_persona,usuario,contraseña)"
                + "values ((select id_persona from persona order by id_persona desc limit 1),?,?)";
        
        try {
            Connection conn = (Connection) getConnection();
            PreparedStatement pst2= conn.prepareCall(sSQL);
            
            pst2.setString(1, obj.getUsuario());
            pst2.setString(2, obj.getContraseña());
            
            int n2 = pst2.executeUpdate();
            
            return n2 != 0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    @Override
    public boolean update(Usuario obj) {
        sSQL = "update usuario set usuario=?,contraseña=?"
                + " where id_persona=?";
        
        try{
            Connection conn = (Connection) getConnection();
            PreparedStatement pst2= conn.prepareStatement(sSQL);
            
            pst2.setString(1, obj.getUsuario());
            pst2.setString(2, obj.getContraseña());
            pst2.setInt(3, obj.getIdpersona());
            
            
            int n2 = pst2.executeUpdate();

            return n2 != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
}
