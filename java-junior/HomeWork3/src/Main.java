import java.util.Optional;

/**
 * Главный класс, демонстрирующий использование класса Serializer для
 * сериализации и десериализации объектов.
 */
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра книги
        Book warAndPeace = new Book("Война и мир", "Лев Толстой", 1869);

        // Сериализация объекта книги и получение имени файла, в который он сохранен
        String filename = Serializer.upload(warAndPeace);
        if (filename == null) {
            System.out.println("Ошибка при сериализации объекта.");
            return;
        }

        // Десериализация объекта книги из файла
        Optional<Book> downloadedBook = Serializer.download(filename);

        // Вывод информации о книге, если она успешно десериализована
        downloadedBook.ifPresent(System.out::println);
    }
}
