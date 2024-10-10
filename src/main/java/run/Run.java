/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

import mvc.controlador.Controlador;
import mvc.modelo.JugadorDAOArrayList;
import mvc.vista.VisConsola;

/**
 *
 * @author Andoni
 */
public class Run {
    public static void main(String[] args) {
        VisConsola vista = new VisConsola();
        Controlador controlador = new Controlador(vista);
        JugadorDAOArrayList modelo = new JugadorDAOArrayList();
        
        controlador.setModelo(modelo);
        vista.setControlador(controlador);
        
        vista.show(); 
    }
}
