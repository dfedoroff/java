package service;

import interfaces.CustomerServiceInterface;
import models.Ticket;
import models.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, реализующий основную логику покупки билетов.
 * Реализует интерфейс CustomerServiceInterface.
 */
public class CustomerManagementService implements CustomerServiceInterface {
    private TicketManagementService ticketManagementService;
    private PaymentProcessingService paymentProcessingService;
    private UserManagementService userManagementService;
    private User client;
    private List<Ticket> selectedTickets;

    /**
     * Конструктор класса, инициализирующий сервисы для работы с билетами, платежами и пользователями.
     */
    public CustomerManagementService() {
        this.paymentProcessingService = new PaymentProcessingService();
        this.ticketManagementService = new TicketManagementService();
        this.userManagementService = new UserManagementService();
    }

    @Override
    public List<Ticket> getSelectedTickets() {
        return selectedTickets;
    }

    @Override
    public void setSelectedTickets(List<Ticket> selectedTickets) {
        this.selectedTickets = selectedTickets;
    }

    @Override
    public UserManagementService getUserProvider() {
        return userManagementService;
    }

    @Override
    public User getUser() {
        return client;
    }

    @Override
    public void setUser(User client) {
        this.client = client;
    }

    @Override
    public boolean buyTicket(Ticket ticket) throws RuntimeException {
        // Проверка предусловий: билет и клиент не должны быть null
        if (ticket == null || client == null) {
            throw new IllegalArgumentException("Билет или клиент не может быть null");
        }

        boolean flag;
        paymentProcessingService.authorization(client);
        flag = paymentProcessingService.buy(ticket);
        if (flag) {
            flag = ticketManagementService.updateTicketStatus(ticket);
        }

        // Проверка постусловий: билет должен быть куплен успешно
        if (!flag) {
            throw new RuntimeException("Не удалось купить билет");
        }
        return flag;
    }

    @Override
    public List<Ticket> searchTicket(Date date, int route) throws RuntimeException {
        // Проверка предусловий: дата не должна быть null и номер маршрута должен быть положительным
        if (date == null || route <= 0) {
            throw new IllegalArgumentException("Дата не может быть null и номер маршрута должен быть положительным");
        }

        List<Ticket> result = new ArrayList<>();
        var list = ticketManagementService.getTickets(route);

        LocalDate inputDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        for (Ticket ticket : list) {
            LocalDate ticketDate = ticket.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (ticketDate.equals(inputDate)) {
                result.add(ticket);
            }
        }

        // Проверка постусловий: должен быть возвращен список билетов
        if (result.isEmpty()) {
            throw new RuntimeException("На эту дату билетов нет");
        }
        return result;
    }
}
