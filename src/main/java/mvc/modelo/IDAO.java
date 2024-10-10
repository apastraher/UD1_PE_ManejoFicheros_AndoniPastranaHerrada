/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.modelo;

import java.util.List;

/**
 *
 * @author Andoni
 */
public interface IDAO<T>{
    
    public abstract String insertar(T o);
    public abstract String eliminar(T o);
    public abstract String modificar(T nuevo);

    public Jugador listadoID(Jugador jAux);
    public String listadoGeneral();
    public List<Jugador> getJugadores();
}
