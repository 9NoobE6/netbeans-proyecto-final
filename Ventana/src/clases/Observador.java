package clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Observador {
    private final File path;
    private long path_size=0;
    private long path_size_tmp=0;
    private ObservadorInterface observardor = null;

    // Método constructor
    public Observador(File path) {
        this.path = path;
    }

    public Observador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Métodos publico 
    public void quitarObservardor(){
        this.observardor = null;
    }
    
    public void fncIniciarObservador(){
        
        System.out.println("::: Ejecutando el observador :::");
        if(this.fncVerificarCambiosEnElArchivoPath()){
            
            /* ejecutar el observador si existe */
            if(observardor != null)
                observardor.ejecutar();
                
            System.out.println("Hubo cambios en el archivo + " + path.getAbsolutePath());
        }    
    }

    public boolean fncVerificarCambiosEnElArchivoPath() {
        
        this.path_size = 0;
        
        // * Verificar si existe el archivo a observar
        if(new File(path.getAbsoluteFile().toString()).exists()){
            try {
                // * Obtener el tamaño del arcivo
                this.path_size = Files.size(path.toPath());                
                
                // * Verificar si hay algún cambio en el archivo
                if( this.path_size > this.path_size_tmp || this.path_size < this.path_size_tmp  ){
                    
                    // * Salvamos el tamaño original
                    this.path_size_tmp = this.path_size;
                    return true;
                }else return false;
                
            } catch (IOException e) {}
        }else
            return false;
                
        return true;
    }
    
    // Métodos getters y setters
    public ObservadorInterface getObservar() {
        return observardor;
    }

    public void setObservar(ObservadorInterface observar) {
        this.observardor = observar;
    }

}
