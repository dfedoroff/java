package cars;

import java.awt.Color;
import enums.CarType;
import enums.FuelType;
import enums.GearboxType;
import services.RefuelingService;
import services.CarWashService;

/**
 * Класс SportCar, представляющий спортивный автомобиль
 * Этот класс наследуется от абстрактного класса Car и реализует методы, определенные в нем
 */
public class SportCar extends Car implements RefuelingService, CarWashService {

    // Конструктор для инициализации специфических для спортивного автомобиля характеристик
    public SportCar(String make, String model, Color color, CarType carType, int wheelsCount, FuelType fuelType, GearboxType gearboxType, double engineCapacity) {
        super(make, model, color, carType, wheelsCount, fuelType, gearboxType, engineCapacity);
    }

    // Реализация абстрактных методов класса Car
    @Override
    public void move() {
        System.out.println("Спортивный автомобиль быстро движется");
    }

    @Override
    public void service() {
        System.out.println("Спортивный автомобиль на техническом обслуживании");
    }

    @Override
    public void switchGear() {
        System.out.println("Спортивный автомобиль переключает передачу");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("Спортивный автомобиль включает фары");
    }

    @Override
    public void turnOnWipers() {
        System.out.println("Спортивный автомобиль включает дворники");
    }

    @Override
    public void turnOnFogLights() {
        System.out.println("Спортивный автомобиль включает противотуманные фары");
    }

    @Override
    public void carryCargo() {
        System.out.println("Спортивный автомобиль перевозит груз");
    }

    // Реализация методов интерфейсов
    @Override
    public void refuel(FuelType fuelType) {
        System.out.println("Спортивный автомобиль заправляется топливом типа: " + fuelType);
    }

    @Override
    public void wipeWindshield() {
        System.out.println("Спортивный автомобиль протирает ветровое стекло");
    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Спортивный автомобиль протирает фары");
    }

    @Override
    public void wipeMirrors() {
        System.out.println("Спортивный автомобиль протирает зеркала");
    }

    @Override
    public void washCar() {
        System.out.println("Спортивный автомобиль моется на автомойке");
    }
}
