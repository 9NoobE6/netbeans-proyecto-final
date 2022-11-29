/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.ConnectionMySQL;
import java.sql.Connection;

/**
 *
 * @author ruben
 * @param <T>
 */
public interface Dao<T> {
    public Connection connect = (Connection) ConnectionMySQL.getInstance();
    
    public boolean create (T obj);
    public boolean update (T obj);
}
