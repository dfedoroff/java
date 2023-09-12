package repository;

import interfaces.PaymentTransactionInterface;
import models.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий, имитирующий работу с базой данных банка.
 * Реализует интерфейс PaymentTransactionInterface.
 * Использует паттерн Singleton для создания единственного экземпляра класса.
 */
public class CashRepository implements PaymentTransactionInterface {
    private static CashRepository cashRepository; // Единственный экземпляр класса
    private List<BankAccount> clients; // Список банковских аккаунтов клиентов

    /**
     * Метод для получения списка банковских аккаунтов клиентов.
     *
     * @return список банковских аккаунтов клиентов
     */
    public List<BankAccount> getClients() {
        return clients;
    }

    /**
     * Приватный конструктор, инициализирующий список банковских аккаунтов клиентов.
     * Добавляет в список пять банковских аккаунтов с начальным балансом.
     */
    private CashRepository() {
        clients = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            clients.add(new BankAccount());
        }
    }

    /**
     * Статический метод, возвращающий единственный экземпляр класса.
     * Если экземпляр не был создан ранее, создает новый.
     *
     * @return единственный экземпляр класса CashRepository
     */
    public static CashRepository getCashRepository() {
        if (cashRepository == null) {
            cashRepository = new CashRepository();
        }
        return cashRepository;
    }

    /**
     * Метод для проведения транзакции между двумя банковскими аккаунтами.
     * Проверяет наличие счетов и достаточность средств для проведения транзакции.
     * В случае успешной валидации, проводит транзакцию, изменяя балансы счетов.
     *
     * @param payment     сумма платежа
     * @param cardFrom    номер карты отправителя
     * @param carrierCard номер карты получателя
     * @return true, если транзакция прошла успешно, иначе false
     * @throws RuntimeException если валидация не прошла, с сообщением о причине
     */
    @Override
    public boolean transaction(int payment, long cardFrom, long carrierCard) throws RuntimeException {
        BankAccount from = null;
        BankAccount to = null;

        // Поиск банковских аккаунтов отправителя и получателя
        for (var client : clients) {
            if (client.getCard() == cardFrom) {
                from = client;
            }
            if (client.getCard() == carrierCard) {
                to = client;
            }
        }

        // Проверка наличия аккаунтов
        if (from == null) {
            throw new RuntimeException("Счет для снятия средств не найден.");
        }
        if (to == null) {
            throw new RuntimeException("Счет для зачисления средств не найден.");
        }

        // Проверка баланса счета отправителя
        if (from.getBalance() - payment < 0) {
            throw new RuntimeException("Недостаточно средств на счете.");
        }

        // Проверка баланса счета получателя
        if (to.getBalance() > Integer.MAX_VALUE - payment) {
            throw new RuntimeException("Слишком большая сумма для зачисления на счет.");
        }

        // Проведение транзакции с обновлением балансов счетов
        try {
        } finally {
            clients.remove(from);
            clients.remove(to);
            from.setBalance(from.getBalance() - payment);
            to.setBalance(to.getBalance() + payment);
            clients.add(from);
            clients.add(to);
        }
        return true;
    }
}
