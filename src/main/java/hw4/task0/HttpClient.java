package hw4.task0;

/**
 * Класс HttpClient имитирует выполнение HTTP-запроса и возвращает результат.
 */
public class HttpClient {
    /**
     * Метод get имитирует GET-запрос и возвращает строку вместо реального HTTP-ответа.
     * @param url   URL-адрес, к которому будет выполнен HTTP-запрос.
     * @return      фиктивный ответ от сервера.
     */
    public String get(String url) {
        return "Response from " + url;
    }
}
