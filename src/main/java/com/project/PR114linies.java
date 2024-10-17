package com.project;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.project.utilitats.UtilitatsFitxers;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        try {
            List<String> numeros = generarLlistaDeNumeros();

            escriureNumerosAlArxiu(camiFitxer,numeros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escriureNumerosAlArxiu(String camiFitxer, List<String> numeros) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(camiFitxer))) {

            for (int i = 0; i < numeros.size(); i++) {
                //Pasa el numero a texte
                writer.write(numeros.get(i).toString());  
                if (i < numeros.size() - 1) { 
                    //Salt de linea 
                    writer.newLine();  
                }
            }

        }
    }

    private static  List<String> generarLlistaDeNumeros(){
        List<String> numeros = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int numeroRandom = random.nextInt(100); 
            numeros.add(String.valueOf(numeroRandom));
        }

        return numeros;

    }
}
