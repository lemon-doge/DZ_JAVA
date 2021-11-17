package test.java;

import main.java.java_dz_2.Film;
import main.java.java_dz_2.myLibrary;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class myLibraryTest {
    myLibrary library = new myLibrary();

    @Test
    // normal test
    public void findAllNormal() {
        ArrayList<Film> expected = new ArrayList<Film>();
        expected.add(new Film(1L, "Чебурек"));
        expected.add(new Film(2L, "Чебурек"));
        expected.add(new Film(3L, "Чебурек"));

        for (var film : expected
        ) {
            library.saveOne(film);
        }

        Assert.assertEquals(expected, library.findAll());
        Assert.assertEquals(3, library.count());
    }

    @Test
    // nothing added
    public void findAllNothing() {
        ArrayList<Film> films = new ArrayList<Film>();

        Assert.assertEquals(films, library.findAll());
        Assert.assertEquals(films.size(), library.count());
    }

    @Test
    // adding a film with given id, looking for it
    public void findByIdSimple() {
        Film expected = library.saveOne(new Film(1L, "Грань будущего"));
        Film actual = library.findById(1L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    // adding multiple films, one with given id, looking for it
    public void findByIdMultiple() {
        library.saveOne(new Film(null, "Элизиум"));
        library.saveOne(new Film(null, "Эквилибриум"));
        library.saveOne(new Film(null, "Начало"));
        library.saveOne(new Film(null, "Тихоокеанский рубеж"));
        Film expected = library.saveOne(new Film(1L, "Грань будущего"));
        Film actual = library.findById(1L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    // adding multiple films with given id, looking for the last one added
    public void findByIdOverride() {
        library.saveOne(new Film(1L, "Чебурек"));
        Film expected = library.saveOne(new Film(1L, "Грань будущего"));
        Film actual = library.findById(1L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    // adding one film, looking for it
    public void findByTitleContainingSimple() {
        Film expected = library.saveOne(new Film(1L, "Грань будущего"));
        var actual = library.findByTitleContaining("Грань");

        Assert.assertEquals(actual.get(0), expected);
        Assert.assertEquals(1, actual.size());
    }

    @Test
    // adding multiple films, looking for them
    public void findByTitleContainingMultiple() {
        var expected = new ArrayList<Film>();

        expected.add(new Film(1L, "Элизиум"));
        expected.add(new Film(2L, "Эквилибриум"));
        expected.add(new Film(4L, "приключения Эльзы"));

        for (var film : expected
        ) {
            library.saveOne(film);
        }

        library.saveOne(new Film(null, "Начало"));
        library.saveOne(new Film(null, "Тихоокеанский рубеж"));

        var actual = library.findByTitleContaining("Э");

        Assert.assertEquals(actual, expected);
    }

    @Test
    // adding a single film with given id to empty lib
    public void saveOneSingle() {
        Film expected = new Film(1L, "Грань будущего");
        Film actual = library.saveOne(new Film(1L, "Грань будущего"));

        Assert.assertEquals(expected, actual);
    }

    @Test
    // adding a film with the same id as the previous one
    public void saveOneOverride() {
        Film expected = new Film(1L, "Грань будущего");
        library.saveOne(new Film(1L, "Чебурек"));
        Film actual = library.saveOne(new Film(1L, "Грань будущего"));

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(1, library.count());
    }

    @Test
    // adding a film with null id
    public void saveOneNullId() {
        Film actual = library.saveOne(new Film(null, "Грань будущего"));

        Assert.assertEquals("Грань будущего", library.findByTitleContaining("Грань").get(0).title());
        Assert.assertEquals(1, library.findByTitleContaining("Грань").size());
    }

    @Test
    // adding a film with null title
    public void saveOneNullTitle() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            library.saveOne(new Film(1L, null));
        });
    }

    @Test
    // simple count test
    public void countSimple() {
        library.saveOne(new Film(null, "Грань будущего"));
        library.saveOne(new Film(null, "Элизиум"));
        library.saveOne(new Film(null, "Эквилибриум"));

        Long actual = library.count();
        Long expected = 3L;

        Assert.assertEquals(expected, actual);
    }

    @Test
    // zero count test
    public void countZero() {
        Long actual = library.count();
        Long expected = 0L;
        Assert.assertEquals(expected, actual);
    }
}