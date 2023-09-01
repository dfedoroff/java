package ModelElements;

import BaseTypes.Angle3D;
import BaseTypes.Point3D;

/**
 * Класс, описывающий камеру в 3D-сцене.
 * Содержит информацию о положении камеры и ее угле.
 */
public class Camera {
    // Местоположение камеры в 3D-пространстве
    public Point3D location;

    // Угол поворота камеры
    public Angle3D angle;

    /**
     * Метод для вращения камеры.
     *
     * @param angle3D Угол, на который следует повернуть камеру.
     */
    public void rotate(Angle3D angle3D) {
        // TODO: реализация поворота камеры
    }

    /**
     * Метод для перемещения камеры.
     *
     * @param point3D Точка, в которую следует переместить камеру.
     */
    public void move(Point3D point3D) {
        // TODO: реализация перемещения камеры
    }
}
