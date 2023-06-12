/**
 * La clase AddressBookApplication contiene la clase principal de la aplicación.
 * Se encarga de crear una instancia de AddressBook, una instancia de Menu y
 * llamar al método displayMenu() de Menu para mostrar el menú y capturar las
 * entradas del usuario.
 */
public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
