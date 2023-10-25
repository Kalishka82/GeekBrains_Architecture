public class WashStation extends WashPrice implements Wash {

    @Override
    public void wash(CarType carType) {
        switch (carType) {
            case Sedan -> {
                washPrice(CarType.Sedan);
                System.out.println("Автомойка седана, цена = " + getWashPrice());
            }
            case Hatchback -> {
                washPrice(CarType.Hatchback);
                System.out.println("Автомойка хэтчбэка, цена = " + getWashPrice());
            }
            case Pickup -> {
                washPrice(CarType.Pickup);
                System.out.println("Автомойка пикапа, цена = " + getWashPrice());
            }
            case Sport -> {
                washPrice(CarType.Sport);
                System.out.println("Автомойка спорт, цена = " + getWashPrice());
            }
            case Harvester -> {
                washPrice(CarType.Harvester);
                System.out.println("Автомойка уборщика, цена = " + getWashPrice());
            }
        }
    }
}
