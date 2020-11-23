/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana_chats;

import ventana_people.*;
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

/**
 *
 * @author max98
 */
public class Chats extends javax.swing.JFrame {
    JScrollPane scrollBar;
    /**
     * Creates new form Registro
     */
    public Chats() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.fncInicializarVentana();

    }
    
    public Chats(Session session_activa) {
        
        this.session_activa = session_activa;
        initComponents();
        this.fncInicializarVentana();
        
    }

    public Session getSession_activa() {
        return session_activa;
    }

    public void setSession_activa(Session session_activa) {
        this.session_activa = session_activa;
    }
   
    
    public void fncAgregarCuentas(){
        /*
        int t=0;
        for(int item=0; item < 20; item++){
            PanelCuenta a = new PanelCuenta();
            a.setBounds(item, t , 600, 200);
            this.panel_cuentas.add(a);
            this.panel_cuentas.validate();
            this.panel_cuentas.repaint();
            t += 200 + 20;
        }
        */
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_3_Background = new jpanelimagen.JPanelImagen();
        jPanel1 = new javax.swing.JPanel();
        campo_email = new javax.swing.JTextField();
        bntVolver = new javax.swing.JButton();
        panel_lista_de_amigos = new jpanelimagen.JPanelImagen();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panel_contenedor_chat = new jpanelimagen.JPanelImagen();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        campo_email.setEditable(false);
        campo_email.setText("jTextField1");

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
                .addContainerGap()
                .addComponent(campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addComponent(bntVolver)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntVolver))
                .addContainerGap())
        );

        panel_lista_de_amigos.setBackground(new java.awt.Color(0, 153, 153));
        panel_lista_de_amigos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setText("Lista de amigos");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Abrir chat");

        jButton2.setBackground(new java.awt.Color(153, 51, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar");

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ver perfil");

        javax.swing.GroupLayout panel_lista_de_amigosLayout = new javax.swing.GroupLayout(panel_lista_de_amigos);
        panel_lista_de_amigos.setLayout(panel_lista_de_amigosLayout);
        panel_lista_de_amigosLayout.setHorizontalGroup(
            panel_lista_de_amigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panel_lista_de_amigosLayout.createSequentialGroup()
                .addGroup(panel_lista_de_amigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_lista_de_amigosLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1))
                    .addGroup(panel_lista_de_amigosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_lista_de_amigosLayout.setVerticalGroup(
            panel_lista_de_amigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lista_de_amigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_lista_de_amigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        panel_contenedor_chat.setBackground(new java.awt.Color(0, 153, 153));
        panel_contenedor_chat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        javax.swing.GroupLayout panel_contenedor_chatLayout = new javax.swing.GroupLayout(panel_contenedor_chat);
        panel_contenedor_chat.setLayout(panel_contenedor_chatLayout);
        panel_contenedor_chatLayout.setHorizontalGroup(
            panel_contenedor_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_contenedor_chatLayout.setVerticalGroup(
            panel_contenedor_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_3_BackgroundLayout = new javax.swing.GroupLayout(panel_3_Background);
        panel_3_Background.setLayout(panel_3_BackgroundLayout);
        panel_3_BackgroundLayout.setHorizontalGroup(
            panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                        .addComponent(panel_lista_de_amigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_contenedor_chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel_3_BackgroundLayout.setVerticalGroup(
            panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_contenedor_chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_lista_de_amigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        SingUp ventana_singup = new SingUp( new Session( this.session_activa.getStrEmail() ));
        ventana_singup.setVisible(true);
        
        this.observador.stop();
        ventana_singup.setSession_activa(this.session_activa);
        this.dispose();
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
            java.util.logging.Logger.getLogger(Chats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVolver;
    private javax.swing.JTextField campo_email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private jpanelimagen.JPanelImagen panel_3_Background;
    private jpanelimagen.JPanelImagen panel_contenedor_chat;
    private jpanelimagen.JPanelImagen panel_lista_de_amigos;
    // End of variables declaration//GEN-END:variables
    public static Session session_activa;
    private ActionListener oyente;
    private Timer observador = new Timer(1000, oyente);
    JPanelImagen panel_perfiles;
    
    private void fncInicializarVentana(){
        this.setLocationRelativeTo(null);
        this.panel_3_Background.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b4.jpg").getPath() ), 1.0f ));
        this.panel_contenedor_chat.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b1.jpg").getPath() ), 0.1f ));
        this.panel_lista_de_amigos.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b1.jpg").getPath() ), 0.1f ));
        this.campo_email.setText( this.session_activa.getStrEmail() );
        this.setTitle( this.session_activa.getStrNombres() + " - " + this.session_activa.getStrEmail()  );
        
        try{
             
            ActionListener tarea = (ActionEvent e) -> {
                
            };

           observador.addActionListener(tarea);
           observador.start();
           
        }catch(Exception a){}
    }
    
    private long size_friendship;
    private int coordenadaY=20;
    
    public long fncObtenerTamahnoStorages(String file){
        Path path = Paths.get(file);
        long bytes =0;
        try{
             bytes = Files.size(path.toAbsolutePath());
        }catch(Exception e){}
        return bytes;
    }
}
