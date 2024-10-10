/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.vista;

import mvc.controlador.Controlador;

/**
 *
 * @author Andoni
 */
public interface IVista<T> {
    public abstract T getObject();
    
    public abstract void setObject(T jugador);

    public abstract void show();

    public abstract void mensaje(String s);

    // Comunicación con el controlador
    public abstract void setControlador(Controlador c);
    
    public abstract int mostrarMenuConfiguracion();

}
