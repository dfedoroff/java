import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Задача 1: Создание резервных копий файлов
        DirectoryBackUpper backUpper = new DirectoryBackUpper();
        backUpper.backUpFiles(Path.of("."));

        // Задача 2: Вывод дерева директорий
        DirectoryTreePrinter.print(Path.of("./src"));

        // Задача 3: Сериализация состояния игрового поля в файл
        byte[] field = {1, 2, 0, 1, 2, 1, 0, 0, 3};
        int serializedField = serializeField(field);
        String fileName = "field.dat";
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write((serializedField >> 16) & 0xFF);
            outputStream.write((serializedField >> 8) & 0xFF);
            outputStream.write(serializedField & 0xFF);
            System.out.println("Состояние игрового поля успешно записано в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи состояния игрового поля в файл.");
            e.printStackTrace();
        }

        // Вывод размера файла
        File file = new File(fileName);
        long fileSize = file.length();
        System.out.println("Размер созданного файла: " + fileSize + " байт(а).");
    }

    private static int serializeField(byte[] field) {
        if (field == null || field.length != 9) {
            throw new IllegalArgumentException("Поле должно быть массивом из 9 элементов.");
        }

        int serializedField = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i] < 0 || field[i] > 3) {
                throw new IllegalArgumentException("Каждый элемент должен быть в диапазоне [0, 3].");
            }
            serializedField |= (field[i] << (i * 2));
        }
        return serializedField;
    }
}
