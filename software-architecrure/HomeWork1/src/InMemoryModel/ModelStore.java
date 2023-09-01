package InMemoryModel;

import ModelElements.*;

import java.util.ArrayList;

/**
 * Класс, описывающий хранилище 3D-сцен и элементов модели (источники света, камеры, полигональные модели).
 * Реализует интерфейс IModelChanger для уведомления об изменениях.
 */
public class ModelStore implements IModelChanger {
    // Список полигональных моделей в хранилище
    public ArrayList<PoligonalModel> models = new ArrayList<>();

    // Список 3D-сцен в хранилище
    public ArrayList<Scene> scenes = new ArrayList<>();

    // Список источников света в хранилище
    public ArrayList<Flash> flashes = new ArrayList<Flash>();

    // Список камер в хранилище
    public ArrayList<Camera> cameras = new ArrayList<>();

    // Список наблюдателей за изменением модели
    private ArrayList<IModelChangedObserver> changedObservers = new ArrayList<>();

    /**
     * Конструктор класса ModelStore, инициализирует хранилище начальными значениями.
     *
     * @param texture Начальная текстура для создания полигональной модели.
     */
    public ModelStore(Texture texture) {
        ArrayList<Texture> newTextures = new ArrayList<>();
        newTextures.add(texture);
        models.add(new PoligonalModel(newTextures));
        flashes.add(new Flash());
        cameras.add(new Camera());
        scenes.add(new Scene(models.get(0), cameras.get(0)));
    }

    /**
     * Метод для получения 3D-сцены по уникальному идентификатору.
     *
     * @param id Уникальный идентификатор сцены.
     * @return 3D-сцена или null, если сцена с таким идентификатором не найдена.
     */
    public Scene getScene(int id) {
        if (id < 0 || id >= scenes.size()) {
            return null; // TODO: добавить выброс исключения в будущем
        }
        return scenes.get(id);
    }

    /**
     * Уведомление об изменении модели.
     *
     * @param sender Объект, вызвавший изменение.
     */
    @Override
    public void notifyChange(IModelChanger sender) {
        // TODO: реализация уведомления об изменении модели
    }
}
