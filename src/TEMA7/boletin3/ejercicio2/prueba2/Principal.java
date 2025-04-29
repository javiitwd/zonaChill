package TEMA7.boletin3.ejercicio2.prueba2;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        try {
            System.out.println("Titulo -> " + mostrarTitulo());
            System.out.println("Contar <div> -> " + contarDivisores());
            System.out.println("Contar <div> con atributos id con valor -> " + contarDivisoresConValorEnId());
            System.out.println("Textos alternativos de imagenes -> " + mostrarTextoAlternativosDeImagenes());
            System.out.println("Opciones del menu -> " + mostrarOpcionesDelMenu());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String mostrarTitulo() {

        try {
            // Cargamos el html
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaHtml);

            // Normalizamos para que no haya errores
            document.getDocumentElement().normalize();

            NodeList nodeListTitle = document.getElementsByTagName("title");

            if (nodeListTitle.getLength() > 0) {
                return nodeListTitle.item(0).getTextContent();
            } else {
                return "No se encontró el titulo";
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
        return "Ha ocurrido un error";
    }

    public static int contarDivisores() throws IOException {

        try {
            // Cargamos el html
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaHtml);

            // Normalizamos para que no haya errores
            document.getDocumentElement().normalize();

            NodeList nodeListDiv = document.getElementsByTagName("div");

            return nodeListDiv.getLength();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new IOException("Ha ocurrido un error");
    }

    public static int contarDivisoresConValorEnId() throws IOException {

        try {
            // Cargamos el html
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaHtml);

            // Normalizamos para que no haya errores
            document.getDocumentElement().normalize();

            NodeList nodeListDiv = document.getElementsByTagName("div");

            if (nodeListDiv.getLength() < 0) {
                throw new IOException("No hay atributos div");
            }

            int contadorDiv = 0;
            for (int i = 0; i < nodeListDiv.getLength(); i++) {

                //Por cada <div>(i)...
                //Hacemos un Map en el que guardaremos todos los atributos del div y sus valores (Ej id(k), 4(v))
                NamedNodeMap nodeListAtributosDiv = nodeListDiv.item(i).getAttributes();

                //Del Map de atributos solo cogemos en conjunto clave-valor del atributo id
                Node nodeAtributoIdDeDiv = nodeListAtributosDiv.getNamedItem("id");

                //Miramos si el atributos tiene valor (esta inicializado), si es asi aumentamos el contador
                if (nodeAtributoIdDeDiv != null && !nodeAtributoIdDeDiv.getNodeValue().isEmpty()) {
                    contadorDiv++;
                }
            }

            return contadorDiv;

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new IOException("Ha ocurrido un error");
    }

    public static String mostrarTextoAlternativosDeImagenes() throws IOException {

        try {
            // Cargamos el html
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaHtml);

            // Normalizamos para que no haya errores
            document.getDocumentElement().normalize();

            NodeList nodeListImg = document.getElementsByTagName("img");

            if (nodeListImg.getLength() < 0) {
                throw new IOException("No hay <img>");
            }

            StringBuilder textosAlternativos = new StringBuilder();
            for (int i = 0; i < nodeListImg.getLength(); i++) {

                NamedNodeMap namedNodeMapAtributosDeImg = nodeListImg.item(i).getAttributes();

                Node nodeAtributoAltDeImg = namedNodeMapAtributosDeImg.getNamedItem("alt");

                if (nodeAtributoAltDeImg != null && !nodeAtributoAltDeImg.getNodeValue().isEmpty()) {

                    textosAlternativos.append(nodeAtributoAltDeImg.getNodeValue()).append(System.lineSeparator());
                }
            }
            return textosAlternativos.toString();


        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new IOException("Ha ocurrido algún error");
    }

    public static String mostrarOpcionesDelMenu() throws IOException {

        try {
            // Cargamos el html
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaHtml);

            // Normalizamos para que no haya errores
            document.getDocumentElement().normalize();

            Node nodeNav = document.getElementsByTagName("nav").item(0);

            NodeList nodeListUl = nodeNav.getChildNodes();
            Node nodeUl = null;

            for (int i = 0; i < nodeListUl.getLength(); i++) {

                Node nodeUlDeI = nodeListUl.item(i);

                //Comprobamos que el nodo es realmente un Nodo y ademas <ul> (ya que a veces puedes ocurrir errores y dar valores nulos)
                if (nodeUlDeI.getNodeType() == Node.ELEMENT_NODE && nodeUlDeI.getNodeName().equals("ul")) {
                    nodeUl = nodeUlDeI;
                    break;
                }
            }

            if (nodeUl == null){
                throw new IOException("No se encontro el menu");
            }

            NodeList nodeListLi = nodeUl.getChildNodes();

            StringBuilder opcionesMenu = new StringBuilder();
            for (int i = 0; i < nodeListLi.getLength(); i++) {

                //Guardamos el Nodo actual
                Node nodeI = nodeListLi.item(i);

                //Nos aseguramos que la posicion i contiene un Nodo <li>
                if (nodeI.getNodeType() == Node.ELEMENT_NODE && nodeI.getNodeName().equals("li")){

                    NodeList nodosHijosDeLi = nodeI.getChildNodes();

                    for (int j = 0; j < nodosHijosDeLi.getLength(); j++) {

                        Node nodeA = nodosHijosDeLi.item(i);

                        if (nodeA != null && nodeA.getNodeType() == Node.ELEMENT_NODE && nodeA.getNodeName().equals("a")){

                            opcionesMenu.append(nodeA.getTextContent()).append(System.lineSeparator());
                        }
                    }
                }
            }

            return opcionesMenu.toString();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new IOException("Ha ocurrido un error");
    }
}
