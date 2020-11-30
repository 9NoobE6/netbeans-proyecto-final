package clases;

import java.io.File;
import javax.swing.JOptionPane;
import ventana_people.PanelTarjeta;
import ventana_profile.Profile;

public class Amistad {
    private final Session session_activa;
    private final Session perfil;
    private String amistad_perfil;
    private String amistad_session;
    private boolean activar_msg;
    private int respuesta=-100;
    public boolean ventana_People=false;
    public boolean ventana_Profile=false;

    // Método Getter y Setter
    public boolean isActivar_msg() {
        return activar_msg;
    }

    public void setActivar_msg(boolean activar_msg) {
        this.activar_msg = activar_msg;
    }
    
    public Amistad(Session session_activa, Session perfil) {
        this.session_activa = session_activa;
        this.perfil = perfil;
        this.activar_msg = false;
        this.fncVerificarAmistad();
    }
    
    private void fncVerificarAmistad(){
        
        // * Verificar estado de amistad
        amistad_perfil = Storage.fncStorageVerificarAmistad(this.perfil.stgFriends, this.session_activa.getStrEmail());
        amistad_session = Storage.fncStorageVerificarAmistad(this.session_activa.stgFriends, this.perfil.getStrEmail());
        
        System.out.println("Amistad session = " + amistad_session);
        System.out.println("Amistad perfil = " + amistad_perfil);
        
    }
    
