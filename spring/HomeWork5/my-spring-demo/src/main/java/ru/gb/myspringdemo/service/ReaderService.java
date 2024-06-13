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
        return readerRepository.findAll();
    }

    public Reader addNewReader(ReaderRequest request) {
        if (readerRepository.findReaderByName(request.getName()) != null) {
            throw new IllegalArgumentException("Данный читатель уже существует");
        }
        Reader reader = new Reader(request.getName());
        readerRepository.save(reader);
        return reader;
    }

    public Reader showReaderInfo(long id) {
        return readerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найден читатель с id: \"" + id + "\""));
    }

    public Reader deleteReader(long id) {
        Reader reader = showReaderInfo(id);
        if (reader == null) {
            throw new NoSuchElementException("Не найден читатель с id: \"" + id + "\"");
        }
        readerRepository.deleteById(id);
        return reader;
    }
}
