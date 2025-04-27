package TEMA7.boletin3.ejercicio1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Persona> conjuntoPersonas;

    public static void main(String[] args) {

        conjuntoPersonas = new ArrayList<>(List.of(
                new Persona("Jose", "55481193H", "681091711", LocalDate.of(2025, 8, 16)),
                new Persona("Carlos", "55481193H", "681091711", LocalDate.of(2025, 8, 16)),
                new Persona("Anibal", "55481193H", "681091711", LocalDate.of(2025, 8, 16)),
                new Persona("Marcelo", "55481193H", "681091711", LocalDate.of(2025, 8, 16))));

        crearXml();
    }

    public static void crearXml() {
        //Ruta donde guardaremos el xml que crearemos
        File destino = new File("src/TEMA7/boletin3/Ejercicio1/");

        try {
            //1. llamas a la fábrica de albañiles
            //Necesitas a alguien que sepa construir casas, así que llamas a una fábrica que te mande constructores.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //2. La fábrica te manda a un albañil experto
            //La fábrica crea un "builder" para ti, un albañil que sabe levantar estructuras de casas
            DocumentBuilder builder = factory.newDocumentBuilder();

            //3. Le das un terreno en blanco para empezar a construir
            //Imagina que ahora tienes un terreno (folio en blanco) donde vas a crear la casa (xml)
            Document documento = builder.newDocument();

            //4. El albañil construye la base de la casa, la estructura principal
            //crea un objeto Element que representa una etiqueta <personas>.
            //Todavía no lo mete en el documento, sólo lo crea.
            Element root = documento.createElement("personas");  // nodoRaiz

            //Ahora pega los cimientos al terreno para que quede fijo.
            //(añadimos el Element root al folio en blanco del xml)
            //Ya tienes la casa en pie, aunque todavía vacía
            documento.appendChild(root);

            for (Persona persona : conjuntoPersonas) {

                //6. Hay que amueblar la casa asi que se compran muebles (Persona)
                Element elementoPersona = documento.createElement("persona");
                elementoPersona.setAttribute("dni", persona.getDni());

                //6.1 El Element persona tiene atributos (Hijos que heredan) asi que los creamos
                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(persona.getNombre());

                Element telefono = documento.createElement("telefono");
                telefono.setTextContent(persona.getPhone());

                Element fecha = documento.createElement("fecha");
                fecha.setTextContent(persona.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                //7. Le añadimos los atributos (Hijos) al Element elementoPersona
                elementoPersona.appendChild(nombre);
                elementoPersona.appendChild(telefono);
                elementoPersona.appendChild(fecha);

                //7.1 Empiezas a amueblar la casa (añadir personas con todos sus atributos/hijos)
                root.appendChild(elementoPersona);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(destino);
            DOMSource source = new DOMSource(documento);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
}
