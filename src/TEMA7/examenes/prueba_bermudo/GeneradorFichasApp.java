package TEMA7.examenes.prueba_bermudo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneradorFichasApp {
    public static void main(String[] args) {

        try {
            File rutaXml = new File("src/TEMA7/examenes/prueba_bermudo/catalogo_videojuegos.xml");
            Document documentoXml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaXml);

            List<Videojuego> listaDeVideojuegos = cargarDatosAColeccion(documentoXml);

            generarFichas(listaDeVideojuegos);


        } catch (IOException | ParserConfigurationException | SAXException | ExamenException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Videojuego> cargarDatosAColeccion(Document documentoXml) throws ExamenException {

        List<Videojuego> listaDeVideojuegos = new LinkedList<>();

        NodeList nodosVideojuegos = documentoXml.getElementsByTagName("videojuego");

        if (nodosVideojuegos.getLength() == 0) {
            throw new ExamenException("No hay videojuegos");
        }

        for (int i = 0; i < nodosVideojuegos.getLength(); i++) {
            Element videojuegoActual = (Element) nodosVideojuegos.item(i);

            String titulo = videojuegoActual.getElementsByTagName("titulo").item(0).getTextContent();
            String desarrollador = videojuegoActual.getElementsByTagName("desarrollador").item(0).getTextContent();
            int lanzamiento = Integer.parseInt(videojuegoActual.getElementsByTagName("lanzamiento").item(0).getTextContent());
            String plataforma = videojuegoActual.getElementsByTagName("plataforma").item(0).getTextContent();
            String genero = videojuegoActual.getElementsByTagName("genero").item(0).getTextContent();
            String descripcion = "no hay descripción";
            if (videojuegoActual.getElementsByTagName("descripcion").getLength() == 1) {
                descripcion = videojuegoActual.getElementsByTagName("descripcion").item(0).getTextContent();
            }
            String id = videojuegoActual.getAttribute("id");

            Videojuego nuevoVideojuego = new Videojuego(titulo, desarrollador, lanzamiento, plataforma, genero, descripcion, id);

            listaDeVideojuegos.add(nuevoVideojuego);
        }
        return listaDeVideojuegos;
    }

    public static String pegiVideojuego(Videojuego videojuego) {

        Pattern pattern = Pattern.compile("PEGI: (\\d{1,2})");

        String descripcion = videojuego.getDescripcion();

        Matcher matcher = pattern.matcher(descripcion);

        String pegi = "no encontrada.";
        if (matcher.find()) {
            pegi = matcher.group(1);
        }

        return pegi;
    }

    public static void generarFichas(List<Videojuego> listaDeVideojuegos) {

        Pattern pattern = Pattern.compile("[^\\p{Alnum}|-]");
        for (int i = 0; i < listaDeVideojuegos.size(); i++) {

            String titulo = listaDeVideojuegos.get(i).getTitulo().toLowerCase();
            String id = listaDeVideojuegos.get(i).getId();

            Matcher matcher = pattern.matcher(titulo);
            String tituloNormalizado = matcher.replaceAll("_");

            String nombreFichero = tituloNormalizado + "_" + id + ".txt";

            Path rutaAEnviarFichero = Path.of("src/TEMA7/examenes/prueba_bermudo/" + nombreFichero);

            String fichaDelVideojuegoActual = crearFichaVideojuego(listaDeVideojuegos.get(i));

            try {
                Files.writeString(rutaAEnviarFichero, fichaDelVideojuegoActual, StandardOpenOption.CREATE);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String crearFichaVideojuego(Videojuego videojuego) {

        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("FICHA DEL VIDEOJUEGO\n");
        sb.append("========================================\n");
        sb.append("ID: ").append(videojuego.getId()).append("\n");
        sb.append("Titulo: ").append(videojuego.getTitulo()).append("\n");
        sb.append("Desarrollador: ").append(videojuego.getDesarrolador()).append("\n");
        sb.append("Año de Lanzamiento: ").append(videojuego.getLanzamiento()).append("\n");
        sb.append("PEGI: ").append(pegiVideojuego(videojuego)).append("\n");
        sb.append("ID: ").append(videojuego.getId()).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("Descripción: \n");
        sb.append(videojuego.getDescripcion().trim().replaceAll("\\s{2,}", "\n")).append("\n");
        sb.append("========================================\n");

        return sb.toString();
    }
}
