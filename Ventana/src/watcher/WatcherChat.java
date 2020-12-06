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

/**
 *
 * @author max98
 */
public class WatcherChat extends Observador{
    private JList lista_de_mensajes;
    DefaultListModel mensajes = new DefaultListModel();
    private String path_conversacion;
    private String lista_vacio;
    private Session session_activa;
    private Session perfil;

        
    public WatcherChat(File path) {
        super(path);
    }

    public WatcherChat(Session sessio_activa, JList lista_de_mensajes) {
        super(new File(sessio_activa.stgChatTmp));
        this.session_activa = sessio_activa;
        this.lista_de_mensajes = lista_de_mensajes;
    }
    
    public void setChatearTo(Session perfil){
        
        // Establecer el perfil
        this.perfil = perfil;
        
        String chat_session_activa = Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), this.perfil.getStrEmail());
        String chat_perfil = Storage.fncStorageCrearRutaChats(this.perfil.getStrEmail(), this.session_activa.getStrEmail());

        // * Verificar que la conversacion exista
        if( new File(chat_session_activa).exists() && new File(chat_perfil).exists() ){
            
            // * Establecer el path de la conversacion
            this.path_conversacion = new File(chat_session_activa).getAbsolutePath();
            this.setPath( new File(this.path_conversacion) );
            
        }
        
    }
    
    public void Inicializar(){
                
        if(this.fncVerificarCambiosEnElArchivoPath()){
            
            try {
                
                // * Reiniciar todas las notificaciones
                this.lista_de_mensajes.removeAll();
                this.mensajes.clear();
                
                // * Cerrar el almacenamiento de .notify 
                File archivo = new File(this.path_conversacion);
                BufferedReader chat_activo = new BufferedReader(new FileReader(archivo));
                String linea;

                while ((linea = chat_activo.readLine()) != null) {
                    
                    if( linea.contains(this.session_activa.getStrEmail()) ){
                        this.mensajes.addElement(" # " + linea);
                        linea = chat_activo.readLine();
                        this.mensajes.addElement(linea);
                    }else if( linea.contains( this.perfil.getStrEmail() ) ){ 
                        String a = "%-" + Math.abs(linea.length() - 90) + "s";
                        this.mensajes.addElement( linea.format(a, "").replace(' ',' ') + linea + " * ");
                        linea = chat_activo.readLine();
                        this.mensajes.addElement( linea + linea.format(a, "").replace(' ',' '));
                    }else{
                        this.mensajes.addElement(linea);
                    }
                    
                }
                
                // * Cerrar el almacenamiento de .notify
                chat_activo.close();
                
                // * Mostrar todas las notificaciones...
                this.lista_de_mensajes.setModel(mensajes);
            
            } catch (IOException e) {}

        }
        
        // * Verificar no existe notificaciones para mostrar un mensaje
        if(this.mensajes.isEmpty()){
            this.mensajes.addElement( this.lista_vacio );
            this.lista_de_mensajes.setModel(mensajes);
        }
         
    }

    public void setLista_vacio(String lista_vacio) {
        this.lista_vacio = lista_vacio;
    }

    public String getPath_conversacion() {
        return path_conversacion;
    }

    public void setPath_conversacion(String path_conversacion) {
        this.path_conversacion = path_conversacion;
    }
        
}
