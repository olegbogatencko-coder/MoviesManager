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
        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        assertArrayEquals(expected, last);
    }

    @Test
    void shouldCreateWithCustomLimit() {
        MoviesManager manager = new MoviesManager(3);
        manager.add("A");
        manager.add("B");
        manager.add("C");
        manager.add("D");
        String[] last = manager.findLast();
        String[] expected = {"D", "C", "B"};
        assertArrayEquals(expected, last);
    }

    @Test
    void shouldReturnAllMoviesInOrder() {
        MoviesManager manager = new MoviesManager();
        manager.add("First");
        manager.add("Second");
        manager.add("Third");
        String[] all = manager.findAll();
        String[] expected = {"First", "Second", "Third"};
        assertArrayEquals(expected, all);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoMovies() {
        MoviesManager manager = new MoviesManager();
        String[] all = manager.findAll();
        assertArrayEquals(new String[0], all);
        String[] last = manager.findLast();
        assertArrayEquals(new String[0], last);
    }

    @Test
    void shouldReturnAllWhenLessThanLimit() {
        MoviesManager manager = new MoviesManager(10);
        manager.add("X");
        manager.add("Y");
        String[] last = manager.findLast();
        String[] expected = {"Y", "X"};
        assertArrayEquals(expected, last);
    }

    @Test
    void shouldReturnExactlyLimitWhenMoreThanLimit() {
        MoviesManager manager = new MoviesManager(2);
        manager.add("One");
        manager.add("Two");
        manager.add("Three");
        String[] last = manager.findLast();
        String[] expected = {"Three", "Two"};
        assertArrayEquals(expected, last);
    }
}