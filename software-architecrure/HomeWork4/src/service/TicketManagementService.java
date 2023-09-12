package service;

import interfaces.TicketDatabaseInterface;
import models.Ticket;
import repository.TicketRepository;

import java.util.List;

/**
 * Класс-провайдер для работы с базой данных билетов.
 * Отвечает за получение информации о билетах и обновление статуса билетов.
 */
public class TicketManagementService {

    private TicketDatabaseInterface ticketRepo;

    /**
     * Конструктор класса, инициализирующий репозиторий для работы с билетами.
     * Реализует паттерн Singleton для репозитория билетов.
     */
    public TicketManagementService() {
        this.ticketRepo = TicketRepository.getTicketRepository();
    }

    /**
     * Метод для получения списка билетов по номеру маршрута.
     * Проверяет корректность входных данных и возвращает список доступных билетов.
     *
     * @param routeNumber номер маршрута
     * @return список билетов
     * @throws RuntimeException если билеты не найдены или введён некорректный номер маршрута
     */
    public List<Ticket> getTickets(int routeNumber) throws RuntimeException {
        if (routeNumber <= 0) {
            throw new IllegalArgumentException("Номер маршрута должен быть положительным");
        }

        List<Ticket> tickets = ticketRepo.readAll(routeNumber);

        if (tickets.isEmpty()) {
            throw new RuntimeException("Билеты не найдены");
        }
        return tickets;
    }

    /**
     * Метод для обновления статуса билета.
     * Проверяет корректность входных данных и обновляет статус билета в базе данных.
     *
     * @param ticket билет, статус которого нужно обновить
     * @return true, если статус успешно обновлён, иначе false
     * @throws RuntimeException если обновление не удалось или билет некорректен
     */
    public boolean updateTicketStatus(Ticket ticket) throws RuntimeException {
        if (ticket == null) {
            throw new IllegalArgumentException("Билет не может быть null");
        }

        ticket.setValid(false);
        boolean result = ticketRepo.update(ticket);

        if (!result) {
            throw new RuntimeException("Не удалось обновить статус билета");
        }
        return result;
    }
}
