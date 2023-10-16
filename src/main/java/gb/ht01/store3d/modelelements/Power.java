package gb.ht01.store3d.modelelements;

public class Power {

    //region Constructors
    {
        id = ++counter;
    }
    public Power(float power) {
        this.power = power;
    }
    //endregion

    //region Public Properies
    public int getId() {
        return id;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    //endregion

    //region Private Fields
    private static int counter = 0;
    private int id;
    private float power;
    //endregion
}
