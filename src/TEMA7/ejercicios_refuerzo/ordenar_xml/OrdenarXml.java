package TEMA7.ejercicios_refuerzo.ordenar_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class OrdenarXml {
    public static void main(String[] args) {

        try {
            File rutaXml = new File("src/TEMA7/ejercicios_refuerzo/xmlDesordenado.xml");
            Document documentoXml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rutaXml);

            NodeList listaTransaccion = documentoXml.getElementsByTagName("transaccion");

            List<Element> listaElement = new LinkedList<>();

            for (int i = 0; i < listaTransaccion.getLength(); i++) {

                Element transaccion = (Element) listaTransaccion.item(i);

                listaElement.add(transaccion);
            }
            // Ordenar normal--> listaElement.sort(Comparator.comparing(e -> Double.parseDouble(e.getElementsByTagName("importe").item(0).getTextContent())));

            // Y ahora para ordenar en reverso, como debemos indicarle al comparaotr que vamos a comparar con Element debemos hacer:
            Comparator<Element> comparator = Comparator.comparingDouble(e -> Double.parseDouble(e.getElementsByTagName("importe").item(0).getTextContent()));

            listaElement.sort(comparator.reversed());

            Element elementoRaiz = documentoXml.getDocumentElement();

            // Añadimos la lista ordenada al nodo raiz (no añadiria los ordenados + los que habia)
            // ya que internamente, comparaia los nuevos con los que ya habia y al ser iguales,
            // reemplazaria su orden simplemente
            for (Element elemento : listaElement) {
                elementoRaiz.appendChild(elemento);
            }

            try {
                Transformer transformer = TransformerFactory.newInstance().newTransformer();

                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                //Pasamos nuestro documento actual como el antes
                DOMSource rutaDeNuestroXmlOriginal = new DOMSource(documentoXml);
                //Pasamos la ruta donde queremos guardar el nuevo xml
                StreamResult rutaParaGuardarElNuevoXML = new StreamResult("src/TEMA7/ejercicios_refuerzo/xmlOrdenado.xml");

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(rutaDeNuestroXmlOriginal, rutaParaGuardarElNuevoXML);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
