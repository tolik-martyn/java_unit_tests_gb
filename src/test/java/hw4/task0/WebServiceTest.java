package hw4.task0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("Тесты класса WebService")
class WebServiceTest {
    private WebService webService;
    private HttpClient httpClient;

    @BeforeEach
    public void setUp() {
        httpClient = mock(HttpClient.class);
        webService = new WebService(httpClient);
    }

    @Test
    @DisplayName("Тест получения данных с веб-сайта")
    public void testGetDataFromWebsite() {
        // Задаем ожидаемый результат от HttpClient
        String expectedResponse = "Mocked response";

        // Устанавливаем поведение мок-объекта HttpClient при вызове метода get
        when(httpClient.get(anyString())).thenReturn(expectedResponse);

        // Вызываем метод getDataFromWebsite
        String actualResponse = webService.getDataFromWebsite("https://example.com");

        // Проверяем, что метод getDataFromWebsite вернул ожидаемый результат
        assertEquals(expectedResponse, actualResponse);

        // Проверяем, что метод get был вызван ровно один раз с ожидаемым URL
        verify(httpClient, times(1)).get("https://example.com");
    }
}
