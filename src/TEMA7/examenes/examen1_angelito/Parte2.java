package TEMA7.examenes.examen1_angelito;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.Path;

public class Parte2 {
    public static void main(String[] args) {

        try {
            Path path = Path.of("src/TEMA7/examenes/examen1_angelito/desayuno.xml");
            Document documentXml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(path.toFile());

            arreglarXml(documentXml);
            Path pathArreglado = Path.of("src/TEMA7/examenes/examen1_angelito/desayunoArreglado.xml");
            Document documentXmlArreglado = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(pathArreglado.toFile());

            annadirId(documentXmlArreglado);

            eliminarPlatosMenos5Euros(documentXmlArreglado);

            System.out.println("Precio medio y total: " + sumaPrecioTotalYMedio(documentXmlArreglado));

            annadirPlato(documentXmlArreglado);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static void arreglarXml(Document document) {

        NodeList platos = document.getElementsByTagName("plato");
        for (int i = 0; i < platos.getLength(); i++) {
            Element platoActual = (Element) platos.item(i);

            Element precioAntes = (Element) platoActual.getElementsByTagName("precio").item(0);
            String textoPrecioAntes = precioAntes.getTextContent();

            String precioFinal = textoPrecioAntes.replace(",", ".").replace("€", "").trim();

            precioAntes.setTextContent(precioFinal);
        }
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlNuevo = new StreamResult("src/TEMA7/examenes/examen1_angelito/desayunoArreglado.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, xmlNuevo);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void annadirId(Document document) {

        NodeList platos = document.getElementsByTagName("plato");
        for (int i = 0; i < platos.getLength(); i++) {
            Element platoActual = (Element) platos.item(i);

            platoActual.setAttribute("id", String.valueOf(1000 + (i + 1)));
        }
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlNuevo = new StreamResult("src/TEMA7/examenes/examen1_angelito/desayunoConId.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, xmlNuevo);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String sumaPrecioTotalYMedio(Document document) {

        NodeList precios = document.getElementsByTagName("precio");

        double sumaTotal = 0;
        for (int i = 0; i < precios.getLength(); i++) {

            String precioActualString = precios.item(i).getTextContent();
            double precioActual = Double.parseDouble(precioActualString);
            sumaTotal += precioActual;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("Suma total: ").append(sumaTotal).append(" - Media: ").append(String.valueOf(sumaTotal / precios.getLength()));
        return sb.toString();
    }

    public static void eliminarPlatosMenos5Euros(Document document) {

        Element desayuno = (Element) document.getElementsByTagName("desayuno").item(0);

        NodeList platos = document.getElementsByTagName("plato");
        for (int i = 0; i < platos.getLength(); i++) {
            Element platoActual = (Element) platos.item(i);

            double precio = Double.parseDouble(platoActual.getElementsByTagName("precio").item(0).getTextContent());

            if (precio > 5) {
                desayuno.removeChild(platoActual);
                i--;
            }
        }
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlNuevo = new StreamResult("src/TEMA7/examenes/examen1_angelito/desayunoBaratito.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, xmlNuevo);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void annadirPlato(Document document) {

        Element desayuno = (Element) document.getElementsByTagName("desayuno").item(0);

        Element plato = document.createElement("plato");
        Element precio = document.createElement("precio");
        precio.setTextContent("3,8 €");
        Element nombre = document.createElement("nombre");
        nombre.setTextContent("Smoothie de frutas");
        Element calorias = document.createElement("calorias");
        calorias.setTextContent("290");

        plato.appendChild(nombre);
        plato.appendChild(precio);
        plato.appendChild(calorias);

        desayuno.appendChild(plato);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlNuevo = new StreamResult("src/TEMA7/examenes/examen1_angelito/desayunoNuevo.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, xmlNuevo);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
