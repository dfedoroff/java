package ModelElements;

import java.util.ArrayList;

/**
 * Класс, описывающий 3D-сцену.
 * Содержит списки полигональных моделей, источников света, камер и уникальный идентификатор.
 * Также содержит два обобщенных метода для работы с типами.
 */
public class Scene<Type1, Type2> {
    // Уникальный идентификатор сцены
    public int Id;

    // Список полигональных моделей на сцене
    public ArrayList<PoligonalModel> models = new ArrayList<>();

    // Список источников света на сцене
    public ArrayList<Flash> flashes = new ArrayList<>();

    // Список камер на сцене
    public ArrayList<Camera> cameras = new ArrayList<>();

    /**
     * Конструктор класса Scene, инициализирует списки моделей и камер начальными значениями.
     *
     * @param model  Начальная модель для сцены.
     * @param camera Начальная камера для сцены.
     */
    public Scene(PoligonalModel model, Camera camera) {
        models.add(model);
        cameras.add(camera);
    }

    /**
     * Обобщенный метод, возвращающий значение типа Type1.
     *
     * @param t Значение типа Type1.
     * @return Значение типа Type1.
     */
    public Type1 method1(Type1 t) {
        return t;
    }

    /**
     * Обобщенный метод, принимающий значения типов Type1 и Type2 и возвращающий значение типа Type2.
     *
     * @param t1 Значение типа Type1.
     * @param t2 Значение типа Type2.
     * @return Значение типа Type2.
     */
    public Type2 method2(Type1 t1, Type2 t2) {
        return t2;
    }
}
