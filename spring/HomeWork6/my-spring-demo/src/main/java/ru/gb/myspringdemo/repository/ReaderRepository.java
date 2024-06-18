package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findReaderByName(String name);
}
