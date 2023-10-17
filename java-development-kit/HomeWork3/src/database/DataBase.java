package database;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Класс для работы с базой данных.
 * Реализует интерфейс OpenData.
 */
public class DataBase<T> implements OpenData {
    private List<T> data;
    private final String filePath;

    public DataBase(String filePath) {
        this.filePath = filePath;
        this.data = new ArrayList<>();
    }

    /**
     * Добавление элемента в базу данных.
     */
    public void add(T element) {
        data.add(element);
    }

    /**
     * Получение элемента из базы данных по индексу.
     */
    public T get(int index) {
        return data.get(index);
    }

    /**
     * Получение размера списка данных.
     */
    public int size() {
        return data.size();
    }

    @Override
    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            data = (List<T>) ois.readObject();
            System.out.println("Данные загружены");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки данных: " + e.getMessage());
        }
    }

    @Override
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
            System.out.println("Данные сохранены");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < data.size()) {
            data.remove(index);
            System.out.println("Данные удалены");
        } else {
            System.out.println("Неверный индекс");
        }
    }
}
