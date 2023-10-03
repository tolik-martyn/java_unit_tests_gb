package hw5.task1.model;

import java.util.List;

/**
 * Интерфейс модели контактов.
 */
public interface ContactModel {
    /**
     * Добавляет новый контакт.
     *
     * @param name         Имя контакта.
     * @param phoneNumber  Номер телефона контакта.
     */
    void addContact(String name, String phoneNumber);

    /**
     * Редактирует контакт по его идентификатору.
     *
     * @param contactId      Идентификатор контакта для редактирования.
     * @param newName        Новое имя контакта.
     * @param newPhoneNumber Новый номер телефона контакта.
     */
    void editContact(int contactId, String newName, String newPhoneNumber);

    /**
     * Удаляет контакт по его идентификатору.
     *
     * @param contactId Идентификатор контакта для удаления.
     */
    void deleteContact(int contactId);

    /**
     * Получает список всех контактов.
     *
     * @return Список всех контактов.
     */
    List<Contact> getAllContacts();
}
