/**
 * La clase AddressEntry representa una única entrada de información de dirección/contacto
 * en la libreta de direcciones.
 */
public class AddressEntry {
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private String phone;

    /**
     * Constructor de la clase AddressEntry que acepta los valores para inicializar las variables.
     *
     * @param firstName   El nombre del contacto.
     * @param lastName    El apellido del contacto.
     * @param address     La dirección del contacto.
     * @param email       El correo electrónico del contacto.
     * @param phone       El número de teléfono del contacto.
     */
    public AddressEntry(String firstName, String lastName, Address address, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Devuelve el nombre del contacto.
     *
     * @return El nombre del contacto.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Devuelve el apellido del contacto.
     *
     * @return El apellido del contacto.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Devuelve la dirección del contacto.
     *
     * @return La dirección del contacto.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Devuelve el correo electrónico del contacto.
     *
     * @return El correo electrónico del contacto.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Devuelve el número de teléfono del contacto.
     *
     * @return El número de teléfono del contacto.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Devuelve una representación en forma de cadena de la entrada de dirección.
     *
     * @return Una cadena que contiene toda la información de contacto.
     */
    @Override
    public String toString() {
        return "Nombre: " + firstName + " " + lastName + "\n" +
                "Dirección: " + address.toString() + "\n" +
                "Correo electrónico: " + email + "\n" +
                "Teléfono: " + phone;
    }
}
