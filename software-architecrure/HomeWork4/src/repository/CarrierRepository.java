package repository;

import interfaces.CarrierDatabaseInterface;
import models.Carrier;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий, имитирующий работу с базой данных перевозчиков.
 * Реализует интерфейс CarrierDatabaseInterface.
 * Использует паттерн Singleton для создания единственного экземпляра класса.
 */
public class CarrierRepository implements CarrierDatabaseInterface {
    private static CarrierRepository carrierRepository; // Единственный экземпляр класса
    private List<Carrier> carriers; // Список перевозчиков

    /**
     * Приватный конструктор, инициализирующий список перевозчиков.
     * Добавляет в список одного перевозчика с ID 1.
     */
    private CarrierRepository() {
        carriers = new ArrayList<>();
        carriers.add(new Carrier(1, 1));
    }

    /**
     * Статический метод, возвращающий единственный экземпляр класса.
     * Если экземпляр не был создан ранее, создает новый.
     *
     * @return единственный экземпляр класса CarrierRepository
     */
    public static CarrierRepository getCarrierRepository() {
        if (carrierRepository == null) {
            carrierRepository = new CarrierRepository();
        }
        return carrierRepository;
    }

    /**
     * Метод для чтения информации о перевозчике по его ID.
     * Перебирает список перевозчиков и возвращает перевозчика с указанным ID.
     * Если перевозчик не найден, выбрасывает исключение с сообщением об ошибке.
     *
     * @param id уникальный идентификатор перевозчика
     * @return объект перевозчика
     * @throws RuntimeException если перевозчик с указанным ID не найден
     */
    @Override
    public Carrier read(int id) throws RuntimeException {
        for (var carrier : carriers) {
            if (carrier.getId() == id) {
                return carrier;
            }
        }
        throw new RuntimeException("Перевозчик с указанным ID не найден");
    }
}
