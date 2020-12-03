package clases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import paneles.PanelTarjeta;

public class Mensaje {
    private Session perfil= null;
    private String mensaje = null;
    private Session session_activa = null;
    private String perfil_seleccionado;
    private String yoker;
    private boolean mostrar_msg = true;

    public boolean isMostrar_msg() {
        return mostrar_msg;
    }

    public void setMostrar_msg(boolean mostrar_msg) {
        this.mostrar_msg = mostrar_msg;
    }
        
    public Mensaje(Session session_activa, String mensaje) {  
        
        if( Storage.fncStorageEncontrarUnaLinea( Rutas.path_profiles, session_activa.getStrEmail() ) ){
            
            // * Establecer session_activa
            this.session_activa = session_activa;
            this.mensaje = Storage.fncStorageCrearMensaje(session_activa, mensaje);
            System.out.println("Generando mensaje de ..." + this.session_activa.getStrEmail());
            
        }
        
    }
    
    public void fncMensajeEnviarMensajeTo(Session perfil){
        if( Storage.fncStorageEncontrarUnaLinea( Rutas.path_profiles, perfil.getStrEmail() ) ){
            
            // * Establecer perfil
            this.perfil = perfil;
            System.out.println("Enviado mensaje a ... " + this.perfil.getStrEmail());
            
            //* Enviado mensaje...
            this.fncMensajeEnviadoMensajeTo();
            
        }
    }
    
    private void fncMensajeEnviadoMensajeTo() {
        
        // Verificar si es perfil es amigo
        this.perfil_seleccionado = perfil.getStrEmail();
        this.yoker = session_activa.getStrEmail();
        
        if( Storage.fncStorageEncontrarUnaCuenta(session_activa.stgFriends, perfil_seleccionado) == false ){
            // Si no somos amigos nos ponemos un *
            perfil_seleccionado += "*"; // Si perfil selecciona no es amigo mio se pone un *
            yoker += "*";
        }
        
        // Buscar el chat
        boolean db_chats = Storage.fncStorageEncontrarUnaLinea(session_activa.stgChats, perfil_seleccionado);
        boolean db_friends = Storage.fncStorageEncontrarUnaLinea(session_activa.stgFriends, perfil_seleccionado);

//        System.out.println(" amigo = "+ perfil_seleccionado);
//        System.out.println(" amigo = "+ yoker);
//        System.out.println(" db_chats = " + db_chats);
//        System.out.println(" db_friends = " + db_friends);

        if(db_friends == true && db_chats == true){
            this.fncConversacionActiva();
            
        }else if( db_friends == true && db_chats == false ){
           this.fncConversacionPendientePerfil();
           
        }else if( db_friends == false && db_chats == true  ){
           this.fncConversacionPendienteSessionActiva();
        
        }else if( db_friends == false && db_chats == false ){
            this.fncCrearConversacion();
        
        }
    }

    private void fncConversacionActiva() {
        
        // Tengo una conversación
        // Seleccionas al chat del perfil en mi session_activa
        // y haces una copia a pefil
        System.out.println("STAGE 1");

        // * Agregar el mensaje en mi cuenta o session_activa
        String chat = Storage.fncStorageCrearRutaChats(perfil.getStrEmail(), session_activa.getStrEmail());
        Storage.fncStorageAcoplarUnaLinea(chat, mensaje);

        // * Copiar el chat de mi cuenta o session a perfil
        String chat_clone = Storage.fncStorageCrearRutaChats(session_activa.getStrEmail(), perfil.getStrEmail());
        Storage.fncStorageCopiarArchivo(new File(chat), chat_clone);

        if( this.mostrar_msg )
            JOptionPane.showMessageDialog(null, "Mensaje+1");
        
    }

    private void fncConversacionPendientePerfil() {
        
        // No tengo una conversación, pero perfil si.
        // Seleccionas al chat del perfil y agregas el mensaje
        // despues notificas....
        System.out.println("STAGE 2");

        // Respodiendo a perfil 
        // Seleccionar la conversion de perfil con sesion_activa
        String chat = Storage.fncStorageCrearRutaChats(perfil.getStrEmail(), session_activa.getStrEmail());
        Storage.fncStorageAcoplarUnaLinea(chat, mensaje);


        // Si session_activa no esta en la lista de amigo de perfil
        if( Storage.fncStorageEncontrarUnaLinea(perfil.stgFriends, yoker) == false ){

            System.out.println("STAGE 2 - AAAA");

            // Constentando el mensaje deperfil
            // Notificar - Registrar session_activa en .friends de perfil
            // es decir, que session_activa se registra en la lista de amigos de perfil...
            Storage.fncStorageAcoplarUnaLinea(perfil.stgFriends, yoker);

            // Notificar - Registrar perfil en .chats de session_activa  
            // es decir, perfil se registra en la lista de conversaciónes de session_activa
            Storage.fncStorageAcoplarUnaLinea(session_activa.stgChats, perfil_seleccionado);

            // Clonar la conversion de perfil a session_activa
            String chat_clone = Storage.fncStorageCrearRutaChats(session_activa.getStrEmail(), perfil.getStrEmail());
            Storage.fncStorageCopiarArchivo(new File(chat), chat_clone);
            
            if( this.mostrar_msg )
                JOptionPane.showMessageDialog(null, "Este usuario te habia enviado un mensaje\n"+
                    "Puedes chatear pueden conservar en en las lista de amigos.");
        }else{

            System.out.println("STAGE 2 - BBBB");
            
            if( this.mostrar_msg )
                JOptionPane.showMessageDialog(null, "Mensaje enviado.");
        }
        
    }

