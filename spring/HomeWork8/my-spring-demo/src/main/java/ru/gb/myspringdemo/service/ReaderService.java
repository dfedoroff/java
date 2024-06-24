package ru.gb.myspringdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.myspringdemo.api.ReaderRequest;
import ru.gb.myspringdemo.aspect.RecoverException;
import ru.gb.myspringdemo.aspect.Timer;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    @Timer
    public List<Reader> showAllReaders() {
        return readerRepository.findAll();
    }

    @Timer
    @Transactional
    @RecoverException(noRecoverFor = {IllegalArgumentException.class})
    public Reader addNewReader(ReaderRequest request) {
        if (readerRepository.findReaderByName(request.getName()) != null) {
            throw new IllegalArgumentException("Данный читатель уже существует");
        }
        Reader reader = new Reader(request.getName());
        readerRepository.save(reader);
        return reader;
    }

    @Timer
    public Reader showReaderInfo(long id) {
        return readerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Не найден читатель с id: \"" + id + "\""));
    }

    @Timer
    @Transactional
    @RecoverException(noRecoverFor = {NoSuchElementException.class})
    public Reader deleteReader(long id) {
        Reader reader = showReaderInfo(id);
        readerRepository.deleteById(id);
        return reader;
    }
}
