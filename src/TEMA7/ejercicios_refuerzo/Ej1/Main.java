package TEMA7.ejercicios_refuerzo.Ej1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        try {

            File fileDocOriginal = new File("src/TEMA7/ejercicios_refuerzo/Ej1/imagenes.xml");
            Document documentOriginal = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileDocOriginal);

            filtrarImagenes(documentOriginal);
            File fileDocNuevo = new File("src/TEMA7/ejercicios_refuerzo/Ej1/xmlFiltrado.xml");
            Document documentNuevo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileDocNuevo);

            separarDescripcion(documentOriginal);

            normalizar(documentNuevo);

            System.out.println("Num etiquetas: " + contarEtiquetas(documentNuevo));

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void filtrarImagenes(Document document) {
        try {
            Pattern pattern = Pattern.compile("\\b\\d+,\\d+\\b");
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document documentFiltrado = builder.newDocument();

            Element galeriaNueva = documentFiltrado.createElement("galeria");
            documentFiltrado.appendChild(galeriaNueva);

            NodeList imagenes = document.getElementsByTagName("imagen");

            for (int i = 0; i < imagenes.getLength(); i++) {
                Element imagenActual = (Element) imagenes.item(i);

                String formato = imagenActual.getElementsByTagName("formato").item(0).getTextContent().toLowerCase();
                Matcher matcher = pattern.matcher(imagenActual.getElementsByTagName("tamaño").item(0).getTextContent());
                if (matcher.find()) {
                    String textoTamano = matcher.group().replaceAll(",", ".");

                    try {
                        double tamano = Double.parseDouble(textoTamano);

                        if (tamano > 2 && (formato.equals("jpeg") || formato.equals("png"))) {
                            Node imagenImportada = documentFiltrado.importNode(imagenActual, true);
                            galeriaNueva.appendChild(imagenImportada);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Tamaño inválido en la imagenActual " + (i + 1));
                    }
                }
            }
            // Guardar el nuevo archivo filtrado
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(documentFiltrado);
            StreamResult result = new StreamResult("src/TEMA7/ejercicios_refuerzo/Ej1/xmlFiltrado.xml");

            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void separarDescripcion(Document document) {

        Path rutaDescripciones = Path.of("src/TEMA7/ejercicios_refuerzo/Ej1/descripcion.txt");

        NodeList descripciones = document.getElementsByTagName("descripcion");

        for (int i = 0; i < descripciones.getLength(); i++) {
            Element descripcion = (Element) descripciones.item(i);
            NodeList hijosDeDescripcion = descripcion.getChildNodes();

            for (int j = 0; j < hijosDeDescripcion.getLength(); j++) {
                //FILTRAMOS SOLO LOS ELEMENTOS
                if (hijosDeDescripcion.item(j) != null && hijosDeDescripcion.item(j).getNodeType() == Node.ELEMENT_NODE) {

                    Node node = hijosDeDescripcion.item(j);
                    String textoHijoActual = node.getTextContent();

                    try {
                        Files.writeString(rutaDescripciones, textoHijoActual + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public static void normalizar(Document document) {
        Pattern pattern = Pattern.compile("\\s+");

        NodeList listaImagenes = document.getElementsByTagName("imagen");

        for (int i = 0; i < listaImagenes.getLength(); i++) {
            Element imagenActual = (Element) listaImagenes.item(i);

            String nombreAutor = imagenActual.getElementsByTagName("autor").item(0).getTextContent().toLowerCase();

            String nombreAutorSinTildes = quitarTildes(nombreAutor);

            Matcher matcher = pattern.matcher(nombreAutorSinTildes);

            String nombreAutorNormalizado = matcher.replaceAll("_");

            Path rutaAEnviarFichero = Path.of("src/TEMA7/ejercicios_refuerzo/Ej1/" + nombreAutorNormalizado + ".txt");

            try {
                Files.writeString(rutaAEnviarFichero, generarFicha(imagenActual), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String generarFicha(Element imagen) {

        StringBuilder sb = new StringBuilder();

        String nombre = imagen.getElementsByTagName("nombre").item(0).getTextContent();
        String autor = imagen.getElementsByTagName("autor").item(0).getTextContent();
        String tamano = imagen.getElementsByTagName("tamaño").item(0).getTextContent();
        String formato = imagen.getElementsByTagName("formato").item(0).getTextContent();
        String descripcion = imagen.getElementsByTagName("descripcion").item(0).getTextContent().trim().replaceAll("\\s+", " ");

        sb.append(nombre).append("\n");
        sb.append(autor).append("\n");
        sb.append(tamano).append("\n");
        sb.append(formato).append("\n");
        sb.append(descripcion).append("\n");
        return sb.toString();
    }

    public static String quitarTildes(String frase) {

        return frase.replaceAll("á", "a")
                .replaceAll("é", "e")
                .replaceAll("í", "i")
                .replaceAll("ó", "o")
                .replaceAll("ú", "u");
    }

    public static int contarEtiquetas(Document document) {

        int contador = 0;
        NodeList hijosDeDocument = document.getChildNodes();

        for (int i = 0; i < hijosDeDocument.getLength(); i++) {
            if (hijosDeDocument.item(i) != null && hijosDeDocument.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elementoActual = (Element) hijosDeDocument.item(i);

                if (elementoActual.hasChildNodes()) {
                    contador = contarEtiquetas2(elementoActual, contador);
                }
            }
            contador++;
        }
        return contador;
    }

    public static int contarEtiquetas2(Element element, int contador) {

        NodeList hijosDeElemento = element.getChildNodes();

        for (int i = 0; i < hijosDeElemento.getLength(); i++) {
            if (hijosDeElemento.item(i) != null && hijosDeElemento.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elementoActual = (Element) hijosDeElemento.item(i);

                if (elementoActual.hasChildNodes()) {
                    contador = contarEtiquetas2(elementoActual, contador);
                }
                contador++;
            }
        }
        return contador;
    }
}