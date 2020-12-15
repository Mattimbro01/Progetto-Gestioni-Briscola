/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class FileCSV {

    public FileCSV(String src) {
        this.src = src;
    }

     public  JCarta[]  leggiCSV() throws FileNotFoundException, IOException {
        String riga;
        JCarta[] array = new JCarta[30];
        int numEl = 0;
        FileReader file = new FileReader(src);
        BufferedReader buffer = new BufferedReader(file);
        while (true) {
            riga = buffer.readLine();
            if (riga != null) {
               array[numEl]=new JCarta(riga);
                numEl++;
            } else {
                break;
            }
           
        }
         return array;
    }

    public void ScriviFile(ArrayList<String> b, String source) throws IOException {
        FileWriter file = new FileWriter(source);
        for (int i = 0; i < b.size(); i++) {
            file.write(b.get(i) + "\n");
        }
        file.flush();
    }
    private String src;
}
