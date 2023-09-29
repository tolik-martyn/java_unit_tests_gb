package hw4.task0;

/**
 * Класс WebService использует HttpClient для получения данных с веб-сайта.
 */
public class WebService {
    private HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Метод для получения данных с веб-сайта, используя HttpClient.
     * @param url   URL-адрес, к которому будет выполнен HTTP-запрос.
     * @return      данные с веб-сайта.
     */
    public String getDataFromWebsite(String url) {
        return httpClient.get(url);
    }
}
