/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.modelo;

import java.io.Serializable;

/**
 * Clase que representa a un jugador en el sistema. Cada jugador tiene un ID,
 * experiencia, nivel de vida, monedas y un nombre de usuario (nick). Implementa
 * las interfaces Serializable y Comparable.
 *
 * Esta clase permite crear jugadores, obtener y modificar sus atributos, y
 * compararlos o verificarlos por igualdad de acuerdo a su ID.
 */
public class Jugador implements Serializable, Comparable {

    private int id, experiencia, nvlVida, monedas;
    private String nick;

    /**
     * Constructor con parámetros para inicializar un jugador con valores
     * específicos.
     *
     * @param id el ID del jugador
     * @param experiencia la cantidad de experiencia del jugador
     * @param nvlVida el nivel de vida del jugador
     * @param monedas la cantidad de monedas del jugador
     * @param nick el nombre de usuario (nick) del jugador
     */
    public Jugador(int id, int experiencia, int nvlVida, int monedas, String nick) {
        this.id = id;
        this.experiencia = experiencia;
        this.nvlVida = nvlVida;
        this.monedas = monedas;
        this.nick = nick;
    }

    /**
     * Constructor sin parámetros que crea un jugador con valores por defecto
     * (cero para los atributos numéricos y una cadena vacía para el nick).
     */
    public Jugador() {
        this(0, 0, 0, 0, "");
    }

    /**
     * Obtiene el ID del jugador.
     *
     * @return el ID del jugador
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del jugador.
     *
     * @param id el nuevo ID del jugador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la experiencia del jugador.
     *
     * @return la experiencia del jugador
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia del jugador.
     *
     * @param experiencia la nueva experiencia del jugador
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Obtiene el nivel de vida del jugador.
     *
     * @return el nivel de vida del jugador
     */
    public int getNvlVida() {
        return nvlVida;
    }

    /**
     * Establece el nivel de vida del jugador.
     *
     * @param nvlVida el nuevo nivel de vida del jugador
     */
    public void setNvlVida(int nvlVida) {
        this.nvlVida = nvlVida;
    }

    /**
     * Obtiene la cantidad de monedas del jugador.
     *
     * @return la cantidad de monedas del jugador
     */
    public int getMonedas() {
        return monedas;
    }

    /**
     * Establece la cantidad de monedas del jugador.
     *
     * @param monedas la nueva cantidad de monedas del jugador
     */
    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    /**
     * Obtiene el nombre de usuario (nick) del jugador.
     *
     * @return el nombre de usuario del jugador
     */
    public String getNick() {
        return nick;
    }

    /**
     * Establece el nombre de usuario (nick) del jugador.
     *
     * @param nick el nuevo nombre de usuario del jugador
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * Genera una representación en cadena de los atributos del jugador.
     *
     * @return una cadena que describe al jugador, incluyendo ID, experiencia,
     * nivel de vida, monedas y nick.
     */
    @Override
    public String toString() {
        return "{ID=" + id + ", Experiencia=" + experiencia + ", NvlVida=" + nvlVida + ", Monedas=" + monedas + ", Nick=" + nick + '}';
    }

    /**
     * Compara este jugador con otro objeto. Actualmente, este método devuelve
     * un valor constante, pero puede ser modificado para una comparación más
     * útil.
     *
     * @param o el objeto con el que se va a comparar
     * @return un valor constante (-9)
     */
    @Override
    public int compareTo(Object o) {
        return -9;
    }

    /**
     * Calcula el valor hash del jugador basado en su ID.
     *
     * @return el valor hash del jugador
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
    }

    /**
     * Verifica si este jugador es igual a otro objeto. Dos jugadores se
     * consideran iguales si tienen el mismo ID.
     *
     * @param obj el objeto con el que se va a comparar
     * @return true si los jugadores tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        return this.id == other.id;
    }
}
