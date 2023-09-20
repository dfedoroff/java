package main.notes.core.application.interfaces;

import main.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

/**
 * Интерфейс редактора заметок.
 * Определяет методы для работы с заметками: добавление, редактирование, удаление, получение по ID, получение всех заметок, вывод всех заметок и сохранение изменений.
 */
public interface NoteEditor {

    /**
     * Добавляет новую заметку.
     *
     * @param item объект заметки для добавления
     * @return true, если заметка успешно добавлена, иначе false
     */
    boolean add(Note item);

    /**
     * Редактирует существующую заметку.
     *
     * @param item объект заметки с обновлённой информацией
     * @return true, если заметка успешно отредактирована, иначе false
     */
    boolean edit(Note item);

    /**
     * Удаляет заметку.
     *
     * @param item объект заметки для удаления
     * @return true, если заметка успешно удалена, иначе false
     */
    boolean remove(Note item);

    /**
     * Получает заметку по её ID.
     *
     * @param id ID заметки
     * @return объект Optional, содержащий заметку, если она найдена, иначе пустой Optional
     */
    Optional<Note> getById(Integer id);

    /**
     * Получает все заметки.
     *
     * @return коллекция всех заметок
     */
    Collection<Note> getAll();

    /**
     * Выводит все заметки.
     */
    void printAll();

    /**
     * Сохраняет все изменения, сделанные с заметками.
     */
    void saveChanges();
}
