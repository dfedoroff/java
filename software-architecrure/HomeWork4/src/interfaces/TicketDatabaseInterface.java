package interfaces;

import models.Ticket;

import java.util.List;

/**
 * Интерфейс для взаимодействия с базой данных билетов.
 * Предоставляет методы для создания, чтения, обновления и удаления записей билетов.
 */
public interface TicketDatabaseInterface {

    /**
     * Создает новый билет в базе данных.
     *
     * @param ticket Объект билета, который нужно создать в базе данных.
     * @return true, если билет успешно создан, и false в противном случае.
     */
    boolean create(Ticket ticket);

    /**
     * Получает список всех билетов по номеру маршрута.
     *
     * @param routeNumber Номер маршрута, по которому нужно найти билеты.
     * @return Список билетов, соответствующих указанному номеру маршрута.
     */
    List<Ticket> readAll(int routeNumber);

    /**
     * Обновляет информацию о билете в базе данных.
     *
     * @param ticket Объект билета с обновленной информацией.
     * @return true, если информация о билете успешно обновлена, и false в противном случае.
     */
    boolean update(Ticket ticket);

    /**
     * Удаляет билет из базы данных.
     *
     * @param ticket Объект билета, который нужно удалить из базы данных.
     * @return true, если билет успешно удален, и false в противном случае.
     */
    boolean delete(Ticket ticket);
}
