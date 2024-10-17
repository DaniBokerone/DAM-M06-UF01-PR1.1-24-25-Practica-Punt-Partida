package com.project.utilitats;

import java.io.File;
import java.io.IOException;

public class UtilitatsFitxers {
    
    // Directoris
    public static boolean comprobarSiCarpetaExisteix(String camiFitxer) throws IOException {
        File fitxer = new File(camiFitxer);

        if (fitxer.exists() && fitxer.isDirectory()) {
            if (!fitxer.canRead() || !fitxer.canWrite()) {
                throw new IOException("Error: el directori ja existeix però no té els permisos correctes.");
            }
            return true;  // La carpeta existeix
        }
        return false; // La carpeta no existeix
    }

    public static void crearCarpetaSiNoExisteix(String camiFitxer) throws IOException {
        File fitxer = new File(camiFitxer);

        if (fitxer.exists() && fitxer.isFile()) {
            throw new IOException("Error: el camí especificat és un fitxer i ja existeix.");
        }

        if (!fitxer.exists()) {
            if (!fitxer.mkdirs()) {
                throw new IOException("Error en la creació de la carpeta " + fitxer.getPath());
            }
        }
    }

    // Fitxers
    public static void crearArxiuSiNoExisteix(String camiFitxer, String nomFitxer) throws IOException {
        File filePath = new File(camiFitxer);

        if (!filePath.exists() || !filePath.isDirectory()) {
            throw new IOException("Error: el directori no existeix.");
        }

        if (!filePath.canRead() || !filePath.canWrite()) {
            throw new IOException("Error: el directori no té permisos d'escriptura.");
        }

        File tempFile = new File(filePath, nomFitxer);
        if (tempFile.exists()) {
            throw new IOException("Error: Ja existeix aquest fitxer en aquesta ubicació.");
        }

        if (!crearArxiu(tempFile.getPath())) {
            throw new IOException("Error: No s'ha pogut crear l'arxiu.");
        }
    }

    public static boolean crearArxiu(String camiFitxer) throws IOException {
        File fitxer = new File(camiFitxer);
        return fitxer.createNewFile();
    }

    public static boolean borrarArxiu(String camiFitxer) {
        File fitxer = new File(camiFitxer);
        return fitxer.delete();
    }

    public static boolean renombrarArxiu(String camiFitxer, String nouNom) {
        File fitxer = new File(camiFitxer);
        File fitxerRenombrat = new File(fitxer.getParent(), nouNom);
        return fitxer.renameTo(fitxerRenombrat);
    }

    public static boolean comprobarSiArxiuExisteix(String camiFitxer) throws IOException {
        File fitxer = new File(camiFitxer);

        if (fitxer.exists() && fitxer.isFile()) {
            if (!fitxer.canRead() || !fitxer.canWrite()) {
                throw new IOException("El fitxer no existeix o no és accessible.");
            }
            return true;  // Arxiu existeix
        }
        return false; // Arxiu no existeix
    }
}
