package cars;

import java.awt.Color;
import enums.CarType;
import enums.FuelType;
import enums.GearboxType;
import services.RefuelingService;
import services.CarWashService;
import services.FlyingCarService;

/**
 * Класс FlyCar, представляющий летающий автомобиль
 * Этот класс наследуется от абстрактного класса Car и реализует методы, определенные в нем,
 * а также дополнительный метод для осуществления полета, представленный в интерфейсе FlyingCarService
 */
public class FlyCar extends Car implements RefuelingService, CarWashService, FlyingCarService {

    // Конструктор для инициализации характеристик летающего автомобиля
    public FlyCar(String make, String model, Color color, CarType carType, int wheelsCount, FuelType fuelType, GearboxType gearboxType, double engineCapacity) {
        super(make, model, color, carType, wheelsCount, fuelType, gearboxType, engineCapacity);
    }

    // Реализация абстрактных методов класса Car
    @Override
    public void move() {
        System.out.println("Летающий автомобиль движется в воздухе");
    }

    @Override
    public void service() {
        System.out.println("Летающий автомобиль на техническом обслуживании");
    }

    @Override
    public void switchGear() {
        System.out.println("Летающий автомобиль переключает передачу");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("Летающий автомобиль включает фары");
    }

    @Override
    public void turnOnWipers() {
        System.out.println("Летающий автомобиль включает дворники");
    }

    @Override
    public void turnOnFogLights() {
        System.out.println("Летающий автомобиль включает противотуманные фары");
    }

    @Override
    public void carryCargo() {
        System.out.println("Летающий автомобиль перевозит груз");
    }

    // Реализация методов интерфейсов
    @Override
    public void refuel(FuelType fuelType) {
        System.out.println("Летающий автомобиль заправляется топливом типа: " + fuelType);
    }

    @Override
    public void wipeWindshield() {
        System.out.println("Летающий автомобиль протирает ветровое стекло");
    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Летающий автомобиль протирает фары");
    }

    @Override
    public void wipeMirrors() {
        System.out.println("Летающий автомобиль протирает зеркала");
    }

    @Override
    public void washCar() {
        System.out.println("Летающий автомобиль моется на автомойке");
    }

    // Реализация дополнительного метода интерфейса FlyingCarService
    @Override
    public void fly() {
        System.out.println("Летающий автомобиль взлетает");
    }
}
