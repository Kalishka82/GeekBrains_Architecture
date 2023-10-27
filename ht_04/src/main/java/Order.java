public class Order {
    private static int counter;
    private int id;
    private int customerId;
    private int ticketId;

    {
        this.id = ++counter;
    }

    public Order(int customerId, int ticketId) {
        this.customerId = customerId;
        this.ticketId = ticketId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTicketId() {
        return ticketId;
    }
}
