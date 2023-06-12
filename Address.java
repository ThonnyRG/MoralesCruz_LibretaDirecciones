/**
 * La clase Address representa una dirección con variables de instancia para calle, ciudad,
 * estado y código postal.
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    /**
     * Constructor de la clase Address que acepta los valores para inicializar las variables.
     *
     * @param street     La calle de la dirección.
     * @param city       La ciudad de la dirección.
     * @param state      El estado de la dirección.
     * @param postalCode El código postal de la dirección.
     */
  public Address(String street, String city, String state, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
    /**
     * Devuelve la calle de la dirección.
     *
     * @return La calle de la dirección.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param street La calle de la dirección.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Devuelve la ciudad de la dirección.
     *
     * @return La ciudad de la dirección.
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad de la dirección.
     *
     * @param city La ciudad de la dirección.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Devuelve el estado de la dirección.
     *
     * @return El estado de la dirección.
     */
    public String getState() {
        return state;
    }

    /**
     * Establece el estado de la dirección.
     *
     * @param state El estado de la dirección.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Devuelve el código postal de la dirección.
     *
     * @return El código postal de la dirección.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param postalCode El código postal de la dirección.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Devuelve una representación en forma de cadena de la dirección.
     *
     * @return Una cadena que contiene la dirección completa.
     */
    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + "]";
    }
}
