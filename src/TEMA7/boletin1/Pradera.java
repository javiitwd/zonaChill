package TEMA7.boletin1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Pradera {

    public static void main(String[] args) {
        try {
            // Guardamos la ruta de la imagen en una variable tipo File. Pero el archivo en sí no se abre
            // ni lee hasta que usamos ese objeto con ImageIO.read() para cargar la imagen.
            File archivoEntrada = new File("C:\\Users\\alumno\\Downloads\\pradera.bmp");
            if (!archivoEntrada.exists()) {
                System.out.println("El archivo no existe en la ruta especificada.");
                return;
            }

            // Cargar la imagen BMP. Ahora tienes la imagen cargada en el objeto BufferedImage.
            // A partir de aquí, puedes manipular la imagen.
            BufferedImage imagen = ImageIO.read(archivoEntrada);
            if (imagen == null) {
                System.out.println("No se pudo cargar la imagen. Verifica el formato.");
                return;
            }

            // Recorrer todos los píxeles y aplicar la inversión de colores
            for (int i = 0; i < imagen.getWidth(); i++) {
                for (int j = 0; j < imagen.getHeight(); j++) {
                    // Obtener el color del píxel
                    int color = imagen.getRGB(i, j);

                    // Extraer los valores de los componentes rojo, verde y azul
                    // usamos int rojo = (color >> 16) & 0xFF -> para quedarnos solo con el color rojo, ya que los bits estan repartidos asi:
                    // Original: AAAAAAAA RRRRRRRR GGGGGGGG BBBBBBBB
                    // Por eso para quedarnos solo con el rojo lo desplazamos 16 bits a la derecha (>>16   → 00000000 00000000 AAAAAAAA RRRRRRRR)
                    //0xFF -> Esta es una máscara binaria. Lo que hace es quedarse con solo los últimos 8 bits (el rojo ahora está ahí).

                    int rojo = (color >> 16) & 0xFF;
                    int verde = (color >> 8) & 0xFF;
                    int azul = color & 0xFF;

                    // Invertir los colores
                    rojo = 255 - rojo;
                    verde = 255 - verde;
                    azul = 255 - azul;

                    // Crear el nuevo color invertido
                    // volvemos a desplazar los colores a su posicion original
                    int colorInvertido = (rojo << 16) | (verde << 8) | azul;

                    // Establecer el color invertido en el píxel actual
                    imagen.setRGB(i, j, colorInvertido);
                }
            }

            // Guardar la imagen invertida
            File archivoSalida = new File("C:\\Users\\alumno\\Downloads\\imagen_invertida.bmp");
            ImageIO.write(imagen, "BMP", archivoSalida);

            System.out.println("Imagen invertida guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
