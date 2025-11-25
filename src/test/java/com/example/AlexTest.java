package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlexTest {
    
    @Test
    void testGetFriends() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }
    
    @Test
    void testGetPlaceOfLiving() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
    
    @Test
    void testGetKittensReturnsZero() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }
    
    @Test
    void testAlexIsMale() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }
}
