class AddressEntry implements Comparable<AddressEntry> {
    private static int nextId = 1;

    private int id;
    private String firstName;
    private String lastName;
    private Address address;

    public AddressEntry(String firstName, String lastName, Address address) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public AddressEntry(String street, String city, String state, String postalCode) {
        this.id = nextId++;
        this.firstName = "";
        this.lastName = "";
        this.address = new Address(street, city, state, postalCode);
    }

    public int getId() {
        return id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Address: " + address.toString();
    }

    @Override
    public int compareTo(AddressEntry entry) {
        return this.getLastName().compareTo(entry.getLastName());
    }
}