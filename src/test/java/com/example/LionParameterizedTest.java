package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
        "Самец, true",
        "Самка, false"
    })
    void testLionHasManeBasedOnSex(String sex, boolean expectedHasMane) throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
