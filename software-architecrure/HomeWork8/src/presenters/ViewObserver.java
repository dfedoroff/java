package presenters;

import java.util.Date;

/**
 * Интерфейс для обработки событий пользовательского интерфейса.
 */
public interface ViewObserver {
    void onReservationTable(Date reservationDate, int tableNo, String name);
    void onChangeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName);
}
