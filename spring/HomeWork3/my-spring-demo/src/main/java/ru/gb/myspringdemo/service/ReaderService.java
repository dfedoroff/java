package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.myspringdemo.api.ReaderRequest;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<Reader> showAllReaders() {
        return readerRepository.getAll();
    }

    public Reader addNewReader(ReaderRequest request) {
        if (readerRepository.getReaderByName(request.getName()) != null) {
            throw new IllegalArgumentException("Данный читатель уже существует");
        }
        Reader reader = new Reader(request.getName());
        readerRepository.addReader(reader);
        return reader;
    }

    public Reader showReaderInfo(long id) {
        Reader reader = readerRepository.getReaderById(id);
        if (reader == null) {
            throw new NoSuchElementException("Не найден читатель с id: \"" + id + "\"");
        }
        return reader;
    }

    public Reader deleteReader(long id) {
        Reader reader = readerRepository.getReaderById(id);
        if (reader == null) {
            throw new NoSuchElementException("Не найден читатель с id: \"" + id + "\"");
        }
        readerRepository.deleteReader(reader);
        return reader;
    }
}
