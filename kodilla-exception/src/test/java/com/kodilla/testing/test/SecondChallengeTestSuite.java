package com.kodilla.testing.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException() {
        // Given
        SecondChallenge secondChallenge = new SecondChallenge();
        // When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.5, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(-1, 2)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1.51)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1.49)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.99, 2))
        );

    }
}
