package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoviesManagerTest {

    @Test
    void shouldCreateWithDefaultLimit() {
        MoviesManager manager = new MoviesManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        String[] last = manager.findLast();
        assertEquals(5, last.length);
        assertEquals("Film 6", last[0]);
        assertEquals("Film 5", last[1]);
        assertEquals("Film 4", last[2]);
        assertEquals("Film 3", last[3]);
        assertEquals("Film 2", last[4]);
    }

    @Test
    void shouldCreateWithCustomLimit() {
        MoviesManager manager = new MoviesManager(3);
        manager.add("A");
        manager.add("B");
        manager.add("C");
        manager.add("D");
        String[] last = manager.findLast();
        assertEquals(3, last.length);
        assertEquals("D", last[0]);
        assertEquals("C", last[1]);
        assertEquals("B", last[2]);
    }

    @Test
    void shouldReturnAllMoviesInOrder() {
        MoviesManager manager = new MoviesManager();
        manager.add("First");
        manager.add("Second");
        manager.add("Third");
        String[] all = manager.findAll();
        assertEquals(3, all.length);
        assertEquals("First", all[0]);
        assertEquals("Second", all[1]);
        assertEquals("Third", all[2]);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoMovies() {
        MoviesManager manager = new MoviesManager();
        String[] all = manager.findAll();
        assertEquals(0, all.length);
        String[] last = manager.findLast();
        assertEquals(0, last.length);
    }

    @Test
    void shouldReturnAllWhenLessThanLimit() {
        MoviesManager manager = new MoviesManager(10);
        manager.add("X");
        manager.add("Y");
        String[] last = manager.findLast();
        assertEquals(2, last.length);
        assertEquals("Y", last[0]);
        assertEquals("X", last[1]);
    }

    @Test
    void shouldReturnExactlyLimitWhenMoreThanLimit() {
        MoviesManager manager = new MoviesManager(2);
        manager.add("One");
        manager.add("Two");
        manager.add("Three");
        String[] last = manager.findLast();
        assertEquals(2, last.length);
        assertEquals("Three", last[0]);
        assertEquals("Two", last[1]);
    }
}