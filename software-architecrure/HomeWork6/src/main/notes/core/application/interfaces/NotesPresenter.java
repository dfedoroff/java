package main.notes.core.application.interfaces;

import main.notes.core.domain.Note;

import java.util.Collection;

/**
 * Интерфейс презентера заметок.
 * Определяет методы для представления заметок пользователю.
 */
public interface NotesPresenter {

    /**
     * Выводит все переданные заметки.
     *
     * @param notes коллекция заметок для вывода
     */
    void printAll(Collection<Note> notes);
}
