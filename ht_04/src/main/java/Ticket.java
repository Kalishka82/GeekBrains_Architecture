import java.util.Date;

public class Ticket {
    private static int counter;
    private int id;
    private int customerId;
    private Date date = new Date();
    private double price;
    private String qrcode;
    private boolean enable = true;

    {
        this.id = ++counter;
    }


    public Ticket(int customerId, double price) {
        this.customerId = customerId;
        this.price = price;
        updateQrCode();
    }

    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    private void updateQrCode() {
        this.qrcode = String.format("ticketId=%d&customerId=%d&date=%s", this.id, this.customerId, this.date);
    }

    @Override
    public String toString() {
        return String.format("Ticket(id=%d, customerId=%d,date=%s, enable=%s)",
                this.id, this.customerId, this.date, this.enable);
    }
}
