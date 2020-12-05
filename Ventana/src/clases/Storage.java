/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author max98
 */
public class Storage {
    
    // * Esto son espacio que dejan entre los mensajes en el chat
    public final static String espacios="\n\n";
    public final static int longitud = 60;
    public final static String identificador_amigo1 = " - Somos amigos.";
    public final static String identificador_amigo2 = " - Amigo+1 Recibido.";
    public final static String identificador_amigo3 = " - Amigo+1 Enviado.";
    public static final String extension_rs = "@gobim.dev";
    
    
    // ******* Método con retorno a boolean *******
    public static boolean fncStorageBorrarUnaLinea(File enArchivo, String eliminar_linea) {
        // Si el File no existe y el String es vacio retorna false
        if (enArchivo.exists() || !eliminar_linea.isEmpty()) {
            try {

                File archivo_tmp = new File(enArchivo.getPath() + "_tmp000.txt");
                if (archivo_tmp.createNewFile()) {

                    try (FileWriter sobrescribirArchivo = new FileWriter(enArchivo.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(enArchivo.getPath()));
                        String linea;

                        while ((linea = leerArchivo.readLine()) != null) {
                            // Sobreescribiendo archivo
                            if ( !linea.trim().contains(eliminar_linea) && !linea.trim().isEmpty() && linea != "\n" ) {
                                sobrescribirArchivo.write(linea.trim() + "\n");
                            }
                        }
                        leerArchivo.close();
                    }

                    // Cambio de storage
                    enArchivo.delete();
                    archivo_tmp.renameTo(new File(enArchivo.getPath()));
                }

            } catch (IOException e) {}

        } else {
            return false;
        }

        return true;
    }
    
    public static boolean fncStorageEliminarUnaLinea(File enArchivo, String eliminar_linea) {
        // Si el File no existe y el String es vacio retorna false
        if (enArchivo.exists() || !eliminar_linea.isEmpty()) {
            try {

                File archivo_tmp = new File(enArchivo.getPath() + "_tmp000.txt");
                if (archivo_tmp.createNewFile()) {

                    try (FileWriter sobrescribirArchivo = new FileWriter(enArchivo.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(enArchivo.getPath()));
                        String linea;

                        while ((linea = leerArchivo.readLine()) != null) {
                            // Sobreescribiendo archivo
                            if ( !linea.trim().equals(eliminar_linea) && !linea.trim().isEmpty() && linea != "\n" ) {
                                sobrescribirArchivo.write(linea.trim() + "\n");
                            }
                        }
                        leerArchivo.close();
                    }

                    // Cambio de storage
                    enArchivo.delete();
                    archivo_tmp.renameTo(new File(enArchivo.getPath()));
                }

            } catch (IOException e) {}

        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageActualizarUnaLinea(String enArchivo, String actualizar_linea) {
        // Devulve true si la condicion se cumple
        return Storage.fncStorageEliminarUnaLinea(new File(enArchivo), actualizar_linea) && Storage.fncStorageAcoplarUnaLinea(enArchivo, actualizar_linea);
    }
    
    public static boolean fncStorageReemplazarUnaLinea(String enArchivo, String enLineaA, String porLineaB) {
        // Devulve true si la condicion se cumple
        return Storage.fncStorageEliminarUnaLinea(new File(enArchivo), enLineaA) && Storage.fncStorageAcoplarUnaLinea(enArchivo, porLineaB);
    }

    public static boolean fncStorageAcoplarUnaLinea(String pathA, String linea) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(pathA).exists() || !linea.isEmpty()) {
            try {
                BufferedWriter escribir = new BufferedWriter(new FileWriter(pathA, true));
                // ** Antes **; + "\n"
                escribir.append(linea + "\n");
                escribir.close();
            } catch (IOException e) {}

        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageEncontrarUnaCuenta(String enPath, String encontrar_cuenta) {
        // Si el File no existe y el String es vacio retorna false
        if ( (new File(enPath).exists() || !encontrar_cuenta.isEmpty()) && encontrar_cuenta.contains(extension_rs)) {
            try {
                
                // * Obtener la cuenta con extension
                if( !encontrar_cuenta.contains("*") ){
                    encontrar_cuenta = encontrar_cuenta.substring(0, encontrar_cuenta.lastIndexOf("@"));
                    encontrar_cuenta = encontrar_cuenta + extension_rs;
                }
                
                BufferedReader db_archivo = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = db_archivo.readLine()) != null) {
                    
                    // Si encuentra la cuenta se rompe el bucle
                    if (linea.equals(encontrar_cuenta) && !linea.isEmpty() && linea.contains(extension_rs)) {
                        return true;
                    }else 
                    if (linea.equals(encontrar_cuenta + Storage.identificador_amigo1) && !linea.isEmpty() && linea.contains(extension_rs)){
                        return true;
                    }
                    
                }
                
                db_archivo.close();

            } catch (IOException e) {}

        } else {
            return false;
        }

        return false;
    }
    
