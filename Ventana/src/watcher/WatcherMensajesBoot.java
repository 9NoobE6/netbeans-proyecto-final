/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watcher;

import clases.Mensaje;
import clases.Observador;
import clases.Session;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ventana_amigos.Amigos;

/**
 *
 * @author max98
 */
public class WatcherMensajesBoot extends Observador{
    private String mensaje_enviado="";
    private String mensaje_responder="";
    private Session perfil;
    private Session session_activa;
        
    public WatcherMensajesBoot(File path) {
        super(path);
    }

    public WatcherMensajesBoot(String path_conversacion, Session perfil) {
        super(new File(path_conversacion));
        this.perfil = perfil;
    }
    
    public void Inicializar(){
        
        if(this.fncVerificarCambiosEnElArchivoPath()){
            
            try {
                
                // * Cerrar el almacenamiento de .notify 
                File archivo = new File(this.perfil.stgChatTmp);
                BufferedReader conversacion = new BufferedReader(new FileReader(archivo));
                String linea;
                
                while ((linea = conversacion.readLine()) != null) {
                    
                    linea = linea.trim();
                    if(linea.contains("@MsgDefault")){
                        
                        this.mensaje_responder = conversacion.readLine();
                        
                    }else
                    if( !linea.isEmpty() && !this.mensaje_enviado.trim().isEmpty() && linea.contains("@") ){
                        
                        if( this.fncSeleccionarMensajeDeRespuesta(linea, this.mensaje_enviado.trim()) > 50 ){
                            this.mensaje_responder = conversacion.readLine();
                            
                            break;
                        }
                        
                        
                        
                    }
                    
                }
                
                if( !this.mensaje_responder.isEmpty() && !this.mensaje_enviado.trim().isEmpty() ){
                    
                    Mensaje responder = new Mensaje(this.perfil, this.mensaje_responder);
                    responder.setMostrar_msg(false);
                    responder.fncMensajeEnviarMensajeTo(this.session_activa);
                    
                }
                
                // * Cerrar el almacenamiento de .notify
                conversacion.close();
                
            
            } catch (IOException e) {}
            
            this.mensaje_enviado="";
            this.mensaje_responder="";
            Amigos.mensajes_boots_activado = false;
        }

    }
    
    private int fncSeleccionarMensajeDeRespuesta(String palabras_claves, String mensaje_enviado ){
        
        String[] claves = palabras_claves.trim().replace(" ", "@").split("@");
        String[] query = mensaje_enviado.trim().replace(" ", "@").split("@");
        Pattern patron = Pattern.compile("[ 0-9A-Za-zñÑáéíóúÁÉÍÓÚ¡!¿?@#$%()=+-€/.,]{1,50}");
        int conicidencias = 0;
        
        for(int qitem=0; qitem < query.length; qitem++){
            
            for(int citem=0; citem < claves.length; citem++){
           
                Matcher comquery = patron.matcher(query[qitem].toUpperCase());
                Matcher comclaves = patron.matcher(claves[citem].toUpperCase());
                
                if( query[qitem].toUpperCase().equals(claves[citem].toUpperCase()) && comquery.matches() && comclaves.matches() )
                    conicidencias++;
                /*
                else if( query[qitem].toUpperCase().contains(claves[citem].toUpperCase()) )
                    conicidencias++;
                */              
            }
            
        }
        
        return (int) ((conicidencias*100) / query.length);
    }
    
    public void setMensaje(Session session_activa, String mensaje_enviado ){
        this.session_activa = session_activa;
        this.mensaje_enviado = mensaje_enviado;
    }
    
    
        
}
