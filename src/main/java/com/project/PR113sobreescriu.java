package com.project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {
        
        List<String> frases = new ArrayList<>(Arrays.asList(
            "I Show You How Deep The Rabbit-Hole Goes",
            "Have You Ever Had A Dream, Neo, That You Were So Sure Was Real?"
        ));

        frases.add(" "); 

        try {
            Files.write(Paths.get(camiFitxer), frases, StandardCharsets.UTF_8);
            System.out.println("S'ha sobrescrit correctament l'arxiu");
        } catch (IOException e) {
            System.err.println("Error al escriure el fitxer: " + e.getMessage());
        }
    }
}
