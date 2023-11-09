package Presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date reservaionDate, int tableNo, String name);
    void onReservationChange(int oldReservationNo, Date reservationDate, int tableNo, String name);
}
