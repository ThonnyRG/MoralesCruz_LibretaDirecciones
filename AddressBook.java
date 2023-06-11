import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La clase AddressBook representa una libreta de direcciones que contiene una lista de
 * entradas de direcciones.
 */
public class AddressBook {
    private List<AddressEntry> entries;

    /**
     * Constructor de la clase AddressBook que inicializa la lista de entradas.
     */
    public AddressBook() {
        entries = new ArrayList<>();
    }

    /**
     * Agrega una entrada a la libreta de direcciones.
     *
     * @param entry La entrada de dirección a agregar.
     */
    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }

    /**
     * Elimina una entrada de la libreta de direcciones.
     *
     * @param entry La entrada de dirección a eliminar.
     */
    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
    }

    /**
     * Busca y devuelve una lista de entradas de direcciones que coinciden con el apellido
     * proporcionado.
     *
     * @param lastName El apellido a buscar.
     * @return Una lista de entradas de direcciones que coinciden con el apellido.
     */
    public List<AddressEntry> searchByLastName(String lastName) {
        List<AddressEntry> matchingEntries = new ArrayList<>();
        for (AddressEntry entry : entries) {
            if (entry.getLastName().startsWith(lastName)) {
                matchingEntries.add(entry);
            }
        }
        return matchingEntries;
    }

    /**
     * Devuelve una lista de entradas de direcciones ordenadas alfabéticamente por apellido.
     *
     * @return Una lista de entradas de direcciones ordenadas por apellido.
     */
    public List<AddressEntry> getEntriesSortedByLastName() {
        List<AddressEntry> sortedEntries = new ArrayList<>(entries);
        Collections.sort(sortedEntries, (a, b) -> a.getLastName().compareToIgnoreCase(b.getLastName()));
        return sortedEntries;
    }
}
