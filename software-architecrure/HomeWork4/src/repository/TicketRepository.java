package repository;

import interfaces.TicketDatabaseInterface;
import models.Ticket;

import java.util.*;

/**
 * Класс репозиторий, имитирующий работу с базой данных билетов.
 * Реализует интерфейс TicketDatabaseInterface.
 * Использует паттерн Singleton для создания единственного экземпляра класса.
 */
public class TicketRepository implements TicketDatabaseInterface {
    private static TicketRepository ticketRepository; // Единственный экземпляр класса
    private List<Ticket> tickets; // Список билетов

    /**
     * Приватный конструктор, инициализирующий список билетов.
     * Генерирует билеты для двух маршрутов с помощью метода generateTickets.
     */
    private TicketRepository() {
        tickets = new ArrayList<>();
        Date date = new Date();
        generateTickets(1, 6, 10, date);
        generateTickets(2, 4, 15, date);
    }

    /**
     * Статический метод, возвращающий единственный экземпляр класса.
     * Если экземпляр не был создан ранее, создает новый.
     *
     * @return единственный экземпляр класса TicketRepository
     */
    public static TicketRepository getTicketRepository() {
        if (ticketRepository == null) {
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }

    /**
     * Метод для создания нового билета.
     * В текущей реализации не используется.
     *
     * @param ticket объект билета
     * @return true, подтверждая успешное создание билета
     */
    @Override
    public boolean create(Ticket ticket) {
        tickets.add(ticket);
        return true;
    }

    /**
     * Метод для чтения всех доступных билетов по номеру маршрута.
     *
     * @param routeNumber номер маршрута
     * @return список доступных билетов
     * @throws RuntimeException если билеты не найдены, с сообщением о причине
     */
    @Override
    public List<Ticket> readAll(int routeNumber) throws RuntimeException {
        List<Ticket> routeTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getRouteNumber() == routeNumber && ticket.isValid()) {
                routeTickets.add(ticket);
            }
        }
        if (routeTickets.isEmpty()) {
            throw new RuntimeException("Билеты на данный автобус отсутствуют.");
        }
        return tickets;
    }

    /**
     * Метод для обновления информации о билете.
     *
     * @param ticket объект билета с обновленной информацией
     * @return true, если обновление прошло успешно, иначе false
     */
    @Override
    public boolean update(Ticket ticket) {
        for (Ticket tick : tickets) {
            if (tick.equals(ticket)) {
                tickets.remove(tick);
                tickets.add(ticket);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для удаления билета.
     * В текущей реализации не используется.
     *
     * @param ticket объект билета для удаления
     * @return true, если билет успешно удален, иначе false
     */
    @Override
    public boolean delete(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            return true;
        }
        return false;
    }

    /**
     * Приватный метод для генерации билетов.
     * Создает указанное количество билетов для маршрута с заданными параметрами.
     *
     * @param routeNumber номер маршрута
     * @param countPlaces количество мест
     * @param price       цена билета
     * @param date        дата отправления
     */
    private void generateTickets(int routeNumber, int countPlaces, int price, Date date) {
        for (int i = 1; i <= countPlaces; i++) {
            tickets.add(new Ticket(routeNumber, i, price, date, true));
        }
    }
}
