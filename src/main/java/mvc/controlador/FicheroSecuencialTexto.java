package mvc.controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import mvc.modelo.Jugador;

/**
 * Clase que maneja la escritura de objetos Jugador en un archivo de texto de
 * forma secuencial.
 *
 * Proporciona un método para escribir una lista de jugadores en un archivo de
 * texto, guardando la información de cada jugador en una línea separada.
 *
 */
public class FicheroSecuencialTexto {

    /**
     * Escribe una lista de jugadores en un archivo de texto secuencial. Cada
     * jugador es escrito en una línea separada en el formato: [USER_ID = <id>,
     * NICK_NAME = <nick>, EXPERIENCE = <experiencia>, LIFE_LEVEL =
     * <nivel_vida>, COINS = <monedas>].
     *
     * Si la lista está vacía, se muestra un mensaje indicando que no hay
     * jugadores para añadir.
     *
     * @param jugadores la lista de jugadores a escribir en el archivo de texto
     * @param archivo el nombre del archivo en el que se guardarán los jugadores
     */
    public void escribirJugadoresTexto(List<Jugador> jugadores, String archivo) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay ningun jugador para añadir.");
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Ficheros/" + archivo))) {
                for (Jugador jugador : jugadores) {
                    writer.write("[USER_ID = " + jugador.getId()
                            + ", NICK_NAME = " + jugador.getNick()
                            + ", EXPERIENCE = " + jugador.getExperiencia()
                            + ", LIFE_LEVEL = " + jugador.getNvlVida()
                            + ", COINS = " + jugador.getMonedas() + "]");
                    writer.newLine();
                }
                System.out.println("Jugadores guardados correctamente en archivo de texto.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de texto: " + e.getMessage());
            }
        }
    }
}
