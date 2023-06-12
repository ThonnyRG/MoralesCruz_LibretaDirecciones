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
     * Constructor de la clase Menu que cre un archivo para crear un txt de las direcciones.
     *
     * @param addressBook La libreta de direcciones.
     */
    public Menu() {
        addressBook = new ArrayList<>();
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
                  searchEntries();
                    break;
                case 'e':
                    // Lógica para mostrar todas las entradas ordenadas por apellido
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo de texto: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            scanner = new Scanner(file);

            addressBook.clear(); // Clear the existing entries

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length == 4) {
                    String street = parts[0];
                    String city = parts[1];
                    String state = parts[2];
                    String postalCode = parts[3];

                    AddressEntry entry = new AddressEntry(street, city, state, postalCode);
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

    AddressEntry entry = new AddressEntry(firstName, lastName, new Address(street, city, "", postalCode));
    addressBook.add(entry);

    System.out.println("La entrada se agregó correctamente.");
}


    private void deleteEntry() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
            try {
        FileWriter writer = new FileWriter(FILE_PATH);
        for (AddressEntry entry : addressBook) {
            Address address = entry.getAddress();
            String line = address.getStreet() + ";" + address.getCity() + ";" +
                    address.getState() + ";" + address.getPostalCode() + "\n";
            writer.write(line);
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
