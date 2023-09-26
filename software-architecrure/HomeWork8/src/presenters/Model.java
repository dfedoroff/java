package presenters;

import models.Table;
import models.Reservation;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс для работы с моделью данных.
 */
public interface Model {
    Collection<Table> loadTables();
    int reservationTable(Date reservationDate, int tableNo, String name);
    int changeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName);
}
