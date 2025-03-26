package com.kodilla.kodilla_project_patterns.singleton;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger = Logger.INSTANCE;

    @Test
    void testLog() {
        //Given
        String log = "New log";
        //When
        logger.log(log);
        //Then
        assertEquals(log, logger.getLastLog());
    }
}
