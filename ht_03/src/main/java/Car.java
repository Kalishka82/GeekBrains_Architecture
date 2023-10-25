import java.awt.*;

public abstract class Car {

    /**
     * Заправить автомобиль
     */
    private Refuel refuel;

    public void setRefuelStation(Refuel refuelStation) {
        this.refuel = refuelStation;
    }

    public void fuel(FuelType fuelType) {
        if (refuel != null) {
            refuel.fuel(fuelType);
        }
    }

    /**
     * Помыть автомобиль
     */
    private Wash wash;

    public void setWashStation(Wash washStation) {
        this.wash = washStation;
    }

    public void wash(CarType carType) {
        if (wash != null) {
            wash.wash(carType);
        }
    }

     public abstract void maintenance();


    //region Методы
    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    // Движение
    public abstract void movement();


    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadLights();

    // Включение дворников
    public abstract boolean switchWipers();

    //endregion

    //region Конструкторы

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    //endregion

    //region Поля

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType carType;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType = FuelType.Diesel;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    //endregion

}
