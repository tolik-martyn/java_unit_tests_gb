package hw5.task1.view;

import hw5.task1.model.Contact;

import java.util.List;

/**
 * Интерфейс представления контактов.
 */
public interface ContactView {
    /**
     * Отображает список контактов.
     *
     * @param contacts Список контактов для отображения.
     */
    void showAllContacts(List<Contact> contacts);

    /**
     * Отображает контакт по его идентификатору.
     *
     * @param contactId Идентификатор контакта.
     * @param contacts  Список контактов.
     */
    void showContactById(int contactId, List<Contact> contacts);
}
