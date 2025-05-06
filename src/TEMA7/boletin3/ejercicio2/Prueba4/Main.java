package TEMA7.boletin3.ejercicio2.Prueba4;

import TEMA7.boletin3.ejercicio2.WebException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            File rutaDeHtml = new File("src/TEMA7/boletin3/ejercicio2/prueba3LaDefinitivaYMejor/PaginaWeb.html");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaDeHtml);

            System.out.println("Titulo: " + mostrarTitulo(document));
            System.out.println("Nº de <div>: " + contarDiv(document));
            System.out.println("Nº de <div> con atributo id con valor: " + contarDivConAtributoIdConValor(document));
            System.out.println("Mostrar texto alternativo de imagenes \n" + mostrarTextoAlternativoDeImagenes(document));
            System.out.println("Mostrar titular de las noticias seguido del texto de la imagen que la acompaña: \n" + mostrarTitularNoticiaMasTextoImagen(document));
            System.out.println("Mostrar opciones del menú principal: \n" + mostrarOpcionesMenuPrincipal(document));
            //System.out.println("Contar cuantos elementos tienen el atributo class con valor 'menu': \n" + contarCuantosElementosTienenElAtributoClassConValorMenu(document));

        } catch (IOException | ParserConfigurationException | SAXException | WebException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String mostrarTitulo(Document document) {

        Element element = (Element) document.getElementsByTagName("title").item(0);

        return element.getTextContent();
    }

    public static int contarDiv(Document document) {

        NodeList listaDeDiv = document.getElementsByTagName("div");
        return listaDeDiv.getLength();
    }

    public static int contarDivConAtributoIdConValor(Document document) throws WebException {

        NodeList listaDeDiv = document.getElementsByTagName("div");
        if (listaDeDiv.getLength() == 0) {
            throw new WebException("No se han encontrado <div>");
        }

        int cont = 0;
        for (int i = 0; i < listaDeDiv.getLength(); i++) {

            Element divActual = (Element) listaDeDiv.item(i);

            if (divActual.hasAttribute("id")) {
                String valorDelAtributoId = divActual.getAttribute("id");
                if (!valorDelAtributoId.isEmpty()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static String mostrarTextoAlternativoDeImagenes(Document document) {

        NodeList listaImagenes = document.getElementsByTagName("img");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < listaImagenes.getLength(); i++) {

            Element imgActual = (Element) listaImagenes.item(i);

            NamedNodeMap namedNodeMap = imgActual.getAttributes();

            // Los atributos no se pueden pasar a Element, deben quedarse como Node
            Node atributoAlt = namedNodeMap.getNamedItem("alt");

            // Usamos .getNodeValue() en lugar .getTextContent() ya que es mejor para los atributos
            String valorDeAlt = atributoAlt.getNodeValue();

            sb.append(valorDeAlt).append("\n");
        }
        return sb.toString();
    }

    public static String mostrarTitularNoticiaMasTextoImagen(Document document) {

        NodeList listaDeDiv = document.getElementsByTagName("div");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaDeDiv.getLength(); i++) {
            Element divAct = (Element) listaDeDiv.item(i);

            if (divAct.hasAttribute("class")) {

                String valorClass = divAct.getAttribute("class");

                if (valorClass.equals("noticia")) {

                    String titulo = divAct.getElementsByTagName("h2").item(0).getTextContent();
                    Element img = (Element) divAct.getElementsByTagName("img").item(0);
                    String txtAlt = img.getAttribute("alt");
                    sb.append(titulo).append(System.lineSeparator()).append(txtAlt).append(System.lineSeparator());
                }
            }
        }
        return sb.toString();
    }

    public static String mostrarOpcionesMenuPrincipal(Document document) {

        NodeList listaDeDiv = document.getElementsByTagName("div");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaDeDiv.getLength(); i++) {
            Element divAct = (Element) listaDeDiv.item(i);

            if (divAct.hasAttribute("id")) {

                String valorClass = divAct.getAttribute("id");

                if (valorClass.equals("menu-principal")) {

                    Element ul = (Element) divAct.getElementsByTagName("ul").item(0);

                    NodeList listaLi = ul.getElementsByTagName("li");

                    for (int j = 0; j < listaLi.getLength(); j++) {

                        sb.append(listaLi.item(j).getTextContent()).append(System.lineSeparator());
                    }
                }
            }
        }
        return sb.toString();
    }

    /*public static int contarCuantosElementosTienenElAtributoClassConValorMenu(Document document) {

        Node nodoRaiz = document.getDocumentElement();

        NodeList listaHijosDelNodoRaiz = nodoRaiz.getChildNodes();

        int contador = 0;
        for (int i = 0; i < listaHijosDelNodoRaiz.getLength(); i++) {

            
        }
    }*/
}
