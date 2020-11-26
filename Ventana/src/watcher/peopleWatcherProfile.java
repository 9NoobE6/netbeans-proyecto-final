/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watcher;

import clases.Observador;
import clases.Rutas;
import clases.Session;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JPanel;
import ventana_people.PanelTarjeta;
import ventana_people.People;

/**
 *
 * @author max98
 */
public class peopleWatcherProfile extends Observador{
    private JPanel panel_perfiles;
    private int coordenadaY = 20;
    
    public peopleWatcherProfile(File path) {
        super(path);
    }

    public peopleWatcherProfile(String path, JPanel perfiles) {
        super(new File(path));
        this.panel_perfiles = perfiles;
    }
    
    public void Inicializar(){
        
        if(this.fncVerificarCambiosEnElArchivoPath()){

            try {
                
                panel_perfiles.removeAll();
                File archivo = new File(Rutas.path_profiles);
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;

                while ((linea = br.readLine()) != null) {

                    if (linea.equals(People.session_activa.getStrEmail()) == false && !linea.isEmpty() && linea.contains(Rutas.extension_rs)) {
                        PanelTarjeta a = new PanelTarjeta(new Session(linea));
                        a.setBounds(60, coordenadaY, 600, 135);
                        panel_perfiles.add(a);
                        panel_perfiles.validate();
                        panel_perfiles.repaint();
                        coordenadaY += 20 + a.getHeight();
                    }
                    
                }

                panel_perfiles.setPreferredSize(new Dimension(0, coordenadaY));
                panel_perfiles.validate();
                panel_perfiles.revalidate();
                panel_perfiles.repaint();
                coordenadaY = 20;
                
            } catch (Exception e) {
            }
            
        }
        
    }
    
    // Metodos getters y setters
    public JPanel getPanel_perfiles() {
        return panel_perfiles;
    }

    public void setPanel_perfiles(JPanel panel_perfiles) {
        this.panel_perfiles = panel_perfiles;
    }

}
