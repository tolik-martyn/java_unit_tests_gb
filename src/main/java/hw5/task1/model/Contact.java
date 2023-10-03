package hw5.task1.model;

/**
 * Класс, представляющий данные контакта.
 */
public class Contact {
    private final int id;
    private String name;
    private String phoneNumber;

    /**
     * Конструктор для создания контакта.
     *
     * @param id          Идентификатор контакта.
     * @param name        Имя контакта.
     * @param phoneNumber Номер телефона контакта.
     */
    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Получает идентификатор контакта.
     *
     * @return Идентификатор контакта.
     */
    public int getId() {
        return id;
    }

    /**
     * Получает имя контакта.
     *
     * @return Имя контакта.
     */
    public String getName() {
        return name;
    }

    /**
     * Получает номер телефона контакта.
     *
     * @return Номер телефона контакта.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Устанавливает имя контакта.
     *
     * @param name Новое имя контакта.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает номер телефона контакта.
     *
     * @param phoneNumber Новый номер телефона контакта.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
