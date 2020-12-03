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
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import ventana_people.PanelTarjeta;
import ventana_people.People;
import ventana_singup.PanelFirma;

/**
 *
 * @author max98
 */
public class singupWatcherTome extends Observador{
    private JPanel panel_mural;
    private String path_stgTome;
    private String email_session_activa;
    private int coordenadaY = 20;
        
    public singupWatcherTome(File path) {
        super(path);
    }

    public singupWatcherTome(String email, String path, JPanel panel_mural) {
        super(new File(path));
        this.path_stgTome = new File(path).getAbsolutePath();
        this.panel_mural = panel_mural;
        this.email_session_activa = email;
    }
    
    public void Inicializar(){
        coordenadaY = 20; // Reiniciar los valores de la coordenadaY
        
        if(this.fncVerificarCambiosEnElArchivoPath()){
            
            try {
                
                // * Reiniciar todas las firmas
                this.panel_mural.removeAll();
                
                // * Cerrar el almacenamiento de .notify 
                File archivo = new File(this.path_stgTome);
                BufferedReader stgTome = new BufferedReader(new FileReader(archivo));
                String email;

                while ((email = stgTome.readLine()) != null) {
                    // *** Testing
                    System.out.println(":: Tome :: linea = " + email);
                    
                    // * Verificar si existe una cuenta 
                    boolean cuenta = Storage.fncStorageEncontrarUnaLinea(Rutas.path_profiles, email);
                    if( cuenta == true && email.contains(email_session_activa) == false && !email.isEmpty() && email.contains(Storage.extension_rs) ){
                        // * Registrar todas las firmas...
                        PanelFirma a = new PanelFirma(new Session(email));
                        a.setFirma( stgTome.readLine() );
                        a.setBounds(20, coordenadaY, 480, 130);
                        panel_mural.add(a);
                        panel_mural.validate();
                        panel_mural.repaint();
                        coordenadaY += 20 + a.getHeight();
                    }
                    
                }
                
                // * Establecer nuevo valores
                panel_mural.setPreferredSize(new Dimension(0, coordenadaY));
                panel_mural.revalidate();
                panel_mural.repaint();
                coordenadaY = 20;
                // * Cerrar el almacenamiento de .tome
                stgTome.close();

            } catch (Exception e) { System.out.println("Error en profileWatcherTome" + e.getMessage()); }

        }   
         
    }

    
    
}
