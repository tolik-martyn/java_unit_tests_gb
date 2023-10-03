package hw5.task1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-тесты класса SimpleContactModel")
class SimpleContactModelTest {
    private ContactModel contactModel;

    @BeforeEach
    void setUp() {
        contactModel = new SimpleContactModel();
    }

    @Test
    @DisplayName("Добавление контакта")
    void testAddContact() {
        contactModel.addContact("Иванов Иван", "111");
        List<Contact> contacts = contactModel.getAllContacts();
        assertEquals(1, contacts.size());

        Contact addedContact = contacts.get(0);
        assertEquals("Иванов Иван", addedContact.getName());
        assertEquals("111", addedContact.getPhoneNumber());
    }

    @Test
    @DisplayName("Редактирование контакта")
    void testEditContact() {
        contactModel.addContact("Иванов Иван", "111");
        List<Contact> contacts = contactModel.getAllContacts();
        Contact contactToEdit = contacts.get(0);

        int contactId = contactToEdit.getId();
        contactModel.editContact(contactId, "Петров Петр", "777");

        List<Contact> updatedContacts = contactModel.getAllContacts();
        assertEquals(1, updatedContacts.size());

        Contact editedContact = updatedContacts.get(0);
        assertEquals("Петров Петр", editedContact.getName());
        assertEquals("777", editedContact.getPhoneNumber());
    }

    @Test
    @DisplayName("Удаление контакта")
    void testDeleteContact() {
        contactModel.addContact("Иванов Иван", "111");
        List<Contact> contacts = contactModel.getAllContacts();
        Contact contactToDelete = contacts.get(0);

        int contactId = contactToDelete.getId();
        contactModel.deleteContact(contactId);

        List<Contact> updatedContacts = contactModel.getAllContacts();
        assertTrue(updatedContacts.isEmpty());
    }

    @Test
    @DisplayName("Получение списка всех контактов")
    void testGetAllContacts() {
        contactModel.addContact("Иванов Иван", "111");
        contactModel.addContact("Петров Петр", "777");

        List<Contact> contacts = contactModel.getAllContacts();
        assertEquals(2, contacts.size());
    }
}
