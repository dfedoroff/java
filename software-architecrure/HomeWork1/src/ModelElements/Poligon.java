package ModelElements;

import BaseTypes.Point3D;

import java.util.ArrayList;

/**
 * Класс, описывающий полигон.
 * Содержит список точек, определяющих полигон.
 */
public class Poligon {
    // Список точек, формирующих полигон
    public ArrayList<Point3D> points = new ArrayList<>();

    /**
     * Конструктор класса Poligon, инициализирует список точек одной начальной точкой.
     *
     * @param point Начальная точка для полигона.
     */
    public Poligon(Point3D point) {
        points.add(point);
    }
}
