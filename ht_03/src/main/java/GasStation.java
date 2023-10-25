import java.util.Objects;

public class GasStation implements Refuel {
    public void gasFuel(FuelType fuelType) {
        if (fuelType == FuelType.LPG) {
            System.out.println("Заправка автогазом");
        }
    }

    @Override
    public void fuel(FuelType fuelType) {
        gasFuel(fuelType);
    }
}
