package TEMA7.boletin3.ejercicio2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {
    public static void main(String[] args) {

        try {
            System.out.println("Titulo -> " + decirTitulo());
            System.out.println("Numero de <div> -> " + contarDivisores());
            System.out.println("Numero de <div> con atributos inicializados -> " + contarDivisoresConAtributosId());
            System.out.println("Textos alternativos de imagenes -> " + mostrarTextoAlternativoDeImagenes());
            System.out.println("Titulos mas textos alternativos -> \n" + mostrarTitularDeNoticiaMasTextoAlternativo());
            System.out.println("Opciones del menú -> \n" + mostrarOpcionesMenu());
            System.out.println("Mostrar titular de noticias mas párrafo \n" + mostrarTitularDeNoticiaMasParrafo());

            // Ejercicio de examen:
            // contar cuantos elementos del html que contenga la clase "menu" como tal, no -menu o menu-
            System.out.println("Elementos encontrados -> " + contarCuantosElementosTieneLaClaseMenuRecursivo());

        } catch (IOException | SAXException | WebException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String decirTitulo() throws IOException, WebException {

        try {
            //Cargamos el html
            File rutaDelHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaDelHtml);

            //Normalizamos el documento
            // normalize() limpia todo eso -> Une nodos de texto separados.
            //Quita nodos vacíos inútiles y Deja el documento bien organizado para que puedas recorrerlo correctamente.
            documento.getDocumentElement().normalize();

            // Buscar el elemento <title>
            NodeList nodeList = documento.getElementsByTagName("title");

            if (nodeList.getLength() != 0) {
                String titulo = nodeList.item(0).getTextContent();
                return "El titulo de la página es: " + titulo;
            } else {
                return "No se encontró titulo en el html";
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            throw new WebException("Ha ocurrido un error");
        }
    }

    public static int contarDivisores() throws IOException, SAXException, WebException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            //Guardamos un lista de los <div>
            NodeList listaDiv = documento.getElementsByTagName("div");

            return listaDiv.getLength();

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            throw new WebException("Ha ocurrido algún error");
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
                throw new WebException("No se han encontrado <div>");
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
                // nodoId.getNodeValue() es para coger el valor del atributo (Ej -> <div id="menu-principal"> saca "principal")
                if (nodoId != null && nodoId.getNodeValue() != null && !nodoId.getNodeValue().isEmpty()) {
                    contadorDeAtributosInicializados++;
                }
            }
            return contadorDeAtributosInicializados;

        } catch (ParserConfigurationException | WebException e) {
            System.out.println(e.getMessage());
            throw new IOException("Ha ocurrido algún error");
        }
    }

    public static String mostrarTextoAlternativoDeImagenes() throws IOException, WebException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            //Guardamos una lista de todos los <img> que haya
            NodeList listNodoImg = documento.getElementsByTagName("img");

            if (listNodoImg.getLength() < 1) {
                throw new IOException("No se han encontrado <IMG>");
            }

            StringBuilder textosAlternativos = new StringBuilder();

            //Recorremos todos los <img>
            for (int i = 0; i < listNodoImg.getLength(); i++) {

                //Guardamos el Nodo img (etiqueta img)
                Node img = listNodoImg.item(i);

                //Hacemos un Map con los atributos del img
                NamedNodeMap mapImgAtributos = img.getAttributes();

                //Guardamos el conjunto clave-valor del atributo "alt"
                Node atributoAlt = mapImgAtributos.getNamedItem("alt");

                //Nos aseguramos de solo añadir al StringBuilder los textos de las imagenes que tengan alt
                //ya que si no tiene altributoAlt (!=null) es cuando añadimos al StringBuilder su nodeValue, si fuera null pasa al siguiente
                if (atributoAlt != null) {

                    //Añadimos el valor (del conjunto clave-valor de "alt") al StringBuilder
                    textosAlternativos.append(atributoAlt.getNodeValue()).append("\n");
                }
            }

            return textosAlternativos.toString();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            throw new WebException("Ha ocurrido algun error");
        }
    }

    public static String mostrarTitularDeNoticiaMasTextoAlternativo() throws WebException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaHtml);

            //Guardamos una lista de <div>
            NodeList listaDeDiv = document.getElementsByTagName("div");

            StringBuilder stringBuilder = new StringBuilder();

            //Recorrelos los div, asegurandonos de que son ELEMENT_NODE
            for (int i = 0; i < listaDeDiv.getLength(); i++) {
                if (listaDeDiv.item(i) != null && listaDeDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    //Convertimos el <div> a Element
                    Element elementDiv = (Element) listaDeDiv.item(i);

                    //Comprobamos que el valor del atributo class (si lo tiene) es "noticia", para saber que estamos en una noticia
                    //Ahora necesitariamos entrar en sus hijos, donde estan <h2> (titular) y <img alt="texto"> (imagen con texto alternativo)
                    String valorDeAtributoClass = elementDiv.getAttribute("class");

                    if (valorDeAtributoClass.equals("noticia")) {

                        Element h2 = (Element) elementDiv.getElementsByTagName("h2").item(0);

                        String textoDeH2 = h2.getTextContent();

                        Element img = (Element) elementDiv.getElementsByTagName("img").item(0);


                        String textoAlt = img.getAttribute("alt");
                        stringBuilder.append(textoDeH2).append(System.lineSeparator()).append(textoAlt).append(System.lineSeparator());
                    }
                }
            }
            return stringBuilder.toString();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new WebException("Ha ocurrido un error");
    }

    public static String mostrarOpcionesMenu() throws WebException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaHtml);

            NodeList listaDeDiv = document.getElementsByTagName("div");

            StringBuilder opcionesMenu = new StringBuilder();
            for (int i = 0; i < listaDeDiv.getLength(); i++) {

                if (listaDeDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element div = (Element) listaDeDiv.item(i);

                    String valorAtributoId = div.getAttribute("id");

                    if (valorAtributoId.equals("menu-principal")) {

                        Element ul = (Element) div.getElementsByTagName("ul").item(0);

                        NodeList listaDeLi = ul.getElementsByTagName("li");

                        for (int j = 0; j < listaDeLi.getLength(); j++) {

                            Node liTemporal = listaDeLi.item(j);
                            String textoLiTemporal = liTemporal.getTextContent();
                            opcionesMenu.append(textoLiTemporal).append(System.lineSeparator());
                        }
                    }
                }
            }
            return opcionesMenu.toString();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println(e.getMessage());
            throw new WebException("Ha ocurrido un error");
        }
    }

    public static String mostrarOpcionesMenu2() throws WebException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documento = documentBuilder.parse(rutaHtml);

            documento.getDocumentElement().normalize();

            Element nav = (Element) documento.getElementsByTagName("div").item(0);

            //Guardamos los ul que encontreemos
            NodeList nodosUl = nav.getElementsByTagName("ul");

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
            System.out.println(e.getMessage());
            throw new WebException("Ha ocurrido un error");
        }
    }

    public static Element getDivMenu(Element nodoRaiz) {

        NodeList listaDeNodosDiv = nodoRaiz.getElementsByTagName("id");

        for (int i = 0; i < listaDeNodosDiv.getLength(); i++) {

            Element elementoTemporal = (Element) listaDeNodosDiv.item(i);

            if (elementoTemporal.getAttribute("id").equals("menu")) {

                return elementoTemporal;
            }
        }
        return null;
    }

    public static String mostrarTitularDeNoticiaMasParrafo() throws WebException {

        try {
            File rutaHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaHtml);

            //Guardamos una lista de <div>
            NodeList listaDeDiv = document.getElementsByTagName("div");

            StringBuilder stringBuilder = new StringBuilder();

            //Recorrelos los div, asegurandonos de que son ELEMENT_NODE
            for (int i = 0; i < listaDeDiv.getLength(); i++) {
                if (listaDeDiv.item(i) != null && listaDeDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    //Convertimos el <div> a Element
                    Element elementDiv = (Element) listaDeDiv.item(i);

                    //Comprobamos que el valor del atributo class (si lo tiene) es "noticia", para saber que estamos en una noticia
                    //Ahora necesitariamos entrar en sus hijos, donde estan <h2> (titular) y <img alt="texto"> (imagen con texto alternativo)
                    String valorDeAtributoClass = elementDiv.getAttribute("class");

                    if (valorDeAtributoClass.equals("noticia")) {

                        Element h2 = (Element) elementDiv.getElementsByTagName("h2").item(0);

                        String textoDeH2 = h2.getTextContent();

                        Element p = (Element) elementDiv.getElementsByTagName("p").item(0);
                        String textoP = p.getTextContent();

                        stringBuilder.append(textoDeH2).append(System.lineSeparator()).append(textoP).append(System.lineSeparator());
                    }
                }
            }
            return stringBuilder.toString();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new WebException("Ha ocurrido un error");
    }

    public static int contarCuantosElementosTieneLaClaseMenu() throws WebException {

        try {
            //Cargamos el html
            File rutaDelHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaDelHtml);

            // \\b la usamos cuando queremos buscar una palabra en concreto (aislada de otras)
            Pattern patron = Pattern.compile("(?i)\\bmenu\\b");

            Element nodoRaiz = documento.getDocumentElement();

            NodeList hijosDelNodoRaiz = nodoRaiz.getChildNodes();

            int contador = 0;

            for (int i = 0; i < hijosDelNodoRaiz.getLength(); i++) {

                if (hijosDelNodoRaiz.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element elementoActual = (Element) hijosDelNodoRaiz.item(i);

                    String valorDelAtributoClass = elementoActual.getAttribute("class");

                    Matcher matcher = patron.matcher(valorDelAtributoClass);

                    if (matcher.matches()){
                        contador++;
                    }
                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
        throw new WebException("Ha ocurrido algún error");
    }

    public static int contarCuantosElementosTieneLaClaseMenuRecursivo() throws WebException {

        try {
            //Cargamos el html
            File rutaDelHtml = new File("src/TEMA7/boletin3/ejercicio2/PaginaWeb.html");
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaDelHtml);

            //La expresion regular
            //(?i) indica que ignora mayusculas y minusculas (incluye ambas)
            //Otra forma seria ->  Pattern.compile("\\bmenu\\b", Pattern.CASE_INSENSITIVE)
            Pattern patron = Pattern.compile("(?i)\\bmenu\\b");

            Node nodoRaiz = documento.getDocumentElement();

            int encontrados = 0;
            return elementosConAtributoClassRecursivo(nodoRaiz, patron, encontrados);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
            throw new WebException("Ha ocurrido algún error");
        }
    }

    public static int elementosConAtributoClassRecursivo(Node node, Pattern patron, int encontrados) {

        //Hacemos una lista de los hijos del nodo raiz (que lo recibimos por parametro)
        NodeList nodeList = node.getChildNodes();

        //Recorremos los hijos del Nodo
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node nodoTemporal = nodeList.item(i);

            if (nodoTemporal.getNodeType() == Node.ELEMENT_NODE) {

                //Si el nodo acutal tiene hijos, vuelvo a llamar al metodo, creando asi un metodo recursivo
                if (nodoTemporal.hasChildNodes()) {
                    encontrados += elementosConAtributoClassRecursivo(nodoTemporal, patron, encontrados);
                }

                String clase = ((Element) nodoTemporal).getAttribute("class");

                //El separador del .slipt() sera 1 o + espacios
                String[] arrayDeClases = clase.split("\\s+");

                for (int j = 0; j < arrayDeClases.length; j++) {

                    Matcher matcher = patron.matcher(clase);

                    if (matcher.matches()) {
                        encontrados++;
                        break;
                    }
                }
            }
        }
        return encontrados;
    }
}