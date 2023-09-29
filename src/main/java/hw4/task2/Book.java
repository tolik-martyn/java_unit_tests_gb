package hw4.task2;

/**
 * Класс, представляющий книгу.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int year;

    /**
     * Конструктор для создания объекта книги.
     *
     * @param id     Идентификатор книги.
     * @param title  Название книги.
     * @param author Автор книги.
     * @param year   Год выпуска книги.
     */
    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
