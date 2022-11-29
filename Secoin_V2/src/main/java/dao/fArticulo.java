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
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruben
 */
public class fArticulo {
    
    private static java.sql.Connection getConnection() throws SQLException {
        return ConnectionMySQL.getInstance();
    }
    
    private static String sSQL="";
    public static Integer totalregistros;
    
    public static DefaultTableModel getTable(String buscar){
        DefaultTableModel modelo;
       
        String [] titulos = {"ID","Articulo","Precio Venta"};

        String [] registro =new String [3];

        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);

        sSQL="select * from articulo where nombre like '%"+ buscar + "%' order by id_articulo desc";

        try {
            Connection conn = (Connection) getConnection();
            PreparedStatement st= (PreparedStatement) conn.prepareCall(sSQL);
            ResultSet rs=st.executeQuery();

            while(rs.next()){
                registro [0]=rs.getString("id_articulo");
                registro [1]=rs.getString("nombre");
                registro [2]=rs.getString("precio");


                totalregistros=totalregistros+1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    } 
    
    public static void search(String buscar) {
        try {
            DefaultTableModel modelo;
            modelo = getTable(buscar);

            //frmArticulo.tablalistado.setModel(modelo);
            //Buscar_Item.ocultar_columnas();

        } catch (Exception e) {
            Component rootPane = null;
        }
    }
}
