package ModelElements;

import java.util.ArrayList;

/**
 * Класс, описывающий полигональную модель.
 * Содержит списки полигонов и текстур, ассоциированных с моделью.
 */
public class PoligonalModel {
    // Список полигонов, составляющих модель
    public ArrayList<Poligon> poligons;

    // Список текстур, ассоциированных с моделью
    public ArrayList<Texture> textures;

    /**
     * Конструктор класса PoligonalModel, инициализирует список текстур и создает пустой список полигонов.
     *
     * @param textures Список текстур для модели.
     */
    public PoligonalModel(ArrayList<Texture> textures) {
        this.textures = textures;
        this.poligons = new ArrayList<>();
    }
}
