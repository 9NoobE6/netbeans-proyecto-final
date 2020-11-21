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
    
    // Metodo constructor
    public Session(String correo){
        Scanner scanner;
        String tmpcontrasenha = "";
        
        try {
            scanner = new Scanner(new File( Rutas.db_profile + correo + ".txt"));
            scanner.useDelimiter("\n");
                 
            // System.out.println("Activando session...");
            this.strNombres = scanner.next();
            this.strApellidos = scanner.next();
            this.strNacimiento = scanner.next();
            this.strSexo = scanner.next();
            this.strContrasenha = scanner.next();
            this.strEmail = scanner.next();
            this.strImgPerfil = scanner.next();
            
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
                
            File myObj = new File(Rutas.db_profile + this.strEmail + ".txt");
                
            if (myObj.exists()) {
                FileWriter myWriter = new FileWriter(Rutas.db_profile + this.strEmail +".txt");
                   
                myWriter.write(this.strNombres + "\n");
                myWriter.write(this.strApellidos + "\n");
        
                myWriter.write(this.strNacimiento + "\n");
                myWriter.write(this.strSexo + "\n");
                
                myWriter.write(this.strContrasenha + "\n");
                myWriter.write(this.strEmail + "\n");
                myWriter.write(this.strImgPerfil + "\n");
                
                myWriter.close();
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
