import Models.TableModel;
import Presenters.BookingPresenter;
import Presenters.Model;
import Views.BookingView;

import java.util.Date;

public class Program {
    //TODO: changeReservationTable must work!
    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "Tatiana");
        view.changeReservationTable(1001, new Date(), 1, "Tatiana");
    }
}
