package com.project;

import java.io.File;
import java.io.IOException;
import com.project.utilitats.UtilitatsFitxers;

public class PR111Files {

    public static void main(String[] args) throws IOException {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        String camiCarpeta = "/myFiles";
        String camiDefinitiu = camiFitxer + camiCarpeta;

        if (!UtilitatsFitxers.comprobarSiCarpetaExisteix(camiDefinitiu)) {
            UtilitatsFitxers.crearCarpetaSiNoExisteix(camiDefinitiu);
        }

        gestionarArxius(camiDefinitiu);
    }

    public static void gestionarArxius(String camiFitxer) {
        try {
            UtilitatsFitxers.crearArxiuSiNoExisteix(camiFitxer, "file1.txt");
            UtilitatsFitxers.crearArxiuSiNoExisteix(camiFitxer, "file2.txt");

            String renameFile = camiFitxer + "/file2.txt";
            UtilitatsFitxers.renombrarArxiu(renameFile, "renamedFile.txt");

            imprimirNomArchiusEnDirectori(camiFitxer);

            String deleteFile = camiFitxer + "/file1.txt";
            UtilitatsFitxers.borrarArxiu(deleteFile);
            
            imprimirNomArchiusEnDirectori(camiFitxer);

            //Borrar els archius per a poder tornar a fer les probes
            String deleteRenamedFile = camiFitxer + "/renamedFile.txt";
            
            UtilitatsFitxers.borrarArxiu(deleteRenamedFile);
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
