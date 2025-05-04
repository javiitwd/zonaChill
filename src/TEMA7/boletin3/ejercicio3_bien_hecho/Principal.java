package TEMA7.boletin3.ejercicio3_bien_hecho;

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

public class Principal {
    public static void main(String[] args) {

        try {
            File file = new File("src/TEMA7/boletin3/ejercicio3_bien_hecho/desayuno.xml");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            System.out.println("Platos de menos de 5 euros: \n" + platosDeMenosDe5Euros(document));
            System.out.println("Platos de menos de 500 calorias : \n" + platosDeMenosDe500Calorias(document));
            annadirAtributoId(document);
            annadirNuevoPlato(document);
        } catch (ParserConfigurationException | IOException | SAXException | DesayunoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String platosDeMenosDe5Euros(Document document) throws DesayunoException {

        NodeList listaDeFood = document.getElementsByTagName("food");

        if (listaDeFood.getLength() == 0) {
            throw new DesayunoException("No hay platos (<food>)");
        }

        StringBuilder platosMenos5Euros = new StringBuilder();
        for (int i = 0; i < listaDeFood.getLength(); i++) {
            if (listaDeFood.item(i) != null && listaDeFood.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element foodActual = (Element) listaDeFood.item(i);
                String name = foodActual.getElementsByTagName("name").item(0).getTextContent();

                Element priceElement = (Element) foodActual.getElementsByTagName("price").item(0);
                String priceString = priceElement.getTextContent();
                String priceFiltrado = priceString.replaceAll(",", ".").replaceAll("€", "");
                double price = Double.parseDouble(priceFiltrado);

                if (price < 5) {
                    platosMenos5Euros.append(name).append(System.lineSeparator());
                }
            }
        }
        return platosMenos5Euros.toString();
    }

    public static String platosDeMenosDe500Calorias(Document document) throws DesayunoException {

        NodeList listaDeFood = document.getElementsByTagName("food");

        if (listaDeFood.getLength() == 0) {
            throw new DesayunoException("No hay platos (<food>)");
        }

        StringBuilder platosMenos500Calorias = new StringBuilder();
        for (int i = 0; i < listaDeFood.getLength(); i++) {
            if (listaDeFood.item(i) != null && listaDeFood.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element foodActual = (Element) listaDeFood.item(i);
                String name = foodActual.getElementsByTagName("name").item(0).getTextContent();

                Element caloriesElement = (Element) foodActual.getElementsByTagName("calories").item(0);
                String caloriesString = caloriesElement.getTextContent();
                double calories = Double.parseDouble(caloriesString);

                if (calories < 500) {
                    platosMenos500Calorias.append(name).append(System.lineSeparator());
                }
            }
        }
        return platosMenos500Calorias.toString();
    }

    public static void annadirAtributoId(Document document) throws DesayunoException {

        NodeList listaDeFood = document.getElementsByTagName("food");

        if (listaDeFood.getLength() == 0) {
            throw new DesayunoException("No hay platos (<food>)");
        }

        for (int i = 0; i < listaDeFood.getLength(); i++) {
            if (listaDeFood.item(i) != null && listaDeFood.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element foodActual = (Element) listaDeFood.item(i);

                foodActual.setAttribute("id", String.valueOf(i + 1));
            }
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource xmlActual = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult rutaAGuardar = new StreamResult("src/TEMA7/boletin3/ejercicio3_bien_hecho/desayunoConId.xml");

            transformer.transform(xmlActual, rutaAGuardar);

        } catch (TransformerException e) {
            throw new DesayunoException(e.getMessage());
        }
    }

    public static void annadirNuevoPlato(Document document) throws DesayunoException {

        Node nodoRaiz = document.getDocumentElement();

        Element newFood = document.createElement("food");

        Element name = document.createElement("name");
        name.setTextContent("Paloma frita");
        Element price = document.createElement("price");
        price.setTextContent("3€");
        Element description = document.createElement("description");
        description.setTextContent("Plato típico de Perú");
        Element calories = document.createElement("calories");
        calories.setTextContent("400");

        newFood.appendChild(name);
        newFood.appendChild(price);
        newFood.appendChild(description);
        newFood.appendChild(calories);

        nodoRaiz.appendChild(newFood);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource xmlActual = new DOMSource(document);
            StreamResult rutaAGuardar = new StreamResult("src/TEMA7/boletin3/ejercicio3_bien_hecho/desayunoConNuevoPlato.xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, rutaAGuardar);

        } catch (TransformerException e) {
            throw new DesayunoException(e.getMessage());
        }
    }
}
