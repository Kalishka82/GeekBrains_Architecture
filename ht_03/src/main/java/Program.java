import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс Car, у которого должны быть
     * - свойства: марка, модель, цвет, тип кузова, число колес, тип топлива, тип коробки
     * передач, объем двигателя;
     * - методы: движение, обслуживание, переключение передач, включение фар, включение
     * дворников.
     * 2. Создать конкретный автомобиль путем наследования класса Car.
     * 3. Расширить абстрактный класс Car, добавить метод: подметать улицу. Создать
     * конкретный автомобиль путем наследования класса Car. Провести проверку принципа
     * SRP - single responsibility principle (принцип единственной ответсвенности -
     * каждый класс должен выполнять конкретные задачи).
     * 4. Расширить абстрактный класс Car, добавить метод: включение противотуманных фар,
     * перевозка груза. Провести проверку принципа OCP - open close principle (принцип
     * открытоски и закрытости - все программные сущности должны быть открыты для расширения,
     * но закрыты для модификации).
     * 5. Создать конкретный автомобиль путем наследования класса Car, определить число
     * колес = 3. Провести проверку принципа LSP - Principle Liska
     * 6. Создать конкретный автомобиль путем наследования класса Car, определить метод
     * "движение" - "полет". Провести проверку принципа LSP.
     * 7. Создать интерфейс "Заправочная станция", создать метод: заправка топливом.
     * 8. Имплементировать метод интерфейса "Заправочная станция" в конкретный
     * класс Car.
     * 9. Добавить в интерфейс "Заправочная станция" методы: протирка лобового стекла,
     * протирка фар, протирка зеркал.
     * 10. Имплементировать все методы интерфейса "Заправочная станция" в конкретный
     * класс Car. Провести проверку принципа ISP. Создать доп интерфейс(ы) и имлементировать
     * их в конкретный класс Car. Провести проверку принципа ISP.
     * 11. Создать путем наследования класса Car два автомобиля: с бензиновым и дизельным
     * двигателями, имплементировать метод "Заправка топливом" интерфейса "Заправочная станция".
     * Реализовать заправку каждого автомобиля подходящим топливом. Провести проверку
     * принципа DIP.
     *
     * @param args
     */
    public static void main(String[] args) {
        Harvester harvester = new Harvester("H", "A", Color.ORANGE);
        Sport sport = new Sport("S", "P", Color.RED);
        Pickup pickup = new Pickup("P", "I", Color.BLACK);

        PetrolStation petrolStation = new PetrolStation();
        GasStation gasStation = new GasStation();
        WashStation washStation = new WashStation();

        harvester.setRefuelStation(gasStation);
        harvester.fuel(harvester.fuelType);
        harvester.setWashStation(washStation);
        harvester.wash(harvester.carType);
        System.out.println("-----");

        sport.setRefuelStation(petrolStation);
        sport.fuel(sport.fuelType);
        sport.setWashStation(washStation);
        sport.wash(sport.carType);
        sport.movement();
        System.out.println("-----");

        pickup.setRefuelStation(petrolStation);
        pickup.fuel(pickup.fuelType);
        pickup.setWashStation(washStation);
        pickup.wash(pickup.carType);
        System.out.println("-----");
    }
}
