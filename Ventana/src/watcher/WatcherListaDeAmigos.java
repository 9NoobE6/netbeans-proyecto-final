/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watcher;

import clases.Observador;
import clases.Rutas;
import clases.Session;
import clases.Storage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import paneles.PanelTarjeta;
import ventana_people.People;

/**
 *
 * @author max98
 */
public class WatcherListaDeAmigos extends Observador{
    private JList lista_de_amigos;
    DefaultListModel amigos = new DefaultListModel();
    private String path_stgFriends;
    private String lista_vacio;
        
    public WatcherListaDeAmigos(File path) {
        super(path);
    }

    public WatcherListaDeAmigos(String path, JList lista_de_amigos) {
        super(new File(path));
        this.path_stgFriends = new File(path).getAbsolutePath();
        this.lista_de_amigos = lista_de_amigos;
    }
    
    public void Inicializar(){
        
        if(this.fncVerificarCambiosEnElArchivoPath()){
            
            try {
                
                // * Reiniciar todas las notificaciones
                this.lista_de_amigos.removeAll();
                this.amigos.clear();
                
                // * Cerrar el almacenamiento de .notify 
                File archivo = new File(this.path_stgFriends);
                BufferedReader stgFriends = new BufferedReader(new FileReader(archivo));
                String linea;

                while ((linea = stgFriends.readLine()) != null) {
                    
                    if ( !linea.isEmpty() && linea.contains(Storage.extension_rs) ) {
                        // * Obtener el email
                        String email = linea.substring(0, linea.lastIndexOf("@"));
                        email = email + Storage.extension_rs;
                        
                        // * Verificar si existe una cuenta 
                        boolean cuenta_data = new File( new Session(email).stgData ).exists();
                        File cuenta_contenedor = new File( Rutas.storage_profiles + email );
                        
                        if(cuenta_data && cuenta_contenedor.isDirectory() && cuenta_contenedor.exists()){
                            // * Registar amigo...
                            this.amigos.addElement(linea.trim());
                            
                        }
                    }
                    
                }
                
                // * Cerrar el almacenamiento de .notify
                stgFriends.close();
                
                // * Mostrar todas las notificaciones...
                this.lista_de_amigos.setModel(amigos);
            
            } catch (IOException e) {}

        }
        
        // * Verificar no existe notificaciones para mostrar un mensaje
        if(this.amigos.isEmpty()){
            this.amigos.addElement( this.lista_vacio );
            this.lista_de_amigos.setModel(amigos);
        }
         
    }

    public void setLista_vacio(String lista_vacio) {
        this.lista_vacio = lista_vacio;
    }

    public String getPath_stgNotify() {
        return path_stgFriends;
    }

    public void setPath_stgNotify(String path_stgNotify) {
        this.path_stgFriends = path_stgNotify;
    }
        
}
