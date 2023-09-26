package presenters;

import models.Reservation;
import models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс для работы с пользовательским интерфейсом.
 */
public interface View {
    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    void reservationTable(Date reservationDate, int tableNo, String name);
    void changeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName);
    void showReservationTableResult(int reservationId);
    void showChangeReservationTableResult(int reservationId);
    void showReservations(Collection<Reservation> reservations);
}
