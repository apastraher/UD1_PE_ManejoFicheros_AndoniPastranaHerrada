package mvc.modelo;

import java.util.*;

/**
 * Clase que implementa la interfaz {@code IDAO} para gestionar jugadores
 * utilizando un ArrayList. Permite realizar las operaciones CRUD (Crear, Leer,
 * Actualizar y Eliminar) sobre objetos {@code Jugador}.
 */
public class JugadorDAOArrayList implements IDAO<Jugador> {

    private ArrayList<Jugador> jugadores;
    private int cont = 0;

    /**
     * Constructor que inicializa la lista de jugadores. Si la lista es nula,
     * crea una nueva instancia de {@code ArrayList<Jugador>}.
     */
    public JugadorDAOArrayList() {
        jugadores = new ArrayList<>();
        if (jugadores == null) {
            jugadores = new ArrayList<>();
        }
    }

    /**
     * Inserta un nuevo jugador en la lista si no está ya presente.
     *
     * @param o el jugador a insertar
     * @return {@code null} si la operación se realiza correctamente, o un
     * mensaje indicando que el jugador ya está en el equipo
     */
    @Override
    public String insertar(Jugador o) {
        if (jugadores.contains(o)) {
            return "El equipo ya contiene este jugador";
        } else {
            jugadores.add(o);
            return null;
        }
    }

    /**
     * Elimina un jugador de la lista si está presente.
     *
     * @param o el jugador a eliminar
     * @return {@code null} si la operación se realiza correctamente, o un
     * mensaje indicando que el jugador no está en el equipo
     */
    @Override
    public String eliminar(Jugador o) {
        if (jugadores.contains(o)) {
            jugadores.remove(o);
            return null;
        } else {
            return "El jugador no está en este equipo";
        }
    }

    /**
     * Modifica los datos de un jugador existente en la lista. Si el jugador
     * existe, actualiza sus atributos.
     *
     * @param nuevo el jugador con los nuevos datos
     * @return {@code null} si la modificación es exitosa, o un mensaje
     * indicando que el jugador no existe
     */
    @Override
    public String modificar(Jugador nuevo) {
        if (jugadores.contains(nuevo)) {
            for (Jugador j : jugadores) {
                if (j.equals(nuevo)) {
                    j.setNick(nuevo.getNick());
                    j.setExperiencia(nuevo.getExperiencia());
                    j.setNvlVida(nuevo.getNvlVida());
                    j.setMonedas(nuevo.getMonedas());
                    return null;
                }
            }
        }
        return "No existe";
    }

    /**
     * Busca un jugador por su ID en la lista.
     *
     * @param jAux el jugador con el ID a buscar
     * @return el jugador si es encontrado, o {@code null} si no existe
     */
    @Override
    public Jugador listadoID(Jugador jAux) {
        int ind = jugadores.indexOf(jAux);
        if (ind != -1) {
            return jugadores.get(ind);
        }
        return null;
    }

    /**
     * Devuelve un listado de todos los jugadores en la lista.
     *
     * @return una cadena con la información de todos los jugadores, o
     * {@code null} si no hay jugadores
     */
    @Override
    public String listadoGeneral() {
        if (!jugadores.isEmpty()) {
            return jugadores.toString();
        }
        return null;
    }

    /**
     * Obtiene la lista de jugadores almacenada.
     *
     * @return la lista de jugadores
     */
    @Override
    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
