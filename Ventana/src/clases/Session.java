package clases;

// Importar librerias java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ventana_pricipal.Principal;


public class Session {
    private String strNombres, strApellidos, strNacimiento, strSexo, strContrasenha, strEmail, strImgPerfil;
    public String stgChats, stgFriends, stgData, stgSvg, stgTome, stgNotify, stgChatTmp;
    
    // Metodo constructor
    public Session(String correo){
       this.fncObtenerDatosDeSession(correo);
    }
    
    private void fncObtenerDatosDeSession(String email){
        Scanner scanner;
        
        try {
            scanner = new Scanner(new File( Storage.fncStorageObtenerRutaData(email) ));
            scanner.useDelimiter("\n");
                 
            // System.out.println("Activando session...");
            this.strNombres = scanner.next().trim(); // Eliminar los caracteres blancos iniciales y finales.
            this.strApellidos = scanner.next().trim(); // Eliminar los caracteres blancos iniciales y finales.
            this.strNacimiento = scanner.next().trim(); // Eliminar los caracteres blancos iniciales y finales.
            this.strSexo = scanner.next().trim(); // Eliminar los caracteres blancos iniciales y finales.
            this.strContrasenha = scanner.next();
            this.strEmail = scanner.next().trim(); // Eliminar los caracteres blancos iniciales y finales.
            this.strImgPerfil = scanner.next().trim(); // Eliminar los caracteres blancos iniciales y finales.
            
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // * Crear archivos de almacenamiento para el perfil
        // storage_profiles/abcd@extesion/profile/example@extesion.data
        this.stgData = Rutas.storage_profiles + this.strEmail + Rutas.storage_profile + this.strEmail + Rutas.extesion_data;
        this.stgFriends = Rutas.storage_profiles + this.strEmail + Rutas.storage_profile + this.strEmail + Rutas.extesion_friends;
        this.stgChats = Rutas.storage_profiles + this.strEmail + Rutas.storage_profile + this.strEmail + Rutas.extesion_chats;
        this.stgTome = Rutas.storage_profiles + this.strEmail + Rutas.storage_profile + this.strEmail + Rutas.extesion_tome;
        this.stgNotify = Rutas.storage_profiles + this.strEmail + Rutas.storage_profile + this.strEmail + Rutas.extesion_notify;
        
        // * Creando el path del chat temporal
        this.stgChatTmp = Rutas.storage_profiles + this.strEmail + Rutas.storage_chats + Rutas.extesion_chatmp + this.strEmail + Rutas.extesion_chats;
        
        // * Crear la ruta para el imagen de perfil por defecto  
        this.stgSvg = Rutas.storage_profiles + this.strEmail + Rutas.storage_profile + this.strEmail + Rutas.extesion_svg;
        
    }
    
    // Metodo para cerrar session
    public void CerrarSession(){
        this.strNombres = "";
        this.strApellidos = "";
        this.strNacimiento = "";
        this.strSexo = "";
        this.strContrasenha = "";
        this.strEmail = "";
    }
    
    public void fncActualizarDatos(){
        
        try {
            String path = this.stgData;
            File mis_datos = new File(path);
                
            if (mis_datos.exists()) {
                FileWriter registrar_nuevos_datos = new FileWriter(path);
                
                System.out.println(">>>>> NAme " + strNombres);
                System.out.println(">>>>> FirsrNAme " + strApellidos);
                
                registrar_nuevos_datos.write(this.strNombres + "\n");
                registrar_nuevos_datos.write(this.strApellidos + "\n"); 
        
                registrar_nuevos_datos.write(this.strNacimiento + "\n");
                registrar_nuevos_datos.write(this.strSexo + "\n");
                
                registrar_nuevos_datos.write(this.strContrasenha + "\n");
                registrar_nuevos_datos.write(this.strEmail + "\n");
                registrar_nuevos_datos.write(this.strImgPerfil + "\n");
                
                registrar_nuevos_datos.close();
            }
                
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
        //System.out.println("Datos Actualizados...");
    }
    
    // Metodos setters y getters
    public String getStrNombres() {
        return strNombres;
    }

    public void setStrNombres(String strNombres) {
        this.strNombres = strNombres;
    }

    public String getStrApellidos() {
        return strApellidos;
    }

    public void setStrApellidos(String strApellidos) {
        this.strApellidos = strApellidos;
    }

    public String getStrNacimiento() {
        return strNacimiento;
    }

    public void setStrNacimiento(String strNacimiento) {
        this.strNacimiento = strNacimiento;
    }

    public String getStrSexo() {
        return strSexo;
    }

    public void setStrSexo(String strSexo) {
        this.strSexo = strSexo;
    }

    public String getStrContrasenha() {
        return strContrasenha;
    }

    public void setStrContrasenha(String strContrasenha) {
        this.strContrasenha = strContrasenha;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrImgPerfil() {
        return strImgPerfil;
    }

    public void setStrImgPerfil(String strImgPerfil) {
        this.strImgPerfil = strImgPerfil;
    }
        
}
