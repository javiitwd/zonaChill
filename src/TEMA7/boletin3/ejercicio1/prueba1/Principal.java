package TEMA7.boletin3.ejercicio1.prueba1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Principal {
    public static void main(String[] args) {


        Persona p = new Persona("ManuDT", "234253", "7563424", LocalDate.of(2000, 12, 12));

        try {
            crearXml(p);

        } catch (ParserConfigurationException e){
            System.out.println(e.getMessage());
        }

    }

    public static void crearXml(Persona p) throws ParserConfigurationException {

        File rutaDestino = new File("src/TEMA7/boletin3/ejercicio1/prueba1/documentoxml.xml");

        try {

            DocumentBuilderFactory empresaConstruccion = DocumentBuilderFactory.newInstance();

            DocumentBuilder constructor = empresaConstruccion.newDocumentBuilder();

            Document folioBlanco = constructor.newDocument();

            //1a posicion) Creamos la raiz (Las personas, generalizando)
            Element raiz = folioBlanco.createElement("personas");

            //Añadimos el elemento raiz
            folioBlanco.appendChild(raiz);

            //2a posicion) Creamos la herencia de la raiz (La persona, mas especifico)
            Element elementoPersona = folioBlanco.createElement("persona");

            //-->Antes de añadir elementoPersona (2a posicion) al folio
            // debemos ponerse sus atributos(hijos que heredan de él):

            //Ahora creamos los atributos de persona(2a posicion)
            //que heredaran de <persona> y ocuparan la 3a posicion
            //Y le damos un valor (accediento a su valor con el personaX.get())

            Element dni = folioBlanco.createElement("dni"); //creamos
            dni.setTextContent(p.getDni()); //damos valor

            Element nombre = folioBlanco.createElement("nombre");
            nombre.setTextContent(p.getNombre());

            Element telefono = folioBlanco.createElement("telefono");
            telefono.setTextContent(p.getPhone());

            Element fechaNacimiento = folioBlanco.createElement("fecha_nacimiento");
            fechaNacimiento.setTextContent(p.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            //--> Una vez creados los Element (atributos) de persona(2a posicion) tenemos que asignarselos (darselo como herencia)
            elementoPersona.appendChild(dni);
            elementoPersona.appendChild(nombre);
            elementoPersona.appendChild(telefono);
            elementoPersona.appendChild(fechaNacimiento);

            raiz.appendChild(elementoPersona);

            //--> Una vez creado todo, debemos tarnsformarlo a un XML

            Transformer transformador = TransformerFactory.newInstance().newTransformer();

            transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            //Guardamos la ruta de destino donde guardaremos el XML una vez creado
            StreamResult dondeGuardamosElResultado = new StreamResult(rutaDestino);

            //Indicamos el Document que vamos a usar para transformarlo a XML (el nuestro ya lo creamos y dimos todos sus niveles de herencia)
            DOMSource documentoQueConvertiremosAXML = new DOMSource(folioBlanco);

            //PARA PONER EN VERTICAL y no todo en la misma linea
            //OutputKeys.INDENT es una propiedad del Transformer.
            //Cuando le dices "yes", le estás diciendo:
            //➔ "Por favor, indentarlo (ponerlo en varias líneas y con espacios/tabulaciones)".
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");

            //Hacemos la transformacion del Document al XML
            transformador.transform(documentoQueConvertiremosAXML, dondeGuardamosElResultado);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error: " +e.getMessage());
        }
    }
}
