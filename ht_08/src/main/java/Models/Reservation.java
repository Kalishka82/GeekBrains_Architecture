package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Reservation {
    public Reservation(int tableNo, Date date, String name) {
        this.date = date;
        this.name = name;
        this.tableNo = tableNo;
    }

    private static int counter = 1000;
    private final int id;

    {
        id = ++counter;
    }
    private final int tableNo;

    private Date date;
    private String name;

    public int getId() {
        return id;
    }

    public int getTableNo() {
        return tableNo;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
