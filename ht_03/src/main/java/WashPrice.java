public class WashPrice {
    private double washPrice;

    public double getWashPrice() {
        return washPrice;
    }

    public void setWashPrice(double washPrice) {
        this.washPrice = washPrice;
    }

    public void washPrice(CarType carType) {
        switch (carType) {
            case Sedan -> setWashPrice(200.0);
            case Hatchback -> setWashPrice(300.0);
            case Pickup -> setWashPrice(800.0);
            case Sport -> setWashPrice(500.0);
            case Harvester -> setWashPrice(1000.0);
        }
    }
}
