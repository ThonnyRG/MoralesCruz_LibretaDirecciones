import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Menu se utiliza para mostrar las opciones de menú al usuario y capturar las
 * entradas del usuario.
 */
public class Menu {
    private static final String FILE_PATH = "Directions.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private List<AddressEntry> addressBook;

    /**
     * Constructor de la clase Menu que crea una libreta de direcciones vacía.
     */
    public Menu() {
        addressBook = new ArrayList<>();
    }

    /**
     * Muestra las opciones del menú y solicita al usuario que ingrese una opción.
     */
    public void displayMenu() {
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
                    loadEntriesFromFile();
                    break;
                case 'b':
                    addEntry();
                    break;
                case 'c':
                    deleteEntry();
                    break;
                case 'd':
                    searchEntries();
                    break;
                case 'e':
                    displayEntries();
                    break;
                case 'f':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (choice != 'f');
    }

    private void loadEntriesFromFile() {
        System.out.print("Ingrese el nombre del archivo de texto: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            addressBook.clear(); // Clear the existing entries

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length == 4) {
                    String street = parts[0];
                    String city = parts[1];
                    String state = parts[2];
                    String postalCode = parts[3];

                    AddressEntry entry = new AddressEntry("", "", street, city, state, postalCode, "", "");
                    addressBook.add(entry);
                }
            }

            System.out.println("Las entradas se han cargado correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void addEntry() {
    System.out.print("Ingrese el nombre: ");
    String firstName = scanner.nextLine();

    System.out.print("Ingrese el apellido: ");
    String lastName = scanner.nextLine();

    System.out.print("Ingrese la calle: ");
    String street = scanner.nextLine();

    System.out.print("Ingrese la ciudad: ");
    String city = scanner.nextLine();

    System.out.print("Ingrese el código postal: ");
    String postalCode = scanner.nextLine();

    System.out.print("Ingrese el correo electrónico: ");
    String email = scanner.nextLine();

    System.out.print("Ingrese el número de teléfono: ");
    String phoneNumber = scanner.nextLine();

    System.out.print("Ingrese el estado: ");
    String state = scanner.nextLine();

   AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phoneNumber);

    addressBook.add(entry);

    System.out.println("La entrada se está guardando...");
    saveEntries();
    }

    private void deleteEntry() {
        System.out.print("Ingrese el inicio del apellido del usuario: ");
        String query = scanner.nextLine();

        List<AddressEntry> searchResults = new ArrayList<>();

        for (AddressEntry entry : addressBook) {
            if (entry.getLastName().startsWith(query)) {
                searchResults.add(entry);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No se encontraron coincidencias para el apellido proporcionado.");
        } else {
            System.out.println("Coincidencias encontradas:");
            displaySearchResults(searchResults);

            System.out.print("Ingrese el número de la entrada que desea eliminar: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice >= 1 && choice <= searchResults.size()) {
                AddressEntry entryToDelete = searchResults.get(choice - 1);
                addressBook.remove(entryToDelete);
                System.out.println("La entrada ha sido eliminada correctamente.");
            } else {
                System.out.println("Opción inválida. No se ha eliminado ninguna entrada.");
            }
        }
    }

    private void searchEntries() {
        System.out.print("Ingrese el inicio del apellido del usuario: ");
        String query = scanner.nextLine();

        List<AddressEntry> searchResults = new ArrayList<>();

        for (AddressEntry entry : addressBook) {
            if (entry.getLastName().startsWith(query)) {
                searchResults.add(entry);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No se encontraron coincidencias para el apellido proporcionado.");
        } else {
            System.out.println("Coincidencias encontradas:");
            displaySearchResults(searchResults);
        }
    }

    private void displayEntries() {
        Collections.sort(addressBook, (entry1, entry2) -> entry1.getLastName().compareToIgnoreCase(entry2.getLastName()));

        System.out.println("Todas las entradas ordenadas por apellido:");
        for (AddressEntry entry : addressBook) {
            System.out.println(entry);
        }
    }

private void saveEntries() {
    try {
        FileWriter writer = new FileWriter(FILE_PATH);
        int count = 1;
        for (AddressEntry entry : addressBook) {
            String line = count + ": " + entry.getFirstName() + " " + entry.getLastName() + "\n" +
                    entry.getStreet() + "\n" +
                    entry.getCity() + ", " + entry.getState() + " cp. " + entry.getPostalCode() + "\n" +
                    entry.getEmail() + "\n" +
                    entry.getPhoneNumber() + "\n\n";
            writer.write(line);
            count++;
        }
        writer.close();
        System.out.println("Las entradas se han guardado correctamente en el archivo.");
    } catch (IOException e) {
        System.out.println("Error al guardar las entradas en el archivo: " + e.getMessage());
    }
}


    private void displaySearchResults(List<AddressEntry> entries) {
        int count = 1;
        for (AddressEntry entry : entries) {
            System.out.println(count + ") " + entry);
            count++;
        }
    }
}
