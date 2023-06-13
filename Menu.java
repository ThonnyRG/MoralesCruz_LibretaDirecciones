import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * La clase Menu se utiliza para mostrar las opciones de menú al usuario y capturar las
 * entradas del usuario.
 */
public class Menu {
    private static final String FILE_PATH = "Directions.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private List<AddressEntry> addressBook;

    /**
     * Constructor de la clase Menu.
     * Inicializa la lista de direcciones (addressBook) como una lista vacía.
     */
    public Menu() {
        addressBook = new ArrayList<>();
    }

    /**
     * Muestra las opciones del menú y solicita al usuario que ingrese una opción.
     * El método se ejecuta en un bucle infinito hasta que el usuario elija salir.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("a) Cargar entradas desde un archivo");
            System.out.println("b) Agregar una entrada");
            System.out.println("c) Eliminar una entrada");
            System.out.println("d) Buscar entradas por apellido");
            System.out.println("e) Mostrar todas las entradas ordenadas por apellido");
            System.out.println("f) Salir");
            System.out.print("Ingrese una opción: ");

            String input = scanner.nextLine();

            if (input.length() > 0) {
                char choice = input.charAt(0);

                if (choice == 'f') {
                    System.out.println("Saliendo del programa...");
                    break;
                }

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
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        }
    }

    /**
     * Carga las entradas de dirección desde un archivo de texto.
     * Solicita al usuario que ingrese el nombre del archivo.
     * Cada entrada en el archivo debe estar separada por una línea en blanco.
     * Las entradas se agregan a la lista addressBook.
     */
    private void loadEntriesFromFile() {
        System.out.print("Ingrese el nombre del archivo de texto: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            addressBook.clear(); // Limpiar las entradas existentes

            StringBuilder entryBuilder = new StringBuilder();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (!line.isEmpty()) {
                    entryBuilder.append(line).append("\n");
                } else {
                    String entryString = entryBuilder.toString();
                    if (!entryString.isEmpty()) {
                        AddressEntry entry = AddressEntry.fromString(entryString);
                        addressBook.add(entry);
                        entryBuilder.setLength(0); // Limpiar el StringBuilder
                    }
                }
            }

            // Comprobar si queda una entrada por procesar
            String entryString = entryBuilder.toString();
            if (!entryString.isEmpty()) {
                AddressEntry entry = AddressEntry.fromString(entryString);
                addressBook.add(entry);
            }

            System.out.println("Las entradas se han cargado correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Agrega una nueva entrada de dirección a la lista addressBook.
     * Solicita al usuario que ingrese los detalles de la entrada (nombre, apellido, calle, ciudad, etc.).
     * Después de agregar la entrada, se guarda en el archivo.
     */
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

    /**
     * Elimina una entrada de dirección de la lista addressBook.
     * Solicita al usuario que ingrese el inicio del apellido para buscar las coincidencias.
     * Si encuentra coincidencias, muestra las entradas y permite al usuario seleccionar una para eliminar.
     * Después de eliminar la entrada, se guarda en el archivo.
     */
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

    /**
     * Busca las entradas de dirección por el inicio del apellido proporcionado por el usuario.
     * Muestra las coincidencias encontradas en la lista addressBook.
     */
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

    /**
     * Muestra todas las entradas de dirección ordenadas por apellido.
     * Utiliza el comparador para ordenar la lista addressBook.
     */
    private void displayEntries() {
        Collections.sort(addressBook, Comparator.comparing(AddressEntry::getLastName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Todas las entradas ordenadas por apellido:");
        for (AddressEntry entry : addressBook) {
            System.out.println(entry);
        }
    }

    /**
     * Muestra los resultados de la búsqueda de entradas.
     * Enumera las entradas con números para que el usuario pueda seleccionar una opción.
     */
    private void displaySearchResults(List<AddressEntry> entries) {
        int count = 1;
        for (AddressEntry entry : entries) {
            System.out.println(count + ") " + entry);
            count++;
        }
    }

    /**
     * Guarda todas las entradas de dirección en un archivo de texto.
     * Cada entrada se guarda como una cadena de texto en el archivo.
     */
    private void saveEntries() {
        if (addressBook.isEmpty()) {
            System.out.println("No hay entradas en la libreta de direcciones.");
            return;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (AddressEntry entry : addressBook) {
                writer.write(entry.toString());
                writer.write(System.lineSeparator());
                writer.write(System.lineSeparator());
            }
            System.out.println("Las entradas se han guardado correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
