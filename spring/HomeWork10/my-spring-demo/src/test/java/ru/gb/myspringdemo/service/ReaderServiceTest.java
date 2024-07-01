package ru.gb.myspringdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.gb.myspringdemo.api.ReaderRequest;
import ru.gb.myspringdemo.model.Reader;
import ru.gb.myspringdemo.repository.ReaderRepository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private ReaderService readerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowAllReaders() {
        List<Reader> readers = Arrays.asList(new Reader("Reader1"), new Reader("Reader2"));
        when(readerRepository.findAll()).thenReturn(readers);

        List<Reader> result = readerService.showAllReaders();

        assertEquals(2, result.size());
        assertEquals("Reader1", result.get(0).getName());
        assertEquals("Reader2", result.get(1).getName());
    }

    @Test
    void testAddNewReader() {
        ReaderRequest request = new ReaderRequest();
        request.setName("New Reader");
        when(readerRepository.findReaderByName("New Reader")).thenReturn(null);
        when(readerRepository.save(any(Reader.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Reader result = readerService.addNewReader(request);

        assertNotNull(result);
        assertEquals("New Reader", result.getName());
    }

    @Test
    void testAddNewReaderAlreadyExists() {
        ReaderRequest request = new ReaderRequest();
        request.setName("Existing Reader");
        when(readerRepository.findReaderByName("Existing Reader")).thenReturn(new Reader("Existing Reader"));

        assertThrows(IllegalArgumentException.class, () -> readerService.addNewReader(request));
    }

    @Test
    void testShowReaderInfo() {
        Reader reader = new Reader("Test Reader");
        when(readerRepository.findById(1L)).thenReturn(Optional.of(reader));

        Reader result = readerService.showReaderInfo(1L);

        assertEquals("Test Reader", result.getName());
    }

    @Test
    void testShowReaderInfoNotFound() {
        when(readerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> readerService.showReaderInfo(1L));
    }

    @Test
    void testDeleteReader() {
        Reader reader = new Reader("Reader to Delete");
        when(readerRepository.findById(1L)).thenReturn(Optional.of(reader));

        Reader result = readerService.deleteReader(1L);

        assertEquals("Reader to Delete", result.getName());
        verify(readerRepository, times(1)).deleteById(1L);
    }
}