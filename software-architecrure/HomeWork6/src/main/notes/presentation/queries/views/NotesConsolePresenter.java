package main.notes.presentation.queries.views;

import main.notes.core.application.interfaces.NotesPresenter;
import main.notes.core.domain.Note;

import java.util.Collection;

/**
 * Класс, реализующий интерфейс NotesPresenter для представления заметок в консоли.
 */
public class NotesConsolePresenter implements NotesPresenter {

    /**
     * Метод для печати всех заметок в консоль.
     *
     * @param notes коллекция заметок для печати
     */
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes) {
            System.out.println(note);
        }
    }
}
