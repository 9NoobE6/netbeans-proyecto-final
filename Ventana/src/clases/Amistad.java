package clases;

import java.io.File;
import javax.swing.JOptionPane;
import paneles.PanelTarjeta;
import ventana_people.People;
import ventana_profile.Profile;

public class Amistad {
    private Session session_activa = null;
    private Session perfil = null;
    private String operacion = "none";
    
    private String perfil_seleccionado;
    private String yoker;
    
    public Amistad(Session session_activa) {
        this.session_activa = session_activa;
    }
    
    public void fncAmistadEnviarSolicitudTo(Session perfil){
        if( Storage.fncStorageEncontrarUnaLinea( Rutas.path_profiles, perfil.getStrEmail() ) ){
            
            // * Establecer perfil
            this.perfil = perfil;
            
            //* Enviado mensaje...
            this.operacion = "none";
            this.fncAmistadEnviadoSolicitudTo();
            
        }
    }
    
    private void fncAmistadEnviadoSolicitudTo(){
        
        // Verificar si es perfil es amigo
        this.perfil_seleccionado = this.perfil.getStrEmail();
        this.yoker = session_activa.getStrEmail();
        
        
        if( !Storage.fncStorageBuscarUnaLinea(session_activa.stgFriends, this.perfil.getStrEmail()+Storage.identificador_amigo1) ){
            // Si no somos amigos nos ponemos un *
            perfil_seleccionado += "*"; // Si perfil selecciona no es amigo mio se pone un *
            yoker += "*";
        }
        
        // Buscar el chat
        boolean db_chats = Storage.fncStorageBuscarUnaLinea(session_activa.stgChats, perfil_seleccionado);
        boolean db_friends = Storage.fncStorageBuscarUnaLinea(session_activa.stgFriends, perfil_seleccionado+Storage.identificador_amigo1);
        
        // * Verificar estado de amistad para perfil
        String amistad_session_activa = Storage.fncStorageVerificarAmistad(this.session_activa.stgFriends, this.perfil.getStrEmail());
        String amistad_perfil = Storage.fncStorageVerificarAmistad(this.perfil.stgFriends, this.session_activa.getStrEmail());
        
        if(db_chats == false && db_friends == false && amistad_session_activa.equals("recibido")){         
            
            if( amistad_perfil.contains("enviado")){
                this.fncSolicitudDeAmistadRecibidoCancelar();
            }else{
                this.fncSolicituDeAmistadRecibido();
            }
            
        }else
        if(db_chats == true && db_friends == false && amistad_session_activa.equals("enviado")){         
            this.fncSolicituDeAmistadEnviado();
            
        }else
        if( db_chats == false && db_friends == false && amistad_session_activa.equals("none") ){
            this.fncCrearUnaSolicitudDeAmistad();            
        }else 
        if(db_chats == true && db_friends == true && amistad_session_activa.equals("amigos")){         
            this.fncSolicituDeAmistadEliminar();
            
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
        Storage.fncStorageActualizarUnaLinea(this.session_activa.stgChats, perfil_seleccionado);

        // Reemplazar
        Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends, yoker, yoker+Storage.identificador_amigo2);
        
        // * Registrar notificaciones
        Storage.fncStorageRegistrarNotificacion(this.session_activa, "Haz enviado una solicitud de amistad para " + this.perfil.getStrEmail() );
        Storage.fncStorageRegistrarNotificacion(this.perfil, "Tienes una solicitud de amistad de " + this.session_activa.getStrEmail() );
        
        // Mensaje de operacion
        JOptionPane.showMessageDialog(null, "Solicitud de amistad enviado.");
                
        // * Fronted
        this.operacion = "enviado";
        
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
            
            // * Registrar notificaciones
            Storage.fncStorageRegistrarNotificacion(this.session_activa, "Haz cancelado una solicitud de amistad para " + this.perfil.getStrEmail() );
            
            // Mensaje de operacion
            JOptionPane.showMessageDialog(null, "Haz cancelado la solicitud de amistad." );
            
            // * Fronted 
            this.operacion = "cancelado";
            
        }else{
            JOptionPane.showMessageDialog(null, "Espera que el usuario acepte tú solicitud de amistad.");
        }
        
    }

    private void fncSolicituDeAmistadRecibido() {
        
        int respuesta = JOptionPane.showConfirmDialog(null, "Este usuario te ha enviado una solicitud de amistad."
                + "\nDeseas aceptar la solicitud de amistad?", "Confirmar ..." , JOptionPane.YES_NO_OPTION);
        
        if( respuesta == JOptionPane.YES_OPTION ){
        
            // Reemplazar el mensaje recibo de session_activa a mensaje de somos amigos
            Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgFriends, 
                    perfil_seleccionado+Storage.identificador_amigo2, this.perfil.getStrEmail()+Storage.identificador_amigo1);
            
            // Reemplzar el mensaje enviado de perfil a mensaje de somos amigos
            Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends,
                    yoker+Storage.identificador_amigo3, this.session_activa.getStrEmail()+Storage.identificador_amigo1);
            
            // Crear rutas para clonar el chat de solicitud de amistad...
            String original = Storage.fncStorageCrearRutaChats(this.perfil.getStrEmail(), this.session_activa.getStrEmail());
            String clone = Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), this.perfil.getStrEmail());
            Storage.fncStorageCopiarArchivo(new File(original), clone); // Clonando archivo
            
            // * Activar chats en ambos cuentas...
            Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgChats, perfil_seleccionado, this.perfil.getStrEmail());
            Storage.fncStorageReemplazarUnaLinea(this.perfil.stgChats, yoker, this.session_activa.getStrEmail());
            
            // * Registrar notificaciones
            Storage.fncStorageRegistrarNotificacion(this.session_activa, "Haz aceptado una solicitud de amistad de " + this.perfil.getStrEmail() );
            Storage.fncStorageRegistrarNotificacion(this.perfil, this.session_activa.getStrEmail() + " acepto tú solicitud de amistad" );
            
            // Mensaje de operacion 
            JOptionPane.showMessageDialog(null, "Haz aceptado el solicitud de amistad."
                    + "\nEn hora buena ahora pueden conversar.");
            
            // * Frontend
            this.operacion = "aceptado";
            
        }
        
    }

    private void fncSolicituDeAmistadEliminar() {
        
        int respuesta = JOptionPane.showConfirmDialog(null, "Este perfil y tú son amigos."
                + "\nDeseas eliminar de tú lista de amigos?", "Confirmar ..." , JOptionPane.YES_NO_OPTION);
        
        if( respuesta == JOptionPane.YES_OPTION ){
        
            // Eliminar rastros de session_activa en perfil
            Storage.fncStorageEliminarUnaLinea(new File(this.perfil.stgChats), this.session_activa.getStrEmail());
            Storage.fncStorageEliminarUnaLinea(new File(this.perfil.stgFriends), this.session_activa.getStrEmail()+Storage.identificador_amigo1);
            
            // Elimiar rastros de perfil en session_activa
            Storage.fncStorageEliminarUnaLinea(new File(this.session_activa.stgChats), this.perfil.getStrEmail());
            Storage.fncStorageEliminarUnaLinea(new File(this.session_activa.stgFriends), this.perfil.getStrEmail()+Storage.identificador_amigo1);
                        
            // Crear rutas para clon y el chat original...
            String original = Storage.fncStorageCrearRutaChats(this.perfil.getStrEmail(), this.session_activa.getStrEmail());
            String clone = Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), this.perfil.getStrEmail());
            
            // Eliminar todos los chats
            new File(original).delete();
            new File(clone).delete();
            
            // * Registrar notificaciones
            Storage.fncStorageRegistrarNotificacion(this.session_activa, "Haz eliminado " + this.perfil.getStrEmail() + " de tú lista de amigos" );
            
            // Mensaje de operacion 
            JOptionPane.showMessageDialog(null, "Haz aceptado eliminar este perfil de tú lista de amigos.");
            
            // * Frontend
            this.operacion = "eliminado";
            
        }
        
    }
   
    private void fncSolicitudDeAmistadRecibidoCancelar() {
        
        int respuesta = JOptionPane.showConfirmDialog(null, "Este perfil te ha enviado una solicitud de amistad."
                + "\nDeseas rechazar a solicitud de amistad?", "Confirmar ..." , JOptionPane.YES_NO_OPTION); 
        
        if( respuesta == JOptionPane.YES_OPTION ){
            
            // Eliminar rastros en perfil en .chats y .friends
            Storage.fncStorageEliminarUnaLinea(new File(this.perfil.stgChats), this.yoker);
            Storage.fncStorageEliminarUnaLinea(new File(this.perfil.stgFriends), this.yoker+Storage.identificador_amigo3);
            
            // Eliminar rastros en session_activa en .chats y .friends
            Storage.fncStorageEliminarUnaLinea(new File(this.session_activa.stgChats), this.perfil_seleccionado);
            Storage.fncStorageEliminarUnaLinea(new File(this.session_activa.stgFriends), this.perfil_seleccionado+Storage.identificador_amigo2);
            
            // Eliminar el chat de perfil con su soicitud de amistad para session_activa
            String solicitud = Storage.fncStorageCrearRutaChats(this.perfil.getStrEmail(), this.session_activa.getStrEmail() );
            new File(solicitud).delete();
            
            // * Registrar notificaciones
            Storage.fncStorageRegistrarNotificacion(this.session_activa, "Haz rechazado la solicitu de amistad de " + this.perfil.getStrEmail() );
            Storage.fncStorageRegistrarNotificacion(this.perfil, this.session_activa.getStrEmail() + " ha rechazado tú solicitud de amistad" );

            JOptionPane.showMessageDialog(null, "Haz rechazado la solicitu de amistad.");
            
            this.operacion = "rechazado";
            
        }else{
            JOptionPane.showMessageDialog(null, "Abre el chat para aceptar la solicitud de amistad en tú lista de amigos.");
        }
        
    }
    
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion_exitosa) {
        this.operacion = operacion_exitosa;
    }
    
} // !# Fin de la clase
