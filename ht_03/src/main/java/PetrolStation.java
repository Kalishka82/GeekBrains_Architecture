public class PetrolStation implements Refuel {
    public void petrolFuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

    @Override
    public void fuel(FuelType fuelType) {
        petrolFuel(fuelType);
    }
}