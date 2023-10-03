package hw5.task1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс модели контактов, реализующий интерфейс ContactModel.
 */
public class SimpleContactModel implements ContactModel {
    private final Map<Integer, Contact> contactMap;
    private int nextId;

    /**
     * Конструктор для создания модели контактов.
     */
    public SimpleContactModel() {
        contactMap = new HashMap<>();
        nextId = 1;
    }

    @Override
    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(nextId++, name, phoneNumber);
        contactMap.put(contact.getId(), contact);
    }

    @Override
    public void editContact(int contactId, String newName, String newPhoneNumber) {
        Contact contact = contactMap.get(contactId);
        if (contact != null) {
            contact.setName(newName);
            contact.setPhoneNumber(newPhoneNumber);
        }
    }

    @Override
    public void deleteContact(int contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactMap.values());
    }
}
