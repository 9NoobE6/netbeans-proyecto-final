/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
import javax.swing.JOptionPane;

/**
 *
 * @author max98
 */
public class Storage {
    
    // * Esto son espacio que dejan entre los mensajes en el chat
    public final static String espacios="\n\n";
    
    
    // ******* Método con retorno a boolean *******
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
                            if (!linea.equals(eliminar_linea)) {
                                sobrescribirArchivo.write(linea + "\n");
                            }
                        }
                        leerArchivo.close();
                    }

                    // Cambio de storage
                    enArchivo.delete();
                    archivo_tmp.renameTo(new File(enArchivo.getPath()));
                }

            } catch (IOException e) {
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageActualizarUnaLinea(String enArchivo, String actualizar_linea) {
        // Devulve true si la condicion se cumple
        return Storage.fncStorageEliminarUnaLinea(new File(enArchivo), actualizar_linea) && Storage.fncStorageAcoplarUnaLinea(enArchivo, actualizar_linea);
    }

    public static boolean fncStorageAcoplarUnaLinea(String pathA, String linea) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(pathA).exists() || !linea.isEmpty()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathA, true));
                // ** Antes **; + "\n"
                bw.append(linea + "\n");
                bw.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageEncontrarUnaCuenta(String enPath, String encontrar_cuenta) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(enPath).exists() || !encontrar_cuenta.isEmpty()) {
            try {

                BufferedReader br = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = br.readLine()) != null) {
                    // Si encuentra la cuenta se rompe el bucle
                    if (linea.equals(encontrar_cuenta) && !linea.isEmpty() && linea.contains(Rutas.extension_rs)) {
                        return true;
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            return false;
        }

        return false;
    }

    public static boolean fncStorageEncontrarUnaLinea(String enPath, String encontrar_linea) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(enPath).exists() || !encontrar_linea.isEmpty()) {

            try {
                BufferedReader br = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = br.readLine()) != null) {
                    // System.out.println("Buscando .. " + linea_buscado + " con .." + linea);
                    if (linea.equals(encontrar_linea) && !linea.isEmpty()) {
                        return true;
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            return false;
        }

        return false;
    }

    public static boolean fncStorageBuscarUnaLinea(String enPath, String buscar_linea) {
        // Si el File no existe y el String es vacio retorna false
        if (new File(enPath).exists() || !buscar_linea.isEmpty()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File(enPath)));
                String linea;

                while ((linea = br.readLine()) != null) {
                    // System.out.println("Buscando .. " + linea_buscado + " con .." + linea);
                    if (linea.contains(buscar_linea) && !linea.isEmpty()) {
                        return true;
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
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
            System.out.println("archivo no existe.");

            return false;
        } else if (!new File(aArchivoB).exists()) {
            System.out.println("pathB no existe.");

            return false;
        } else if (enArchivoA.exists() && new File(aArchivoB).exists()) {
            System.out.println("******** Moviendo *******");
            System.out.println("De: " + enArchivoA.getAbsolutePath());
            System.out.println("To: " + aArchivoB);
            System.out.println("******** ******** *******");

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
            System.out.println("archivoA no existe.");

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

            } catch (IOException e) {
            }

        } else {
            return false;
        }

        return true;
    }

    public static boolean fncStorageMoverArchivo(File enArchivoA, String aArchivoB) {

        if (!enArchivoA.exists()) {
            System.out.println("archivoA no existe.");

            return false;
        } else if (!new File(aArchivoB).exists()) {
            System.out.println("pathB no existe.");

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

            } catch (IOException e) {
            }

        } else {
            return false;
        }

        return true;
    }
    
    public static String fncStorageFormatearMensaje(String msg){
        String mensaje_nuevo="";
        int longitud = 70;
        int posicion = longitud;
        
        if(!msg.isEmpty()){
            int linea=0;
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
                
                
                //System.out.println(":::"+mensaje_nuevo);
            }
            
        }else return null;
        
        return mensaje_nuevo;
    }

    // ******* Método con retorno a String *******
    public static String fncStorageObtenerRutaData(String email) {
        // System.out.println(" sadasdsdas ----- "+ Rutas.storage_profiles + email + "/profile/" + email + Rutas.extesion_data );
        return Rutas.storage_profiles + email + "/profile/" + email + Rutas.extesion_data;
    }

    public static String fncStorageCrearRutaProfile(String email, String extension) {
        return Rutas.storage_profiles + email + "/profile/" + email + extension;
    }

    public static String fncStorageCrearRutaChats(String emailA, String emailB) {
        return Rutas.storage_profiles + emailA + "/chats/" + emailB + Rutas.extesion_chats;
    }

}
