package hw5.task1.view;

import hw5.task1.model.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-тесты класса ConsoleContactView")
class ConsoleContactViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ContactView contactView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        contactView = new ConsoleContactView();
    }

    @Test
    @DisplayName("Показать все контакты")
    void testShowAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Иванов Иван", "111"));
        contacts.add(new Contact(2, "Петров Петр", "777"));

        contactView.showAllContacts(contacts);

        // В Windows используется комбинация символов \r\n (возврат каретки и перевод строки).
        String expectedOutput = """
                Все контакты:\r
                ID: 1, имя: Иванов Иван, телефон: 111\r
                ID: 2, имя: Петров Петр, телефон: 777\r
                """;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Показать контакт по ID")
    void testShowContactById() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Иванов Иван", "111"));
        contacts.add(new Contact(2, "Петров Петр", "777"));

        contactView.showContactById(2, contacts);

        // В Windows используется комбинация символов \r\n (возврат каретки и перевод строки).
        String expectedOutput = "Контакт ID: 2 - имя: Петров Петр, телефон: 777\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Показать контакт по ID (если не найден)")
    void testShowContactByIdIfNotFound() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Иванов Иван", "111"));

        contactView.showContactById(2, contacts);

        // В Windows используется комбинация символов \r\n (возврат каретки и перевод строки).
        String expectedOutput = "Контакт ID: 2 - не найден\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Показать все контакты (если список пуст)")
    void testShowAllContactsIfEmptyList() {
        List<Contact> contacts = new ArrayList<>();

        contactView.showAllContacts(contacts);

        String expectedOutput = "";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Показать контакт по ID (если список пуст)")
    void testShowContactByIdIfEmptyList() {
        List<Contact> contacts = new ArrayList<>();

        contactView.showContactById(1, contacts);

        String expectedOutput = "";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Показать контакт по ID (если список равен null)")
    void testShowContactByIdIfNullList() {
        contactView.showContactById(1, null);

        String expectedOutput = "";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Показать все контакты (если список равен null)")
    void testShowAllContactsIfNullList() {
        contactView.showAllContacts(null);

        String expectedOutput = "";

        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalOut);
    }
}
