package main.notes.core.domain;

import java.util.Date;

/**
 * Класс, представляющий сущность заметки.
 * Содержит информацию о заметке, включая её идентификатор, заголовок, детали и даты создания и редактирования.
 */
public class Note {

    @Override
    public String toString() {
        return "Заметка{" +
                "id=" + id +
                ", заголовок='" + title + '\'' +
                ", детали='" + details + '\'' +
                '}';
    }

    //region Конструкторы

    /**
     * Конструктор для создания объекта заметки с заданными параметрами.
     *
     * @param id идентификатор заметки
     * @param userId идентификатор пользователя
     * @param title заголовок заметки
     * @param details детали заметки
     * @param creationDate дата создания заметки
     */
    public Note(int id, int userId, String title, String details, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.creationDate = creationDate;
    }

    //endregion

    //region Публичные геттеры и сеттеры (свойства)

    /**
     * Устанавливает заголовок заметки.
     *
     * @param title новый заголовок заметки
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Устанавливает детали заметки.
     *
     * @param details новые детали заметки
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Устанавливает дату редактирования заметки.
     *
     * @param editDate новая дата редактирования заметки
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * Возвращает идентификатор заметки.
     *
     * @return идентификатор заметки
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает идентификатор пользователя, создавшего заметку.
     *
     * @return идентификатор пользователя
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Возвращает заголовок заметки.
     *
     * @return заголовок заметки
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает детали заметки.
     *
     * @return детали заметки
     */
    public String getDetails() {
        return details;
    }

    /**
     * Возвращает дату создания заметки.
     *
     * @return дата создания заметки
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Возвращает дату последнего редактирования заметки.
     *
     * @return дата последнего редактирования заметки
     */
    public Date getEditDate() {
        return editDate;
    }

    //endregion

    //region Приватные поля

    private int id;
    private int userId;
    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    //endregion
}
