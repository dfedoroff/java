package main.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Класс, представляющий таблицу заметок в базе данных.
 * Содержит методы для работы с записями заметок: добавление, обновление, удаление, получение по ID и получение всех записей.
 */
public class NotesTable {

    private Random random = new Random();

    private Collection<NotesRecord> records;

    /**
     * Получает все записи заметок. Если записей нет, создает их.
     *
     * @return коллекция всех записей заметок
     */
    public Collection<NotesRecord> getRecords() {
        if (records == null) {
            records = new ArrayList<>();
            int recordsCount = 5 + random.nextInt(10);
            for (int i = 0; i < recordsCount; i++){
                records.add(new NotesRecord("title #" + i, "details #" + i));
            }
        }
        return records;
    }

    /**
     * Добавляет новую запись заметки.
     *
     * @param record объект записи заметки для добавления
     * @return true, если запись успешно добавлена, иначе false
     */
    public boolean addRecord(NotesRecord record) {
        if (records == null) {
            records = new ArrayList<>();
        }
        return records.add(record);
    }

    /**
     * Обновляет существующую запись заметки.
     *
     * @param record объект записи заметки с обновлённой информацией
     * @return true, если запись успешно обновлена, иначе false
     */
    public boolean updateRecord(NotesRecord record) {
        for (NotesRecord rec : records) {
            if (rec.getId() == record.getId()) {
                rec.setTitle(record.getTitle());
                rec.setDetails(record.getDetails());
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет запись заметки.
     *
     * @param record объект записи заметки для удаления
     * @return true, если запись успешно удалена, иначе false
     */
    public boolean removeRecord(NotesRecord record) {
        return records.removeIf(rec -> rec.getId() == record.getId());
    }

    /**
     * Получает запись заметки по её ID.
     *
     * @param id ID записи заметки
     * @return объект записи заметки, если она найдена, иначе null
     */
    public NotesRecord getRecordById(int id) {
        for (NotesRecord rec : records) {
            if (rec.getId() == id) {
                return rec;
            }
        }
        return null;
    }
}
