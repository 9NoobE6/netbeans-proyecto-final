/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana_people;

import clases.Rutas;
import clases.Session;
import clases.Storage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import jpanelimagen.ImagenFondo;
import jpanelimagen.JPanelImagen;
import ventana_pricipal.Principal;
import ventana_singup.SingUp;
import clases.Observador;
import clases.ObservadorInterface;
import watcher.peopleWatcherProfile;

/**
 *
 * @author max98
 */
public class People extends javax.swing.JFrame {

    JScrollPane scrollBar;

    /**
     * Creates new form Registro
     */
    public People() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.fncInicializarVentana();

    }

    public People(Session session_activa) {

        People.session_activa = session_activa;
        initComponents();
        this.fncInicializarVentana();

    }

    public Session getSession_activa() {
        return session_activa;
    }

    public void setSession_activa(Session session_activa) {
        this.session_activa = session_activa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_3_Background = new jpanelimagen.JPanelImagen();
        jPanel1 = new javax.swing.JPanel();
        bntVolver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panel_contenedor_perfiles = new jpanelimagen.JPanelImagen();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bntVolver.setBackground(new java.awt.Color(0, 102, 153));
        bntVolver.setForeground(new java.awt.Color(255, 255, 255));
        bntVolver.setText("Volver");
        bntVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntVolverMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(672, Short.MAX_VALUE)
                .addComponent(bntVolver)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntVolver)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        panel_contenedor_perfiles.setBackground(new java.awt.Color(204, 255, 255));
        panel_contenedor_perfiles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        javax.swing.GroupLayout panel_contenedor_perfilesLayout = new javax.swing.GroupLayout(panel_contenedor_perfiles);
        panel_contenedor_perfiles.setLayout(panel_contenedor_perfilesLayout);
        panel_contenedor_perfilesLayout.setHorizontalGroup(
            panel_contenedor_perfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_contenedor_perfilesLayout.setVerticalGroup(
            panel_contenedor_perfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_3_BackgroundLayout = new javax.swing.GroupLayout(panel_3_Background);
        panel_3_Background.setLayout(panel_3_BackgroundLayout);
        panel_3_BackgroundLayout.setHorizontalGroup(
            panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_contenedor_perfiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel_3_BackgroundLayout.setVerticalGroup(
            panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_contenedor_perfiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_3_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_3_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVolverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntVolverMouseReleased
        
        // Se borra la ventana People liberando memoria
        this.observador.stop(); // Se detiene los observadores
        this.setVisible(false); // Desaparece la ventana
        this.dispose(); // Se libera la memoria
        
        
        // Se inicializa la ventana SingUp
        SingUp ventana = new SingUp( People.session_activa );
        People.session_activa = null; // En la ventana People se elimina la sesssion_activa
        ventana.setVisible(true);
        System.out.println("*** People:::De vuelto a ventana SingUp");

    }//GEN-LAST:event_bntVolverMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(People.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new People().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private jpanelimagen.JPanelImagen panel_3_Background;
    private jpanelimagen.JPanelImagen panel_contenedor_perfiles;
    // End of variables declaration//GEN-END:variables
    public static Session session_activa;
    private ActionListener oyente;
    private Timer observador = new Timer(1000, oyente);
    private JPanelImagen panel_perfiles;
    public static boolean CerrarVentana = false;

    private void fncInicializarVentana() {

        // Modificamos las propiedades para la ventana JFrame)
        
        // * Posicionarlo en el centro
        this.setLocationRelativeTo(null);
        
        // * Establece el imagen de fodo para el JFrame usando el pane Background
        this.panel_3_Background.setImagenFondo(new ImagenFondo(new java.io.File( Rutas.path_background_jframe_people ), 1.0f));
        
        // * Establecer el imagen de fodo para contenedor_perfiles
        this.panel_contenedor_perfiles.setImagenFondo(new ImagenFondo(new java.io.File( Rutas.path_background_panel ), 0.0f));
        
        // * Establecer los datos del usuario en campo de texto y titulo de la ventana
        this.setTitle(People.session_activa.getStrNombres() + " - " + People.session_activa.getStrEmail());
        
        // * Crear un panel para mostrar las tarjetas de presentacion de los perfiles registrados
        panel_perfiles = new JPanelImagen();
        panel_perfiles.setPreferredSize(new Dimension(0, 0));
        panel_perfiles.setImagenFondo(new ImagenFondo(new java.io.File( Rutas.path_background_jframe_people  ), 1.0f));
        panel_perfiles.setLayout(null);
            
        // * Crear un scroll para dezplazarme hacia abajo y ver más perfiles
        // si ya no cabe en el panel contenedor_perfiles
        // ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        JScrollPane jsp = new JScrollPane(panel_perfiles, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(0, 0, this.panel_contenedor_perfiles.getWidth(), this.panel_contenedor_perfiles.getHeight());
        jsp.setAutoscrolls(true);
        this.panel_contenedor_perfiles.add(jsp);
        
        // * Crear el observador de perfiles
        peopleWatcherProfile observador_de_perfiles = new peopleWatcherProfile(Rutas.path_profiles, this.panel_perfiles);
        
        // Intentar ejecutar los observadores
        try {

            ActionListener tarea = (ActionEvent e) -> {
                System.out.println("::: Observador People :::");
                
                /// * Verifica si hubo algun cambio en archivo database.profiles
                observador_de_perfiles.Inicializar();
                
                if(People.CerrarVentana == true){
                    // Se borra la ventana People liberando memoria
                    this.observador.stop(); // Se detiene los observadores
                    this.setVisible(false); // Desaparece la ventana
                    this.dispose(); // Se libera la memoria
                }
                
            };

            observador.addActionListener(tarea);
            observador.start();

        } catch (Exception error) {}
        
    }
    
}
