package hw3.task0and3;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий репозиторий пользователей.
 */
public class UserRepository {
    List<User> dataUser = new ArrayList<>();

    /**
     * Добавляет пользователя в репозиторий.
     *
     * @param user Пользователь для добавления.
     */
    public void addUser(User user) {
        if (user.isAuthenticate()) {
            if (findByName(user.getName())) {
                System.out.println("Пользователь " + user.getName() + " уже существует в системе.");
            } else {
                dataUser.add(user);
                System.out.println("Пользователь " + user.getName() + " успешно добавлен в систему.");
            }
        } else {
            System.out.println("Пользователь " + user.getName() + " не прошел аутентификацию.");
        }
    }

    /**
     * Проверяет, существует ли пользователь с указанным именем в репозитории.
     *
     * @param username Имя пользователя для поиска.
     * @return true, если пользователь с указанным именем существует, иначе false.
     */
    public boolean findByName(String username) {
        return dataUser.stream()
                .anyMatch(user -> user.getName().equals(username));
    }

    /**
     * Разлогинивает всех пользователей, кроме администраторов.
     */
    public void logoutAllUsersExceptAdmins() {
        dataUser.stream()
                .filter(user -> !user.isAdmin())
                .forEach(user -> user.setAuthenticate(false));
        System.out.println("Все пользователи, кроме администраторов, были разлогинены.");
    }
}
