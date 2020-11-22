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
    public static long size_friendship;
    
    public Rutas(){}
    
    public Rutas(String correo){
        this.size_friendship = this.fncObtenerTamahnoStorages( Rutas.storage_friendship +  correo + Rutas.extesion_storage );
    }
    
    public long fncObtenerTamahnoStorages(String file){
        Path path = Paths.get(file);
        long bytes =0;
        try{
             bytes = Files.size(path.toAbsolutePath());
        }catch(Exception e){}
        return bytes;
    }
        
    public static final String db_profile = "database/profile/";
    public static final String storage_friendship = "database/friendship/";
    public static final String db_img = "database/foto_perfil/";
    public static final String default_img = "user_default.png";
    public static final String db_chat = "database/chat/";
    public static final String extesion_storage = ".txt";
}
