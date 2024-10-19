package com.project;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al fitxer amb UTF-8 i línia en blanc final
    public static void afegirFrases(String camiFitxer) {

        List<String> frases = new ArrayList<>(Arrays.asList(
            "I can only show you the door",
            "You're the one that has to walk through it"
        ));

        try {
            File fitxer = new File(camiFitxer);
            if (!fitxer.exists()) {
                fitxer.createNewFile();
            }

            Files.write(Paths.get(camiFitxer), frases, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            System.out.println("S'han afegit correctament les frases a l'arxiu");
        } catch (IOException e) {
            System.err.println("Error al escriure el fitxer: " + e.getMessage());
        }
    }
}
