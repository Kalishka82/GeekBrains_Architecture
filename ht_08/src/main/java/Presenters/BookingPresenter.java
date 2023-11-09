package Presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTables() {
        view.showTables(model.loadTables());
    };

    private void showReseravitonTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    };

    @Override
    public void onReservationTable(Date reservaionDate, int tableNo, String name) {
        try {
            int reservationNo = model.reserveTable(reservaionDate, tableNo, name);
            showReseravitonTableResult(reservationNo);
        } catch (RuntimeException e) {
            showReseravitonTableResult(-1);
        }
    }

    @Override
    public void onReservationChange(int oldReservationNo, Date reservationDate, int tableNo, String name) {
        try {
            int newReservationNo = model.changeReservationTable(oldReservationNo, reservationDate, tableNo, name);
            showReseravitonTableResult(newReservationNo);
        } catch (RuntimeException e) {
            showReseravitonTableResult(-1);
        }
    }
}
