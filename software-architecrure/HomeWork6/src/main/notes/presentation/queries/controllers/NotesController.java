package main.notes.presentation.queries.controllers;

import main.notes.core.application.interfaces.NoteEditor;
import main.notes.core.domain.Note;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

/**
 * Контроллер для работы с заметками.
 * Предоставляет методы для добавления, редактирования и удаления заметок, а также для получения заметки по ID и получения последней заметки.
 */
public class NotesController extends Controller {

    private final NoteEditor notesEditor;

    /**
     * Конструктор класса.
     *
     * @param notesEditor редактор заметок, используемый для работы с заметками
     */
    public NotesController(NoteEditor notesEditor) {
        this.notesEditor = notesEditor;
    }

    /**
     * Метод для добавления новой заметки.
     *
     * @param note новая заметка
     */
    public void routeAddNote(Note note) {
        notesEditor.add(note);
    }

    /**
     * Метод для редактирования существующей заметки.
     *
     * @param note заметка с обновленными данными
     */
    public void routeEditNote(Note note) {
        Note existingNote = notesEditor.getById(note.getId()).orElse(null);
        if (existingNote != null) {
            existingNote.setTitle(note.getTitle());
            existingNote.setDetails(note.getDetails());
            existingNote.setEditDate(new Date());
            if (notesEditor.edit(existingNote)) {
                System.out.println("Заметка с ID " + note.getId() + " успешно обновлена.");
            } else {
                System.out.println("Не удалось обновить заметку с ID " + note.getId() + ".");
            }
        } else {
            System.out.println("Заметка с ID " + note.getId() + " не найдена.");
        }
    }

    /**
     * Метод для удаления заметки по ID.
     *
     * @param noteId ID заметки для удаления
     */
    public void routeRemoveNoteById(Integer noteId) {
        Note note = notesEditor.getById(noteId).orElse(null);
        if (note != null) {
            if (notesEditor.remove(note)) {
                System.out.println("Заметка с ID " + noteId + " успешно удалена.");
            } else {
                System.out.println("Не удалось удалить заметку с ID " + noteId + ".");
            }
        } else {
            System.out.println("Заметка с ID " + noteId + " не найдена.");
        }
    }

    /**
     * Метод для получения и вывода всех заметок.
     */
    public void routeGetAll() {
        this.notesEditor.printAll();
    }

    /**
     * Метод для редактирования последней заметки.
     *
     * @param newTitle новый заголовок заметки
     * @param newDetails новые детали заметки
     */
    public void routeEditLastNote(String newTitle, String newDetails) {
        // Получение всех заметок
        Collection<Note> allNotes = notesEditor.getAll();

        // Поиск заметки с наибольшим ID
        Note lastNote = allNotes.stream()
                .max(Comparator.comparingInt(Note::getId))
                .orElse(null);

        // Если заметка найдена, обновляем ее данные
        if (lastNote != null) {
            lastNote.setTitle(newTitle);
            lastNote.setDetails(newDetails);
            lastNote.setEditDate(new Date());

            // Сохранение изменений
            if (notesEditor.edit(lastNote)) {
                System.out.println("Последняя заметка успешно обновлена.");
            } else {
                System.out.println("Не удалось обновить последнюю заметку.");
            }
        } else {
            System.out.println("Нет доступных заметок для редактирования.");
        }
    }

    /**
     * Метод для получения заметки по ID.
     *
     * @param noteId ID заметки
     * @return заметка с указанным ID или null, если заметка не найдена
     */
    public Optional<Note> getNoteById(int noteId) {
        return notesEditor.getById(noteId);
    }

    /**
     * Метод для получения последней заметки.
     *
     * @return последняя заметка или null, если заметок нет
     */
    public Optional<Note> getLastNote() {
        return notesEditor.getAll().stream()
                .max(Comparator.comparingInt(Note::getId));
    }

    /**
     * Метод для сохранения изменений.
     */
    public void saveChanges() {
        notesEditor.saveChanges();
    }
}
