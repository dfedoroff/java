package InMemoryModel;

/**
 * Интерфейс наблюдателя за изменением модели.
 * Содержит метод, вызываемый при изменении модели.
 */
public interface IModelChangedObserver {
    /**
     * Метод, вызываемый при изменении модели.
     */
    void applyUpdateModel();
}
