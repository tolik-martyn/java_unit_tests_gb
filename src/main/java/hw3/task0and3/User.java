package hw3.task0and3;

/**
 * Класс представляет пользователя системы.
 */
public class User {
    private String name;
    private String password;
    boolean isAuthenticate = false;
    boolean isAdmin = false;

    /**
     * Конструктор класса User.
     *
     * @param name     Имя пользователя.
     * @param password Пароль пользователя.
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Проверяет аутентификацию пользователя.
     *
     * @param inputName     Введенное имя пользователя.
     * @param inputPassword Введенный пароль пользователя.
     * @return true, если введенное имя и пароль совпадают с данными пользователя, иначе - false.
     */
    public boolean authenticate(String inputName, String inputPassword) {
        return isAuthenticate = inputName.equals(name) && inputPassword.equals(password);
    }

    public String getName() {
        return name;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
