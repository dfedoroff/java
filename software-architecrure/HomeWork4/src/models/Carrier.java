package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий собой модель перевозчика.
 * Хранит информацию об идентификаторе перевозчика, номере его карты и зонах, в которых он работает.
 */
public class Carrier {

    private int id; // Идентификатор перевозчика
    private long cardNumber; // Номер карты перевозчика
    private List<Integer> zones; // Список зон, в которых работает перевозчик

    /**
     * Конструктор класса, инициализирующий поля id и cardNumber.
     * Также инициализирует список зон, добавляя в него зоны 0 и 1.
     *
     * @param id         идентификатор перевозчика
     * @param cardNumber номер карты перевозчика
     */
    public Carrier(int id, long cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;

        zones = new ArrayList<>();
        zones.add(0);
        zones.add(1);
    }

    /**
     * Метод для получения номера карты перевозчика.
     *
     * @return номер карты перевозчика
     */
    public long getCardNumber() {
        return cardNumber;
    }

    /**
     * Метод для получения идентификатора перевозчика.
     *
     * @return идентификатор перевозчика
     */
    public int getId() {
        return id;
    }
}
