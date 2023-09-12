package client;

import service.CustomerManagementService;
import interfaces.CustomerServiceInterface;
import models.Ticket;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Основной класс клиентского приложения, который управляет пользовательским интерфейсом для входа в систему,
 * регистрации и покупки билетов.
 */
public class ApplicationStarter extends UserInputValidator {
    private CustomerServiceInterface customer;
    private int ticketRouteNumber;
    private Date ticketDate;

    public ApplicationStarter() {
        printMessageLine("Приложение для покупки автобусных билетов");
    }

    /**
     * Метод для запуска меню входа/регистрации. Предоставляет пользователю возможность войти в систему или зарегистрироваться.
     */
    public void runLoginRegisterMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Для входа в систему нажмите 1");
            printMessageLine("Для регистрации нажмите 2");
            printMessageLine("Для выхода нажмите 0");
            System.out.print("Ваш выбор > ");
            int choice = 0;
            try {
                choice = inputInt(0, 2);
                System.out.println();
            } catch (RuntimeException ex) {
                System.err.println(ex.getMessage());
                continue;
            }
            run = runLoginRegisterMenuChoiceLogic(choice);
        }
    }

    /**
     * Логика выбора действия в меню входа/регистрации.
     *
     * @param choice выбор пользователя
     * @return true, если меню должно продолжить работу; false, если пользователь выбрал выход
     */
    private boolean runLoginRegisterMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1:
                login();
                if (customer.getUser() != null) {
                    runBuyingMenu();
                }
                break;
            case 2:
                register();
                if (customer != null) {
                    runBuyingMenu();
                }
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Метод для входа в систему, включая аутентификацию пользователя.
     */
    private void login() {
        printMessageLine("Вход в систему");
        System.out.print("Имя пользователя: ");
        String userName = inputString();
        System.out.print("Пароль: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Вход в систему... ");
        customer = new CustomerManagementService();
        try {
            customer.setUser(UserAuthenticationService.authentication(customer.getUserProvider(), userName, passwordHash));
            printMessageLine("Успешно");
        } catch (RuntimeException ex) {
            System.out.println("Ошибка");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод для регистрации нового пользователя в системе.
     */
    private void register() {
        printMessageLine("Регистрация");
        System.out.print("Введите имя пользователя: ");
        String userName = inputString();
        System.out.print("Введите пароль: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Повторите пароль: ");
        int passwordHash2 = inputString().hashCode();
        if (passwordHash != passwordHash2) {
            printMessageLine("Пароли не совпадают. Регистрация отменена.");
            return;
        }
        System.out.print("Введите номер карты: ");
        long cardNumber = inputLong(1L, 9999_9999_9999_9999L);
        System.out.print("Регистрация... ");
        customer = new CustomerManagementService();
        int id;
        try {
            id = customer.getUserProvider().createClient(userName, passwordHash, cardNumber);
            customer.setUser(UserAuthenticationService.authentication(customer.getUserProvider(), userName, passwordHash));
            printMessageLine("Успешно. Пользователь " + customer.getUser().getUserName() + " с ID " + id + " добавлен.");
        } catch (RuntimeException ex) {
            System.out.println("Ошибка");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод для запуска меню покупки билетов, предоставляющий пользователю возможности выбора маршрута и даты.
     */
    private void runBuyingMenu() {
        boolean run = true;
        while (run) {
            printMessageLine("Приложение для покупки автобусных билетов. | Пользователь " + customer.getUser().getUserName() + " |");
            printMessageLine("Для выбора номера маршрута и просмотра всех билетов нажмите 1");
            printMessageLine("Для выхода из аккаунта нажмите 0");
            System.out.print("Ваш выбор > ");
            int choice = 0;
            try {
                choice = inputInt(0, 1);
                System.out.println();
            } catch (RuntimeException ex) {
                System.err.println(ex.getMessage());
                continue;
            }
            run = runBuyingMenuChoiceLogic(choice);
        }
    }

    /**
     * Логика выбора действия в меню покупки билетов.
     *
     * @param choice выбор пользователя
     * @return true, если меню должно продолжить работу; false, если пользователь выбрал выход
     */
    private boolean runBuyingMenuChoiceLogic(int choice) {
        switch (choice) {
            case 1:
                ticketRouteNumber = runSelectRouteMenu();
                if (ticketRouteNumber > 0) {
                    ticketDate = runSelectDate();
                    if (ticketDate != null) {
                        try {
                            customer.setSelectedTickets(customer.searchTicket(ticketDate, ticketRouteNumber));
                        } catch (RuntimeException ex) {
                            printMessageLine(ex.getMessage());
                            return true;
                        }
                        printAllTickets(customer.getSelectedTickets());
                        buyTicketMenu();
                        return true;
                    }
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * Метод для выбора номера маршрута билета.
     *
     * @return выбранный номер маршрута
     */
    private int runSelectRouteMenu() {
        printMessageLine("Выбор номера маршрута и даты. | Пользователь " + customer.getUser().getUserName() + " |");
        System.out.print("Номер маршрута > ");
        int numRoute;
        try {
            numRoute = inputInt(1, 2);
            System.out.println();
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return -1;
        }
        return numRoute;
    }

    /**
     * Метод для выбора даты покупки билета.
     *
     * @return выбранная дата
     */
    private Date runSelectDate() {
        System.out.print("Дата (формат: ГГГГ-ММ-ДД) > ");
        Date date;
        try {
            date = inputDate();
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return null;
        }
        return date;
    }

    /**
     * Метод для печати всех доступных билетов.
     *
     * @param ticks список билетов для печати
     */
    private void printAllTickets(List<Ticket> ticks) {
        for (var t : ticks) {
            System.out.println(t.toString());
        }
    }

    /**
     * Метод для запуска меню подтверждения покупки билета.
     */
    private void buyTicketMenu() {
        printMessageLine("Подтверждение покупки. | Пользователь " + customer.getUser().getUserName() + " |");
        System.out.print("Для покупки билета на маршрут " + ticketRouteNumber + " датой " + ticketDate + " введите \"ДА\" > ");
        String answer = inputString();
        buyTicketMenuConfirmLogic(answer);
    }

    /**
     * Логика подтверждения покупки билета.
     *
     * @param answer ответ пользователя на запрос подтверждения
     */
    private void buyTicketMenuConfirmLogic(String answer) {
        if (answer.equalsIgnoreCase("ДА")) {
            LocalDate inputDate = ticketDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            for (var t : customer.getSelectedTickets()) {
                LocalDate ticketDate = t.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (ticketDate.equals(inputDate) && t.getRouteNumber() == ticketRouteNumber && t.isValid()) {
                    boolean flag = false;
                    try {
                        flag = customer.buyTicket(t);
                    } catch (RuntimeException ex) {
                        printMessageLine(ex.getMessage());
                        return;
                    }
                    if (flag) {
                        printMessageLine("Билет успешно куплен:\n" + t.toPrint());
                        return;
                    }
                }
            }
            printMessageLine("Не удалось найти подходящий билет для покупки.");
        }
    }

    /**
     * Метод для печати сообщения с добавлением разделительной линии.
     *
     * @param message сообщение для печати
     */
    private void printMessageLine(String message) {
        System.out.println(message);
        System.out.println("=====================================================================================");
    }
}
