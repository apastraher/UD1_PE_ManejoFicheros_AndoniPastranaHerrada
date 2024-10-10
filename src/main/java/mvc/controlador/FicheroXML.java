package mvc.controlador;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import mvc.modelo.Jugador;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FicheroXML {

    public void escribirJugadoresXML(List<Jugador> jugadores, String archivo) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay ningun jugador para añadir.");
        } else {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.newDocument();

                // Elemento raíz <jugadores>
                Element rootElement = doc.createElement("jugadores");
                doc.appendChild(rootElement);

                for (Jugador jugador : jugadores) {
                    // Elemento <jugador>
                    Element jugadorElement = doc.createElement("jugador");

                    // ID
                    Element id = doc.createElement("id");
                    id.appendChild(doc.createTextNode(String.valueOf(jugador.getId())));
                    jugadorElement.appendChild(id);

                    // Nick
                    Element nick = doc.createElement("nick");
                    nick.appendChild(doc.createTextNode(jugador.getNick()));
                    jugadorElement.appendChild(nick);

                    // Experiencia
                    Element experience = doc.createElement("experience");
                    experience.appendChild(doc.createTextNode(String.valueOf(jugador.getExperiencia())));
                    jugadorElement.appendChild(experience);

                    // Nivel de vida
                    Element lifeLevel = doc.createElement("life_level");
                    lifeLevel.appendChild(doc.createTextNode(String.valueOf(jugador.getNvlVida())));
                    jugadorElement.appendChild(lifeLevel);

                    // Monedas
                    Element coins = doc.createElement("coins");
                    coins.appendChild(doc.createTextNode(String.valueOf(jugador.getMonedas())));
                    jugadorElement.appendChild(coins);

                    rootElement.appendChild(jugadorElement);
                }

                // Escribir el contenido al archivo XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                // Formato bonito
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("Ficheros/" + archivo));
                transformer.transform(source, result);

                System.out.println("Jugadores guardados correctamente en archivo XML.");
            } catch (ParserConfigurationException | TransformerException e) {
                System.out.println("Error al escribir en el archivo XML: " + e.getMessage());
            }
        }

    }
}
