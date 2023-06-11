import java.util.List;
import java.util.Scanner;

/**
 * La clase Menu se utiliza para mostrar las opciones de menú al usuario y capturar las
 * entradas del usuario.
 */
public class Menu {
    private AddressBook addressBook;

    /**
     * Constructor de la clase Menu que acepta una instancia de AddressBook.
     *
     * @param addressBook La libreta de direcciones.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Muestra las opciones del menú y solicita al usuario que ingrese una opción.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            System.out.println("\nMenú:");
            System.out.println("a) Cargar entradas desde un archivo");
            System.out.println("b) Agregar una entrada");
            System.out.println("c) Eliminar una entrada");
            System.out.println("d) Buscar entradas por apellido");
            System.out.println("e) Mostrar todas las entradas ordenadas por apellido");
            System.out.println("f) Salir");
            System.out.print("Ingrese una opción: ");
            choice = scanner.nextLine().charAt(0);
            switch (choice) {
                case 'a':
                    // Lógica para cargar entradas desde un archivo
                    break;
                case 'b':
                    // Lógica para agregar una entrada
                    break;
                case 'c':
                    // Lógica para eliminar una entrada
                    break;
                case 'd':
                    // Lógica para buscar entradas por apellido
                    break;
                case 'e':
                    // Lógica para mostrar todas las entradas ordenadas por apellido
                    break;
                case 'f':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (choice != 'f');
    }

    // Métodos para implementar la lógica de cada opción del menú
}
