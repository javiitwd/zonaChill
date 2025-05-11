package TEMA7.examenes.prueba_bermudo.prueba1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

        StringBuilder resumen = new StringBuilder();

        File rutaXml = null;
        try {
            if (Files.exists(Path.of("src/TEMA7/examenes/prueba_bermudo/prueba1/catalogo_videojuegos.xml"))) {
                rutaXml = new File("src/TEMA7/examenes/prueba_bermudo/prueba1/catalogo_videojuegos.xml");
            } else {
                throw new CatalogoVideojuegosExcepcion("Ruta no encontrada");
            }
            Document documentoXml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaXml);

            List<Videojuego> listaDeVideojuegos = cargarXmlEnLista(documentoXml, resumen);

            generarFicheros(listaDeVideojuegos, resumen);

            System.out.println(resumen);


        } catch (IOException | ParserConfigurationException | SAXException | CatalogoVideojuegosExcepcion e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Videojuego> cargarXmlEnLista(Document documentoXml, StringBuilder resumen) throws CatalogoVideojuegosExcepcion {
        resumen.append("PROCESO DE CARGAR XML EN LA LISTA \n");
        List<Videojuego> listaDeVideojuegos = new LinkedList<>();

        NodeList nodosVideojuegos = documentoXml.getElementsByTagName("videojuego");

        if (nodosVideojuegos.getLength() == 0) {
            throw new CatalogoVideojuegosExcepcion("No hay etiquetas <videojuego> en el XML");
        }

        int contadorVideojuegosLeidos = 0;
        for (int i = 0; i < nodosVideojuegos.getLength(); i++) {
            Element elementoCideojuegoActual = (Element) nodosVideojuegos.item(i);
            contadorVideojuegosLeidos++;

            Videojuego videojuegoActual = crearVideojuego(elementoCideojuegoActual, resumen);

            if (videojuegoActual != null) {
                listaDeVideojuegos.add(videojuegoActual);
            }
        }
        resumen.append("Videojuegos leidos:  ").append(contadorVideojuegosLeidos).append("\n");
        return listaDeVideojuegos;
    }

    public static Videojuego crearVideojuego(Element elementoVideojuego, StringBuilder resumen) {
        boolean videojuegoValido = true;

        String titulo = "";
        Node nodoTitulo = elementoVideojuego.getElementsByTagName("titulo").item(0);
        if (nodoTitulo != null) {
            titulo = nodoTitulo.getTextContent();
        } else {
            videojuegoValido = false;
            resumen.append("Se ha intentado registrar un videojuego sin título\\n");
        }

        String id = "";
        if (elementoVideojuego.hasAttribute("id")) {
            id = elementoVideojuego.getAttribute("id");
        } else {
            videojuegoValido = false;
            resumen.append("Se ha intentado registrar un videojuego sin id\n");
        }

        String desarrollador = "";
        Node nodoDesarrollador = elementoVideojuego.getElementsByTagName("desarrollador").item(0);
        if (nodoDesarrollador != null) {
            desarrollador = nodoDesarrollador.getTextContent();
        } else {
            videojuegoValido = false;
            resumen.append("Se ha intentado registrar un videojuego sin desarrollador\n");
        }

        int lanzamiento = 0;
        Node nodoLanzamiento = elementoVideojuego.getElementsByTagName("lanzamiento").item(0);
        if (nodoLanzamiento != null) {
            lanzamiento = Integer.parseInt(elementoVideojuego.getElementsByTagName("lanzamiento").item(0).getTextContent());
        } else {
            videojuegoValido = false;
            resumen.append("Se ha intentado registrar un videojuego sin año de lanzamiento\n");
        }

        String plataforma = "";
        Node nodoPlataforma = elementoVideojuego.getElementsByTagName("plataforma").item(0);
        if (nodoPlataforma != null) {
            plataforma = nodoPlataforma.getTextContent();
        } else {
            videojuegoValido = false;
            resumen.append("Se ha intentado registrar un videojuego sin plataforma\n");
        }

        String genero = "";
        Node nodoGenero = elementoVideojuego.getElementsByTagName("genero").item(0);
        if (nodoGenero != null) {
            genero = nodoGenero.getTextContent();
        } else {
            videojuegoValido = false;
            resumen.append("Se ha intentado registrar un videojuego sin género\n");
        }

        String descripcion = "no disponible";
        Node nodoDescripcion = elementoVideojuego.getElementsByTagName("descripcion").item(0);
        if (nodoDescripcion != null) {
            descripcion = nodoDescripcion.getTextContent();
        }

        if (videojuegoValido) {
            return new Videojuego(id, titulo, desarrollador, lanzamiento, plataforma, genero, descripcion);
        }
        return null;
    }

    public static String extraerPEGI(Videojuego videojuego) {

        Pattern patronPegi = Pattern.compile("\\bPEGI: (\\d{2})\\b");
        String pegi = "no disponible.";

        String descripcion = videojuego.getDescripcion();

        Matcher matcher = patronPegi.matcher(descripcion);

        if (matcher.find()) {
            pegi = matcher.group(1);
        }
        return pegi;
    }

    public static void generarFicheros(List<Videojuego> listaDeVideojuegos, StringBuilder resumen) throws CatalogoVideojuegosExcepcion {

        if (listaDeVideojuegos.isEmpty()) {
            throw new CatalogoVideojuegosExcepcion("No se ha encontrado videojuegos en la lista");
        }

        int contadorFichasCreadas = 0;
        for (int i = 0; i < listaDeVideojuegos.size(); i++) {
            Videojuego videojuegoActual = listaDeVideojuegos.get(i);

            String titulo = videojuegoActual.getTitulo();
            String id = videojuegoActual.getId();
            String tituloNormalizado = normalizarTexto(titulo.toLowerCase());

            String fichaVideojuegoActual = crearFichaVideojuegos(videojuegoActual);

            Path rutaFichaActual = Path.of("src/TEMA7//examenes/prueba_bermudo/prueba1/" + tituloNormalizado + "_" + id + ".txt");

            try {
                Files.writeString(rutaFichaActual, fichaVideojuegoActual, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                contadorFichasCreadas++;

            } catch (IOException e) {
                resumen.append(e.getMessage());
            }
        }
        resumen.append("Fichas creadas: ").append(contadorFichasCreadas);
    }

    public static String normalizarTexto(String texto) {
        Pattern pattern = Pattern.compile("([^\\p{Alnum}|-])");

        Matcher matcher = pattern.matcher(texto);

        String textoNormalizado = texto;
        if (matcher.find()) {
            textoNormalizado = matcher.replaceAll("_");
        }
        return textoNormalizado;
    }

    public static String crearFichaVideojuegos(Videojuego videojuego) {

        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("FICHA DEL VIDEOJUEGO\n");
        sb.append("========================================\n");
        sb.append("Título: ").append(videojuego.getTitulo());
        sb.append("\n");
        sb.append("Desarrollador: ").append(videojuego.getDesarrollador());
        sb.append("\n");
        sb.append("Año lanzamiento: ").append(videojuego.getLanzamiento());
        sb.append("\n");
        sb.append("Género: ").append(videojuego.getGenero());
        sb.append("\n");
        sb.append("Plataformas: ").append(videojuego.getPlataforma());
        sb.append("\n");
        sb.append("PEGI: ").append(extraerPEGI(videojuego));
        sb.append("\n");
        sb.append("========================================\n");
        sb.append("Descripción: ").append(videojuego.getDescripcion().trim().replaceAll("\\s{2,}", "\n"));
        sb.append("\n");
        sb.append("========================================\n");
        return sb.toString();
    }
}
