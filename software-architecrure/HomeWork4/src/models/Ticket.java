package models;

import java.util.Date;

/**
 * Класс, представляющий собой модель билета.
 * Содержит информацию о маршруте, месте, цене, дате поездки и статусе билета (действителен или нет).
 */
public class Ticket {

    // Поля класса
    private long id; // Уникальный идентификатор билета
    private int zoneStart; // Начальная зона маршрута
    private int zoneStop; // Конечная зона маршрута
    private int routeNumber; // Номер маршрута
    private int place; // Номер места
    private int price; // Цена билета
    private Date date; // Дата поездки
    private boolean isValid; // Статус билета (действителен или нет)

    /**
     * Конструктор класса Ticket.
     *
     * @param routeNumber Номер маршрута
     * @param place       Номер места
     * @param price       Цена билета
     * @param date        Дата поездки
     * @param isValid     Статус билета (действителен или нет)
     */
    public Ticket(int routeNumber, int place, int price, Date date, boolean isValid) {
        this.routeNumber = routeNumber;
        this.place = place;
        this.price = price;
        this.date = date;
        this.isValid = isValid;
    }

    // Геттеры и сеттеры для полей класса

    public void setZoneStart(int zoneStart) {
        this.zoneStart = zoneStart;
    }

    public void setZoneStop(int zoneStop) {
        this.zoneStop = zoneStop;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * Переопределенный метод toString для предоставления строкового представления объекта билета.
     * Обычно используется для логирования и отладки.
     *
     * @return строковое представление объекта билета
     */
    @Override
    public String toString() {
        return "Билет" +
                " Номер маршрута: " + routeNumber +
                ", Место: " + place +
                ", Цена: " + price + " руб." +
                ", Дата: " + date +
                ", Статус: " + (isValid ? "Свободен" : "Занят");
    }

    /**
     * Метод для формирования строкового представления билета, предназначенного для печати или отображения пользователю.
     * Предоставляет более детальное и читаемое представление информации о билете.
     *
     * @return строковое представление билета для печати
     */
    public String toPrint() {
        return "Номер маршрута: " + routeNumber +
                "\nМесто: " + place +
                "\nЦена: " + price + " руб." +
                "\nДата: " + date;
    }

    // Переопределенные методы hashCode и equals для корректной работы с коллекциями

    @Override
    public int hashCode() {
        return date.hashCode() ^ (routeNumber + place + price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.equals((Ticket) obj);
    }

    public boolean equals(Ticket ticket) {
        return ticket != null
                && ticket.getRouteNumber() == this.routeNumber
                && ticket.getPlace() == this.place
                && ticket.getPrice() == this.price
                && ticket.getDate().equals(this.date)
                && ticket.hashCode() == this.hashCode();
    }
}
