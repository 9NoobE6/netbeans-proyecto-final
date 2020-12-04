/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author victo
 */
public class Rutas {        
    
    // * Archivos importantes *WARNING*
    public static final String default_img = "user_default.png";
    public static final String path_profiles = "storage_profiles/database.profiles";
    public static final String path_tmp_profiles = "storage_profiles/_db.profiles";
    
    // * Rutas importantes *WARNING*  
    public static final String storage_profiles = "storage_profiles/";
    public static final String extesion_chatmp = "tmp_";
    public static final String storage_profile = "/profile/";
    public static final String storage_chats = "/chats/";
    
    // * Extensiones importantes *WARNING*
    public static final String extesion_friends = ".friends";
    public static final String extesion_chats = ".chats";
    public static final String extesion_tome = ".tome";
    public static final String extesion_notify = ".notify";
    public static final String extesion_svg = ".svg";
    public static final String extesion_data = ".data";
    
    
    // Este ruta es necesario usarlo con getClass().getResource();
    public static final String path_user_default = "img/user_default.png";
    
    // * Rutas para el fondo de pantalla de cada ventana
    public static final String path_background_jframe_amigos = "img/b4.jpg";
    public static final String path_background_jframe_people = "img/b4.jpg";
    public static final String path_background_jframe_profile = "img/b3.jpg";
    public static final String path_background_jframe_singup = "img/b3.jpg";
    
    // Rutas para la ventana Principal
    public static final String path_background_jframe_principal = "img/b2.jpg";
    public static final String path_background_panel_registro = "img/b2.jpg";
    public static final String path_background_panel_singup = "img/b2.jpg";
    public static final String path_logo = "img/logo1_1.png";
    
    public static final String path_background_panel = "img/b1.jpg";
    public static final String path_background_panel_paneltarjeta = "img/b2.jpg";
    
}
