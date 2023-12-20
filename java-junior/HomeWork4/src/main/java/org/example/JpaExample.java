package main.java.org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Пример использования JPA (Hibernate) для работы с базой данных.
 * Включает в себя создание сущностей, сохранение и запрос данных.
 */
public class JpaExample {

    /**
     * Точка входа в программу.
     * Демонстрирует процесс работы с сущностями в JPA.
     */
    public static void main(String[] args) {
        // Создание EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        // Создание и использование EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Начало транзакции
        entityManager.getTransaction().begin();

        // Создание и сохранение объектов Book
        for (int i = 1; i <= 10; i++) {
            entityManager.persist(new Book("Book" + i, "Author" + (i % 2 == 0 ? 2 : 1)));
        }

        // Фиксация транзакции
        entityManager.getTransaction().commit();

        // Выполнение запроса для получения книг определённого автора
        List<Book> books = entityManager.createQuery("SELECT b FROM Book b WHERE b.author = :author", Book.class)
                .setParameter("author", "Author1")
                .getResultList();

        // Вывод результатов
        for (Book book : books) {
            System.out.println(book);
        }

        // Закрытие EntityManager и EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
