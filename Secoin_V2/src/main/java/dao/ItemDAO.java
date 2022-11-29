/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Item;

/**
 *
 * @author ruben
 */
public class ItemDAO implements Dao<Item>{

    private static Connection getConnection() {
        return (Connection) ConnectionMySQL.getInstance();
    }
    
    private String sSQL = "";
    public Integer totalregistros;
    
    @Override
    public boolean create(Item obj) {
        sSQL = "insert into item (id_articulo,cantidad,subtotal)"
                + "values (?,?,?)";
        
        try {
            //Connection conn = (Connection) getConnection();
            PreparedStatement pst= ItemDAO.connect.prepareCall(sSQL);
            
            pst.setInt(1, obj.getArticulo().getId_articulo());
            pst.setInt(2, obj.getCantidad());
            pst.setDouble(3, obj.getSubtotal());
            
            
            int n2 = pst.executeUpdate();

            return n2 != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }

    @Override
    public boolean update(Item obj) {
        sSQL = "update item set id_articulo=?, cantidad=?, subtotal=?"
                + " where id_item=?";
        
        try{
            Connection conn = (Connection) getConnection();
            PreparedStatement pst= conn.prepareStatement(sSQL);
            
            pst.setInt(1, obj.getArticulo().getId_articulo());
            pst.setInt(2, obj.getCantidad());
            pst.setDouble(3, obj.getSubtotal());
            
            pst.setDouble(4, obj.getId_item());
            
            int n2 = pst.executeUpdate();

            return n2 != 0;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
