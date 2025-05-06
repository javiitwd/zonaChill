package TEMA7.examenes.libros_chelu;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("src/TEMA7/examenes/libros_chelu/libros.html");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            System.out.println("Titulo: " + tituloPagina(document));
            System.out.println("Parrafos: " + contarParrafos(document));
            System.out.println("Enlaces y textos que contiene: \n" + mostrarEnlacesYTextos(document));
            System.out.println("Titulos de destacados: \n" + mostrarTitulosLibrosDestacados(document));
            System.out.println("Contenido del pie de pagina: \n" + contenidoPiePagina(document));
            System.out.println("Opciones del menú (generos disponibles): \n" + mostrarGenerosDisponibles(document));
            System.out.println("Libro más autor : \n" + tituloLibroMasNombreAutor(document));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String tituloPagina(Document document) {

        return document.getElementsByTagName("title").item(0).getTextContent();
    }

    public static int contarParrafos(Document document) {

        return document.getElementsByTagName("p").getLength();
    }

    public static String mostrarEnlacesYTextos(Document document) {

        StringBuilder sb = new StringBuilder();
        NodeList listaDeA = document.getElementsByTagName("a");

        for (int i = 0; i < listaDeA.getLength(); i++) {

            Element aActual = (Element) listaDeA.item(i);

            if (aActual.hasAttribute("href")) {

                String valorDeHref = aActual.getAttribute("href");
                String textoDentro = aActual.getTextContent();
                sb.append(valorDeHref).append(" --> ").append(textoDentro).append("\n");
            }
        }
        return sb.toString();
    }

    public static String mostrarTitulosLibrosDestacados(Document document) {

        StringBuilder sb = new StringBuilder();
        NodeList listaDeArticulos = document.getElementsByTagName("article");

        for (int i = 0; i < listaDeArticulos.getLength(); i++) {
            Element articuloActual = (Element) listaDeArticulos.item(i);

            if (articuloActual.hasAttribute("class")) {

                String valorDeClass = articuloActual.getAttribute("class");
                if (valorDeClass.equals("destacado")) {
                    Element h3 = (Element) articuloActual.getElementsByTagName("h3").item(0);
                    String tituloH3 = h3.getTextContent();
                    sb.append(tituloH3).append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static String contenidoPiePagina(Document document) {

        Element footer = (Element) document.getElementsByTagName("footer").item(0);
        return footer.getElementsByTagName("p").item(0).getTextContent();
    }

    public static String mostrarGenerosDisponibles(Document document) {

        Element nav = (Element) document.getElementsByTagName("nav").item(0);

        StringBuilder sb = new StringBuilder();

        if (nav.hasAttribute("id")) {
            String valorAtributoId = nav.getAttribute("id");

            if (valorAtributoId.equals("generos")) {

                Element ul = (Element) nav.getElementsByTagName("ul").item(0);

                NodeList listDeLi = ul.getElementsByTagName("li");

                for (int i = 0; i < listDeLi.getLength(); i++) {

                    sb.append(listDeLi.item(i).getTextContent()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static String tituloLibroMasNombreAutor(Document document) {

        NodeList listaDeSection = document.getElementsByTagName("section");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaDeSection.getLength(); i++) {

            Element sectionActual = (Element) listaDeSection.item(i);

            Element h2 = (Element) sectionActual.getElementsByTagName("h2").item(0);
            Element p = (Element) sectionActual.getElementsByTagName("p").item(0);

            sb.append(h2.getTextContent()).append(" -> ").append(p.getTextContent()).append("\n");
        }
        return sb.toString();
    }
}
