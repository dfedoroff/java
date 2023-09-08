package services;

import enums.FuelType;

/**
 * Интерфейс для описания сервиса по заправке автомобиля топливом
 */
public interface RefuelingService {
    void refuel(FuelType fuelType);
}