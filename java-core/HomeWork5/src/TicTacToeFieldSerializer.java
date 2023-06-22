import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToeFieldSerializer {

    public static void main(String[] args) {
        // Исходный массив состояний ячеек (9 элементов, каждый в диапазоне [0, 3])
        byte[] field = {1, 2, 0, 1, 2, 1, 0, 0, 3};

        // Сериализация поля в одно число типа int
        int serializedField = serializeField(field);

        // Запись сериализованного поля в файл
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("field.dat"))) {
            outputStream.writeInt(serializedField);
            System.out.println("Состояние игрового поля успешно записано в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи состояния игрового поля в файл.");
            e.printStackTrace();
        }
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
