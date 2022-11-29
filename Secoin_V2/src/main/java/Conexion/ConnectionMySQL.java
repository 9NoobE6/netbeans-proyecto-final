/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ruben
 */
public class ConnectionMySQL {

    private static final String db="secoin";
    private static final String url="jdbc:mysql://127.0.0.1/" +db;
    private static final String user="root";
    private static final String pass="";
    
    private static Connection connect;
    
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, e);
                e.printStackTrace();
            }
        }        
        return connect;    
    }
}
