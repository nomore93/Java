import java.util.List;

// APLIKACNI VRSTVA

public class ContactService {
    private ContactDAO contactDAO;

    public ContactService(ContactDAO dao) {
        this.contactDAO = dao;
    }

    public void addContact(String name, String surname, int Age) {
        Contact newContact = new Contact(name, surname, Age);
        contactDAO.addContact(newContact);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    public List<Contact> searchContacts(String name) {
        return contactDAO.searchByName(name);
    }

}
