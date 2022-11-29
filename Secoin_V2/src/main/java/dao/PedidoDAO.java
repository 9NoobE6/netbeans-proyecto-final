/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.ConnectionMySQL;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;

/**
 *
 * @author ruben
 */
public class PedidoDAO implements Dao<Pedido>{
    
    private static Connection getConnection() {
        return (Connection) ConnectionMySQL.getInstance();
    }
    
    private static String sSQL = "";
    public static Integer totalregistros;
    
    public static DefaultTableModel getTable(String idusuario) {
        DefaultTableModel modelo;
       
        String [] titulos = {"ID","Id_usuario","Nom. Completo","Articulo","Cantidad","Subtotal"};

        String [] registro =new String [6];

        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);

        sSQL="SELECT p.idpedido, u.id_usuario, pr.nombre_completo, a.nombre, i.cantidad, i.subtotal "
                + "FROM pedido p INNER JOIN item i ON i.id_item = p.id_item "
                + "INNER JOIN articulo a on i.id_articulo = a.id_articulo "
                + "INNER JOIN usuario u ON p.id_usuario = u.id_usuario "
                + "INNER JOIN persona pr on pr.id_persona = u.id_persona "
                + "WHERE u.id_usuario = "+ idusuario +" ORDER BY p.idpedido DESC;";
        

        try {
            Connection conn = (Connection) getConnection();
            PreparedStatement st= (PreparedStatement) conn.prepareCall(sSQL);
            ResultSet rs=st.executeQuery();

            while(rs.next()){
                registro [0]=rs.getString("idpedido");
                registro [1]=rs.getString("id_usuario");
                registro [2]=rs.getString("nombre_completo");
                registro [3]=rs.getString("nombre");
                registro [4]=rs.getString("cantidad");
                registro [5]=rs.getString("subtotal");

                totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
        //return null;
    }
    
    public static void search(String buscar) {
        try {
            DefaultTableModel modelo1;
            modelo1 = getTable(buscar);

            //frmSistemClient.tablalistpedido.setModel(modelo1);
            //Buscar_Item.ocultar_columnas();

        } catch (Exception e) {
            Component rootPane = null;
        }
    }

    
    //PA ABAJO SIRVE
    
    @Override
    public boolean create(Pedido obj) {
         sSQL = "insert into pedido (id_usuario,id_item)"
                + "values (?,(select id_item from item order by id_item desc limit 1))";
        
        try {
            Connection conn = (Connection) getConnection();
            PreparedStatement pst2= (PreparedStatement) conn.prepareCall(sSQL);
            
            pst2.setString(1, obj.getUsuario().getIdusuario());
            //pst2.setInt(2, obj.getItem().getId_item());
            
            int n2 = pst2.executeUpdate();
            
            return n2 != 0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    @Override
    public boolean update(Pedido obj) {
        return false;
    }
    
}