    private void fncConversacionPendienteSessionActiva() {
        
        // Tengo una conversion en session_activa
        // Sin que me responda perfil
        System.out.println("STAGE 4");

        // Verificar que pefil aun conserva la conversion original entre session_activa y perfil
        if( Storage.fncStorageEncontrarUnaLinea(perfil.stgFriends, yoker) == true && 
            Storage.fncStorageEncontrarUnaLinea(perfil.stgChats, yoker) == true
        ){

            System.out.println("STAGE 4 - FFFF");

            // Agrego un nuevo mensaje a la conversion original
            // por que si perfil me tiene como amigo pudo estar enviado mesajes... (Entonces es el más actualizado)
            String chat_original = Storage.fncStorageCrearRutaChats(perfil.getStrEmail(), session_activa.getStrEmail());
            Storage.fncStorageAcoplarUnaLinea(chat_original, mensaje);

            // Registrar a perfil en mi cuenta o session_activa
            Storage.fncStorageActualizarUnaLinea(session_activa.stgFriends, perfil_seleccionado);

            // Regitrar a perfil en mi cuenta o session_activa (Este no es necesario)
            // Storage.fncStorageActualizarUnaLinea(session_activa.stgChats, perfil);

            // Clonar la conversion de perfil a session_activa  (Entonces es el más actualizado)
            String chat_clone = Storage.fncStorageCrearRutaChats(session_activa.getStrEmail(), perfil.getStrEmail());
            Storage.fncStorageCopiarArchivo(new File(chat_original), chat_clone);
            
            if( this.mostrar_msg )
                JOptionPane.showMessageDialog(null, "Tienes una conversación pendiente con "
                    + "\n\t\t\t\t" + perfil.getStrEmail()
                    + "\nPuedes chatear pueden conservar en usuario en las lista de amigos.");
        }else{ 

            // Agrego un nuevo mensaje en la conversación de session_activa
            String chat = Storage.fncStorageCrearRutaChats(session_activa.getStrEmail(), perfil.getStrEmail());
            Storage.fncStorageAcoplarUnaLinea(chat, mensaje);

            // Clonar la conversion de session_activa a perfil 
            String chat_clone = Storage.fncStorageCrearRutaChats(perfil.getStrEmail(), session_activa.getStrEmail());
            Storage.fncStorageCopiarArchivo(new File(chat), chat_clone);

            // * Verificar que los puedan conversar entre ellos ....
            if( Storage.fncStorageEncontrarUnaLinea(perfil.stgFriends, yoker) == false && 
            Storage.fncStorageEncontrarUnaLinea(session_activa.stgFriends, perfil_seleccionado) == false
            ){

              Storage.fncStorageActualizarUnaLinea(perfil.stgFriends, yoker);
              Storage.fncStorageActualizarUnaLinea(session_activa.stgFriends, perfil_seleccionado);
              
              if( this.mostrar_msg )
                JOptionPane.showMessageDialog(null, "Haz recuperado la conversación con "
                      + "\n\t\t\t\t" + perfil.getStrEmail()
                      + "\nPuedes chatear pueden conservar en usuario en las lista de amigos.");

            }else JOptionPane.showMessageDialog(null, "Mensaje enviado.");   
        }  
    }

    private void fncCrearConversacion() {
        
        // Crear una conversación
        String chat = Storage.fncStorageCrearRutaChats(session_activa.getStrEmail(), perfil.getStrEmail());

        try {

            if( new File(chat).createNewFile() ){

                System.out.println("STAGE 5");

                // * Agregar el mensaje
                Storage.fncStorageAcoplarUnaLinea(chat, mensaje);

                // * Notificar - Registra a perfil en el .chats de session_activa
                // es decir session_activa abre una conversación....
                Storage.fncStorageAcoplarUnaLinea(session_activa.stgChats, perfil_seleccionado);

                // * Notificar - Registra a perfil en el .friends de session_activa
                // es decir session_activa se registra en lista de amigos de pefil....
                Storage.fncStorageAcoplarUnaLinea(perfil.stgFriends, yoker);

                // Mensaje de salida
                if( this.mostrar_msg )
                    JOptionPane.showMessageDialog(null, "Mensaje enviado.\nEl usuario no aparece en tu lista de amigos\n"+
                        "Espera su respuesta para conversar.");

            }
        } catch (IOException ex) { Logger.getLogger(PanelTarjeta.class.getName()).log(Level.SEVERE, null, ex); }            
    }
   
 
} // Final de la clase
