package main;

import main.database.NotesDatabase;
import main.notes.core.application.ConcreteNoteEditor;
import main.notes.core.domain.Note;
import main.notes.infrastructure.persistance.NotesDbContext;
import main.notes.presentation.queries.controllers.NotesController;
import main.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Date;
import java.util.Optional;

/**
 * Главный класс программы, отвечающий за запуск приложения и демонстрацию работы с заметками через консольный интерфейс.
 */
public class Program {

    public static void main(String[] args) {
        // Инициализация контроллера с нужными объектами для работы
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        // Вывод всех существующих заметок при запуске программы
        System.out.println("Существующие заметки:");
        controller.routeGetAll();
        System.out.println();

        // Добавление новой заметки
        Note newNote = new Note(0, 0, "Новая заметка", "Новые детали", new Date());
        System.out.println("Добавление новой заметки...");
        controller.routeAddNote(newNote);
        System.out.println();

        // Просмотр всех заметок после добавления
        System.out.println("Заметки после добавления новой:");
        controller.routeGetAll();
        System.out.println();

        // Редактирование заметки
        Note editNote = new Note(1001, 0, "Обновленная заметка", "Обновленные детали", new Date());
        System.out.println("Редактирование заметки...");
        System.out.println("До редактирования:");
        displayNoteDetails(controller, 1001);
        System.out.println();
        controller.routeEditNote(editNote);

        // Просмотр всех заметок после редактирования
        System.out.println("Заметки после редактирования:");
        controller.routeGetAll();
        System.out.println();

        // Удаление заметки
        int removeNoteId = 1001;
        System.out.println("Удаление заметки...");
        System.out.println("До удаления:");
        displayNoteDetails(controller, removeNoteId);
        System.out.println();
        controller.routeRemoveNoteById(removeNoteId);

        // Просмотр всех заметок после удаления
        System.out.println("Заметки после удаления:");
        controller.routeGetAll();
        System.out.println();

        // Редактирование последней заметки
        System.out.println("Редактирование последней заметки...");
        System.out.println("До редактирования:");
        displayLastNoteDetails(controller);
        System.out.println();
        controller.routeEditLastNote("Последняя заметка обновлена", "Последние детали обновлены");

        // Просмотр всех заметок после редактирования последней заметки
        System.out.println("Заметки после редактирования последней заметки:");
        controller.routeGetAll();
        System.out.println();
    }

    /**
     * Метод для отображения деталей заметки по её ID.
     *
     * @param controller контроллер для работы с заметками
     * @param noteId     ID заметки
     */
    private static void displayNoteDetails(NotesController controller, int noteId) {
        Optional<Note> note = controller.getNoteById(noteId);
        note.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Заметка с ID " + noteId + " не найдена.")
        );
    }

    /**
     * Метод для отображения деталей последней заметки.
     *
     * @param controller контроллер для работы с заметками
     */
    private static void displayLastNoteDetails(NotesController controller) {
        Optional<Note> note = controller.getLastNote();
        note.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Заметки не найдены.")
        );
    }
}
