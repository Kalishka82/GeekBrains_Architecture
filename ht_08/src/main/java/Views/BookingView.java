package Views;

import Models.Table;
import Presenters.View;
import Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("The table reserved successfully. Reservation number #%d\n", reservationNo);
         else
            System.out.println("Table reservation isn't available.\n" +
                    "Please, try again later.");
    }

    public void setObservers(Collection<ViewObserver> observers) {
        this.observers = observers;
    }

    public void reservationTable(Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservationDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationChange(oldReservationNo, reservationDate, tableNo, name);
    }
}
