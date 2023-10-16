package gb.ht01.store3d.modelelements;

public class Flash {

    //region Public Methods
    public void rotate(Angle3D newAngle) {
        this.angle = newAngle;
    }

    public void move(Point3D newLocation) {
        this.location = newLocation;
    }
    //endregion

    //region Constructors

    public Flash(Point3D location, Angle3D angle, Color color, Power power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Flash() {}

    //endregion

    //region Public Properies

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public Power getPower() {
        return power;
    }

    //endregion

    //region Private Fields
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private Power power;
    //endregion
}
