package clases;

import java.io.File;
import javax.swing.JOptionPane;
import ventana_people.PanelTarjeta;
import ventana_profile.Profile;

public class Amistad {
    private Session session_activa = null;
    private Session perfil = null;

    public boolean ventana_People = false;
    public boolean ventana_Profile = false;
    private String perfil_seleccionado;
    private String yoker;
    
    public Amistad(Session session_activa) {
        this.session_activa = session_activa;
    }
    
    public void fncAmistadEnviarSolicitudTo(Session perfil){
        if( Storage.fncStorageEncontrarUnaLinea( Rutas.path_profiles, perfil.getStrEmail() ) ){
            
            // * Establecer perfil
            this.perfil = perfil;
            System.out.println("Enviado solicitud a ... " + this.perfil.getStrEmail());
            
            //* Enviado mensaje...
            this.fncAmistadEnviadoSolicitudTo();
            
        }
    }
    
    private void fncAmistadEnviadoSolicitudTo(){
        
        // Verificar si es perfil es amigo
        this.perfil_seleccionado = perfil.getStrEmail();
        this.yoker = session_activa.getStrEmail();
        
        
        if( Storage.fncStorageBuscarUnaLinea(session_activa.stgFriends, perfil_seleccionado) == false ){
            // Si no somos amigos nos ponemos un *
            perfil_seleccionado += "*"; // Si perfil selecciona no es amigo mio se pone un *
            yoker += "*";
        }
        
        // Buscar el chat
        boolean db_chats = Storage.fncStorageEncontrarUnaLinea(session_activa.stgChats, perfil_seleccionado);
        boolean db_friends = Storage.fncStorageEncontrarUnaLinea(session_activa.stgFriends, perfil_seleccionado);
    
        if( db_chats == false && db_friends == false ){
            this.fncCrearUnaSolicitudDeAmistad();            
        }
        
        
        
    }

    private void fncCrearUnaSolicitudDeAmistad() {
        
        // Crear un nuevo mensaje
        Mensaje solicitud = new Mensaje(this.session_activa, "Hola quieres ser mi amigo?");
        solicitud.fncMensajeEnviarMensajeTo(this.perfil);

        // Acoplar que session_a eviado una solicitud de amistad
        Storage.fncStorageAcoplarUnaLinea(this.session_activa.stgFriends, perfil_seleccionado+Storage.identificador_amigo3);

        // Reemplazar
        Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends, yoker, yoker+Storage.identificador_amigo2);

        JOptionPane.showMessageDialog(null, "Solicitud de amistad enviado.");
        
    }
    
}
