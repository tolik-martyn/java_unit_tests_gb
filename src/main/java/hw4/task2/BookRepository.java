package hw4.task2;

import java.util.List;

/**
 * Интерфейс для доступа к книгам в базе данных.
 */
public interface BookRepository {
    /**
     * Получает список всех книг из базы данных.
     *
     * @return Список всех книг.
     */
    List<Book> getAllBooks();

    /**
     * Получает книгу по ее идентификатору из базы данных.
     *
     * @param bookId Идентификатор книги.
     * @return Книга с заданным идентификатором или null, если книга не найдена.
     */
    Book getBookById(int bookId);

    /**
     * Добавляет новую книгу в базу данных.
     *
     * @param book Книга для добавления.
     */
    void addBook(Book book);

    /**
     * Обновляет информацию о книге в базе данных.
     *
     * @param book Книга с обновленными данными.
     */
    void updateBook(Book book);

    /**
     * Удаляет книгу из базы данных по ее идентификатору.
     *
     * @param bookId Идентификатор книги для удаления.
     */
    void deleteBook(int bookId);
}
