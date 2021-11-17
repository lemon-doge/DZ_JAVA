package main.java.java_dz_2;

import java.util.*;

public class myLibrary implements FilmLibrary {
    ArrayList<Film> films = new ArrayList<Film>();

    @Override
    // returns a defencive copy of the list of films
    public List<Film> findAll() {
        return new ArrayList<Film>(this.films);
    }

    @Override
    // returns a film with given id if found, null otherwise
    public Film findById(long id) {
        return films.stream().filter(x -> id == x.id())
                .findAny()
                .orElse(null);
    }

    @Override
    // returns a defencive copy of a list of all suitable films or an empty list
    public List<Film> findByTitleContaining(String titleSubstring) {
        return new ArrayList<Film>(films.stream().filter(x -> x.title().toLowerCase().contains(titleSubstring.toLowerCase())).toList());
    }

    @Override
    // saves film to library
    // if film is null - throws IllegalArgumentException
    // if film id is null adding a new instance of a film with new random id
    // if film id is not present - simply adding given film
    // else replace existing film with given
    public Film saveOne(Film film) {
        if (film == null) {
            throw new IllegalArgumentException("null film provided");
        }
        if (film.id() == null) {
            Film addFilm = new Film(getNewId(), film.title());
            films.add(addFilm);
            return addFilm;
        } else if (!isPresentId(film.id())) {
            films.add(film);
            return film;
        } else {
            for (int i = 0; i < films.size(); i++) {
                if (Objects.equals(films.get(i).id(), film.id())) {
                    films.set(i, film);
                }
            }
            return film;
        }
    }

    @Override
    public long count() {
        return films.size();
    }

    private Long getNewId() {
        Random rnd = new Random();
        long id = rnd.nextLong((long) films.size() * films.size() + 5);
        while (isPresentId(id)) {
            id = rnd.nextLong((long) films.size() * films.size() + 5);
        }
        return id;
    }

    private boolean isPresentId(Long id) {
        return films.stream().anyMatch(x -> Objects.equals(x.id(), id));
    }
}
