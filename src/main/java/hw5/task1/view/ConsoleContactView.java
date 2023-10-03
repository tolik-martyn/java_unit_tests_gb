package hw5.task1.view;

import hw5.task1.model.Contact;

import java.util.List;

/**
 * Класс представления контактов для отображения в консоли.
 */
public class ConsoleContactView implements ContactView {
    @Override
    public void showAllContacts(List<Contact> contacts) {
        if (contacts == null || contacts.isEmpty()){
            return;
        }
        System.out.println("Все контакты:");
        for (Contact contact : contacts) {
            System.out.println("ID: " + contact.getId() + ", имя: " + contact.getName() + ", телефон: " + contact.getPhoneNumber());
        }
    }

    @Override
    public void showContactById(int contactId, List<Contact> contacts) {
        if (contacts == null || contacts.isEmpty()){
            return;
        }
        System.out.print("Контакт ID: " + contactId);
        for (Contact contact : contacts) {
            if (contact.getId() == contactId) {
                System.out.println(" - имя: " + contact.getName() + ", телефон: " + contact.getPhoneNumber());
                return;
            }
        }
        System.out.println(" - не найден");
    }
}
