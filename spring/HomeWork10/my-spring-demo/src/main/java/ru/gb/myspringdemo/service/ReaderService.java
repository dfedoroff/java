package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.myspringdemo.api.ReaderRequest;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Сервис для управления читателями.
 * Реализует бизнес-логику работы с читателями.
 */
@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    /**
     * Получает список всех читателей.
     * @return список всех читателей
     */
    public List<Reader> showAllReaders() {
        return readerRepository.findAll();
    }

    /**
     * Добавляет нового читателя.
     * @param request запрос на добавление читателя
     * @return добавленный читатель
     * @throws IllegalArgumentException если читатель с таким именем уже существует
     */
    public Reader addNewReader(ReaderRequest request) {
        if (readerRepository.findReaderByName(request.getName()) != null) {
            throw new IllegalArgumentException("Данный читатель уже существует");
        }
        Reader reader = new Reader(request.getName());
        readerRepository.save(reader);
        return reader;
    }

    /**
     * Получает информацию о читателе по его ID.
     * @param id идентификатор читателя
     * @return информация о читателе
     * @throws NoSuchElementException если читатель не найден
     */
    public Reader showReaderInfo(long id) {
        return readerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найден читатель с id: \"" + id + "\""));
    }

    /**
     * Удаляет читателя по его ID.
     * @param id идентификатор читателя
     * @return удаленный читатель
     * @throws NoSuchElementException если читатель не найден
     */
    public Reader deleteReader(long id) {
        Reader reader = showReaderInfo(id);
        if (reader == null) {
            throw new NoSuchElementException("Не найден читатель с id: \"" + id + "\"");
        }
        readerRepository.deleteById(id);
        return reader;
    }
}