    public void fncSolicituDeAmistadEnviarTo(){
        
        // Tabla de verdad (Amistad)
        // session_activa   // perfil
        // ----------------------------
        // Amigos           // Amigos
        // Recibido         // Enviado
        // Enviado          // Recibido
        // None             // None
        
        if( amistad_session.equals("Amigos") && amistad_perfil.equals("Amigos") ){
            this.fncAmistadSomosAmigos();
            
            if( respuesta == JOptionPane.YES_OPTION ){
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Amigo+1");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Amigo+1");
            }else{
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Somos amigos");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Somos amigos");
            }  
        
        }else if( amistad_session.equals("Recibido") && amistad_perfil.equals("Enviado") ){
            fncAmistadRecibidoEnviado();
            
            if( respuesta == JOptionPane.YES_OPTION ){
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Amigo+1");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Amigo+1");
            }else{
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Solicitud  recibido");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Solicitud  recibido");
            }
            
        }else if( amistad_session.equals("Enviado") && amistad_perfil.equals("Recibido") ){
            this.fncAmistadEnviadoRecibido();
            
            if( respuesta == JOptionPane.YES_OPTION ){
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Amigo+1");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Amigo+1");
            }else{
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Solicitud  enviado");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Solicitud enviado");
            }
            
        }else if( (amistad_session.equals("None") && amistad_perfil.equals("None")) ||  (amistad_session.equals("Pendiente") && amistad_perfil.equals("None"))  ){
            this.fncAmistadAgregarAmigo();
            
             if( respuesta == JOptionPane.YES_OPTION ){
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Pendiente...");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Pendiente...");
             }else{
                if( ventana_People  ) PanelTarjeta.btnAgregarAmigo.setText("Amigo+1");
                if( ventana_Profile ) Profile.btnAgregarAmigo.setText("Amigo+1");
             }
             
        }
        
        
        
    }
    
    private void fncAmistadSomosAmigos(){
        
        if( this.activar_msg ){
            // Este método se ejecuta si ya somos amigos
            // Esto significa que no tenemos un (*)

            // * Confirmar...
            this.respuesta = JOptionPane.showConfirmDialog(null, "Este perfil y tú ya son amigos."
                    + "\nDeseas eliminar de tú, lista de amigos? ", "Confirmar...", JOptionPane.YES_NO_OPTION);

            if( respuesta == JOptionPane.YES_OPTION ){
                
                // Eliminando a perfil de lista de amigos de session
                Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgFriends,
                        this.perfil.getStrEmail() + Storage.identificador_amigo1,
                        this.perfil.getStrEmail()+"*");
                
                // Eliminando a perfil de lista de amigos de session
                Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends,
                        this.session_activa.getStrEmail() + Storage.identificador_amigo1,
                        this.session_activa.getStrEmail()+ "*");

                JOptionPane.showMessageDialog(null, "Este perfil fue eliminado de tu lista de amigos.");
            }
        }
        
    }
    
    private void fncAmistadRecibidoEnviado() {
        
        if( this.activar_msg ){
            // Este metodo se ejecuta cuando yo session_activa, ya te he recibido
            // una solicitud de amistad.
            // Esto significa que tengo identificador_amigo2

            // * Confirmar...
            this.respuesta = JOptionPane.showConfirmDialog(null, "Este perfil te ha enviado una solicitud de amistad."
                    + "\nDeseas cancelar la solicitud de amistad?", "Confirmar...", JOptionPane.YES_NO_OPTION);

            if( respuesta == JOptionPane.YES_OPTION ){
                
                // Eliminando a perfil de lista de amigos de session
                Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgFriends, 
                    this.perfil.getStrEmail() + Storage.identificador_amigo2, 
                    this.perfil.getStrEmail()+"*");
                
                // Eliminando a session_activa de lista de amigos de perfil
                Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends,
                        this.session_activa.getStrEmail() + Storage.identificador_amigo3,
                        this.session_activa.getStrEmail()+"*");


                JOptionPane.showMessageDialog(null, "Este perfil fue eliminado de tu lista de amigos.");
            }
        }
        
    }

    private void fncAmistadEnviadoRecibido() {
        
        if( this.activar_msg ){
            // Este metodo se ejecuta cuando yo session_activa, ya te he enviado
            // una solicitud de amistad.
            // Esto significa que tengo identificador_amigo3

            // * Confirmar...
            this.respuesta = JOptionPane.showConfirmDialog(null, "Haz enviado una solicitud de amistad a este perfil, ."
                    + "\nDeseas cancelar la solicitud de amistad?", "Confirmar...", JOptionPane.YES_NO_OPTION);

            if( respuesta == JOptionPane.YES_OPTION ){
                
                // Reemplazar a perfil de lista de amigos de session por que la conversacion se queda xD
                Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgFriends, 
                    this.perfil.getStrEmail() +"*"+Storage.identificador_amigo3, 
                    this.perfil.getStrEmail() +"*");
                
                // * Verificar si perfil tiene una conversacion con session_activa
                String chat = Storage.fncStorageCrearRutaChats(this.perfil.getStrEmail(), this.session_activa.getStrEmail());
                if( !Storage.fncStorageBuscarUnaLinea(this.perfil.stgChats, this.session_activa.getStrEmail()) && new File(chat).exists() == false ){
                    
                    // Eliminando a session_activa de lista de amigos de perfil
                    Storage.fncStorageEliminarUnaLinea(new File(this.perfil.stgFriends),
                    this.session_activa.getStrEmail() +"*"+Storage.identificador_amigo2);
                    
                }else{
                    // Si perfil conserva una conversacion con session_activa
                    // Reemplazar a perfil de lista de amigos de session
                    Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgFriends, 
                    this.session_activa.getStrEmail() +"*"+Storage.identificador_amigo2, 
                    this.session_activa.getStrEmail() +"*");
                }
                

                JOptionPane.showMessageDialog(null, "Este perfil fue eliminado de tu lista de amigos.");
            }
        }
        
    }

    private void fncAmistadAgregarAmigo() {
        
        if( this.activar_msg ){
            
            // * Verificar si perfil tiene una conversacion con session_activa
            String chat = Storage.fncStorageCrearRutaChats(this.perfil.getStrEmail(), this.session_activa.getStrEmail());
            if( !Storage.fncStorageBuscarUnaLinea(this.perfil.stgChats, this.session_activa.getStrEmail()) && new File(chat).exists() == false ){

                // Este codigo se ejecuta cuando agregas a un amigo
                Mensaje amistad = new Mensaje(this.session_activa, "Hola, quieres ser mi amigo? \n");
                amistad.fncMensajeEnviarMensajeTo(this.perfil);

                if( Storage.fncStorageEncontrarUnaLinea(this.session_activa.stgFriends, this.perfil.getStrEmail()+"*") ){
                    Storage.fncStorageReemplazarUnaLinea(this.session_activa.stgFriends, 
                        this.perfil.getStrEmail() + "*", 
                        this.perfil.getStrEmail() + "*"+Storage.identificador_amigo3);
                }else{

                    Storage.fncStorageAcoplarUnaLinea(this.session_activa.stgFriends, this.perfil.getStrEmail() + "*"+Storage.identificador_amigo3);

                }

                Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends, 
                        this.session_activa.getStrEmail() + "*", 
                        this.session_activa.getStrEmail() + "*"+Storage.identificador_amigo2);

            }
            
            Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends, 
                        this.session_activa.getStrEmail() + "*", 
                        this.session_activa.getStrEmail() + "*"+Storage.identificador_amigo2);
            
            Storage.fncStorageReemplazarUnaLinea(this.perfil.stgFriends, 
                        this.session_activa.getStrEmail() + "", 
                        this.session_activa.getStrEmail() + "*"+Storage.identificador_amigo2);
            
            JOptionPane.showMessageDialog(null, "Solicitu de amistad enviado");
            
            this.respuesta = JOptionPane.YES_OPTION;
        }
   
    }
    
    
    
    
}
