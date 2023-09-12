package models;

/**
 * Класс представляющий собой модель банковского аккаунта.
 * Хранит информацию о номере карты и балансе на аккаунте.
 */
public class BankAccount {

    private long card; // Номер карты
    private static long oldCard; // Предыдущий номер карты
    private int balance; // Баланс на счету

    /**
     * Конструктор по умолчанию, инициализирующий начальный баланс и устанавливающий номер карты.
     */
    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    /**
     * Метод для установки баланса на счету.
     *
     * @param balance новый баланс
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Метод для установки номера карты.
     *
     * @param card новый номер карты
     */
    public void setCard(long card) {
        this.card = card;
    }

    /**
     * Метод для получения номера карты.
     *
     * @return номер карты
     */
    public long getCard() {
        return card;
    }

    /**
     * Метод для получения баланса на счету.
     *
     * @return баланс на счету
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}
