package main.notes.infrastructure.persistance;

import main.database.NotesDatabase;
import main.database.NotesRecord;
import main.database.EntityState;

import java.util.Collection;

/**
 * Абстрактный класс, представляющий контекст базы данных.
 * Содержит методы для сохранения изменений в базе данных и для конфигурации модели при создании контекста.
 */
public abstract class DbContext {

    /**
     * Объект базы данных, с которым работает контекст.
     */
    protected Database database;

    /**
     * Конструктор, принимающий объект базы данных для инициализации контекста.
     *
     * @param database объект базы данных
     */
    public DbContext(Database database) {
        this.database = database;
    }

    /**
     * Абстрактный метод для конфигурации модели при создании контекста.
     * Должен быть реализован в подклассах для конкретной конфигурации модели.
     *
     * @param builder объект построителя модели для конфигурации
     */
    protected abstract void onModelCreating(ModelBuilder builder);

    /**
     * Метод для сохранения изменений в базе данных.
     * Перебирает все записи в базе данных и, в зависимости от состояния каждой записи, выполняет соответствующее действие (добавление, обновление или удаление).
     *
     * @return true, если все изменения успешно сохранены, иначе false
     */
    public boolean saveChanges(){
        try {
            Collection<NotesRecord> records = ((NotesDatabase) database).getNotesTable().getRecords();
            for (NotesRecord record : records) {
                switch (record.getEntityState()) {
                    case NEW:
                        // логика добавления новой записи в базу данных
                        break;
                    case MODIFIED:
                        // логика обновления существующей записи в базе данных
                        break;
                    case DELETED:
                        // логика удаления записи из базы данных
                        break;
                    case UNCHANGED:
                        // ничего не делать
                        break;
                }
                // после успешной обработки, сбрасываем состояние на UNCHANGED
                record.setEntityState(EntityState.UNCHANGED);
            }
            return true;
        } catch (Exception e) {
            // логирование ошибки (рекомендуется добавить систему логирования)
            return false;
        }
    }
}

/**
 * Класс для построения модели, предоставляющий метод для применения конфигурации маппинга объекта к структуре таблицы базы данных.
 */
class ModelBuilder {

    /**
     * Метод для применения конфигурации маппинга объекта к структуре таблицы базы данных.
     *
     * @param configuration конфигурация маппинга
     * @return объект построителя модели
     */
    public ModelBuilder applyConfiguration(ModelConfiguration configuration){
        //TODO: добавление конфигурации маппинга объекта некоторого типа к структуре таблицы БД
        return this;
    }
}
