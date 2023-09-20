package main.notes.core.application;

import main.notes.core.application.interfaces.NoteEditor;
import main.notes.core.application.interfaces.NotesDatabaseContext;
import main.notes.core.application.interfaces.NotesPresenter;
import main.notes.core.domain.Note;
import main.notes.infrastructure.persistance.NotesDbContext;
import main.database.NotesDatabase;
import main.database.NotesRecord;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

/**
 * Класс, реализующий интерфейс NoteEditor.
 * Предоставляет методы для работы с заметками: добавление, редактирование, удаление, получение по ID, получение всех заметок, вывод всех заметок и сохранение изменений.
 */
public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    /**
     * Конструктор для создания объекта ConcreteNoteEditor с заданными параметрами.
     *
     * @param dbContext контекст базы данных заметок
     * @param notesPresenter презентер для вывода заметок
     */
    public ConcreteNoteEditor(NotesDatabaseContext dbContext, NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    @Override
    public boolean add(Note item) {
        NotesRecord record = new NotesRecord(item.getTitle(), item.getDetails());
        boolean isAdded = ((NotesDatabase)((NotesDbContext) dbContext).getDatabase()).getNotesTable().addRecord(record);
        return isAdded && dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;

        NotesRecord record = new NotesRecord(item.getTitle(), item.getDetails());
        record.setId(item.getId());
        boolean isEdited = ((NotesDatabase)((NotesDbContext) dbContext).getDatabase()).getNotesTable().updateRecord(record);
        return isEdited && dbContext.saveChanges();
    }

    @Override
    public boolean remove(Note item) {
        if (item == null)
            return false;

        NotesRecord record = ((NotesDatabase)((NotesDbContext) dbContext).getDatabase()).getNotesTable().getRecordById(item.getId());
        boolean isRemoved = ((NotesDatabase)((NotesDbContext) dbContext).getDatabase()).getNotesTable().removeRecord(record);
        return isRemoved && dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }

    /**
     * Сохраняет все изменения, сделанные с заметками.
     */
    public void saveChanges() {
        dbContext.saveChanges();
    }
}
