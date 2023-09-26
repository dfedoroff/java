package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Класс, представляющий столик в ресторане.
 */
public class Table {

    private final Collection<Reservation> reservations = new ArrayList<>();
    private static int counter;
    private final int no;

    {
        no = ++counter;
    }

    // Геттеры для получения информации о столике
    public int getNo() { return no; }

    /**
     * Метод для получения всех бронирований данного столика.
     * @return Коллекция бронирований.
     */
    public Collection<Reservation> getReservations() {
        System.out.println("Количество бронирований в столике #" + no + ": " + reservations.size());
        return new ArrayList<>(reservations);
    }

    /**
     * Метод для добавления бронирования к столику.
     * @param reservation Объект бронирования.
     * @return true, если бронирование успешно добавлено, иначе false.
     */
    public boolean addReservation(Reservation reservation) {
        return reservations.add(reservation);
    }

    /**
     * Метод для удаления бронирования из столика.
     * @param reservation Объект бронирования.
     * @return true, если бронирование успешно удалено, иначе false.
     */
    public boolean removeReservation(Reservation reservation) {
        return reservations.remove(reservation);
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
