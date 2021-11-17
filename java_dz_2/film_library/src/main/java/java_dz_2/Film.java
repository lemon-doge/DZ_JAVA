package main.java.java_dz_2;

public record Film(Long id, String title) {
    public Film {
        if (title == null) {
            throw new IllegalArgumentException("null title provided");
        }
    }

    public Film(Film film) {
        this(film.id(),film.title());
    }
}
