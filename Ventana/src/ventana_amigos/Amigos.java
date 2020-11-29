/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana_amigos;

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
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import jpanelimagen.ImagenFondo;
import jpanelimagen.JPanelImagen;
import ventana_pricipal.Principal;
import ventana_profile.Profile;
import ventana_singup.SingUp;

/**
 *
 * @author max98
 */
public class Amigos extends javax.swing.JFrame {
    JScrollPane scrollBar;
    /**
     * Creates new form Registro
     */
    public Amigos() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.fncInicializarVentana();

    }
    
    public Amigos(Session session_activa) {
        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_3_Background = new jpanelimagen.JPanelImagen();
        jPanel1 = new javax.swing.JPanel();
        campo_email_chat = new javax.swing.JTextField();
        bntVolver = new javax.swing.JButton();
        panel_lista_de_amigos = new jpanelimagen.JPanelImagen();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_de_amigos = new javax.swing.JList<>();
        bntVerPerfil = new javax.swing.JButton();
        bntAbrirChat = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        panel_contenedor_chat = new jpanelimagen.JPanelImagen();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mensaje = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_mensajes = new javax.swing.JList<>();
        bntEnviarMensaje = new javax.swing.JButton();
        btnCerrarChat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        campo_email_chat.setEditable(false);
        campo_email_chat.setBackground(new java.awt.Color(204, 255, 204));
        campo_email_chat.setForeground(new java.awt.Color(0, 0, 0));
        campo_email_chat.setText("jTextField1");

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
                .addComponent(campo_email_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addComponent(bntVolver)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_email_chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntVolver))
                .addContainerGap())
        );

        panel_lista_de_amigos.setBackground(new java.awt.Color(0, 153, 153));
        panel_lista_de_amigos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setText("Lista de amigos");

        lista_de_amigos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "cargando..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lista_de_amigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lista_de_amigosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lista_de_amigos);

        bntVerPerfil.setBackground(new java.awt.Color(0, 0, 102));
        bntVerPerfil.setForeground(new java.awt.Color(255, 255, 255));
        bntVerPerfil.setText("Ver perfil");
        bntVerPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntVerPerfilMouseReleased(evt);
            }
        });

        bntAbrirChat.setBackground(new java.awt.Color(0, 102, 0));
        bntAbrirChat.setForeground(new java.awt.Color(255, 255, 255));
        bntAbrirChat.setText("Abrir chat");
        bntAbrirChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntAbrirChatMouseReleased(evt);
            }
        });

        bntEliminar.setBackground(new java.awt.Color(153, 51, 0));
        bntEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bntEliminar.setText("Eliminar");
        bntEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntEliminarMouseReleased(evt);
            }
        });

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
                        .addComponent(bntAbrirChat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntVerPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntEliminar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panel_lista_de_amigosLayout.setVerticalGroup(
            panel_lista_de_amigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_lista_de_amigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panel_lista_de_amigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntVerPerfil)
                    .addComponent(bntAbrirChat)
                    .addComponent(bntEliminar))
                .addContainerGap())
        );

        panel_contenedor_chat.setBackground(new java.awt.Color(0, 153, 153));
        panel_contenedor_chat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        panel_contenedor_chat.setEnabled(false);

        txt_mensaje.setColumns(20);
        txt_mensaje.setRows(5);
        txt_mensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mensajeKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txt_mensaje);

        jScrollPane3.setViewportView(lista_mensajes);

        bntEnviarMensaje.setBackground(new java.awt.Color(0, 153, 0));
        bntEnviarMensaje.setForeground(new java.awt.Color(255, 255, 255));
        bntEnviarMensaje.setText("Enviar mensaje");
        bntEnviarMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntEnviarMensajeMouseReleased(evt);
            }
        });

        btnCerrarChat.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrarChat.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarChat.setText("Cerrar chat");
        btnCerrarChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCerrarChatMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_contenedor_chatLayout = new javax.swing.GroupLayout(panel_contenedor_chat);
        panel_contenedor_chat.setLayout(panel_contenedor_chatLayout);
        panel_contenedor_chatLayout.setHorizontalGroup(
            panel_contenedor_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contenedor_chatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrarChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntEnviarMensaje)
                .addContainerGap())
        );
        panel_contenedor_chatLayout.setVerticalGroup(
            panel_contenedor_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_contenedor_chatLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_contenedor_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntEnviarMensaje)
                    .addComponent(btnCerrarChat))
                .addContainerGap())
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
        
        // Se borra la ventana Amigos liberando memoria
        this.observador.stop(); // Se detiene los observadores
        this.setVisible(false); // Desaparece la ventana
        this.dispose(); // Se libera la memoria 
        
        // Se inicializa la ventana de SingUp
        SingUp ventana = new SingUp(this.session_activa);
        this.session_activa = null; // En la ventana SingUp se elimina la sesssion_activa
        ventana.setVisible(true); // Se visualiza
        
        System.out.println("*** People:::De vuelto a ventana SingUp");

    }//GEN-LAST:event_bntVolverMouseReleased

    private void bntAbrirChatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntAbrirChatMouseReleased

        // Al presionar en el boton Abrir chat se ejecuta este método
        this.fncAbrirChatTo();
        
        
    }//GEN-LAST:event_bntAbrirChatMouseReleased

    private void btnCerrarChatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarChatMouseReleased
        // TODO add your handling code here:
        
        // El codigo se ejecuta, solo si el chat esta activado.
        if( this.chat_activado == true){
            // Deshabilitamos todos los componentes de chat
            this.fncCambiarEstadoPanelAmigos(true);
            this.fncCambiarEstadoPanelChat(false);
            System.out.println("Finalizó la conversacion...");

            // Borrar los variables que se nececesitan para otro chat
            this.lista_mensajes.removeAll();
            this.mensajes.removeAllElements();
            this.txt_mensaje.setText("");
            this.chat_activado = false;
            this.chat_path_activo = "";
            this.size_chats = 0;
            
            // Deshabitamos el panel del titulo, cambiando los colores
            // Este color indica si el chat esta desactivado...
            this.campo_email_chat.setBackground(new Color(204,204,204));
            this.campo_email_chat.setEditable(false); // Se desactiva el JTexField
            this.campo_email_chat.setText(null); // Se elimina el titulo
            
            // Desactivamos el area de mensaje...
            this.txt_mensaje.setFocusable(false);
        }
       
    }//GEN-LAST:event_btnCerrarChatMouseReleased

    private void bntEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEliminarMouseReleased
        // TODO add your handling code here:
        
        // Cuando se presiona el boton eliminar, se ejecuta este método
        this.fncEliminarPerfilTo();
        
    }//GEN-LAST:event_bntEliminarMouseReleased

    private void bntEnviarMensajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEnviarMensajeMouseReleased
        
        // Al presionar el botono Eviar mensaje se ejecuata este método
        // para posteriormente enviar mensaje...
        this.fncEnviarMensajeTo();
        
    }//GEN-LAST:event_bntEnviarMensajeMouseReleased

    private void lista_de_amigosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_de_amigosMouseReleased
        // ********* TESTING
        System.out.println("Quien seleccione ... " + this.lista_de_amigos.getSelectedValue() );
        String mi_amigo = this.lista_de_amigos.getSelectedValue();
        
        // * Se verifica que el perfil seleccionado en la lista de amigos ...
        // existene mi lista de amigos en decir en session_activa
        // * Se verifica que el chat esta desactivado
        if( Storage.fncStorageEncontrarUnaCuenta(this.session_activa.stgFriends, mi_amigo) && this.chat_activado == false ){
            
            // * Se habilitan todos los botones 
            this.bntAbrirChat.setEnabled(true);
            this.bntVerPerfil.setEnabled(true);
            this.bntEliminar.setEnabled(true);
        
        }else{
            
            // * Se desabilitan todos los botones
            this.bntAbrirChat.setEnabled(false);
            this.bntVerPerfil.setEnabled(false);
            this.bntEliminar.setEnabled(false);
        
        }
        
    }//GEN-LAST:event_lista_de_amigosMouseReleased

    private void txt_mensajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mensajeKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            // Al presionar presiona el enter en el area de mensaje se ejecuata este método
            // para posteriormente enviar mensaje...
            this.fncEnviarMensajeTo();
            
        }   
        
    }//GEN-LAST:event_txt_mensajeKeyReleased

    private void bntVerPerfilMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntVerPerfilMouseReleased
        
        // * Obtener el email de perfil selccionado
        String perfil = this.lista_de_amigos.getSelectedValue();
        if( perfil.contains("*") ){
            perfil = perfil.replace("*", "");
        }else{
            perfil = perfil.substring(0, perfil.indexOf("@"));
            perfil = perfil + Rutas.extension_rs;
        }
        
        
        // Se borra la ventana Amigos liberando memoria
        this.observador.stop(); // Se detiene los observadores
        this.setVisible(false); // Desaparece la ventana
        this.dispose(); // Se libera la memoria 
        
        // Se inicializa la ventana de Profile
        // De session_activa para perfil
        Profile ventana = new Profile(this.session_activa, new Session(perfil));
        this.session_activa = null; // En la ventana SingUp se elimina la sesssion_activa
        ventana.ventana_Amigos = true; // Inidicar a la ventana que vuelva a SingUp
        ventana.setVisible(true); // Se visualiza
        ventana.fncSaludarPerfil();
        
        System.out.println("*** Amigos::: Abriendo el perfil de " + perfil);
        
    }//GEN-LAST:event_bntVerPerfilMouseReleased

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
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Amigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Amigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAbrirChat;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntEnviarMensaje;
    private javax.swing.JButton bntVerPerfil;
    private javax.swing.JButton bntVolver;
    private javax.swing.JButton btnCerrarChat;
    private javax.swing.JTextField campo_email_chat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lista_de_amigos;
    private javax.swing.JList<String> lista_mensajes;
    private jpanelimagen.JPanelImagen panel_3_Background;
    private jpanelimagen.JPanelImagen panel_contenedor_chat;
    private jpanelimagen.JPanelImagen panel_lista_de_amigos;
    private javax.swing.JTextArea txt_mensaje;
    // End of variables declaration//GEN-END:variables
    public Session session_activa;
    private ActionListener oyente;
    private Timer observador = new Timer(1000, oyente);
    private long size_friendship;
    private long size_chats;
    DefaultListModel mensajes = new DefaultListModel();
    DefaultListModel amigos = new DefaultListModel();
    private String chat_path_activo;
    private boolean chat_activado=false;
    private boolean es_amigo = false;
    
    private void fncInicializarVentana(){
        this.setLocationRelativeTo(null);
        this.panel_3_Background.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b4.jpg").getPath() ), 1.0f ));
        this.panel_contenedor_chat.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b1.jpg").getPath() ), 0.1f ));
        this.panel_lista_de_amigos.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b1.jpg").getPath() ), 0.1f ));
        this.setTitle( this.session_activa.getStrNombres() + " - " + this.session_activa.getStrEmail()  );
        this.fncCambiarEstadoPanelChat(false);
        this.campo_email_chat.setFocusable(false);
        
        this.bntAbrirChat.setEnabled(false);
        this.bntEliminar.setEnabled(false);
        this.bntVerPerfil.setEnabled(false);
        this.campo_email_chat.setText("");
        this.campo_email_chat.setBackground(new Color(204,204,204));
        this.campo_email_chat.setEditable(false);
        
        
        try{
             
            ActionListener tarea = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println("::: Observador Chats :::");
                        // * Ejecutar los observadores
                        
                        if (chat_activado == true) {   
                            // Sincronizar los mensajes si chat esta activado
                            Amigos.this.fncSincronizarMensajes(); 
                        }
                        
                        // Sincronizar lista de amigos de session_activa
                        Amigos.this.fncSincronizarAmigos();
                    
                    }catch (IOException ex) {
                        Logger.getLogger(Amigos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };

           observador.addActionListener(tarea);
           observador.start();
           
        }catch(Exception a){}
    }
    
    private void fncCambiarEstadoPanelChat(boolean estado){
        this.txt_mensaje.setEnabled(estado);
        this.btnCerrarChat.setEnabled(estado);
        this.lista_mensajes.setEnabled(estado);
        this.txt_mensaje.setEnabled(estado);
        this.bntEnviarMensaje.setEnabled(estado);
        
        // [0,153,153]
        if(estado == false)
            this.panel_contenedor_chat.setBackground(Color.GRAY);
        else
            this.panel_contenedor_chat.setBackground(new Color(0, 153, 153));
            
    }
    
    private void fncCambiarEstadoPanelAmigos(boolean estado){
        this.lista_de_amigos.setEnabled(estado);
        this.bntAbrirChat.setEnabled(estado);
        this.bntEliminar.setEnabled(estado);
        this.bntVerPerfil.setEnabled(estado);
        
        // [0,153,153]
        if(estado == false)
            this.panel_lista_de_amigos.setBackground(Color.GRAY);
        else
            this.panel_lista_de_amigos.setBackground(new Color(0, 153, 153));
            
    }
    
    
    public long fncObtenerTamahnoStorages(String file){
        Path path = Paths.get(file);
        long bytes =0;
        try{
             bytes = Files.size(path.toAbsolutePath());
        }catch(Exception e){}
        return bytes;
    }
    
    private void fncSincronizarAmigos() throws FileNotFoundException, IOException{
        String path = this.session_activa.stgFriends;
        long _size_ = this.fncObtenerTamahnoStorages(path);
        
        // ********* TESTING
        System.out.print("** Observador -fncSincronizarAmigos- :: " );
        System.out.println(" Total de amigos = " + this.amigos.getSize() );

        if( _size_ > this.size_friendship || _size_ < this.size_friendship ){
            this.amigos.removeAllElements();
            this.lista_de_amigos.removeAll();

            File archivo = new File( path );
            BufferedReader br = new BufferedReader( new FileReader(archivo) );
            String st; 

            while ((st = br.readLine()) != null){
                if( !st.contains(this.session_activa.getStrEmail()) ){
                    this.amigos.addElement(st);
                }
            }
            
            this.lista_de_amigos.setModel(this.amigos);
            this.size_friendship = _size_;
        }
        
        
        // Si no tienes amigos a
        if( this.amigos.getSize() == 0    ){
            
            this.amigos.removeAllElements();
            this.lista_de_amigos.removeAll();
            
            this.bntAbrirChat.setEnabled(false);
            this.bntVerPerfil.setEnabled(false);
            this.bntEliminar.setEnabled(false);
            this.amigos.addElement("No tienes amigos...");
            
            this.lista_de_amigos.setModel(this.amigos);
        }
        
    }

    private void fncSincronizarMensajes() throws FileNotFoundException, IOException {
        String path = this.chat_path_activo;
        File chat = new File(path);
        long _size_ = this.fncObtenerTamahnoStorages(path);
        
        if(chat.exists()){
            if( _size_ > this.size_chats || _size_ < this.size_chats ){
                
                this.mensajes.removeAllElements();
                this.lista_mensajes.removeAll();
                
                // Covertir el item selecciona en un correo de con extension
                String perfil = lista_de_amigos.getSelectedValue();
                perfil = perfil.substring(0, perfil.lastIndexOf("@"));
                perfil = perfil + Rutas.extension_rs;
               
                File archivo = new File( path );
                BufferedReader br = new BufferedReader( new FileReader(archivo) );
                String linea; 
                while ((linea = br.readLine()) != null){
                    System.out.println(linea);
                    
                    if( linea.contains(this.session_activa.getStrEmail()) ){
                        this.mensajes.addElement(" # " + linea);
                        linea = br.readLine();
                        this.mensajes.addElement(linea);
                    }else if( linea.contains( perfil ) ){ 
                        String a = "%-" + Math.abs(linea.length() - 90) + "s";
                        this.mensajes.addElement( linea.format(a, "").replace(' ',' ') + linea + " * ");
                        linea = br.readLine();
                        this.mensajes.addElement( linea + linea.format(a, "").replace(' ',' '));
                    }else{
                        this.mensajes.addElement(linea);
                    }
                    
                }

                this.lista_mensajes.setModel(this.mensajes);
                this.size_chats = _size_;
                
                int ultimo_mensaje = this.lista_mensajes.getModel().getSize() - 1;
                if (ultimo_mensaje >= 0) {
                   this.lista_mensajes.ensureIndexIsVisible(ultimo_mensaje);
                }
                
            }
        }
    }

    private void fncEnviarMensajeTo() {
        
        // Se obtiene el perfil seleccionado de lista de amigos..
        String msg_body = this.txt_mensaje.getText();
        
        // ****** Testing
        System.out.println("** tamaño del mensaje : " + msg_body.length());
        System.out.println("## tamaño del mensaje : " + msg_body.trim().length() );
        
        // * Verificar que chat este activado, el chat se activa al Abrir el chat 
        if( this.es_amigo == false && this.chat_activado == true ){
            if( msg_body.trim().length() > 0 ){
                String perfil = this.lista_de_amigos.getSelectedValue();
                perfil = perfil.replace("*", ""); 

                // Eniviamos una notificacion en .chats
                Storage.fncStorageEliminarUnaLinea(new File( new Session(perfil).stgFriends  ), this.session_activa.getStrEmail() + "*");
                Storage.fncStorageAcoplarUnaLinea(new Session(perfil).stgFriends, this.session_activa.getStrEmail() + "*");
                
                // Enviamos una notificación en .friends
                Storage.fncStorageEliminarUnaLinea(new File( new Session(perfil).stgChats  ), this.session_activa.getStrEmail() + "*");
                Storage.fncStorageAcoplarUnaLinea(new Session(perfil).stgChats, this.session_activa.getStrEmail() + "*");
                
                // Registrar un menaje
                String mensaje = Storage.fncStorageCrearMensaje(session_activa, msg_body);
                Storage.fncStorageAcoplarUnaLinea(this.chat_path_activo, mensaje);          

                // Clonar la conversion de session_activa a perfil
                Storage.fncStorageCopiarArchivo(new File(this.chat_path_activo), Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), perfil) );
            
            }else{
                JOptionPane.showMessageDialog(null, "No se puede enviar mensajes vacios.");
            }
            this.txt_mensaje.setText("");
        }
        
    }

    private void fncAbrirChatTo() {
       
        // Crear path y objeto archivo de mi storage .chats para ver los chats que tengo registrados
        String path = this.session_activa.stgFriends;
        File chats = new File( path );
        
        // Si mi archivo de mi storage .chats y el perfil selecciona no es vacio...
        if(chats.exists() && this.lista_de_amigos.isSelectionEmpty() == false && this.chat_activado == false
        && this.lista_de_amigos.getSelectedValue().equals("No tienes amigos...") == false){
            
            if(Storage.fncStorageEncontrarUnaCuenta(path, this.lista_de_amigos.getSelectedValue() )){
                
                String perfil = this.lista_de_amigos.getSelectedValue();
                                
                // Verificar si el perfil seleccionado tiene un (*) eso significa
                // que el perfil no lo tengo agrego en mi lista de amigos, 
                // sino que solo recibi un mensaje de él...
                if(this.lista_de_amigos.getSelectedValue().contains("*")){
                    perfil = perfil.replace("*", "");
                    // Selecciona el chat desde perfil remitente
                    this.chat_path_activo = Storage.fncStorageCrearRutaChats(perfil, this.session_activa.getStrEmail());
                    this.es_amigo = false;
                }else{
                    perfil = perfil.substring(0, perfil.lastIndexOf("@"));
                    perfil = perfil + Rutas.extension_rs;
                    // Selecciona el chat desde mi cuenta principal
                    this.chat_path_activo = Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), perfil);
                    this.es_amigo = true;
                }
                
                // Se activa el chat, esto cancela los eventos de los botones 
                // del panel lista de amigos...
                this.chat_activado = true;
                this.fncCambiarEstadoPanelAmigos(false);
                this.fncCambiarEstadoPanelChat(true);
                
                // * Se activa el campo para ver el usuario co el queien estan conversando..
                String titulo = new Session(perfil).getStrNombres() + " " + new Session(perfil).getStrApellidos();
                this.campo_email_chat.setText(titulo);
                
                // * Este color indica, si el chat esta activa.
                this.campo_email_chat.setBackground(new Color(204,255,204));
                this.campo_email_chat.setEnabled(true); // Activiamos
                this.campo_email_chat.setEditable(false); // Pero el titulo no se puede editar
                
                // Se activa el area de mensaje...
                this.txt_mensaje.setFocusable(true);
                
                System.out.println("Ruta del chat: " + this.chat_path_activo  );
                //System.out.println("Iniciando conversacion...");
            }else{
                JOptionPane.showMessageDialog(null, "Lo siento, el chat no existe.");
            }
        }
        
    }

    private void fncEliminarPerfilTo() {
        
        // * Se la rutas obtiene la lista de amigos de mi cuenta p session_activa
        // y se crear un objeto per verificar su existencia...
        String pathA = this.session_activa.stgFriends;
        File amistades = new File(pathA);
        System.out.println("Eliminado amigo..." + this.lista_de_amigos.getSelectedValue());
        
        if(amistades.exists() && this.lista_de_amigos.isSelectionEmpty() == false && this.chat_activado == false
          && this.lista_de_amigos.getSelectedValue().equals("No tienes amigos...") == false){
            
            // *** Recrear el codigo.
            String perfil = this.lista_de_amigos.getSelectedValue();
            String yoker = this.session_activa.getStrEmail();
            
            // Si el email del perfil contiene un * se elminina (No es amigo de session_activa) 
            if( perfil.contains("*") ){
                perfil = perfil.replace("*", "");
                yoker += "*";
            }
            // Por el contario significa que si es amigo de session_activa y solo obtiene el email 
            else{
                perfil = perfil.substring(0, perfil.indexOf("@"));
                perfil += Rutas.extension_rs;
            }
            
            System.out.println("Eliminado a " + perfil);
            int respuesta = JOptionPane.showConfirmDialog(null, "Seguro que deseas eliminar a " + perfil 
                    +"\nDe lista de amigos, se borrara el chat completo." );
                   
            if( respuesta == 0){
                
                // * Eliminar el perfil de mis conversaciones
                //boolean eliC = Storage.fncStorageEliminarUnaLinea(new File( this.session_activa.stgChats ) , perfil );
                //System.out.println("Eliminado = " + eliC);
                
                // * Eliminar el perfil de mi lista de amigos, Todo lo demas se conserva...
                // Notase que se agrega un * esto es para indicar al programa que el no es mi amigo
                boolean eliF = Storage.fncStorageEliminarUnaLinea(new File( this.session_activa.stgFriends ) , perfil + "*" );
                System.out.println("Eliminado = " + eliF);
                
                /*
                
                // * Eliminar mi cuenta o session_activa en .friends de perfil
                Storage.fncStorageEliminarUnaLinea( new File( new Session(perfil).getStrEmail()) , yoker );
                
                // * Verificar si existe una conversacion con el perfil
                String path_chat = Storage.fncStorageCrearRutaChats(this.session_activa.getStrEmail(), perfil);
                if( new File(path_chat).exists() ){
                    
                    // * Copia la conversacion que tengo de perfil hacia perfil
                    String perfil_chat = Storage.fncStorageCrearRutaChats(perfil, perfil);
                    Storage.fncStorageCopiarArchivo(new File(path_chat), perfil_chat );

                    // * Eliminar chat de mi cuenta o session_activa
                    new File(path_chat).delete();
                    
                }
                */

            }

        }
        
    }
}
