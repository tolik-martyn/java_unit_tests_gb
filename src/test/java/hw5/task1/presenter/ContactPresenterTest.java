package hw5.task1.presenter;

import hw5.task1.model.Contact;
import hw5.task1.model.ContactModel;
import hw5.task1.model.SimpleContactModel;
import hw5.task1.view.ConsoleContactView;
import hw5.task1.view.ContactView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Integration-тесты класса ContactPresenter")
class ContactPresenterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ContactPresenter contactPresenter;
    private ContactModel contactModel;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        contactModel = new SimpleContactModel();
        ContactView contactView = new ConsoleContactView();
        contactPresenter = new ContactPresenter(contactModel, contactView);
    }

    @Test
    @DisplayName("Добавление контакта")
    void testAddContact() {
        contactPresenter.addContact("Иванов Иван", "111");
        List<Contact> contacts = contactModel.getAllContacts();
        assertEquals(1, contacts.size());

        Contact addedContact = contacts.get(0);
        assertEquals("Иванов Иван", addedContact.getName());
        assertEquals("111", addedContact.getPhoneNumber());
    }

    @Test
    @DisplayName("Редактирование контакта")
    void testEditContact() {
        contactPresenter.addContact("Иванов Иван", "111");
        int contactId = contactModel.getAllContacts().get(0).getId();

        contactPresenter.editContact(contactId, "Петров Петр", "777");
        List<Contact> updatedContacts = contactModel.getAllContacts();
        assertEquals(1, updatedContacts.size());

        Contact editedContact = updatedContacts.get(0);
        assertEquals("Петров Петр", editedContact.getName());
        assertEquals("777", editedContact.getPhoneNumber());
    }

    @Test
    @DisplayName("Удаление контакта")
    void testDeleteContact() {
        contactPresenter.addContact("Иванов Иван", "111");
        int contactId = contactModel.getAllContacts().get(0).getId();

        contactPresenter.deleteContact(contactId);
        List<Contact> updatedContacts = contactModel.getAllContacts();
        assertTrue(updatedContacts.isEmpty());
    }

    @Test
    @DisplayName("Отображение всех контактов")
    void testShowAllContacts() {
        contactPresenter.addContact("Иванов Иван", "111");
        contactPresenter.addContact("Петров Петр", "777");

        contactPresenter.showAllContacts();

        // В Windows используется комбинация символов \r\n (возврат каретки и перевод строки).
        String expectedOutput = """
                Все контакты:\r
                ID: 1, имя: Иванов Иван, телефон: 111\r
                ID: 2, имя: Петров Петр, телефон: 777\r
                """;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Отображение контакта по ID")
    void testShowContactById() {
        contactPresenter.addContact("Иванов Иван", "111");
        contactPresenter.addContact("Петров Петр", "777");

        contactPresenter.showContactById(2);

        // В Windows используется комбинация символов \r\n (возврат каретки и перевод строки).
        String expectedOutput = "Контакт ID: 2 - имя: Петров Петр, телефон: 777\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalOut);
    }
}
