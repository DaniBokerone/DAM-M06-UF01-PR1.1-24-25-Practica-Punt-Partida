package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.project.utilitats.UtilitatsFitxers;



public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        try {
            if (comprobarSiFitxerCompatible(rutaOrigen)) {

                Path origFile = Paths.get(rutaOrigen);
                Path copyFile = Paths.get(rutaDesti);

                String rutaDestiNoArxiu =  copyFile.getParent().toString();
                if (!UtilitatsFitxers.comprobarSiCarpetaExisteix(rutaDestiNoArxiu)) {
                    
                    UtilitatsFitxers.crearCarpetaSiNoExisteix(rutaDestiNoArxiu);
                }

                if (UtilitatsFitxers.comprobarSiArxiuExisteix(rutaDesti)) {
                    System.out.println("L'arxiu de la ruta desti ja existeix, per tant es sobreescriura l'informacio.");
                } else {
                    UtilitatsFitxers.crearArxiu(rutaDesti);
                }

                try (BufferedReader reader = Files.newBufferedReader(origFile, StandardCharsets.UTF_8);
                    BufferedWriter writer = Files.newBufferedWriter(copyFile, StandardCharsets.UTF_8)) {

                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        writer.write(linea);
                        writer.newLine();
                    }

                } catch (IOException e) {
                    System.out.println("S'ha cancelat l'operacio degut a un error en la copia");
                    e.printStackTrace();
                }
                
                System.out.println("S'ha copiat el fitxer correctament al destí");
            }

        } catch (Exception e) {
            System.out.println("S'ha cancelat l'operacio degut a un error");
            e.printStackTrace();
        }
        
    }

    private static Boolean comprobarSiFitxerCompatible(String camiFitxer){

        try {
            if (UtilitatsFitxers.comprobarSiCarpetaExisteix(camiFitxer)) {
                System.out.println("El path de l'arxiu origen no correspon a un arxiu, sinó a una carpeta.");
            }else{
                if(UtilitatsFitxers.comprobarSiArxiuExisteix(camiFitxer)){
                    if (camiFitxer.toLowerCase().endsWith(".txt")) {
                        
                        return true;  
                    } else {
                        System.out.println("El fitxer d'origen no es un arxiu .txt .");
                    }
                }else{
                    System.out.println("El fitxer d'origen no existeix o no es accessible.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura del fitxer: " + camiFitxer);
            e.printStackTrace();
        }

        return false;
    }
}
