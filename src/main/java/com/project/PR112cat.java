package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.project.utilitats.UtilitatsFitxers;


public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
        // Ruta d'exemple utilitzada desde l'arrel : ./data/pr112/example.txt
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        
        try {
            if(UtilitatsFitxers.comprobarSiCarpetaExisteix(rutaArxiu)){
                System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
            }else{
                if(UtilitatsFitxers.comprobarSiArxiuExisteix(rutaArxiu)){
                    try {
                        List<String> linies = Files.readAllLines(Paths.get(rutaArxiu), StandardCharsets.UTF_8);
                        mostrarLinies(linies);
                    } catch (IOException e) {
                        System.out.println("Error en la lectura del fitxer: " + rutaArxiu);
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("El fitxer no existeix o no és accessible.");
                }
            }

        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    public static void mostrarLinies(List<String> linies) {
        for (String linia : linies) {
            System.out.println(linia);
        }
    }

}
