package views;

import models.Reservation;
import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

/**
 * Класс, реализующий пользовательский интерфейс для бронирования столиков.
 */
public class BookingView implements View {
    private ViewObserver observer;

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) System.out.println(table);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        else System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
    }

    @Override
    public void showChangeReservationTableResult(int reservationId) {
        if (reservationId > 0) System.out.printf("Бронь успешно изменена. Новый номер брони: #%d\n", reservationId);
        else System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
    }

    @Override
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observer != null) observer.onReservationTable(orderDate, tableNo, name);
    }

    @Override
    public void changeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName) {
        if (observer != null) observer.onChangeReservationTable(oldReservationId, newReservationDate, newTableNo, newName);
    }

    @Override
    public void showReservations(Collection<Reservation> reservations) {
        System.out.println("Список всех бронирований:");
        for (Reservation reservation : reservations) System.out.printf("Бронь #%d на имя %s для столика #%d на дату %s\n", reservation.getId(), reservation.getName(), reservation.getTable().getNo(), reservation.getDate());
    }
}
