package TEMA7.boletin3.ejercicio2.prueba3LaDefinitivaYMejor;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.classfile.components.ClassPrinter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        try {
            File rutaDeHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba3LaDefinitivaYMejor/PaginaWeb.html");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaDeHtml);

            System.out.println("Titulo: " + mostrarTitulo(document));
            System.out.println("Nº de <div>: " + contarDiv(document));
            System.out.println("Nº de <div> con atributo id con valor: " + contarDivConAtributoIdConValor(document));
            System.out.println("Mostrar texto alternativo de imagenes \n" + mostrarTextoAlternativoDeImagenes(document));
            System.out.println("Mostrar titular de las noticias seguido del texto de la imagen que la acompaña: \n" + MostrarTitularNoticiaMasTextoImagen(document));
            System.out.println("Mostrar opciones del menú principal: \n" + mostrarOpcionesMenuPrincipal(document));
            System.out.println("Mostrar titulares de noticia más el texto de estas: \n" + mostrarTitularesNoticiaMasTexto(document));
            System.out.println("Contar cuantos elementos tienen el atributo class con valor 'menu': \n" + contarCuantosElementosTienenElAtributoClassConValorMenu(document));

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static String mostrarTitulo(Document document) {

        Element elementoRaiz = (Element) document.getDocumentElement();

        Element head = (Element) elementoRaiz.getElementsByTagName("head").item(0);

        Element titulo = (Element) head.getElementsByTagName("title").item(0);

        return titulo.getTextContent();
    }

    public static int contarDiv(Document document) {

        return document.getElementsByTagName("div").getLength();
    }

    public static int contarDivConAtributoIdConValor(Document document) throws IOException {

        NodeList listaDeDiv = document.getElementsByTagName("div");

        if (listaDeDiv.getLength() == 0) {
            throw new IOException("No hay <div>");
        }

        int contadorDeDivConAtributoIdConValor = 0;
        for (int i = 0; i < listaDeDiv.getLength(); i++) {
            Element divActual = (Element) listaDeDiv.item(i);

            if (divActual.hasAttribute("id")) {

                //Podriamos hacer String valorDelAtributoId = divActual.getAttribute("id").trim();
                //pero para cambiar haremos un Map de los atributos(k) y su valor(v) del <div>
                NamedNodeMap mapaDeAtributosDelDiv = divActual.getAttributes();

                Node atributoId = mapaDeAtributosDelDiv.getNamedItem("id");

                if (atributoId != null) {

                    //Para sacar el valor del atributo "id" usamos .getNodeValue()
                    //y no .getTextContent() ya que .getNodeValue() está específicamente diseñado para atributos
                    String valorDelAtributoId = atributoId.getNodeValue();
                    if (!valorDelAtributoId.isEmpty()) {
                        contadorDeDivConAtributoIdConValor++;
                    }
                }
            }
        }
        return contadorDeDivConAtributoIdConValor;
    }

    public static String mostrarTextoAlternativoDeImagenes(Document document) throws IOException {

        NodeList listaDeImg = document.getElementsByTagName("img");

        if (listaDeImg.getLength() == 0) {
            throw new IOException("No se han encontrado <img>");
        }

        StringBuilder textosAlternativos = new StringBuilder();
        for (int i = 0; i < listaDeImg.getLength(); i++) {

            Element imgActual = (Element) listaDeImg.item(i);

            if (imgActual.hasAttribute("alt")) {

                String textoAlternativo = imgActual.getAttribute("alt");

                textosAlternativos.append(textoAlternativo).append(System.lineSeparator());
            }
        }
        return textosAlternativos.toString();
    }

    public static String MostrarTitularNoticiaMasTextoImagen(Document document) throws IOException {

        NodeList listaDeDiv = document.getElementsByTagName("div");

        if (listaDeDiv.getLength() == 0) {
            throw new IOException("No se han encontrado <div>");
        }

        StringBuilder titularesMasTextoImagenes = new StringBuilder();
        for (int i = 0; i < listaDeDiv.getLength(); i++) {

            if (listaDeDiv.item(i) != null && listaDeDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element divActual = (Element) listaDeDiv.item(i);

                //Filtramos los <div> que tengan el atributo "class"
                if (divActual.hasAttribute("class")) {

                    String valorDeClass = divActual.getAttribute("class");

                    //Filtramos que el atributo "class" tenga como valor = "noticia"
                    if (valorDeClass.equals("noticia")) {

                        //Sacamos el titular (<h2>)
                        //¡IMPORTANTE! -> usa .item(0) porque sino te puede dar error del "null..."
                        //En el siguiente, para coger el divActual.getElementsByTagName("img") se ve otra forma
                        //de hacerlo sin el .item(0)
                        Element h2 = (Element) divActual.getElementsByTagName("h2").item(0);
                        String titular = h2.getTextContent();

                        //Samamos el texto alternativo de la imagen
                        //<img alt="textoDelTitular">
                        Element img = (Element) divActual.getElementsByTagName("img").item(0);

                        if (img.hasAttribute("alt")) {

                            String textoAlternativoDeImg = img.getAttribute("alt");

                            titularesMasTextoImagenes.append(titular).append(System.lineSeparator())
                                    .append(textoAlternativoDeImg).append(System.lineSeparator());
                        }
                    }
                }
            }
        }
        return titularesMasTextoImagenes.toString();
    }

    public static String mostrarOpcionesMenuPrincipal(Document document) {

        NodeList listaDeDiv = document.getElementsByTagName("div");

        StringBuilder opcionesDeMenu = new StringBuilder();
        for (int i = 0; i < listaDeDiv.getLength(); i++) {

            if (listaDeDiv.item(i) != null && listaDeDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element divActual = (Element) listaDeDiv.item(i);

                if (divActual.hasAttribute("id")) {

                    String valorDelAtributoId = divActual.getAttribute("id");

                    if (valorDelAtributoId.equals("menu-principal")) {

                        Element ul = (Element) divActual.getElementsByTagName("ul").item(0);
                        NodeList listaDeLi = ul.getElementsByTagName("li");

                        if (listaDeLi.getLength() != 0) {

                            for (int j = 0; j < listaDeLi.getLength(); j++) {

                                if (listaDeLi.item(j) != null && listaDeLi.item(j).getNodeType() == Node.ELEMENT_NODE) {

                                    Element liActual = (Element) listaDeLi.item(j);

                                    String textoDelLi = liActual.getTextContent();

                                    opcionesDeMenu.append(textoDelLi).append(System.lineSeparator());
                                }
                            }
                        }
                    }
                }
            }
        }
        return opcionesDeMenu.toString();
    }

    public static String mostrarTitularesNoticiaMasTexto(Document document) throws IOException {

        NodeList listaDeDiv = document.getElementsByTagName("div");

        if (listaDeDiv.getLength() == 0) {
            throw new IOException("No se han encontrado <div>");
        }

        StringBuilder titularMasTexto = new StringBuilder();
        for (int i = 0; i < listaDeDiv.getLength(); i++) {

            if (listaDeDiv.item(i) != null && listaDeDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {

                Element divActual = (Element) listaDeDiv.item(i);

                if (divActual.hasAttribute("class")) {

                    String valorDelAtributoClass = divActual.getAttribute("class");

                    if (valorDelAtributoClass.equals("noticia")) {

                        Element h2 = (Element) divActual.getElementsByTagName("h2").item(0);
                        String titular = h2.getTextContent();

                        Element p = (Element) divActual.getElementsByTagName("p").item(0);
                        String texto = p.getTextContent();

                        titularMasTexto.append(titular).append(System.lineSeparator()).
                                append(texto).append(System.lineSeparator());
                    }
                }
            }
        }
        return titularMasTexto.toString();
    }

    public static int contarCuantosElementosTienenElAtributoClassConValorMenu(Document document) {

        Pattern patron = Pattern.compile("(?i)\\bmenu\\b");

        Element elementoRaiz = document.getDocumentElement();

        int encontrados = 0;
        return contarCuantosElementosTienenElAtributoClassConValorMenuRecursivo(elementoRaiz, patron, encontrados);
    }

    public static int contarCuantosElementosTienenElAtributoClassConValorMenuRecursivo(Element elementoRaiz, Pattern patron, int encontrados) {

        NodeList hijosDelNodoRaiz = elementoRaiz.getChildNodes();

        if (hijosDelNodoRaiz.getLength() != 0) {

            for (int i = 0; i < hijosDelNodoRaiz.getLength(); i++) {

                if (hijosDelNodoRaiz.item(i) != null && hijosDelNodoRaiz.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element elementoActual = (Element) hijosDelNodoRaiz.item(i);

                    if (elementoActual.hasChildNodes()) {
                        encontrados = contarCuantosElementosTienenElAtributoClassConValorMenuRecursivo(elementoActual, patron, encontrados);
                    }

                    if (elementoActual.hasAttribute("class")) {

                        String valorDelAtributoClass = elementoActual.getAttribute("class");

                        Matcher matcher = patron.matcher(valorDelAtributoClass);

                        if (matcher.matches()) {
                            encontrados++;
                        }
                    }
                }
            }
        }
        return encontrados;
    }
}
