package mvc.controlador;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import mvc.modelo.Jugador;

/**
 * Clase que maneja la escritura de objetos Jugador en un archivo de acceso
 * aleatorio con un tamaño de registro fijo.
 *
 * Proporciona un método para escribir una lista de jugadores en un archivo
 * binario, permitiendo el acceso aleatorio a cada registro de jugador.
 */
public class FicheroAccesoAleatorio {

    private static final int TAMANIO_REGISTRO = 128;  // Define un tamaño fijo adecuado

    /**
     * Escribe una lista de jugadores en un archivo de acceso aleatorio con un
     * tamaño de registro fijo.
     *
     * Cada jugador es escrito con los siguientes atributos en el archivo
     * binario: - ID (int) - Nick (String) ajustado a un tamaño fijo de 20
     * caracteres - Experiencia (int) - Nivel de vida (int) - Monedas (int)
     *
     * Si la lista está vacía, se muestra un mensaje indicando que no hay
     * jugadores para añadir.
     *
     * @param jugadores la lista de jugadores a escribir en el archivo de acceso
     * aleatorio
     * @param archivo el nombre del archivo en el que se guardarán los jugadores
     */
    public void escribirJugadoresAleatorio(List<Jugador> jugadores, String archivo) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para añadir.");
        } else {
            try (RandomAccessFile raf = new RandomAccessFile("Ficheros/" + archivo, "rw")) {
                raf.setLength(0);  // Trunca el archivo para sobrescribir
                for (Jugador jugador : jugadores) {
                    raf.writeInt(jugador.getId());
                    raf.writeUTF(padString(jugador.getNick(), 20));  // Ajusta el tamaño del nick a 20 caracteres
                    raf.writeInt(jugador.getExperiencia());
                    raf.writeInt(jugador.getNvlVida());
                    raf.writeInt(jugador.getMonedas());
                }
                System.out.println("Jugadores guardados correctamente en archivo de acceso aleatorio.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de acceso aleatorio: " + e.getMessage());
            }
        }
    }

    /**
     * Ajusta un String al tamaño especificado, rellenándolo con espacios si es
     * necesario. Si el String es más largo que el tamaño especificado, se
     * trunca.
     *
     * @param str el String a ajustar
     * @param length el tamaño deseado
     * @return el String ajustado al tamaño especificado
     */
    private String padString(String str, int length) {
        if (str.length() > length) {
            return str.substring(0, length);
        } else {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() < length) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }
}
