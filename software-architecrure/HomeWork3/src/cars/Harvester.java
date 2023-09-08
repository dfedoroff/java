package cars;

import java.awt.Color;
import enums.CarType;
import enums.FuelType;
import enums.GearboxType;
import services.RefuelingService;
import services.CarWashService;
import services.StreetSweeperService;

/**
 * Класс Harvester, представляющий комбайн или уборочный автомобиль
 * Этот класс наследуется от абстрактного класса Car и реализует методы, определенные в нем,
 * а также дополнительный метод для уборки улиц, представленный в интерфейсе StreetSweeperService
 */
public class Harvester extends Car implements RefuelingService, CarWashService, StreetSweeperService {

    // Конструктор для инициализации характеристик комбайна
    public Harvester(String make, String model, Color color, CarType carType, int wheelsCount, FuelType fuelType, GearboxType gearboxType, double engineCapacity) {
        super(make, model, color, carType, wheelsCount, fuelType, gearboxType, engineCapacity);
    }

    // Реализация абстрактных методов класса Car
    @Override
    public void move() {
        System.out.println("Комбайн движется по полю");
    }

    @Override
    public void service() {
        System.out.println("Комбайн на техническом обслуживании");
    }

    @Override
    public void switchGear() {
        System.out.println("Комбайн переключает передачу");
    }

    @Override
    public void turnOnHeadlights() {
        System.out.println("Комбайн включает фары");
    }

    @Override
    public void turnOnWipers() {
        System.out.println("Комбайн включает дворники");
    }

    @Override
    public void turnOnFogLights() {
        System.out.println("Комбайн включает противотуманные фары");
    }

    @Override
    public void carryCargo() {
        System.out.println("Комбайн перевозит урожай");
    }

    // Реализация методов интерфейсов
    @Override
    public void refuel(FuelType fuelType) {
        System.out.println("Комбайн заправляется топливом типа: " + fuelType);
    }

    @Override
    public void wipeWindshield() {
        System.out.println("Комбайн протирает ветровое стекло");
    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Комбайн протирает фары");
    }

    @Override
    public void wipeMirrors() {
        System.out.println("Комбайн протирает зеркала");
    }

    @Override
    public void washCar() {
        System.out.println("Комбайн моется на автомойке");
    }

    // Реализация дополнительного метода интерфейса StreetSweeperService
    @Override
    public void sweepStreet() {
        System.out.println("Комбайн подметает улицу");
    }
}
