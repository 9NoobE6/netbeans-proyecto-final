package clases;

import java.io.File;
import javax.swing.JOptionPane;
import ventana_people.PanelTarjeta;
import ventana_people.People;
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
        this.perfil_seleccionado = this.perfil.getStrEmail();
        this.yoker = session_activa.getStrEmail();
        
        
        if( !Storage.fncStorageBuscarUnaLinea(session_activa.stgFriends, this.perfil.getStrEmail()+"*"+Storage.identificador_amigo1) ){
            // Si no somos amigos nos ponemos un *
            perfil_seleccionado += "*"; // Si perfil selecciona no es amigo mio se pone un *
            yoker += "*";
        }
        
        // Buscar el chat
        boolean db_chats = Storage.fncStorageBuscarUnaLinea(session_activa.stgChats, perfil_seleccionado);
        boolean db_friends = Storage.fncStorageBuscarUnaLinea(session_activa.stgFriends, perfil_seleccionado+Storage.identificador_amigo1);
        
        // * Verificar estado de amistad para perfil
        String amistad = Storage.fncStorageVerificarAmistad(this.session_activa.stgFriends, this.perfil.getStrEmail());
        
        System.out.println("Perfil = " + this.perfil_seleccionado);
        System.out.println("Yoker = " + this.yoker);
        System.out.println("Ver amistad = " + amistad);
        System.out.println("Ver db_chats = " + db_chats);
        System.out.println("Ver db_friends = " + db_friends);
        
        if(db_chats == true && db_friends == false && amistad.equals("Enviado")){
            
            this.fncSolicituDeAmistadEnviado();
            
        }else
        if( db_chats == false && db_friends == false && amistad.equals("None") ){
            this.fncCrearUnaSolicitudDeAmistad();            
        }
        
        
        
    }

    private void fncCrearUnaSolicitudDeAmistad() {
        
        // Crear un nuevo mensaje
        Mensaje solicitud = new Mensaje(this.session_activa, "Hola quieres ser mi amigo?");
        solicitud.setMostrar_msg(false);
        solicitud.fncMensajeEnviarMensajeTo(this.perfil);

        // Acoplar que session_activa ha enviado una solicitud de amistad
        Storage.fncStorageAcoplarUnaLinea(this.session_activa.stgFriends, perfil_seleccionado+Storage.identificador_amigo3);
        
        // Acoplar en chat que session_activa ha iniciado una conversacion con perfil
        Storage.fncStorageAcoplarUnaLinea(this.session_activa.stgChats, perfil_seleccionado);

        // Reemplazar
        Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends, yoker, yoker+Storage.identificador_amigo2);
        
        // Mensaje de operacion
        JOptionPane.showMessageDialog(null, "Solicitud de amistad enviado.");
        
        // * Fronted
        if( this.ventana_People ) PanelTarjeta.btnAgregarAmigo.setText("Solicitud enviado");
        
    }

    private void fncSolicituDeAmistadEnviado() {
        
        int respuesta = JOptionPane.showConfirmDialog(null, "Haz enviado una solicitud de amistad."
                + "\nDeseas cancelar la solicitud de amistad?", "Confirmar ..." , JOptionPane.YES_NO_OPTION);
        
        if( respuesta == JOptionPane.YES_OPTION){
            
            // Eliminar el chat creado para la solicitud
            String amistad = Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), this.perfil.getStrEmail());
            new File(amistad).delete();
            
            // Eliminar de mi lista de amigos y chats a perfil_seleccionado
            Storage.fncStorageEliminarUnaLinea(new File(this.session_activa.stgChats), this.perfil_seleccionado);
            Storage.fncStorageEliminarUnaLinea(new File(this.session_activa.stgFriends), this.perfil_seleccionado + Storage.identificador_amigo3);

            // Eliminar la notificacion a perfil
            Storage.fncStorageEliminarUnaLinea(new File(this.perfil.stgFriends), this.yoker + Storage.identificador_amigo2);
            
            // Mensaje de operacion
            JOptionPane.showMessageDialog(null, "Haz cancelado la solicitud de amistad." );
            
            // * Fronted 
            if( this.ventana_People ) PanelTarjeta.btnAgregarAmigo.setText("Amigo+1");
        
        }else{
            JOptionPane.showMessageDialog(null, "Espera que el usuario acepte tú solicitud de amistad.");
        }
        
    }
    
}
