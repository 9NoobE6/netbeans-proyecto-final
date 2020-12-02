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

/**
 *
 * @author max98
 */
public class profileWatcherNotify extends Observador{
    private JList lista_de_notificaciones;
    DefaultListModel notificaciones = new DefaultListModel();
    private String path_stgNotify;
        
    public profileWatcherNotify(File path) {
        super(path);
    }

    public profileWatcherNotify(String path, JList lista_de_notify) {
        super(new File(path));
        this.path_stgNotify = new File(path).getAbsolutePath();
        this.lista_de_notificaciones = lista_de_notify;
    }
    
    public void Inicializar(){
        
        if(this.fncVerificarCambiosEnElArchivoPath()){
            
            try {
                
                // * Reiniciar todas las notificaciones
                this.lista_de_notificaciones.removeAll();
                this.notificaciones.clear();
                
                // * Cerrar el almacenamiento de .notify 
                File archivo = new File(this.path_stgNotify);
                BufferedReader stgNotify = new BufferedReader(new FileReader(archivo));
                String linea;

                while ((linea = stgNotify.readLine()) != null) {
                    // *** Testing
                    System.out.println(":: Notify :: linea = " + linea);
                    
                    // * Registrar todas las notificaciones...
                    this.notificaciones.addElement(linea);
                    
                }
                
                // * Cerrar el almacenamiento de .notify
                stgNotify.close();
                
                // ***** TESTING
                System.out.println(":: Notify :: getSize = " + this.notificaciones.getSize());
                System.out.println(":: Notify :: size = " + this.notificaciones.size());
                System.out.println(":: Notify :: isEmpty = " + this.notificaciones.isEmpty());

                // * Verificar no existe notificaciones para mostrar un mensaje
                if(this.notificaciones.isEmpty()){
                    notificaciones.addElement("No tienes notificaciones...");
                }
            
                // * Mostrar todas las notificaciones...
                this.lista_de_notificaciones.setModel(notificaciones);
            
            } catch (Exception e) { System.out.println("Error en profileWatcherNotify"); }

        }   
         
    }

    
    
}