    public static String fncStorageVerificarAmistad(String enPath, String encontrar_cuenta) {
        // Si el File no existe y el String es vacio retorna false
        if ( (new File(enPath).exists() || !encontrar_cuenta.isEmpty()) && encontrar_cuenta.contains(extension_rs)) {
            try {
                
                // * Obtener la cuenta con extension
                if( !encontrar_cuenta.contains("*") ){
                    encontrar_cuenta = encontrar_cuenta.substring(0, encontrar_cuenta.lastIndexOf("@"));
                    encontrar_cuenta = encontrar_cuenta + extension_rs;
                }
                
                BufferedReader db_archivo = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = db_archivo.readLine()) != null) {
                    
                    // Si encuentra la cuenta se rompe el bucle
                    if (linea.contains(encontrar_cuenta) && linea.contains( Storage.identificador_amigo1 ) && !linea.isEmpty() && linea.contains(extension_rs)){
                        return "amigos";
                    }else 
                    if (linea.contains(encontrar_cuenta) && linea.contains( Storage.identificador_amigo2 ) && !linea.isEmpty() && linea.contains(extension_rs)){
                        return "recibido";
                    }else 
                    if (linea.contains(encontrar_cuenta) && linea.contains( Storage.identificador_amigo3 ) && !linea.isEmpty() && linea.contains(extension_rs)){
                        return "enviado";
                    }
                    
                }
                
                db_archivo.close();

            } catch (IOException e) {}

        } else {
            return "error";
        }

        return "none";
    }
    
    public static boolean fncStorageEncontrarUnaLinea(String enPath, String encontrar_linea) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(enPath).exists() || !encontrar_linea.isEmpty()) {

            try {
                BufferedReader archivo = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = archivo.readLine()) != null) {

                    if (linea.equals(encontrar_linea) && !linea.isEmpty()) {
                        return true;
                    }
                }
                
                archivo.close();

            } catch (IOException e) {}

        } else {
            return false;
        }

        return false;
    }

    public static boolean fncStorageBuscarUnaLinea(String enPath, String buscar_linea) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(enPath).exists() || !buscar_linea.isEmpty()) {
            try {
                BufferedReader archivo = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = archivo.readLine()) != null) {

                    if (linea.contains(buscar_linea) && !linea.isEmpty()) {
                        return true;
                    }
                }
                
                archivo.close();
                
            } catch (IOException e) {}
            
        } else {
            return false;
        }

        return false;
    }

    public static boolean fncStorageEliminarDirectorio(File borrar_carpeta) {
        if (borrar_carpeta.exists()) {
            File[] files = borrar_carpeta.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        fncStorageEliminarDirectorio(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
        } else return false;
        
        return (borrar_carpeta.delete());
    }

    public static boolean fncStorageDezplazarArchivo(File enArchivoA, String aArchivoB) throws FileNotFoundException, IOException {
        // Si el File no existe y el String es vacio retorna false

        if (!enArchivoA.exists()) {

            return false;
        } else if (!new File(aArchivoB).exists()) {

            return false;
        } else if (enArchivoA.exists() && new File(aArchivoB).exists()) {

            FileInputStream in = new FileInputStream(enArchivoA.getAbsolutePath());
            FileOutputStream ou = new FileOutputStream(aArchivoB);
            BufferedOutputStream bou;

            try (BufferedInputStream bin = new BufferedInputStream(in)) {
                bou = new BufferedOutputStream(ou);
                int b = 0;
                while (b != -1) {
                    b = bin.read();
                    bou.write(b);
                }
                
                bin.close();
            }

            bou.close();
            

            // Eliminar el archivo original
            enArchivoA.delete();

        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageCopiarArchivo(File deArchivoA, String aArchivoB) {

        if (!deArchivoA.exists()) {

            return false;
        } else if (deArchivoA.exists() && !aArchivoB.isEmpty()) {
            try {
                
                // * Si existe el archivo de destino se elimina
                /*
                if(new File(aArchivoB).exists()){
                    new File(aArchivoB).delete();
                }
                */
                    
                File archivo_tmp = new File(deArchivoA.getPath() + "_tmp000.txt");
                if (archivo_tmp.createNewFile()) {

                    try (FileWriter sobrescribirArchivo = new FileWriter(deArchivoA.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(deArchivoA.getPath()));
                        String linea;

                        while ((linea = leerArchivo.readLine()) != null) {
                            sobrescribirArchivo.write(linea + "\n");
                        }
                        leerArchivo.close();
                    }

                    // Cambio de storage
                    archivo_tmp.renameTo(new File(aArchivoB));
                }

            } catch (IOException e) {}

        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageMoverArchivo(File enArchivoA, String aArchivoB) {

        if (!enArchivoA.exists()) {

            return false;
        } else if (!new File(aArchivoB).exists()) {

            return false;
        } else if (enArchivoA.exists() && !aArchivoB.isEmpty()) {

            try {

                File archivo_tmp = new File(enArchivoA.getPath() + "_tmp000.txt");
                if (archivo_tmp.createNewFile()) {

                    try (FileWriter sobrescribirArchivo = new FileWriter(enArchivoA.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(enArchivoA.getPath()));
                        String linea;

                        while ((linea = leerArchivo.readLine()) != null) {
                            sobrescribirArchivo.write(linea + "\n");
                        }

                        leerArchivo.close();
                    }

                    // Cambio de storage
                    enArchivoA.delete();
                    archivo_tmp.renameTo(new File(aArchivoB));
                }

            } catch (IOException e) {}

        } else {
            return false;
        }

        return true;
    }
    
    
        
    // ******* Método con retorno a String *******
    public static String fncStorageObtenerRutaData(String email) {
        return Rutas.storage_profiles + email + "/profile/" + email + Rutas.extesion_data;
    }

    public static String fncStorageCrearRutaProfile(String email, String extension) {
        return Rutas.storage_profiles + email + "/profile/" + email + extension;
    }

    public static String fncStorageCrearRutaChats(String emailA, String emailB) {
        return Rutas.storage_profiles + emailA + "/chats/" + emailB + Rutas.extesion_chats;
    }
    
    public static String fncStorageFormatearMensaje(String msg){
        String mensaje_nuevo="";
        int posicion = longitud;
        
        if(!msg.isEmpty()){
            for(int item = 0; item < msg.length(); item++){
                
                // Insertar saltos de linea en cada 60 caracteres... 
                if( item == posicion ){
                    
                    // Intentar eliminar los saltos de linea...
                    if( msg.charAt(item) == '\n' ){
                        JOptionPane.showMessageDialog(null, "B {Salto de linea "+ msg.charAt(item) +" encontrado en " + item +" }");
                    } 
                    
                    mensaje_nuevo += "-\n";
                    posicion = (item + longitud);
                    
                }
                
                mensaje_nuevo += msg.charAt(item);
            }
            
        }else return null;
        
        return mensaje_nuevo;
    }
    
    public static String fncStorageCrearMensaje(Session session_activa, String mensaje){
        String remitente = "("+ session_activa.getStrEmail()+")";      
        return remitente + " " + fncObtenerFechayHora() +": \n" + Storage.fncStorageFormatearMensaje(mensaje.trim()) + Storage.espacios;
    }
    
    public static boolean fncStorageRegistrarNotificacion(Session destinatario, String notificacion){
        
        // * Verificar que la cuenta perfil y que el archivo .notify de session_activa exista
        if( new File(destinatario.stgNotify).exists() && Storage.fncStorageEncontrarUnaLinea(Rutas.path_profiles, destinatario.getStrEmail()) ){
           
            String notify = notificacion + ". | " + fncObtenerFechayHora() + "\n";
            
            Storage.fncStorageBorrarUnaLinea(new File(destinatario.stgNotify), notificacion);
            Storage.fncStorageAcoplarUnaLinea(destinatario.stgNotify, notify );
        
        }else return false;
        
        return true;
    }
    
    public static String fncObtenerFechayHora(){
        
        Calendar fechaActual = Calendar.getInstance();
        String cadenaFecha = String.format("%04d-%02d-%02d",
          fechaActual.get(Calendar.YEAR),
          fechaActual.get(Calendar.MONTH)+1,
          fechaActual.get(Calendar.DAY_OF_MONTH));
        
        Calendar a = Calendar.getInstance();
        String horaActual = String.format("%02d:%02d:%02d",
          fechaActual.get(Calendar.HOUR_OF_DAY),
          fechaActual.get(Calendar.MINUTE),
          fechaActual.get(Calendar.SECOND));
        
        return "["+cadenaFecha+" "+horaActual+"]";
    }
    
    public static String fncStorageObtenerImgProfile(Session session_activa) {
        
        String img_profile;
        if( session_activa.getStrImgPerfil().equals("user_default.png") ){
            img_profile = Rutas.path_user_default;  
        }else{
            img_profile = Storage.fncStorageCrearRutaProfile(session_activa.getStrEmail(), Rutas.extesion_svg);
        }
                
        return img_profile;
    }
    
    public static void fncStorageInsertarPicture(JPanel contenedor, String url, boolean vaciar){
        
        if(vaciar) contenedor.removeAll();
        
        ImageIcon icono = new ImageIcon( new File(url).getAbsolutePath() );
        JLabel etiquetaImagen = new JLabel();
        etiquetaImagen.setBounds(0, 0, contenedor.getWidth(), contenedor.getHeight());
        etiquetaImagen.setIcon( new ImageIcon(icono.getImage().getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH)) );
        contenedor.add(etiquetaImagen);
        
        if(vaciar) contenedor.validate();
        if(vaciar) contenedor.repaint();
        
    }
            
}