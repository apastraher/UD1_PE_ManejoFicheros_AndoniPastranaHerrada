package mvc.vista;

import java.util.Scanner;
import mvc.controlador.Controlador;
import mvc.modelo.Jugador;

/**
 * Clase que implementa la interfaz {@code IVista} para la vista de consola.
 * Proporciona métodos para interactuar con el usuario y realizar operaciones
 * sobre objetos {@code Jugador}.
 */
public class VisConsola implements IVista<Jugador> {

    private static final Scanner sc = new Scanner(System.in);
    private Controlador controlador;
    private Jugador j;

    /**
     * Constructor que inicializa un nuevo objeto {@code Jugador}.
     */
    public VisConsola() {
        j = new Jugador();
    }

    /**
     * Obtiene el objeto {@code Jugador} actual.
     *
     * @return el objeto {@code Jugador}
     */
    @Override
    public Jugador getObject() {
        return j;
    }

    /**
     * Establece el objeto {@code Jugador} actual.
     *
     * @param jugador el nuevo objeto {@code Jugador}
     */
    @Override
    public void setObject(Jugador jugador) {
        this.j = jugador;
    }

    /**
     * Establece el controlador para la vista.
     *
     * @param c el controlador a establecer
     */
    @Override
    public void setControlador(Controlador c) {
        this.controlador = c;
    }

    /**
     * Muestra el menú principal de la consola y gestiona las operaciones del
     * usuario.
     */
    @Override
    public void show() {
        int op;

        controlador.configurarTipoArchivo();

        vaciarPantalla();

        System.out.println("Creando carpeta \"Ficheros\" en el escritorio...");
        controlador.crearCarpetaFicheros();

        // Mensaje inicio
        while (true) {
            do {
                mostrarMensajePanelInicio();
                op = sc.nextInt();
                if (op > 7 || op < 1) {
                    vaciarPantalla();
                    System.out.println("Operación no permitida");
                }
            } while (op > 7 || op < 1);

            vaciarPantalla();
            eleccionPanelInicio(op, sc);
            controlador.operacion(op);
        }
    }

    /**
     * Gestiona la elección del usuario en el menú principal.
     *
     * @param op la opción elegida por el usuario
     * @param sc el objeto Scanner para la entrada del usuario
     * @throws AssertionError si la opción es inválida
     */
    private void eleccionPanelInicio(int op, Scanner sc) throws AssertionError {
        switch (op) {
            case 1: // Añadir
                recogerDatosAlta();
                break;
            case 2: // Eliminar
                recogerDatosBaja();
                break;
            case 3: // Modificar
                recogerDatosModificar();
                break;
            case 4: // Listado por código (ID)
                recogerDatosConsultaID();
                break;
            case 5: // Listado general
                System.out.println("Aquí tienes el listado general de jugadores.");
                break;
            case 6: // Configuración
                System.out.println("Elige un fichero donde desees guardar tus jugadores");
                break;
            case 7: // Salir
                System.out.println("Has salido del programa.");
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Recoge los datos necesarios para consultar un jugador por su ID.
     */
    private void recogerDatosConsultaID() {
        j = new Jugador();
        System.out.print("Id Jugador: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error, introduce un número");
            sc.next();
            System.out.print("Id Jugador: ");
        }
        j.setId(sc.nextInt());
    }

    /**
     * Recoge los datos necesarios para modificar un jugador existente.
     */
    private void recogerDatosModificar() {
        j = new Jugador();
        System.out.println("Introduce el id del jugador a modificar");
        System.out.print("Id Jugador: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error, introduce un número");
            sc.next();
            System.out.print("Id Jugador: ");
        }

        j.setId(sc.nextInt());

        // Solicitar datos para modificar
        System.out.print("Indica el nuevo nick: ");
        sc.nextLine();
        j.setNick(sc.nextLine());

        System.out.print("Indica el nuevo nivel de experiencia: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error, introduce un número");
            sc.next();
            System.out.print("Indica el nuevo nivel de experiencia: ");
        }
        j.setExperiencia(sc.nextInt());

        System.out.print("Indica el nuevo nivel de vida: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error, introduce un número");
            sc.next();
            System.out.print("Indica el nuevo nivel de vida: ");
        }
        j.setNvlVida(sc.nextInt());

        System.out.print("Indica la nueva cantidad de monedas: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error, introduce un número");
            sc.next();
            System.out.print("Indica la nueva cantidad de monedas: ");
        }
        j.setMonedas(sc.nextInt());
    }

    /**
     * Recoge los datos necesarios para eliminar un jugador.
     */
    private void recogerDatosBaja() {
        j = new Jugador();

        System.out.print("Id Jugador: ");
        while (!sc.hasNextInt()) {
            System.out.println("Error, introduce un número");
            sc.next();
            System.out.print("Id Jugador: ");
        }

        j.setId(sc.nextInt());
    }

    /**
     * Recoge los datos necesarios para dar de alta a un nuevo jugador.
     */
    private void recogerDatosAlta() {
        recogerDatosConsultaID();
        sc.nextLine();
        System.out.print("Nombre: ");
        j.setNick(sc.nextLine());
        System.out.print("Experiencia: ");
        j.setExperiencia(sc.nextInt());
        System.out.print("Nivel de vida: ");
        j.setNvlVida(sc.nextInt());
        System.out.print("Monedas: ");
        j.setMonedas(sc.nextInt());
    }

    /**
     * Muestra el menú de inicio en la consola.
     */
    public void mostrarMensajePanelInicio() {
        System.out.println("###################################");
        System.out.println("1. Añadir jugador/a");
        System.out.println("2. Eliminar jugador/a");
        System.out.println("3. Modificar jugador/a");
        System.out.println("4. Listado por código (ID)");
        System.out.println("5. Listado general");
        System.out.println("6. Configuración");
        System.out.println("7. Salir del programa");
        System.out.println("###################################");
    }

    /**
     * Muestra un mensaje en la consola.
     *
     * @param s el mensaje a mostrar
     */
    @Override
    public void mensaje(String s) {
        System.out.println(s);
    }

    /**
     * Vacía la pantalla de la consola.
     */
    public void vaciarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Muestra el menú de configuración y devuelve la opción elegida.
     *
     * @return la opción elegida por el usuario
     */
    @Override
    public int mostrarMenuConfiguracion() {
        System.out.println("##################################");
        System.out.println("1. Fichero secuencial de texto");
        System.out.println("2. Fichero secuencial binario");
        System.out.println("3. Fichero de objetos binario");
        System.out.println("4. Fichero de acceso aleatorio binario");
        System.out.println("5. Fichero de texto XML");
        System.out.println("##################################");

        return sc.nextInt();
    }
}
