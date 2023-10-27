import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {
    private final Database database;
    private final PaymentProvider paymentProvider;
    private final CustomerProvider customerProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider, CustomerProvider customerProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
        this.customerProvider = customerProvider;
    }

    public Collection<Ticket> searchTicket(int customerId, Date date) {
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == customerId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;
    }

    public Ticket buyTicket(int customerID, String cardNo) {
        Customer customer = customerProvider.getCustomerById(customerID);
        if (customer == null) {
            throw new RuntimeException("Клиента с таким id не существует");
        }

        Ticket ticket = new Ticket(customerID, database.getTicketAmount());

        Order order = database.createTicketOrder(customerID, ticket);
        customer.addTicket(ticket);

        return ticket;
    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }
}
