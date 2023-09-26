package hw3.task0and3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса User")
class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("user", "password");
    }

    @Test
    @DisplayName("Проверка аутентификации с верными учетными данными")
    void testAuthenticateValidCredentials() {
        assertTrue(user.authenticate("user", "password"));
    }

    @Test
    @DisplayName("Проверка аутентификации с неверными учетными данными")
    void testAuthenticateInvalidCredentials() {
        assertFalse(user.authenticate("user", "wrongpassword"));
    }
}
