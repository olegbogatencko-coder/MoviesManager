package ru.netology;

public class MoviesManager {
    private String[] movies;
    private int limit;

    public MoviesManager() {
        this(5);
    }

    public MoviesManager(int limit) {
        this.limit = limit;
        this.movies = new String[0];
    }

    public void add(String movie) {
        String[] newMovies = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultSize = Math.min(movies.length, limit);
        String[] result = new String[resultSize];
        for (int i = 0; i < resultSize; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}