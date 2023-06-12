public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phoneNumber;

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
        this.postalCode = postalCode;
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
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Address: " + street + "\n" +
                city + ", " + state + " cp. " + postalCode + "\n" +
                "Email: " + email +"\n" +
                "Phone: " + phoneNumber;
    }
}
