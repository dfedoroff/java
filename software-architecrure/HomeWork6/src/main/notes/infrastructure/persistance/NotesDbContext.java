package main.notes.infrastructure.persistance;

import main.database.NotesDatabase;
import main.database.NotesRecord;
import main.notes.core.application.interfaces.NotesDatabaseContext;
import main.notes.core.domain.Note;
import main.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Класс, реализующий интерфейс NotesDatabaseContext для работы с контекстом базы данных заметок.
 * Предоставляет методы для получения всех заметок и сохранения изменений.
 */
public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    /**
     * Конструктор класса.
     *
     * @param database база данных, с которой будет работать контекст
     */
    public NotesDbContext(Database database) {
        super(database);
    }

    /**
     * Метод для конфигурации модели при создании контекста базы данных.
     * В данной реализации применяется конфигурация для маппинга объектов типа Note.
     *
     * @param builder построитель модели для конфигурации
     */
    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    /**
     * Метод для получения всех заметок из базы данных.
     *
     * @return коллекция всех заметок
     */
    @Override
    public Collection<Note> getAll() {
        Collection<NotesRecord> records = ((NotesDatabase) database).getNotesTable().getRecords();
        return records.stream()
                .map(record -> new Note(
                        record.getId(),
                        record.getUserId(),
                        record.getTitle(),
                        record.getDetails(),
                        record.getCreationDate()))
                .collect(Collectors.toList());
    }

    /**
     * Метод для сохранения изменений в базе данных.
     * В текущей реализации всегда возвращает true, предполагая успешное сохранение изменений.
     *
     * @return true, если изменения успешно сохранены, иначе false
     */
    @Override
    public boolean saveChanges() {
        return true; // Здесь предполагается, что изменения всегда успешно сохраняются
    }

    /**
     * Метод для получения объекта базы данных, с которым работает контекст.
     *
     * @return объект базы данных
     */
    public Database getDatabase() {
        return this.database;
    }
}
