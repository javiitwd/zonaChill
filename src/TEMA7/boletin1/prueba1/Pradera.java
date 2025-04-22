package TEMA7.boletin1.prueba1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pradera {
    public static void main(String[] args) {

        invertirColoresPradera();
    }

    public static void invertirColoresPradera() {


        try {

            File ruta = new File("src/TEMA7/boletin1/pradera.bmp");

            if (!ruta.exists()) {
                throw new IOException("La ruta no existe");
            }

            BufferedImage imagen = ImageIO.read(ruta);

            if (imagen == null) {
                throw new IOException("La imagen no existe");
            }

            for (int i = 0; i < imagen.getWidth(); i++) {
                for (int j = 0; j < imagen.getHeight(); j++) {

                    int color = imagen.getRGB(i, j);

                    int rojo = (color >> 16) & 0xFF;
                    int verde = (color >> 8) & 0xFF;
                    int azul = color & 0xFF;

                    int rojoInvertido = 255 - rojo;
                    int verdeInvertido = 255 - verde;
                    int azulInvertido = 255 - azul;

                    int colorNuevo = rojoInvertido << 16 | verdeInvertido << 8 | azulInvertido;

                    imagen.setRGB(i, j, colorNuevo);

                }
            }

            File rutaNueva = new File("src/TEMA7/boletin1/praderaInversa.bmp");
            ImageIO.write(imagen, "BMP", rutaNueva);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
