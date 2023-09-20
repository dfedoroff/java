package main.database;

import main.notes.infrastructure.persistance.Database;

/**
 * Класс, представляющий базу данных заметок.
 * Содержит метод для получения объекта таблицы заметок.
 */
public class NotesDatabase implements Database {

    private NotesTable notesTable;

    /**
     * Получает объект таблицы заметок. Если объект не создан, создает новый.
     *
     * @return объект таблицы заметок
     */
    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = new NotesTable();
        return notesTable;
    }
}
