/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana_people;

import clases.Session;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import jpanelimagen.ImagenFondo;
import ventana_pricipal.Principal;
import ventana_singup.SingUp;

/**
 *
 * @author max98
 */
public class People extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public People() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public People(Session session_activa) {
        this.session_activa = session_activa;
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.panel_3_Background.setImagenFondo(new ImagenFondo( new java.io.File( getClass().getResource("/img/b4.jpg").getPath() ), 1.0f ));
        this.campo_email.setText( this.session_activa.getStrEmail() );
        this.setTitle( this.session_activa.getStrNombres() + " - " + this.session_activa.getStrEmail()  );
        
        // *** Testing ... sin funcionar
        JScrollPane scrollBar=new JScrollPane(this.panel_cuentas,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollBar.setVisible(true);
        scrollBar.setEnabled(true);
        this.add( scrollBar );
        
        try{
             
            ActionListener tarea = (ActionEvent e) -> {
               this.fncSincronizandoMensajes();
            };

           observador.addActionListener(tarea);
           observador.start();
           
        }catch(Exception a){}
    }

    public Session getSession_activa() {
        return session_activa;
    }

    public void setSession_activa(Session session_activa) {
        this.session_activa = session_activa;
    }
    
    public void fncAgregarCuentas(){
        int t=0;
        for(int item=0; item < 20; item++){
            Cuenta a = new Cuenta();
            a.setBounds(item, t , 600, 200);
            this.panel_cuentas.add(a);
            this.panel_cuentas.validate();
            this.panel_cuentas.repaint();
            t += 200 + 20;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_3_Background = new jpanelimagen.JPanelImagen();
        jPanel1 = new javax.swing.JPanel();
        campo_email = new javax.swing.JTextField();
        bntVolver = new javax.swing.JButton();
        panel_cuentas = new javax.swing.JPanel();

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

        javax.swing.GroupLayout panel_cuentasLayout = new javax.swing.GroupLayout(panel_cuentas);
        panel_cuentas.setLayout(panel_cuentasLayout);
        panel_cuentasLayout.setHorizontalGroup(
            panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        panel_cuentasLayout.setVerticalGroup(
            panel_cuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_3_BackgroundLayout = new javax.swing.GroupLayout(panel_3_Background);
        panel_3_Background.setLayout(panel_3_BackgroundLayout);
        panel_3_BackgroundLayout.setHorizontalGroup(
            panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel_3_BackgroundLayout.setVerticalGroup(
            panel_3_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_3_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_cuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JTextField campo_email;
    private javax.swing.JPanel jPanel1;
    private jpanelimagen.JPanelImagen panel_3_Background;
    private javax.swing.JPanel panel_cuentas;
    // End of variables declaration//GEN-END:variables
    Session session_activa;
    JScrollPane myJScrollPane;
    private ActionListener oyente;
    private Timer observador = new Timer(1000, oyente);
 
    private void fncSincronizandoMensajes() {
        System.out.println("::: Observador People :::");
        
        /* // 
        this.mensajes.removeAllElements();
        this.llistaMensajes.removeAll();
        DefaultListModel a = new DefaultListModel();
        
        File archivo = new File( Rutas.db_chat + session_activa.getStrEmail() + ".txt" );
        BufferedReader br = new BufferedReader( new FileReader(archivo) );
        String st; 
        
        while ((st = br.readLine()) != null){
            mensajes.addElement(st);
        }
        
        this.llistaMensajes.setModel(mensajes);
        this.llistaMensajes.setAutoscrolls(true);
        this.llistaMensajes.setSelectedIndex( 1 );
        //System.out.println(st); 
        */
        
    }
}
