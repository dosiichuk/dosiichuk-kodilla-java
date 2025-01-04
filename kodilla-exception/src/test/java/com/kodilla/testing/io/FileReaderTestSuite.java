package com.kodilla.testing.io;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        // Given
        FileReader fileReader = new FileReader();
        // When
        // Then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void whenFileDoesntExistsReadFileShouldThrowException() {
        // Given
        FileReader fileReader = new FileReader();
        // When
        // Then
        assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt"));
    }

    @Test
    void testReadFileWIthName() {
        // Given
        FileReader fileReader = new FileReader();
        // When
        // Then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }
}
