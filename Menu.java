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
                  loadEntriesFromFile();
                    break;
                case 'b':
                  addEntry();
                    break;
                case 'c':
                  // Lógica para eliminar una entrada
                  deleteEntry();
                    break;
                case 'd':
                  // Lógica para buscar entradas por apellido
                  searchEntriesByLastName();
                    break;
                case 'e':
                    // Lógica para mostrar todas las entradas ordenadas por apellido
                  showEntriesOrderedByLastName();
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
private void loadEntriesFromFile() {
        System.out.println("Cargando entradas desde un archivo...");
        // Lógica para cargar las entradas desde un archivo
        // addressBook.loadEntriesFromFile(fileName);
    }

    private void addEntry() {
        System.out.println("Agregar una entrada:");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nombre: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Calle: ");
        String street = scanner.nextLine();
        
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        
        System.out.print("Estado: ");
        String state = scanner.nextLine();
        
        System.out.print("Código Postal: ");
        String zipCode = scanner.nextLine();
        
        System.out.print("Correo Electrónico: ");
        String email = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();

        Address address = new Address(street, city, state, zipCode);
        AddressEntry entry = new AddressEntry(firstName, lastName, address, email, phone);
        addressBook.addEntry(entry);
        
        System.out.println("La entrada ha sido agregada correctamente.");
    }

    private void deleteEntry() {
        System.out.println("Eliminar una entrada:");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el apellido para buscar la entrada: ");
        String lastName = scanner.nextLine();
        
        AddressEntry entry = addressBook.searchEntryByLastName(lastName);
        
        if (entry == null) {
            System.out.println("No se encontró ninguna entrada con ese apellido.");
            return;
        }
        
        System.out.println("Se encontró la siguiente entrada:");
        System.out.println(entry);
        
        System.out.print("¿Está seguro de eliminar esta entrada? (s/n): ");
        String confirmation = scanner.nextLine();
        
        if (confirmation.equalsIgnoreCase("s")) {
            addressBook.deleteEntry(entry);
            System.out.println("La entrada ha sido eliminada correctamente.");
        } else {
            System.out.println("La entrada no ha sido eliminada.");
        }
    }

    private void searchEntriesByLastName() {
        System.out.println("Buscar entradas por apellido:");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el apellido (o parte del apellido) para buscar: ");
        String lastName = scanner.nextLine();
        
        List<AddressEntry> entries = addressBook.searchEntriesByLastName(lastName);
        
        if (entries.isEmpty()) {
            System.out.println("No se encontraron entradas con ese apellido.");
        } else {
            System.out.println("Se encontraron las siguientes entradas:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    private void showEntriesOrderedByLastName() {
        System.out.println("Mostrar todas las entradas ordenadas por apellido:");
        List<AddressEntry> entries = addressBook.getEntriesOrderedByLastName();
        
        if (entries.isEmpty()) {
            System.out.println("No hay entradas para mostrar.");
        } else {
            System.out.println("Las entradas se muestran a continuación:");
            for (AddressEntry entry : entries) {
                System.out.println(entry);
            }
        }
    }
}
