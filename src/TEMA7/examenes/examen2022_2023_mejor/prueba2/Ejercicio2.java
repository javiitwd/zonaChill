package TEMA7.examenes.examen2022_2023_mejor.prueba2;

import TEMA7.examenes.prueba_bermudo.ExamenException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {
    public static void main(String[] args) {

        try {

            File rutaXml = new File("src/TEMA7/examenes/examen2022_2023_mejor/prueba2/simpsons.xml");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaXml);

            System.out.println("Episodios posteriores a 1992: \n" + episodiosPosterioresA1992(document));

            guardarCapConSinopsisMas30Palabras(document);

            crearXMLNombresProtasRodeados(document);

        } catch (IOException | ParserConfigurationException | SAXException | ExamenException e) {
            throw new RuntimeException(e);
        }
    }

    public static String episodiosPosterioresA1992(Document document) throws ExamenException {

        NodeList capitulos = document.getElementsByTagName("capitulo");

        StringBuilder sb = new StringBuilder();
        if (capitulos.getLength() == 0) {
            throw new ExamenException("No hay <capitulo>");
        }

        for (int i = 0; i < capitulos.getLength(); i++) {
            Element capituloActual = (Element) capitulos.item(i);

            if (capituloEsPosterior1992(capituloActual)) {
                sb.append(nombreYFechaCapitulo(capituloActual)).append("\n");
            }
        }
        return sb.toString();
    }

    public static boolean capituloEsPosterior1992(Element capitulo) {

        Pattern patronAnyo = Pattern.compile("\\b(\\d{4})\\b");
        String fecha_emision = capitulo.getElementsByTagName("fecha_emision").item(0).getTextContent();

        Matcher matcher = patronAnyo.matcher(fecha_emision);

        if (matcher.find()) {
            int anyo = Integer.parseInt(matcher.group(1));
            if (anyo > 1992) {
                return true;
            }
        }
        return false;
    }

    public static String nombreYFechaCapitulo(Element capitulo) {

        StringBuilder sb = new StringBuilder();

        String nombre = capitulo.getElementsByTagName("nombre").item(0).getTextContent();
        String fecha_emision = capitulo.getElementsByTagName("fecha_emision").item(0).getTextContent();

        sb.append("Nombre: ").append(nombre).append(", fecha de emisión: ").append(fecha_emision);
        return sb.toString();
    }

    public static void guardarCapConSinopsisMas30Palabras(Document document) throws ExamenException {

        Node nodoRaiz = document.getDocumentElement();
        NodeList capitulos = document.getElementsByTagName("capitulo");

        if (capitulos.getLength() == 0) {
            throw new ExamenException("No hay <capitulo>");
        }

        for (int i = 0; i < capitulos.getLength(); i++) {
            Element capituloActual = (Element) capitulos.item(i);

            if (!sinopsisTieneMas30Palabras(capituloActual)) {
                nodoRaiz.removeChild(capituloActual);
                i--;
            }
        }

        // Guardamos el XML modificado
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlNuevo = new StreamResult("src//TEMA7/examenes/examen2022_2023_mejor/prueba2/simpsonsNuevo.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(xmlActual, xmlNuevo);

        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean sinopsisTieneMas30Palabras(Element capitulo) {

        Pattern patronPalabras = Pattern.compile("\\b\\p{L}+\\b");

        String sinopsisString = capitulo.getElementsByTagName("sinopsis").item(0).getTextContent();

        Matcher matcher = patronPalabras.matcher(sinopsisString);

        int contador = 0;
        while (matcher.find()) contador++;

        return contador > 30;
    }

    public static void crearXMLNombresProtasRodeados(Document document) throws ExamenException {

        NodeList capitulos = document.getElementsByTagName("capitulo");

        if (capitulos.getLength() == 0) {
            throw new ExamenException("No hay <capitulo>");
        }

        for (int i = 0; i < capitulos.getLength(); i++) {
            Element capituloActual = (Element) capitulos.item(i);

            Pattern patronNombres = Pattern.compile("\\b(bart|marge|lisa|homer|maggie)\\b", Pattern.CASE_INSENSITIVE);
            Element sinopsis = (Element) capituloActual.getElementsByTagName("sinopsis").item(0);
            String sinopsisString = sinopsis.getTextContent();

            Matcher matcher = patronNombres.matcher(sinopsisString);

            // Mientras encuentre coincidencias con el patron,
            // cambiara ese matcher por la coincidencia (matcher.group())
            // despues añadira ** antes y detras de la coincidencia

            String sinopsisModificada = matcher.replaceAll(m -> "**" + matcher.group() + "**");
            sinopsis.setTextContent(sinopsisModificada);
        }

        // Guardamos el XML modificado
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlNuevo = new StreamResult("src//TEMA7/examenes/examen2022_2023_mejor/prueba2/simpsonsRodeados.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(xmlActual, xmlNuevo);

        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
