import java.awt.*;

public class Sport extends Car {
    public Sport(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(3);
        this.fuelType = FuelType.Gasoline;
        this.carType = CarType.Sport;
    }

    @Override
    public void movement() {
        if (carType == CarType.Sport) {
            System.out.println("Тип движения - полет");
        }
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
