package mvc.controlador;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import mvc.modelo.Jugador;

/**
 * Clase que maneja la escritura de objetos Jugador en un archivo binario de
 * forma secuencial.
 *
 * Proporciona un método para escribir una lista de jugadores en un archivo
 * binario, guardando los atributos de cada jugador en un formato binario.
 */
public class FicheroSecuencialBinario {

    /**
     * Escribe una lista de jugadores en un archivo binario de forma secuencial.
     * Cada jugador se guarda con los siguientes atributos en el archivo
     * binario: - ID (int) - Nick (String) - Experiencia (int) - Nivel de vida
     * (int) - Monedas (int)
     *
     * Si la lista está vacía, se muestra un mensaje indicando que no hay
     * jugadores para añadir.
     *
     * @param jugadores la lista de jugadores a escribir en el archivo binario
     * @param archivo el nombre del archivo en el que se guardarán los jugadores
     */
    public void escribirJugadoresBinario(List<Jugador> jugadores, String archivo) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay ningun jugador para añadir.");
        } else {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ficheros/" + archivo))) {
                for (Jugador jugador : jugadores) {
                    dos.writeInt(jugador.getId());
                    dos.writeUTF(jugador.getNick());
                    dos.writeInt(jugador.getExperiencia());
                    dos.writeInt(jugador.getNvlVida());
                    dos.writeInt(jugador.getMonedas());
                }
                System.out.println("Jugadores guardados correctamente en archivo binario.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo binario: " + e.getMessage());
            }
        }
    }
}
