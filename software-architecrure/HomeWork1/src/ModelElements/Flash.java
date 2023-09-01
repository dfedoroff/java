package ModelElements;

import BaseTypes.Angle3D;
import BaseTypes.Point3D;

import java.awt.*;

/**
 * Класс, описывающий источник света в 3D-сцене.
 * Содержит информацию о местоположении, угле, цвете и мощности источника света.
 */
public class Flash {
    // Местоположение источника света в 3D-пространстве
    public Point3D location;

    // Угол поворота источника света
    public Angle3D angle;

    // Цвет источника света
    public Color color;

    // Мощность источника света
    public Float power;

    /**
     * Метод для вращения источника света.
     *
     * @param angle3D Угол, на который следует повернуть источник света.
     */
    public void rotate(Angle3D angle3D) {
        // TODO: реализация поворота источника света
    }

    /**
     * Метод для перемещения источника света.
     *
     * @param point3D Точка, в которую следует переместить источник света.
     */
    public void move(Point3D point3D) {
        // TODO: реализация перемещения источника света
    }
}
