package TEMA7.boletin3.ejercicio3.prueba1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {

            File rutaDelXml = new File("src/TEMA7/boletin3/ejercicio3/prueba1/desayuno.xml");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaDelXml);

            System.out.println("Nombre de los platos que cuestan menos de 5 euros: \n" + nombreDePlatosDeMenus5Euros(document));
            System.out.println("Nombre de los platos que cuestan menos de 500 calorias: \n" + nombreDePlatosDeMenus500Calorias(document));
            annadirAPlatosAtributoId(document);
            annadirNuevoPlato(document);
            eliminarPlatosDeMenosDe500Calorias(document);

        } catch (IOException | ParserConfigurationException | SAXException | DesayunoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String nombreDePlatosDeMenus5Euros(Document document) throws DesayunoException {

        NodeList platos = document.getElementsByTagName("plato");

        if (platos.getLength() == 0) {
            throw new DesayunoException("No han encontrado platos");
        }

        StringBuilder nombresDePlatosDeMenosDe5Euros = new StringBuilder();
        for (int i = 0; i < platos.getLength(); i++) {

            if (platos.item(i) != null && platos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element platoActual = (Element) platos.item(i);

                Node nodoPrecio = platoActual.getElementsByTagName("precio").item(0);
                String precioString = nodoPrecio.getTextContent();
                double precio = Double.parseDouble(precioString);

                if (precio < 5) {

                    Node nodoNombre = platoActual.getElementsByTagName("nombre").item(0);
                    String nombre = nodoNombre.getTextContent();
                    nombresDePlatosDeMenosDe5Euros.append(nombre).append(System.lineSeparator());
                }
            }
        }
        return nombresDePlatosDeMenosDe5Euros.toString();
    }

    public static String nombreDePlatosDeMenus500Calorias(Document document) throws DesayunoException {

        NodeList platos = document.getElementsByTagName("plato");

        if (platos.getLength() == 0) {
            throw new DesayunoException("No han encontrado platos");
        }

        StringBuilder nombresDePlatosDeMenosDe500Calorias = new StringBuilder();
        for (int i = 0; i < platos.getLength(); i++) {

            if (platos.item(i) != null && platos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element platoActual = (Element) platos.item(i);

                Node nodoCalorias = platoActual.getElementsByTagName("calorias").item(0);
                String caloriasString = nodoCalorias.getTextContent();
                double calorias = Double.parseDouble(caloriasString);

                if (calorias < 500) {

                    Node nodoNombre = platoActual.getElementsByTagName("nombre").item(0);
                    String nombre = nodoNombre.getTextContent();
                    nombresDePlatosDeMenosDe500Calorias.append(nombre).append(System.lineSeparator());
                }
            }
        }
        return nombresDePlatosDeMenosDe500Calorias.toString();
    }

    public static void annadirAPlatosAtributoId(Document document) throws DesayunoException {

        NodeList platos = document.getElementsByTagName("plato");
        if (platos.getLength() == 0) {
            throw new DesayunoException("No han encontrado platos");
        }

        for (int i = 0; i < platos.getLength(); i++) {

            if (platos.item(i) != null && platos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element platoActual = (Element) platos.item(i);

                //No creamos un Element del documento porque lo que queremos en un atributo
                platoActual.setAttribute("id", String.valueOf(i));
            }
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource archivoActual = new DOMSource(document);
            StreamResult nuevaRuta = new StreamResult("src/TEMA7/boletin3/ejercicio3/prueba1/desayunoConID.xml");

            transformer.transform(archivoActual, nuevaRuta);

        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void annadirNuevoPlato(Document document) {

        Node desayuno = document.getElementsByTagName("desayuno").item(0);

        Element plato = document.createElement("plato");

        Element nombre = document.createElement("nombre");
        nombre.setTextContent("cereales");

        Element precio = document.createElement("precio");
        precio.setTextContent("2");

        Element calorias = document.createElement("calorias");
        calorias.setTextContent("300");

        plato.appendChild(nombre);
        plato.appendChild(precio);
        plato.appendChild(calorias);

        desayuno.appendChild(plato);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult resultado = new StreamResult("src/TEMA7/boletin3/ejercicio3/prueba1/desayunoNuevo.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, resultado);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarPlatosDeMenosDe500Calorias(Document document) {

        NodeList platos = document.getElementsByTagName("plato");
        Node desayuno = document.getElementsByTagName("desayuno").item(0);

        for (int i = 0; i < platos.getLength(); i++) {

            if (platos.item(i) != null && platos.item(i).getNodeType() == Node.ELEMENT_NODE){

                Element platoActual = (Element) platos.item(i);

                Element elementCalorias = (Element) platoActual.getElementsByTagName("calorias").item(0);
                String caloriasString = elementCalorias.getTextContent();
                double calorias = Double.parseDouble(caloriasString);

                if (calorias > 500){


                    //Es importante hacer el remove al padre directo, si se lo hacemos al  document.removeChild(platoActual); dara error
                    desayuno.removeChild(platoActual);
                }
            }
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult resultado = new StreamResult("src/TEMA7/boletin3/ejercicio3/prueba1/desayunoSaludable.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, resultado);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}