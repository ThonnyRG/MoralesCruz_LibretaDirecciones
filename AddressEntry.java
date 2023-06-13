public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phoneNumber;

    /**
     * Crea una nueva instancia de AddressEntry con los detalles proporcionados.
     *
     * @param firstName   el nombre del contacto
     * @param lastName    el apellido del contacto
     * @param street      la calle de la dirección del contacto
     * @param city        la ciudad de la dirección del contacto
     * @param state       el estado de la dirección del contacto
     * @param postalCode  el código postal de la dirección del contacto
     * @param email       el correo electrónico del contacto
     * @param phoneNumber el número de teléfono del contacto
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state,
                        String postalCode, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Crea una instancia de AddressEntry a partir de una cadena de entrada.
     * La cadena de entrada debe tener el siguiente formato: "Nombre: Juan, Apellido: Perez, Calle: Av. Principal, Ciudad: Ciudad de Mexico, ..."
     *
     * @param entryString la cadena de entrada que representa una entrada de dirección
     * @return una instancia de AddressEntry creada a partir de la cadena de entrada
     */
    public static AddressEntry fromString(String entryString) {
        // Implementa la lógica para analizar la cadena de entrada y crear un objeto AddressEntry
        String[] parts = entryString.split(",");
        String firstName = extractValue(parts[0]);
        String lastName = extractValue(parts[1]);
        String street = extractValue(parts[2]);
        String city = extractValue(parts[3]);
        String state = extractValue(parts[4]);
        String postalCode = extractValue(parts[5]);
        String email = extractValue(parts[6]);
        String phoneNumber = extractValue(parts[7]);

        return new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phoneNumber);
    }

    /**
     * Extrae el valor de una parte de la cadena de entrada.
     * Por ejemplo, para la parte " Nombre: Juan", se extraerá "Juan".
     *
     * @param part la parte de la cadena de entrada
     * @return el valor extraído de la parte de la cadena de entrada
     */
    private static String extractValue(String part) {
        // Extrae el valor de una parte de la cadena de entrada (por ejemplo, " Nombre: Juan")
        // Elimina el nombre del campo y recorta el valor
        return part.substring(part.indexOf(':') + 1).trim();
    }

    // Métodos getter y setter para los campos

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        if (isValidPostalCode(postalCode)) {
            this.postalCode = postalCode;
        } else {
            System.out.println("Entrada inválida: el código postal debe contener solo dígitos.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Entrada inválida: el número de teléfono debe contener solo dígitos.");
        }
    }

    /**
     * Verifica si un código postal es válido.
     * Un código postal válido debe contener solo dígitos.
     *
     * @param postalCode el código postal a verificar
     * @return true si el código postal es válido, false en caso contrario
     */
    private boolean isValidPostalCode(String postalCode) {
        return postalCode.matches("\\d+"); // Verifica si el código postal contiene solo dígitos
    }

    /**
     * Verifica si un número de teléfono es válido.
     * Un número de teléfono válido debe contener solo dígitos.
     *
     * @param phoneNumber el número de teléfono a verificar
     * @return true si el número de teléfono es válido, false en caso contrario
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d+"); // Verifica si el número de teléfono contiene solo dígitos
    }

    /**
     * Devuelve una representación de cadena de la entrada de dirección.
     * La representación de cadena contiene todos los detalles de la entrada de dirección.
     *
     * @return una representación de cadena de la entrada de dirección
     */
    @Override
    public String toString() {
        return "Nombre: " + firstName + " " + lastName + "\n" +
                "Calle: " + street + "\n" +
                "Ciudad: " + city + "\n" +
                "Estado: " + state + "\n" +
                "Código Postal: " + postalCode + "\n" +
                "Correo Electrónico: " + email + "\n" +
                "Teléfono: " + phoneNumber;
    }
}
