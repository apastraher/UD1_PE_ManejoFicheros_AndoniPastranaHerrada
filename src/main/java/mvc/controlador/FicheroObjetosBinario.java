package mvc.controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import mvc.modelo.Jugador;

/**
 * Clase que maneja la escritura de una lista de objetos Jugador en un archivo
 * binario utilizando la serialización de objetos.
 *
 * Proporciona un método para escribir una lista de jugadores en un archivo
 * binario, donde la lista completa se guarda como un único objeto serializado.
 */
public class FicheroObjetosBinario {

    /**
     * Escribe una lista de jugadores en un archivo binario utilizando la
     * serialización de objetos. La lista completa se guarda como un único
     * objeto en el archivo.
     *
     * Si la lista está vacía, se muestra un mensaje indicando que no hay
     * jugadores para añadir.
     *
     * @param jugadores la lista de jugadores a escribir en el archivo binario
     * como un objeto serializado
     * @param archivo el nombre del archivo en el que se guardará la lista de
     * jugadores
     */
    public void escribirJugadoresObjeto(List<Jugador> jugadores, String archivo) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para añadir.");
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Ficheros/" + archivo))) {
                oos.writeObject(jugadores);
                System.out.println("Jugadores guardados correctamente en archivo de objetos.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de objetos: " + e.getMessage());
            }
        }
    }
}
