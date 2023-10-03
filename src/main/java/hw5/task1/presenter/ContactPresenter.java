package hw5.task1.presenter;

import hw5.task1.model.Contact;
import hw5.task1.model.ContactModel;
import hw5.task1.view.ContactView;

import java.util.List;

/**
 * Презентер контактов, обеспечивающий взаимодействие между моделью и представлением.
 */
public class ContactPresenter {
    private ContactModel model;
    private ContactView view;

    /**
     * Конструктор презентера.
     *
     * @param model Модель контактов.
     * @param view  Представление контактов.
     */
    public ContactPresenter(ContactModel model, ContactView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Добавляет новый контакт.
     *
     * @param name        Имя контакта.
     * @param phoneNumber Номер телефона контакта.
     */
    public void addContact(String name, String phoneNumber) {
        model.addContact(name, phoneNumber);
    }

    /**
     * Редактирует контакт.
     *
     * @param contactId      Идентификатор контакта для редактирования.
     * @param newName        Новое имя контакта.
     * @param newPhoneNumber Новый номер телефона контакта.
     */
    public void editContact(int contactId, String newName, String newPhoneNumber) {
        model.editContact(contactId, newName, newPhoneNumber);
    }

    /**
     * Удаляет контакт и обновляет представление.
     *
     * @param contactId Идентификатор контакта для удаления.
     */
    public void deleteContact(int contactId) {
        model.deleteContact(contactId);
    }

    /**
     * Обновляет представление, отображая текущий список контактов.
     */
    public void showAllContacts() {
        List<Contact> contacts = model.getAllContacts();
        view.showAllContacts(contacts);
    }

    /**
     * Отображает контакт по его идентификатору.
     *
     * @param contactId Идентификатор контакта.
     */
    public void showContactById(int contactId) {
        List<Contact> contacts = model.getAllContacts();
        view.showContactById(contactId, contacts);
    }
}
