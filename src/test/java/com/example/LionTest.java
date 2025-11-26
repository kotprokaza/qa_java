package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testDoesHaveMane(String sex, boolean expectedHasMane) throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void testGetKittens() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion(feline, "Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testGetKittensCallsFelineGetKittens() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();

        verify(feline, times(1)).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(feline, "Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    void testGetFoodCallsFelineEatMeat() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(feline, "Самка");
        lion.getFood();

        verify(feline, times(1)).eatMeat();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестный", "123", ""})
    void testInvalidSexThrowsException(String invalidSex) {
        Feline feline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, invalidSex));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}