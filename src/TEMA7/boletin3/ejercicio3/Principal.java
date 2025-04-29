package TEMA7.boletin3.ejercicio3;

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

public class Principal {
    public static void main(String[] args) {

        try {
            System.out.println("Nombre de platos de menos de 5 euros -> " + nombreDePlatosMenos5Euros());
            System.out.println("Nombre de platos de menos de 500 calorias -> " + platosConMenosDe500Calorias());
            annadirAtributosAPlatos();
            annadirPlato();
            eliminarPlatosMas500cal();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String nombreDePlatosMenos5Euros() throws IOException {

        try {
            File rutaXml = new File("src/TEMA7/boletin3/ejercicio3/desayuno.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaXml);

            document.getDocumentElement().normalize();

            //Guardamos el Elemento raiz (<desayuno>)
            Node nodeDesayuno = document.getDocumentElement();

            NodeList platos = nodeDesayuno.getChildNodes();

            StringBuilder platosMenos5Euros = new StringBuilder();
            for (int i = 0; i < platos.getLength(); i++) {

                //Nos aseguramos de que i es un Nodo (que sera un <plato>)
                //si lo es, convertimos el plato a Element para poder acceder a sus metodos
                if (platos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element plato = (Element) platos.item(i);

                    //Guardamos el precio y lo convertimos en Double ya que por defecto viene en String ya que es una etiqueta
                    String precioString = plato.getElementsByTagName("precio").item(0).getTextContent();
                    double precio = Double.parseDouble(precioString);

                    if (precio < 5) {

                        String nombre = plato.getElementsByTagName("nombre").item(0).getTextContent();
                        platosMenos5Euros.append(nombre).append("\n");
                    }
                }
            }

            return platosMenos5Euros.toString();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
            throw new IOException("Ha ocurrido un error");
        }
    }

    public static String platosConMenosDe500Calorias() throws IOException {

        try {
            File rutaXml = new File("src/TEMA7/boletin3/ejercicio3/desayuno.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaXml);

            document.getDocumentElement().normalize();

            NodeList platos = document.getElementsByTagName("plato");

            if (platos.getLength() < 0) {
                throw new IOException("No se han encotrado platos");
            }

            StringBuilder platosMenos500calorias = new StringBuilder();

            for (int i = 0; i < platos.getLength(); i++) {

                if (platos.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element plato = (Element) platos.item(i);

                    //Usamos getTextContent() -> porque queremos el contenido entre 2 etiquetas
                    String caloriasString = plato.getElementsByTagName("calorias").item(0).getTextContent();
                    double calorias = Double.parseDouble(caloriasString);

                    if (calorias < 500) {

                        String nombrePlato = plato.getElementsByTagName("nombre").item(0).getTextContent();
                        platosMenos500calorias.append(nombrePlato).append(System.lineSeparator());
                    }
                }
            }
            return platosMenos500calorias.toString();


        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
            throw new IOException("Ha ocurrido un error");
        }
    }

    public static void annadirAtributosAPlatos() throws IOException {

        try {
            File rutaXml = new File("src/TEMA7/boletin3/ejercicio3/desayuno.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaXml);

            document.getDocumentElement().normalize();

            NodeList platos = document.getElementsByTagName("plato");

            if (platos.getLength() < 0) {
                throw new IOException("No se han encotrado platos");
            }

            for (int i = 0; i < platos.getLength(); i++) {

                Element plato = (Element) platos.item(i);

                //String.valueOf(i) -> convertimos i a valor
                plato.setAttribute("id", String.valueOf(i));
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            //Pasamos nuestro documento actual como el antes
            DOMSource rutaDeNuestroXmlOriginal = new DOMSource(document);
            //Pasamos la ruta donde queremos guardar el nuevo xml
            StreamResult rutaParaGuardarElNuevoXML = new StreamResult("src/TEMA7/boletin3/ejercicio3/desayuno2.xml");

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(rutaDeNuestroXmlOriginal, rutaParaGuardarElNuevoXML);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void annadirPlato() {

        try {
            File rutaXml = new File("src/TEMA7/boletin3/ejercicio3/desayuno.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaXml);

            Element desayuno = document.getDocumentElement();

            //Creamos el nuevo plato
            Element plato = document.createElement("plato");

            //Creamos los atributos (hijos) del plato
            Element nombre = document.createElement("nombre");
            nombre.setTextContent("Arroz a la cubana");
            Element precio = document.createElement("precio");
            precio.setTextContent("6");
            Element calorias = document.createElement("calorias");
            calorias.setTextContent("600");

            //Añadimos los atributos (hijos) recien creados al plato
            plato.appendChild(nombre);
            plato.appendChild(precio);
            plato.appendChild(calorias);

            //Añadimos el plato como hijo de platos(<platos> -> que es el nodo raiz del Documento)
            desayuno.appendChild(plato);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource documentoXmlActual = new DOMSource(document);
            StreamResult lugarAGuardarNuevoXml = new StreamResult("src/TEMA7/boletin3/Ejercicio3/desayunoNuevo.xml");

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(documentoXmlActual, lugarAGuardarNuevoXml);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarPlatosMas500cal() {

        try {
            File rutaXml = new File("src/TEMA7/boletin3/ejercicio3/desayuno.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(rutaXml);

            document.getDocumentElement().normalize();

            //Guardamos el elemento preincipal (raiz) que es <desayuno>
            Element desayuno = document.getDocumentElement();

            //Guardamos los platos (hijos de <desayuno>)
            NodeList platos = desayuno.getElementsByTagName("plato");

            if (platos.getLength() < 0) {
                throw new IOException("No hay platos");
            }

            for (int i = 0; i < platos.getLength(); i++) {

                Element plato = (Element) platos.item(i);

                String caloriasString = plato.getElementsByTagName("calorias").item(0).getTextContent();
                double calorias = Double.parseDouble(caloriasString);

                if (calorias > 500) {
                    desayuno.removeChild(plato);
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource xmlActual = new DOMSource(document);
            StreamResult rutaNuevo = new StreamResult("src/TEMA7/boletin3/ejercicio3/desayuno_saludable.xml");

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, rutaNuevo);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
