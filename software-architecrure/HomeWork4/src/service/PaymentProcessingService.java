package service;

import interfaces.CarrierDatabaseInterface;
import interfaces.PaymentTransactionInterface;
import models.Carrier;
import models.Ticket;
import models.User;
import repository.CarrierRepository;
import repository.CashRepository;

/**
 * Класс-провайдер для взаимодействия с банком и базой перевозчиков.
 * Отвечает за авторизацию платежей и осуществление транзакций.
 */
public class PaymentProcessingService {

    private long cardNumber;
    private boolean isAuthorized = false;
    private CarrierDatabaseInterface carrierRepository;
    private PaymentTransactionInterface cashRepository;

    /**
     * Конструктор класса, инициализирующий репозитории для работы с перевозчиками и кассой.
     * Реализует паттерн Singleton для репозиториев.
     */
    public PaymentProcessingService() {
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }

    /**
     * Метод для покупки билета. Проверяет, была ли проведена авторизация, и если да,
     * то осуществляет транзакцию покупки билета.
     *
     * @param ticket билет, который нужно купить
     * @return true, если покупка прошла успешно, иначе false
     * @throws RuntimeException в случае ошибки при покупке билета
     */
    public boolean buy(Ticket ticket) {
        if (isAuthorized) {
            Carrier carrier = carrierRepository.read(1);
            return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
        }
        return false;
    }

    /**
     * Метод для авторизации пользователя. В текущей реализации просто сохраняет номер карты пользователя
     * и устанавливает флаг авторизации в true.
     *
     * @param client пользователь, который пытается авторизоваться
     */
    public void authorization(User client) {
        cardNumber = client.getCardNumber();
        isAuthorized = true;
    }
}
