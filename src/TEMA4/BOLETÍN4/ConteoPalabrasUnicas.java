/*
Conteo de palabras únicas:
Escribe una función que reciba un texto y devuelva cuántas palabras
únicas hay en él, ignorando mayúsculas y signos de puntuación.
Entrada: "Hola, hola mundo. El mundo es increíble"
Salida esperada: 4 (palabras únicas: hola, mundo, el, es, increíble)
*/
package TEMA4.BOLETÍN4;

public class ConteoPalabrasUnicas {
    public static void main(String[] args) {
            String cadena = "Hola, hola mundo. El mundo es increíble".toLowerCase();
            StringBuilder textoLimpio = new StringBuilder();

            for (int i = 0; i < cadena.length(); i++) {
                char c = cadena.charAt(i);
                if ((c >= 'a' && c <= 'z') || c == ' ') {
                    textoLimpio.append(c);
                }
            }
            String[] palabras = textoLimpio.toString().split(" ");

            String[] palabrasUnicas = new String[palabras.length];

            int contadorPalabrasUnicas = 0;
            //Repasar bien este bucle con booleanos para entender bien el funcionamiento.
            for (int i = 0; i < palabras.length; i++) {
                boolean yaExiste = false;
                for (int j = 0; j < contadorPalabrasUnicas; j++) {
                    if (palabrasUnicas[j].equalsIgnoreCase(palabras[i])) {
                        yaExiste = true;
                        break;
                    }
                }
                if (!yaExiste) {
                    palabrasUnicas[contadorPalabrasUnicas] = palabras[i];
                    contadorPalabrasUnicas++;
                }
            }
            for (int i = 0; i < contadorPalabrasUnicas; i++) {
                System.out.print(palabrasUnicas[i] + " ");

            }
        }
}
