package gb.ht01.store3d.modelelements;

public class Color {

    //region Constructors
    {
        id = ++counter;
    }
    public Color(String color) {
        this.color = color;
    }
    //endregion

    //region Public Properies
    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //endregion

    //region Private Fields
    private static int counter = 0;
    private int id;
    private String color;
    //endregion
}
