import java.awt.*;

public class Pickup extends Car {
    public Pickup(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(4);
        this.fuelType = FuelType.Diesel;
        this.carType = CarType.Pickup;
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadLights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }
}
