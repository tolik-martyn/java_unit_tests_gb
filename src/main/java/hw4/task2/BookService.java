package hw4.task2;

import java.util.List;

/**
 * Сервис для управления книгами, использующий репозиторий для доступа к базе данных.
 */
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Конструктор класса BookService.
     *
     * @param bookRepository Репозиторий книг для взаимодействия с базой данных.
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Получает список всех книг.
     *
     * @return Список всех книг.
     */
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    /**
     * Получает книгу по ее идентификатору.
     *
     * @param bookId Идентификатор книги.
     * @return Книга с заданным идентификатором.
     */
    public Book getBookById(int bookId) {
        return bookRepository.getBookById(bookId);
    }

    /**
     * Добавляет новую книгу.
     *
     * @param book Книга для добавления.
     */
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    /**
     * Обновляет информацию о книге.
     *
     * @param book Книга с обновленными данными.
     */
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    /**
     * Удаляет книгу по ее идентификатору.
     *
     * @param bookId Идентификатор книги для удаления.
     */
    public void deleteBook(int bookId) {
        bookRepository.deleteBook(bookId);
    }
}
