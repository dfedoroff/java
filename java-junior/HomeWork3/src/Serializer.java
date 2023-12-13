import java.io.*;
import java.nio.file.*;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для сериализации и десериализации объектов.
 * Этот класс предоставляет статические методы для сохранения объектов в файлы и
 * их восстановления из файлов.
 * Он также управляет жизненным циклом этих файлов, включая их удаление после
 * десериализации.
 */
public class Serializer {

    // Логгер для записи информации о процессе работы класса.
    private static final Logger LOGGER = Logger.getLogger(Serializer.class.getName());

    /**
     * Сериализует объект и сохраняет его в файл.
     * Имя файла генерируется на основе имени класса объекта и случайного UUID.
     *
     * @param item Объект для сериализации. Должен реализовывать интерфейс
     *             Serializable и не быть null.
     * @param <T>  Тип сериализуемого объекта.
     * @return Строка с именем файла, в который был сохранен объект, или null в
     *         случае ошибки.
     */
    public static <T extends Serializable> String upload(T item) {
        if (item == null) {
            LOGGER.log(Level.WARNING, "Попытка сериализовать null-объект");
            return null;
        }

        String fileName = item.getClass().getName() + "_" + UUID.randomUUID().toString();
        Path filePath = Paths.get(fileName);

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath))) {
            oos.writeObject(item);
            System.out.println("Файл успешно создан: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при записи объекта в файл: " + fileName, e);
            return fileName;
        }
        return fileName;
    }

    /**
     * Десериализует объект из файла и удаляет файл после этого.
     * В случае ошибок возвращает пустой Optional.
     *
     * @param filename Имя файла для десериализации. Должно быть валидным и не
     *                 пустым.
     * @param <T>      Тип объекта, который ожидается получить после десериализации.
     * @return Optional, содержащий десериализованный объект, или пустой Optional,
     *         если произошла ошибка.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> Optional<T> download(String filename) {
        if (filename == null || filename.isEmpty()) {
            LOGGER.log(Level.WARNING, "Предоставлено некорректное имя файла для десериализации");
            return Optional.empty();
        }

        Path filePath = Paths.get(filename);

        if (!Files.exists(filePath)) {
            LOGGER.log(Level.WARNING, "Файл не найден: " + filename);
            return Optional.empty();
        }

        T deserializedItem = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath))) {
            deserializedItem = (T) ois.readObject();
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Класс для десериализации не найден", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при чтении файла " + filename, e);
        } finally {
            try {
                Files.deleteIfExists(filePath);
                System.out.println("Файл \"" + filename + "\" успешно удален.");
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Ошибка при удалении файла " + filename, e);
            }
        }
        return Optional.ofNullable(deserializedItem);
    }
}
