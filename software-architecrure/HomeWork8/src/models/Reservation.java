package models;

import java.util.Date;

/**
 * Класс, представляющий бронирование столика.
 */
public class Reservation {

    private static int counter = 1000;
    private final int id;
    private final Table table;
    private Date date;
    private String name;

    {
        id = ++counter;
    }

    /**
     * Конструктор для создания объекта бронирования.
     * @param table Стол, на который создается бронь.
     * @param date Дата бронирования.
     * @param name Имя, на которое создается бронь.
     */
    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }

    // Геттеры для получения информации о бронировании
    public int getId() { return id; }
    public Date getDate() { return date; }
    public String getName() { return name; }
    public Table getTable() { return table; }
}
