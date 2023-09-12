package interfaces;

import service.UserManagementService;
import models.Ticket;
import models.User;

import java.util.Date;
import java.util.List;

/**
 * Интерфейс для взаимодействия с клиентским приложением.
 * Предоставляет методы для работы с билетами и пользователями.
 */
public interface CustomerServiceInterface {

    /**
     * Получает список выбранных билетов.
     *
     * @return Список выбранных билетов.
     */
    List<Ticket> getSelectedTickets();

    /**
     * Устанавливает список выбранных билетов.
     *
     * @param selectedTickets Список билетов для установки.
     */
    void setSelectedTickets(List<Ticket> selectedTickets);

    /**
     * Получает текущего пользователя.
     *
     * @return Текущий пользователь.
     */
    User getUser();

    /**
     * Устанавливает текущего пользователя.
     *
     * @param client Пользователь для установки.
     */
    void setUser(User client);

    /**
     * Получает провайдер услуг для работы с пользователями.
     *
     * @return Провайдер услуг для работы с пользователями.
     */
    UserManagementService getUserProvider();

    /**
     * Покупает билет.
     *
     * @param ticket Билет для покупки.
     * @return true, если покупка прошла успешно, и false в противном случае.
     * @throws RuntimeException если произошла ошибка при покупке билета.
     */
    boolean buyTicket(Ticket ticket) throws RuntimeException;

    /**
     * Ищет доступные для покупки билеты по дате и номеру маршрута.
     *
     * @param date  Дата, на которую нужно найти билеты.
     * @param route Номер маршрута, по которому нужно найти билеты.
     * @return Список доступных для покупки билетов.
     * @throws RuntimeException если произошла ошибка при поиске билетов.
     */
    List<Ticket> searchTicket(Date date, int route) throws RuntimeException;
}
