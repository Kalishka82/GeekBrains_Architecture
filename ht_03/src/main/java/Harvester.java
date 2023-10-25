import java.awt.*;

public class Harvester extends Car {

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
        this.fuelType = FuelType.LPG;
        this.carType = CarType.Harvester;
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }

    private boolean fogLights = false;
    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
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
