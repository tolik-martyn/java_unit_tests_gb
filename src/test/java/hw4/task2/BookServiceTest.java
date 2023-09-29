package hw4.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Тесты класса BookService")
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    @DisplayName("Получение всех книг")
    public void testGetAllBooks() {
        // Создаем список мок-книг
        List<Book> mockBooks = new ArrayList<>();
        mockBooks.add(new Book(1, "Book 1", "Author 1", 2001));
        mockBooks.add(new Book(2, "Book 2", "Author 2", 2002));

        // Устанавливаем поведение мок-репозитория
        when(bookRepository.getAllBooks()).thenReturn(mockBooks);

        // Вызываем метод сервиса
        List<Book> result = bookService.getAllBooks();

        // Проверяем результат
        assertEquals(mockBooks, result);
    }

    @Test
    @DisplayName("Получение книги по ID")
    public void testGetBookById() {
        // Создаем мок-книгу
        Book mockBook = new Book(1, "Book 1", "Author 1", 2001);

        // Устанавливаем поведение мок-репозитория
        when(bookRepository.getBookById(1)).thenReturn(mockBook);

        // Вызываем метод сервиса
        Book result = bookService.getBookById(1);

        // Проверяем результат
        assertEquals(mockBook, result);
    }

    @Test
    @DisplayName("Добавление книги")
    public void testAddBook() {
        // Создаем новую книгу
        Book newBook = new Book(3, "Book 3", "Author 3", 2003);

        // Вызываем метод сервиса для добавления
        bookService.addBook(newBook);

        // Проверяем, что метод addBook репозитория был вызван с правильным аргументом
        verify(bookRepository).addBook(newBook);
    }

    @Test
    @DisplayName("Обновление книги")
    public void testUpdateBook() {
        // Создаем обновленную книгу
        Book updatedBook = new Book(1, "Updated Book 1", "Updated Author 1", 2011);

        // Вызываем метод сервиса для обновления
        bookService.updateBook(updatedBook);

        // Проверяем, что метод updateBook репозитория был вызван с правильным аргументом
        verify(bookRepository).updateBook(updatedBook);
    }

    @Test
    @DisplayName("Удаление книги")
    public void testDeleteBook() {
        // Вызываем метод сервиса для удаления
        bookService.deleteBook(1);

        // Проверяем, что метод deleteBook репозитория был вызван с правильным аргументом
        verify(bookRepository).deleteBook(1);
    }
}