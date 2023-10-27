import java.util.Date;

public class Program {
/**
 * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус
 * в час пик"
 * <p>
 * 1. Предусловия
 * 2. Постусловия
 * 3. Инвариант
 * 4. Определить абстрактные и конкретные классы
 * 5. Определить интерфейсы
 * 6. Реализовать наследование
 * 7. Выявить компоненты
 * 8. Разработать диаграмму компонент, используя нотацию UML 2.0 - общая без деталейё
 * @param args
 */
    public static void main(String[] args) {
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        mobileApp.signInCustomer("cust 014", "pass 014");

        for (Ticket ticket : mobileApp.getTickets() ) {
            System.out.println(ticket);
        }
        System.out.println("-----");

        Ticket newTicket = mobileApp.buyTicket("100000000099");
        for (Ticket ticket : mobileApp.getTickets() ) {
            System.out.println(ticket);
        }
        System.out.println("-----");


        BusStation busStation = new BusStation(core.getTicketProvider());
        busStation.checkTicket(newTicket.getQrcode());
        System.out.println(newTicket);
    }
}
