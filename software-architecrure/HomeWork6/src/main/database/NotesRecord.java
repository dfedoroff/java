package main.database;

import java.util.Date;

/**
 * Класс, представляющий запись заметки в базе данных.
 * Содержит поля для хранения информации о заметке и методы для установки и получения значений этих полей.
 */
public class NotesRecord {

    private static int counter = 1000;

    {
        id = ++counter;
    }

    /**
     * Конструктор для создания новой записи заметки с заданными заголовком и деталями.
     *
     * @param title   заголовок заметки
     * @param details детали заметки
     */
    public NotesRecord(String title, String details) {
        this.title = title;
        this.details = details;
        creationDate = new Date();
        this.entityState = EntityState.UNCHANGED;
    }

    // Методы для установки значений полей

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEntityState(EntityState entityState) {
        this.entityState = entityState;
    }

    // Методы для получения значений полей

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public EntityState getEntityState() {
        return entityState;
    }

    // Приватные поля для хранения информации о заметке

    private int id;
    private int userId;
    private String title;
    private String details;
    private Date creationDate;
    private EntityState entityState;
}
