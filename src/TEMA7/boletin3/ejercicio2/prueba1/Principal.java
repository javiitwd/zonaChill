package TEMA7.boletin3.ejercicio2.prueba1;

import org.w3c.dom.Document;
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

            File file = new File("src/TEMA7/boletin3/ejercicio2/prueba1");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //Transformamos el File a un Document
            Document documento = documentBuilder.parse(file);

            //Lo normalizamos para que no haya errores
            documento.getDocumentElement().normalize();

            NodeList nodeListTitle = documento.getElementsByTagName("title");

            if (nodeListTitle.getLength() > 0) {
                //Guardamos el contenido del titulo (textContent)
                String title = nodeListTitle.item(0).getTextContent();

                System.out.println("El titulo es -> " + title);
            } else {
                System.out.println("No hay titulos");
            }

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
