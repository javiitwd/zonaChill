package TEMA7.boletin1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PruebaMP3 {
    public static void main(String[] args) {

        try (FileReader mp3 = new FileReader("C:\\Users\\alumno\\Downloads\\0103.Fun Time - ShamaluevMusic.mp3")) {

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alumno\\Downloads\\0103.Fun Time - ShamaluevMusic.mp3"));

            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
