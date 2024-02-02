/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author yusuf
 */
public class Output {

    public static void Output(ArrayList<String> test) {
        String dosyaAdi = "output.txt"; // Dosya ad�n� istedi�iniz gibi de�i�tirebilirsiniz
        String dosyaYolu = getProjectDir() + "\\" + dosyaAdi;
        System.out.println(dosyaYolu);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu))) {
            for (String eleman : test) {
                writer.write(eleman);
                writer.newLine(); // Her eleman�n ard�na yeni bir sat�r ekleyin
            }

            System.out.println("ArrayList dosyaya ba�ar�yla yaz�ld�. Dosya Yolu: " + dosyaYolu);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProjectDir() {
        return new File(System.getProperty("user.dir")).getParent();
    }

}
