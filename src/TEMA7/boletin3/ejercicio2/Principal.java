package TEMA7.boletin3.ejercicio2;

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

        decirTitulo();

        try {
            System.out.println("Contamos div -> " + contarDivisores());
            System.out.println("Contamos div con atributos -> " + contarDivisoresConAtributosId());
            System.out.println("Textos alternativos -> " + mostrarTextoAlternativoDeImagenes());
            System.out.println("Mostrar opciones del menu: " + mostrarOpcionesMenu());

        } catch (IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void decirTitulo() {

        try {
            //Cargamos el html
            File rutaDelHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaDelHtml);

            //Normalizamos el documento
            // normalize() limpia todo eso -> Une nodos de texto separados.
            //Quita nodos vacíos inútiles y Deja el documento bien organizado para que puedas recorrerlo correctamente.
            documento.getDocumentElement().normalize();

            // Buscar el elemento <title>
            NodeList nodeList = documento.getElementsByTagName("title");

            if (nodeList.getLength() > 0) {
                String titulo = nodeList.item(0).getTextContent();
                System.out.println("El titulo de la página es: " + titulo);
            } else {
                System.out.println("No se encontró titulo en el html");
            }

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static int contarDivisores() throws IOException, SAXException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            NodeList listaDiv = documento.getElementsByTagName("div");

            return listaDiv.getLength();

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            throw new IOException("Ha ocurrido algún error");
        }
    }

    public static int contarDivisoresConAtributosId() throws IOException, SAXException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            NodeList listaDiv = documento.getElementsByTagName("div");

            if (listaDiv.getLength() < 1) {
                throw new IOException("No se han encontrado <div>");
            }

            int contadorDeAtributosInicializados = 0;
            for (int i = 0; i < listaDiv.getLength(); i++) {

                // Guardamos cada posicion de la lista de Nodos que hemos creado (cada div encontrado)
                Node div = listaDiv.item(i);

                //Como el div puede tener varios atributos...
                //Metemos en un Map todos los atributos (en este caso solo 1 -> "id" pero si hubieran mas se meterian tambien)
                //El Map esta formado la clave que seria el nombre del atributo y su valor seria el valor literal Ej id(k),2(v)
                NamedNodeMap namedNodeMap = div.getAttributes();

                //Guardamos el conjunto clave-valor de la clave llamada "id"
                Node nodoId = namedNodeMap.getNamedItem("id"); // -> Ej de lo que guardaria: <id="3">

                //Si el div tiene valores inicializados aumentamos el contador de divs
                if (nodoId != null && !nodoId.getNodeValue().isEmpty()) {
                    contadorDeAtributosInicializados++;
                }
            }
            return contadorDeAtributosInicializados;

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            throw new IOException("Ha ocurrido algún error");
        }
    }

    public static String mostrarTextoAlternativoDeImagenes() throws IOException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            NodeList listNodoImg = documento.getElementsByTagName("img");

            if (listNodoImg.getLength() < 1) {
                throw new IOException("No se han encontrado <IMG>");
            }

            StringBuilder textosAlternativos = new StringBuilder();

            for (int i = 0; i < listNodoImg.getLength(); i++) {

                //Guardamos el Nodo img (etiqueta img)
                Node img = listNodoImg.item(i);

                //Hacemos un Map con los atributos del img
                NamedNodeMap mapImgAtributos = img.getAttributes();

                //Guardamos el conjunto clave-valor del atributo "alt"
                Node atributoAlt = mapImgAtributos.getNamedItem("alt");

                //Añadimos el valor (del conjunto clave-valor de "alt") al StringBuilder
                textosAlternativos.append(atributoAlt.getNodeValue()).append("\n");
            }

            return textosAlternativos.toString();

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }

        throw new IOException("Ha ocurrido algun error");
    }

    public static String mostrarOpcionesMenu() {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            Node nodoNav = documento.getElementsByTagName("nav").item(0);

            //Guardamos los ul que encontreemos
            NodeList nodosUl = nodoNav.getChildNodes();

            //Nos aseguramos de que ul sea un Nodo
            Node nodoUl = null;
            for (int i = 0; i < nodosUl.getLength(); i++) {
                //Guardamos cada ul
                Node nodo = nodosUl.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE && nodo.getNodeName().equals("ul")) {
                    nodoUl = nodo;
                    break;
                }
            }

            if (nodoUl == null) {
                return "No se encontró el menú.";
            }

            NodeList listaNodosLi = nodoUl.getChildNodes();

            StringBuilder textoOpciones = new StringBuilder();
            for (int i = 0; i < listaNodosLi.getLength(); i++) {
                Node nodoLi = listaNodosLi.item(i);

                if (nodoLi.getNodeType() == Node.ELEMENT_NODE && nodoLi.getNodeName().equals("li")) {

                    // Buscar el <a> dentro del <li>
                    NodeList hijosLi = nodoLi.getChildNodes();
                    for (int j = 0; j < hijosLi.getLength(); j++) {
                        Node nodoA = hijosLi.item(j);
                        if (nodoA.getNodeType() == Node.ELEMENT_NODE && nodoA.getNodeName().equals("a")) {
                            textoOpciones.append(nodoA.getTextContent().trim()).append(System.lineSeparator());
                        }
                    }
                }
            }
            return textoOpciones.toString();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}