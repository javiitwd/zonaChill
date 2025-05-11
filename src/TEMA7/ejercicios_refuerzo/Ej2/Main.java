package TEMA7.ejercicios_refuerzo.Ej2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
            File file = new File("src/TEMA7/ejercicios_refuerzo/Ej2/facturas.xml");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            validarFacturas(document);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean codigoEsValido(Element codigo) {
        String textoFactura = codigo.getTextContent();

        Pattern patronDelCodigo = Pattern.compile("\\bF-(?<anyo>\\d{4})-(?<codigo>\\d{4})\\b");

        Matcher matcher = patronDelCodigo.matcher(textoFactura);

        if (matcher.find()) {
            String parteDeAnyo = matcher.group("anyo");
            int anyo = Integer.parseInt(parteDeAnyo);
            if (anyo <= 2025 && anyo >= 2000) {
                return true;
            }
        }
        return false;
    }

    public static boolean fechaEsValida(Element fecha) {

        String textoFactura = fecha.getTextContent();

        Pattern patronDelCodigo = Pattern.compile("\\b(?<dias>\\d{1,2})/(?<mes>\\d{1,2})/(?<anyo>\\d{4})\\b");

        Matcher matcher = patronDelCodigo.matcher(textoFactura);

        return matcher.find();
    }

    public static boolean importeValido(Element importe) {

        String textoImporte = importe.getTextContent();

        Pattern patronDelImporte = Pattern.compile("^\\d+\\.\\d+$");

        Matcher matcher = patronDelImporte.matcher(textoImporte);

        return matcher.find();
    }

    public static void validarFacturas(Document document) {
        Node facturas = document.getDocumentElement();

        NodeList listaDeFacturas = document.getElementsByTagName("factura");

        for (int i = 0; i < listaDeFacturas.getLength(); i++) {
            Element facturaActual = (Element) listaDeFacturas.item(i);

            Element codigo = (Element) facturaActual.getElementsByTagName("codigo").item(0);
            Element fecha = (Element) facturaActual.getElementsByTagName("fecha").item(0);
            Element importe = (Element) facturaActual.getElementsByTagName("importe").item(0);

            boolean valido = true;
            StringBuilder erroresDetectados = new StringBuilder();
            if (!codigoEsValido(codigo)) {
                valido = false;
                erroresDetectados.append("-Codigo no válido ");
            }
            if (!fechaEsValida(fecha)) {
                valido = false;
                erroresDetectados.append("-Fecha no válida ");
            }
            if (!importeValido(importe)) {
                valido = false;
                erroresDetectados.append("-Importe no válido ");
            }

            if (!valido) {
                try {
                    Path rutaAEnviarFactura = Path.of("src/TEMA7/ejercicios_refuerzo/Ej2/errores_facturas.txt");
                    Files.writeString(rutaAEnviarFactura, facturaActual.getElementsByTagName("codigo").item(0).getTextContent() + ": " + erroresDetectados + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    facturas.removeChild(facturaActual);
                    i--;
                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    //CUANDO ELIMINES EL PUTO I-- PORQUE TE CARGAS TODO Y DESPUES NO HAY COJONES A SABER QUE FALLA
                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                double importeDouble = Double.parseDouble(facturaActual.getElementsByTagName("importe").item(0).getTextContent());

                if (importeDouble >= 1000) {

                    facturaActual.setAttribute("coste", "Alto");
                } else {
                    facturaActual.setAttribute("coste", "Bajo");
                }
            }
        }
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource xmlActual = new DOMSource(document);
            StreamResult xmlFiltrado = new StreamResult("src/TEMA7/ejercicios_refuerzo/Ej2/facturasFiltradas.xml");

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(xmlActual, xmlFiltrado);
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
