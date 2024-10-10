package mvc.controlador;

import java.io.File;
import java.util.ArrayList;
import mvc.modelo.IDAO;
import mvc.modelo.Jugador;
import mvc.vista.IVista;

/**
 * Clase Controlador que gestiona la interacción entre la vista y el modelo en
 * un sistema MVC (Modelo-Vista-Controlador) para realizar operaciones CRUD
 * sobre los jugadores y manejar el tipo de archivo seleccionado por el usuario
 * para guardar los datos.
 *
 * @author Andoni
 */
public class Controlador {

    private IVista<Jugador> vista;
    private IDAO<Jugador> modelo;
    private int tipoArchivo;
    private ArrayList<Jugador> j;

    /**
     * Constructor que inicializa el controlador con la vista proporcionada.
     *
     * @param vista la interfaz de la vista que será utilizada por el
     * controlador
     */
    public Controlador(IVista vista) {
        this.vista = vista;
        j = new ArrayList<>();
    }

    /**
     * Configura el tipo de archivo en el que se guardarán los datos, según lo
     * seleccionado por el usuario.
     */
    public void configurarTipoArchivo() {
        this.tipoArchivo = vista.mostrarMenuConfiguracion();
    }

    /**
     * Establece el modelo que será utilizado por el controlador.
     *
     * @param modelo el DAO (Data Access Object) que implementa las operaciones
     * CRUD para los jugadores
     */
    public void setModelo(IDAO<Jugador> modelo) {
        this.modelo = modelo;
    }

    /**
     * Realiza una operación basada en la opción seleccionada por el usuario.
     * Las opciones incluyen: insertar, eliminar, modificar, mostrar un jugador
     * por ID, listar todos los jugadores, configurar el tipo de archivo y
     * salir.
     *
     * @param op el número de la opción seleccionada
     */
    public void operacion(int op) {
        Jugador jAux;
        String s;

        switch (op) {
            case 1: //Insertar
                jAux = vista.getObject();
                s = modelo.insertar(jAux);
                if (s == null) {
                    vista.mensaje("Se ha insertado");
                    operacionGuardar();
                } else {
                    vista.mensaje(s);
                }
                break;
            case 2: //Eliminar
                jAux = vista.getObject();
                s = modelo.eliminar(jAux);
                if (s == null) {
                    vista.mensaje("Se ha eliminado");
                    operacionGuardar();
                } else {
                    vista.mensaje(s);
                }
                break;
            case 3: //Modificar
                jAux = vista.getObject();
                s = modelo.modificar(jAux);
                if (s == null) {
                    vista.mensaje("Se ha modificado");
                    operacionGuardar();
                } else {
                    vista.mensaje(s);
                }
                break;
            case 4: //Listado ID
                jAux = vista.getObject();
                if (modelo.listadoID(jAux) != null) {
                    vista.mensaje(modelo.listadoID(jAux).toString());
                } else {
                    vista.mensaje("No existen jugadores con ese ID.");
                }
                break;
            case 5: //Listado general
                if (modelo.listadoGeneral() != null) {
                    vista.mensaje(modelo.listadoGeneral());
                } else {
                    vista.mensaje("No existen jugadores.");
                }
                break;
            case 6: // Configurar tipo de archivo
                configurarTipoArchivo();
                operacionGuardar();
                break;
            case 7: // Salir
                System.exit(0);
            default:
                throw new AssertionError();
        }
    }

    /**
     * Guarda los datos de los jugadores en el tipo de archivo seleccionado por
     * el usuario.
     */
    public void operacionGuardar() {
        switch (tipoArchivo) {
            case 1:
                FicheroSecuencialTexto ficheroTexto = new FicheroSecuencialTexto();
                ficheroTexto.escribirJugadoresTexto(modelo.getJugadores(), "FicheroSecuencial.txt");
                break;
            case 2:
                FicheroSecuencialBinario ficheroBinario = new FicheroSecuencialBinario();
                ficheroBinario.escribirJugadoresBinario(modelo.getJugadores(), "FicheroSecuencialBinario.dat");
                break;
            case 3:
                FicheroObjetosBinario ficheroObjeto = new FicheroObjetosBinario();
                ficheroObjeto.escribirJugadoresObjeto(modelo.getJugadores(), "FicheroObjetosBinario.dat");
                break;
            case 4:
                FicheroAccesoAleatorio ficheroAleatorio = new FicheroAccesoAleatorio();
                ficheroAleatorio.escribirJugadoresAleatorio(modelo.getJugadores(), "FicheroAccesoAleatorio.dat");
                break;
            case 5:
                FicheroXML ficheroXML = new FicheroXML();
                ficheroXML.escribirJugadoresXML(modelo.getJugadores(), "FicheroXML.xml");
                break;
            default:
                System.out.println("Tipo de archivo no válido");
        }
    }

    /**
     * Crea una carpeta en el sistema para almacenar los archivos de los
     * jugadores. Verifica si la carpeta ya existe, y si no, intenta crearla.
     */
    public void crearCarpetaFicheros() {
        File carpeta = new File("Ficheros");

        if (!carpeta.exists()) {
            if (carpeta.mkdir()) {
                vista.mensaje("Carpeta creada con éxito en: " + carpeta.getAbsolutePath());
            } else {
                vista.mensaje("Error al crear la carpeta.");
            }
        } else {
            vista.mensaje("La carpeta ya existe.");
        }
    }

}
