/**
 * La clase AddressBookApplication contiene la clase principal de la aplicación.
 * Se encarga de crear una instancia de AddressBook, una instancia de Menu y
 * llamar al método displayMenu() de Menu para mostrar el menú y capturar las
 * entradas del usuario.
 */
public class AddressBookApplication {
    /**
     * El método main es el punto de entrada de la aplicación.
     * Crea una instancia de AddressBook, una instancia de Menu y llama
     * al método displayMenu() de Menu para mostrar el menú y capturar
     * las entradas del usuario.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
