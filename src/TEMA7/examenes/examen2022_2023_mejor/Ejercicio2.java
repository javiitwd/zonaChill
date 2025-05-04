package TEMA7.examenes.examen2022_2023_mejor;

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
            File file = new File("src/TEMA7/examenes/examen2022_2023_mejor/simpsons.xml");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            System.out.println("Muestra por pantalla el título y fecha de emisión de aquellos episodios posteriores a 1992.\n " + mostrarTituloYFechaDeEpisodiosPosterioresA1992(document));

            crearFicheroDeEpisodiosConSinopsisMas30Palabras(document);

            rodearNombresDeLosProtasEnLaSinopsis(document);

        } catch (IOException | ParserConfigurationException | SAXException | Examen2022_2023Excepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String mostrarTituloYFechaDeEpisodiosPosterioresA1992(Document document) throws Examen2022_2023Excepcion {

        NodeList capitulos = document.getElementsByTagName("capitulo");

        if (capitulos.getLength() == 0) {
            throw new Examen2022_2023Excepcion("No se han encontrados capitulos");
        }

        StringBuilder capitulosADevolver = new StringBuilder();
        for (int i = 0; i < capitulos.getLength(); i++) {

            if (capitulos.item(i) != null && capitulos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element capituloActual = (Element) capitulos.item(i);

                Element fechaEmision = (Element) capituloActual.getElementsByTagName("fecha_emision").item(0);
                String fechaEmisionString = fechaEmision.getTextContent();
                String anyoEmisionString = fechaEmisionString.substring(fechaEmisionString.length() - 4);
                int anyoEmision = Integer.parseInt(anyoEmisionString);

                if (anyoEmision > 1992) {

                    String titulo = capituloActual.getElementsByTagName("nombre").item(0).getTextContent();

                    capitulosADevolver.append(titulo).append(", ").append(fechaEmisionString).append(System.lineSeparator());
                }
            }
        }
        return capitulosADevolver.toString();
    }

    public static void crearFicheroDeEpisodiosConSinopsisMas30Palabras(Document document) throws Examen2022_2023Excepcion {

        NodeList capitulos = document.getElementsByTagName("capitulo");

        Node simpsons = document.getElementsByTagName("simpsons").item(0);

        if (capitulos.getLength() == 0) {
            throw new Examen2022_2023Excepcion("No se han encontrados capitulos");
        }

        for (int i = 0; i < capitulos.getLength(); i++) {

            if (capitulos.item(i) != null && capitulos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element capituloActual = (Element) capitulos.item(i);

                String sinopsis = capituloActual.getElementsByTagName("sinopsis").item(0).getTextContent();

                String[] palabrasDeSinopsis = sinopsis.split("\\s+");

                if (palabrasDeSinopsis.length < 30) {

                    simpsons.removeChild(capituloActual);
                }
            }
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource documentoActual = new DOMSource(document);
            StreamResult rutaAGuardarNuevoXml = new StreamResult("src/TEMA7/examenes/examen2022_2023_mejor/simpsons2.xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(documentoActual, rutaAGuardarNuevoXml);
        } catch (TransformerException e) {
            throw new Examen2022_2023Excepcion("Error: " + e.getMessage());
        }
    }

    public static void rodearNombresDeLosProtasEnLaSinopsis(Document document) throws Examen2022_2023Excepcion {

        NodeList capitulos = document.getElementsByTagName("capitulo");

        if (capitulos.getLength() == 0) {
            throw new Examen2022_2023Excepcion("No se han encontrados capitulos");
        }

        Pattern pattern = Pattern.compile("\\b(homer|marge|bart|lisa|maggie)\\b\\.*", Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < capitulos.getLength(); i++) {

            if (capitulos.item(i) != null && capitulos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element capituloActual = (Element) capitulos.item(i);

                Element sinopsisElement = (Element) capituloActual.getElementsByTagName("sinopsis").item(0);
                String sinopsis = sinopsisElement.getTextContent();

                String[] palabrasDeSinopsis = sinopsis.split("\\s+");

                StringBuilder sinopsisModificada = new StringBuilder();

                for (int j = 0; j < palabrasDeSinopsis.length; j++) {
                    String palabraActual = palabrasDeSinopsis[j];

                    Matcher matcher = pattern.matcher(palabraActual);

                    if (matcher.matches()) {

                        String palabraModificada = "**" + palabraActual + "**";
                        sinopsisModificada.append(palabraModificada).append(" ");

                    } else {
                        sinopsisModificada.append(palabraActual).append(" ");
                    }
                }

                capituloActual.removeChild(sinopsisElement);

                Element nuevoElementSinopsis = document.createElement("sinopsis");
                nuevoElementSinopsis.setTextContent(sinopsisModificada.toString());

                capituloActual.appendChild(nuevoElementSinopsis);
            }
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource documentoActual = new DOMSource(document);
            StreamResult rutaAGuardarNuevoXml = new StreamResult("src/TEMA7/examenes/examen2022_2023_mejor/simpsons3.xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(documentoActual, rutaAGuardarNuevoXml);
        } catch (TransformerException e) {
            throw new Examen2022_2023Excepcion("Error: " + e.getMessage());
        }
    }
}
