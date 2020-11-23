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
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        lista_de_amigos = new javax.swing.JList<>();
        bntEliminar = new javax.swing.JButton();
        bntVerPerfil = new javax.swing.JButton();
        bntAbrirChat = new javax.swing.JButton();
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

        jScrollPane1.setViewportView(lista_de_amigos);

        bntEliminar.setBackground(new java.awt.Color(153, 51, 0));
        bntEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bntEliminar.setText("Eliminar");
        bntEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntEliminarMouseReleased(evt);
            }
        });

        bntVerPerfil.setBackground(new java.awt.Color(0, 0, 102));
        bntVerPerfil.setForeground(new java.awt.Color(255, 255, 255));
        bntVerPerfil.setText("Ver perfil");

        bntAbrirChat.setBackground(new java.awt.Color(0, 102, 0));
        bntAbrirChat.setForeground(new java.awt.Color(255, 255, 255));
        bntAbrirChat.setText("Abrir chat");
        bntAbrirChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bntAbrirChatMouseReleased(evt);
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
                        .addComponent(bntEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntAbrirChat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntVerPerfil)))
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
                    .addComponent(bntEliminar)
                    .addComponent(bntVerPerfil)
                    .addComponent(bntAbrirChat))
                .addContainerGap())
        );

        panel_contenedor_chat.setBackground(new java.awt.Color(0, 153, 153));
        panel_contenedor_chat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        panel_contenedor_chat.setEnabled(false);

        txt_mensaje.setColumns(20);
        txt_mensaje.setRows(5);
        jScrollPane2.setViewportView(txt_mensaje);

        jScrollPane3.setViewportView(lista_mensajes);

        bntEnviarMensaje.setBackground(new java.awt.Color(0, 153, 0));
        bntEnviarMensaje.setForeground(new java.awt.Color(255, 255, 255));
        bntEnviarMensaje.setText("Enviar mensaje");

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
                .addComponent(jScrollPane3)
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
        // TODO add your handling code here:
        SingUp ventana_singup = new SingUp( new Session( this.session_activa.getStrEmail() ));
        ventana_singup.setVisible(true);
        
        this.observador.stop();
        ventana_singup.setSession_activa(this.session_activa);
        this.dispose();
        System.out.println("*** People:::De vuelto a ventana SingUp");

    }//GEN-LAST:event_bntVolverMouseReleased

    private void bntAbrirChatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntAbrirChatMouseReleased
        // TODO add your handling code here:
        this.fncCambiarEstadoPanelAmigos(false);
        this.fncCambiarEstadoPanelChat(true);
        System.out.println("Iniciando conversacion...");
        
    }//GEN-LAST:event_bntAbrirChatMouseReleased

    private void btnCerrarChatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarChatMouseReleased
        // TODO add your handling code here:
        this.fncCambiarEstadoPanelAmigos(true);
        this.fncCambiarEstadoPanelChat(false);
        System.out.println("Finalizó la conversacion...");
        
    }//GEN-LAST:event_btnCerrarChatMouseReleased

    private void bntEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntEliminarMouseReleased
        // TODO add your handling code here:
        
        String pathA = Storage.fncStorageCrearRutaProfile(this.session_activa.getStrEmail(), Rutas.extesion_friends);
        File amistades = new File(pathA);
        System.out.println("Eliminado amigo..." + this.lista_de_amigos.getSelectedValue());
        if(amistades.exists() && this.lista_de_amigos.isSelectionEmpty() == false ){
            try {
                int respuesta = JOptionPane.showConfirmDialog(null, "Seguro que deseas elimiar a tu amigo?");
                
                if( respuesta == 0){
                    String pathB = Storage.fncStorageCrearRutaTemporal(this.session_activa.getStrEmail(), Rutas.extesion_friends);
                    File tmp_amistades = new File(pathB);
                    if(tmp_amistades.createNewFile()){
                        FileWriter sobrescribirArchivo = new FileWriter(pathB);
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(pathA));
                        String linea;

                         while ((linea = leerArchivo.readLine()) != null){
                            // Sobreescribiendo archivo
                            if( !this.lista_de_amigos.getSelectedValue().equals(linea) )
                                sobrescribirArchivo.write( linea + "\n");
                        }
                        leerArchivo.close();
                        sobrescribirArchivo.close();

                        // Cambio de storage
                        amistades.delete();
                        tmp_amistades.renameTo(new File(pathA));
                    }
                }
                
            } catch (IOException e) {}
        }
        
    }//GEN-LAST:event_bntEliminarMouseReleased

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
    private javax.swing.JButton bntAbrirChat;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntEnviarMensaje;
    private javax.swing.JButton bntVerPerfil;
    private javax.swing.JButton bntVolver;
    private javax.swing.JButton btnCerrarChat;
    private javax.swing.JTextField campo_email;
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
    public static Session session_activa;
    private ActionListener oyente;
    private Timer observador = new Timer(1000, oyente);
    private long size_friendship;
    private int coordenadaY=20;
    private boolean chat_activado=false;
    DefaultListModel mensajes = new DefaultListModel();
    DefaultListModel amigos = new DefaultListModel();
    
    private void fncInicializarVentana(){
        this.setLocationRelativeTo(null);
        this.panel_3_Background.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b4.jpg").getPath() ), 1.0f ));
        this.panel_contenedor_chat.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b1.jpg").getPath() ), 0.1f ));
        this.panel_lista_de_amigos.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b1.jpg").getPath() ), 0.1f ));
        this.campo_email.setText( this.session_activa.getStrEmail() );
        this.setTitle( this.session_activa.getStrNombres() + " - " + this.session_activa.getStrEmail()  );
        this.fncCambiarEstadoPanelChat(false);
        
        try{
             
            ActionListener tarea = (ActionEvent e) -> {
                try {
                    this.fncSincronizarMensajes();
                    this.fncSincronizarAmigos();
                } catch (IOException ex) {
                    Logger.getLogger(Chats.class.getName()).log(Level.SEVERE, null, ex);
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
        String path = Storage.fncStorageCrearRutaProfile(this.session_activa.getStrEmail(), Rutas.extesion_friends);
        long _size_ = this.fncObtenerTamahnoStorages(path);
        
        if( _size_ > this.size_friendship || _size_ < this.size_friendship ){
            this.amigos.removeAllElements();
            this.lista_de_amigos.removeAll();

            File archivo = new File( path );
            BufferedReader br = new BufferedReader( new FileReader(archivo) );
            String st; 

            while ((st = br.readLine()) != null){
                this.amigos.addElement(st);
            }

            this.lista_de_amigos.setModel(this.amigos);
            this.size_friendship = _size_;
        } 
    }

    private void fncSincronizarMensajes() {
        System.out.println("::: Observador Chats :::");
    }
}
