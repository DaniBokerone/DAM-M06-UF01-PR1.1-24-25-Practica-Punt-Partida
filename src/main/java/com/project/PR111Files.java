package com.project;

import java.io.File;
import java.io.IOException;

import com.project.utilitats.UtilitatsFitxers;

public class PR111Files {

    public static void main(String[] args) throws IOException {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";

        if (!UtilitatsFitxers.comprobarSiCarpetaExisteix(camiFitxer)) {
            UtilitatsFitxers.crearCarpetaSiNoExisteix(camiFitxer);
        }

        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        try {
            String camiCarpeta = camiFitxer + "/myFiles";

            UtilitatsFitxers.crearCarpetaSiNoExisteix(camiCarpeta);

            UtilitatsFitxers.crearArxiuSiNoExisteix(camiCarpeta, "file1.txt");
            UtilitatsFitxers.crearArxiuSiNoExisteix(camiCarpeta, "file2.txt");

            String renameFile = camiCarpeta + "/file2.txt";
            UtilitatsFitxers.renombrarArxiu(renameFile, "renamedFile.txt");

            imprimirNomArchiusEnDirectori(camiCarpeta);

            String deleteFile = camiCarpeta + "/file1.txt";
            UtilitatsFitxers.borrarArxiu(deleteFile);
            
            imprimirNomArchiusEnDirectori(camiCarpeta);

            //Borrar els archius per a poder tornar a fer les probes
            //String deleteRenamedFile = camiFitxer + "/renamedFile.txt";
            
            //UtilitatsFitxers.borrarArxiu(deleteRenamedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void imprimirNomArchiusEnDirectori(String camiFitxer) {
        File directori = new File(camiFitxer);
        File[] llistaArchius = directori.listFiles();

        if (llistaArchius != null) {
            System.out.println("Els arxius de la carpeta són: \n");
            for (File arxiu : llistaArchius) {
                if (arxiu.isFile()) {
                    System.out.println(arxiu.getName());
                }
            }

            System.out.println("\n-------------------------------------\n");
        }
    }
}
