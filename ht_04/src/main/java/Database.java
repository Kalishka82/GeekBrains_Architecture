import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Database {
    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();
    private Collection<Order> orders = new ArrayList<>();

    {
        for (int i = 1; i <= 20; i++) {
            Customer customer = new Customer(String.format("cust 0%d", i), String.format("pass 0%d", i));
            int numsTickets = new Random().nextInt(0, 4);
            for (int j = 0; j < numsTickets; j++) {
                Ticket ticket = new Ticket(customer.getId(), this.getTicketAmount());
                customer.addTicket(ticket);
                this.tickets.add(ticket);
            }
            this.customers.add(customer);
        }
    }


    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount() {
        return 55;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @param clientID
     * @return
     */
    public Order createTicketOrder(int clientID, Ticket ticket) {
        this.tickets.add(ticket);
        Order order = new Order(clientID, ticket.getId());
        this.orders.add(order);
        return order;
    }

    public boolean addCustomer(Customer customer) {
        this.customers.add(customer);
        return true;
    }
}
