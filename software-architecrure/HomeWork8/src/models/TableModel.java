package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Класс, реализующий логику работы с данными о столиках и бронированиях.
 */
public class TableModel implements Model {
    private Collection<Table> tables;

    /**
     * Метод для загрузки данных о столиках.
     * @return Коллекция столиков.
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                if (table.addReservation(reservation)) { // Используем метод addReservation для добавления бронирования
                    return reservation.getId();
                }
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    @Override
    public int changeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName) {
        // Логика изменения бронирования столика
        for (Table table : loadTables()) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservationId) {
                    table.removeReservation(reservation); // Удаляем старую бронь
                    boolean isTableAvailable = true;
                    for (Table existingTable : loadTables()) {
                        for (Reservation existingReservation : existingTable.getReservations()) {
                            if (existingReservation.getDate().equals(newReservationDate)
                                    && existingTable.getNo() == newTableNo) {
                                isTableAvailable = false;
                                break;
                            }
                        }
                    }
                    if (isTableAvailable) {
                        Reservation newReservation = new Reservation(table, newReservationDate, newName);
                        if (table.addReservation(newReservation)) { // Добавляем новую бронь
                            return newReservation.getId();
                        }
                    } else {
                        table.addReservation(reservation); // Добавляем старую бронь обратно, если новая бронь не может быть добавлена
                        throw new RuntimeException("Выбранный столик на указанное время уже занят.");
                    }
                }
            }
        }
        throw new RuntimeException("Бронь с указанным номером не найдена.");
    }
}
