package gb.ht01.store3d.modelelements;

public class Angle3D {

    //region Constructors

    public Angle3D(double xAngle, double yAngle, double zAngele) {
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngele = zAngele;
    }

    public Angle3D() {}
    //endregion

    //region Public Properies

    public double getxAngle() {
        return xAngle;
    }

    public double getyAngle() {
        return yAngle;
    }

    public double getzAngele() {
        return zAngele;
    }

    //endregion

    //region Private Fields
    private double xAngle, yAngle, zAngele;
    //endregion
}
