package presenters;

import models.Reservation;
import models.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    public Collection<Table> loadTables() {
        return model.loadTables();
    }

    public void updateUIShowTables() {
        view.showTables(loadTables());
    }

    public void updateUIShowReservationTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    public void updateUIShowReservations() {
        Collection<Reservation> allReservations = new ArrayList<>();
        for (Table table : loadTables()) {
            allReservations.addAll(table.getReservations());
        }
        System.out.println("Количество бронирований: " + allReservations.size()); // Добавленная строка
        view.showReservations(allReservations);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservationId, Date newReservationDate, int newTableNo, String newName) {
        try {
            int reservationId = model.changeReservationTable(oldReservationId, newReservationDate, newTableNo, newName);
            view.showChangeReservationTableResult(reservationId);
        } catch (RuntimeException e) {
            view.showChangeReservationTableResult(-1);
        }
    }
}
