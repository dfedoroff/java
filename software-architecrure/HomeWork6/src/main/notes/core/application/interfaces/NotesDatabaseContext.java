package main.notes.core.application.interfaces;

import main.notes.core.domain.Note;

import java.util.Collection;

/**
 * Интерфейс контекста базы данных заметок.
 * Определяет методы для работы с базой данных заметок: получение всех заметок и сохранение изменений.
 */
public interface NotesDatabaseContext {

    /**
     * Получает все заметки из базы данных.
     *
     * @return коллекция всех заметок
     */
    Collection<Note> getAll();

    /**
     * Сохраняет все изменения в базе данных.
     *
     * @return true, если изменения успешно сохранены, иначе false
     */
    boolean saveChanges();
}
