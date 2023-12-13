import java.io.Serializable;

/**
 * Класс представляет собой модель книги с базовыми атрибутами.
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private int year;

    /**
     * Конструктор для создания экземпляра книги.
     * 
     * @param title  Название книги.
     * @param author Автор книги.
     * @param year   Год издания.
     */
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Геттеры и сеттеры для полей класса

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
