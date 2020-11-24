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

/**
 *
 * @author max98
 */
public class Storage {

    public static void fncStorageEliminarUnaLinea(File archivo, String find_linea){
        if(archivo.exists() && find_linea.isEmpty() == false){
            try {
               
                File archivo_tmp = new File(archivo.getPath() + "_tmp000.txt");
                if(archivo_tmp.createNewFile()){
                    
                    try (FileWriter sobrescribirArchivo = new FileWriter(archivo.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo.getPath()));
                        String linea;
                        
                        while ((linea = leerArchivo.readLine()) != null){
                            // Sobreescribiendo archivo
                            if( !linea.equals(find_linea) )
                                sobrescribirArchivo.write( linea + "\n");
                        }
                        leerArchivo.close();
                    }
                    
                    // Cambio de storage
                    archivo.delete();
                    archivo_tmp.renameTo(new File(archivo.getPath()));
                }
                
            } catch (IOException e) {}
        }
    }
    
    public static void fncStorageAcoplarUnaLinea(String pathA, String linea){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathA, true));
            bw.append(linea + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean fncStorageBuscarUnaLineaProfile(String pathA, String linea_buscado){
        boolean respuesta = false;
        try {
            File archivo = new File( pathA );
            BufferedReader br = new BufferedReader( new FileReader(archivo) );
            String linea; 

            while ((linea = br.readLine()) != null){
                // System.out.println("Buscando .. " + linea_buscado + " con .." + linea);
                if( linea.equals(linea_buscado) && !linea.isEmpty() && linea.contains("@quasar.org") ){
                   respuesta = true;
                   return true;
                }
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            return respuesta;
        }
    }
    
    public static boolean fncStorageBuscarUnaLinea(String pathA, String linea_buscado){
        boolean respuesta = false;
        try {
            File archivo = new File( pathA );
            BufferedReader br = new BufferedReader( new FileReader(archivo) );
            String linea; 

            while ((linea = br.readLine()) != null){
                // System.out.println("Buscando .. " + linea_buscado + " con .." + linea);
                if( linea.equals(linea_buscado) && !linea.isEmpty() ){
                   respuesta = true;
                   return true;
                }
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally{
            return respuesta;
        }
    }
    
    public static String fncStorageObtenerRutaData(String email){
        // System.out.println(" sadasdsdas ----- "+ Rutas.storage_profiles + email + "/profile/" + email + Rutas.extesion_data );
        return Rutas.storage_profiles + email + "/profile/" + email + Rutas.extesion_data;
    }
    
    public static String fncStorageCrearRutaProfile(String email, String extension){
        return  Rutas.storage_profiles + email + "/profile/" + email + extension;
    }
    
    public static String fncStorageCrearRutaChats(String emailA, String emailB, String extension){
        return  Rutas.storage_profiles + emailA + "/chats/" + emailB + extension;
    }
    
    public static String fncStorageCrearRutaChats(String emailA, String emailB){
        return  Rutas.storage_profiles + emailA + "/chats/" + emailB + Rutas.extesion_chats;
    }
    
    public static String fncStorageCrearRutaTemporalProfile(String email, String extension){
        return  Rutas.storage_profiles +  "/" + email + "/profile/.tmp." + email + extension;
    }
    
    public static boolean fncStorageEliminarDirectorio(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null!=files){
                for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        fncStorageEliminarDirectorio(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
                }
            }
        }
        return(directory.delete());
    }
    
    public static void fncStorageDezplazarArchivo(File archivo, String pathB) throws FileNotFoundException, IOException{
        
        if(archivo.exists()){
            System.out.println("******** Moviendo *******");
            System.out.println("De: " + archivo.getAbsolutePath());
            System.out.println("To: " + pathB);
            System.out.println("******** ******** *******");
            
            FileInputStream in = new FileInputStream( archivo.getAbsolutePath() );
            FileOutputStream ou = new FileOutputStream( pathB );
            BufferedOutputStream bou;
            
            try (BufferedInputStream bin = new BufferedInputStream(in)) {
                bou = new BufferedOutputStream(ou);
                int b=0;
                while(b!=-1){
                    b=bin.read();
                    bou.write(b);
                }
            }
            
            bou.close();
            
            // Eliminar el archivo original
            archivo.delete();
            
        }
    }
    
    public static void fncStorageCopiarArchivo(File archivoA, String pathB){
        if(archivoA.exists() && pathB.isEmpty() == false){
            try {
               
                File archivo_tmp = new File(archivoA.getPath() + "_tmp000.txt");
                if(archivo_tmp.createNewFile()){
                    
                    try (FileWriter sobrescribirArchivo = new FileWriter(archivoA.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(archivoA.getPath()));
                        String linea;
                        
                        while ((linea = leerArchivo.readLine()) != null){
                                sobrescribirArchivo.write( linea + "\n");
                        }
                        leerArchivo.close();
                    }
                    
                    // Cambio de storage
                    archivo_tmp.renameTo(new File(pathB));
                }
                
            } catch (IOException e) {}
        }
    }
    
    public static void fncStorageMoverArchivo(File archivoA, String pathB){
        if(archivoA.exists() && pathB.isEmpty() == false){
            try {
               
                File archivo_tmp = new File(archivoA.getPath() + "_tmp000.txt");
                if(archivo_tmp.createNewFile()){
                    
                    try (FileWriter sobrescribirArchivo = new FileWriter(archivoA.getPath() + "_tmp000.txt")) {
                        BufferedReader leerArchivo = new BufferedReader(new FileReader(archivoA.getPath()));
                        String linea;
                        
                        while ((linea = leerArchivo.readLine()) != null){
                                sobrescribirArchivo.write( linea + "\n");
                        }
                        leerArchivo.close();
                    }
                    
                    // Cambio de storage
                    archivoA.delete();
                    archivo_tmp.renameTo(new File(pathB));
                }
                
            } catch (IOException e) {}
        }
    }
    
}
