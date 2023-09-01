package InMemoryModel;

/**
 * Интерфейс, описывающий возможность уведомления об изменении модели.
 * Содержит метод для уведомления о изменении.
 */
public interface IModelChanger {
    /**
     * Метод для уведомления об изменении модели.
     *
     * @param sender Объект, вызвавший изменение.
     */
    void notifyChange(IModelChanger sender);
}
