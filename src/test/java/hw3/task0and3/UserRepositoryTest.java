package hw3.task0and3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса UserRepository")
class UserRepositoryTest {

    private UserRepository repository;
    private User user1;
    private User user2;
    private User admin;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        user1 = new User("user1", "password1");

        user2 = new User("user2", "password2");
        user2.authenticate("user2", "password2");

        admin = new User("admin", "adminpassword");
        admin.authenticate("admin", "adminpassword");
        admin.setAdmin(true);

        repository = new UserRepository();
        repository.addUser(user2);
        repository.addUser(admin);

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("Проверка успешного добавления пользователя")
    void testAddUserSuccess() {
        user1.authenticate("user1", "password1");
        repository.addUser(user1);
        assertTrue(output.toString().contains("Пользователь user1 успешно добавлен в систему."));
        assertTrue(repository.findByName("user1"));
    }

    @Test
    @DisplayName("Проверка добавления пользователя без аутентификации")
    void testAddUserWithoutAuthentication() {
        repository.addUser(user1);
        assertTrue(output.toString().contains("Пользователь user1 не прошел аутентификацию."));
        assertFalse(repository.findByName("user1"));
    }

    @Test
    @DisplayName("Проверка добавления дубликата пользователя")
    void testAddDuplicateUser() {
        repository.addUser(user2);
        assertTrue(output.toString().contains("Пользователь user2 уже существует в системе."));
        assertTrue(repository.findByName("user2"));
    }

    @Test
    @DisplayName("Поиск существующего пользователя")
    void testFindExistingUser() {
        assertTrue(repository.findByName("admin"));
    }

    @Test
    @DisplayName("Поиск пользователя, отсутствующего в репозитории")
    void testFindNonExistingUser() {
        assertFalse(repository.findByName("user"));
    }

    @Test
    @DisplayName("Проверка разлогинивания всех пользователей, кроме администраторов")
    void testLogoutAllUsersExceptAdmins() {
        repository.logoutAllUsersExceptAdmins();
        assertFalse(user2.isAuthenticate());
        assertTrue(admin.isAuthenticate());
        assertTrue(output.toString().contains("Все пользователи, кроме администраторов, были разлогинены."));
    }
}



