package gb.ht01.store3d.modelelements;

import java.util.Collection;

public class Poligon {

    //region Constructors
    public Poligon(Collection<Point3D> points) {
        this.points = points;
    }
    public Poligon() {}
    //endregion

    //region Public Properies
    public Collection<Point3D> getPoints() {
        return points;
    }
    //endregion

    //region Private Fields
    private Collection<Point3D> points;
    //endregion
}
