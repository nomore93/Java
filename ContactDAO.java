import java.util.ArrayList;
import java.util.List;

//DAO - Data Access Object
//    - Objekt pro přístup k datům
// DATOVÁ VRSTVA

public class ContactDAO {
    // Vytvoření listu s kontakty
    private List<Contact> contacts = new ArrayList<>();

    // Přidání nového kontaktu
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Zobrazení seznamu kontaktu
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    // Vyhledávání dle jména
    public List<Contact> searchByName(String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact x : contacts) {
            if (x.getName().equalsIgnoreCase(name)) {
                result.add(x);
            }
        }
        return result;
    }

}
