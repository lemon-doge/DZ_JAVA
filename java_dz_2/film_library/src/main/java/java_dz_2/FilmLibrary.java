package main.java.java_dz_2;

import java.util.List;

public interface FilmLibrary {
    /**
     * @return массив всех фильмов, сохраненных в этой фильмотеке.
     * Может быть пустым.
     * Никогда не возвращает {@code null}.
     * @implNote Возвращайте копию массива. См. также
     * Item 50: Make defensive copies when needed из Effective Java
     */
    List<Film> findAll();
    /**
     * Найти фильм по идентификатору
     * @param id для поиска
     * @return найденный фильм или {@code null}, если его нет
     */
    Film findById(long id);
    /**
     * Найти все фильмы, в названии которых есть подстрока {@code titleSubstring}
     * @param titleSubstring подстрока названия фильма
     * @return найденные фильмы или пустой массив, если таких фильмов нет
     * @throws IllegalArgumentException, если {@code titleSubstring == null ||
    titleSubstring.isBlank()}
     */
    List<Film> findByTitleContaining(String titleSubstring);
    /**
     * Сохранить фильм в этой фильмотеке.
     *
     * Если {@code film.id()} возвращает не {@code null}, то заменяет фильм на
     предоставленный в аргументах,
     * то есть последующий вызов {@link #findById(long)} с тем же {@code id} вернёт
     {@code film}
     *
     * Иначе, сгенерировать уникальный идентификатор, создать новый {@link Film}, у
     которого будет установлен
     * сгенерированный {@code id} и сохранить фильм в фильмотеке
     *
     * @param film для сохранения
     * @return обновлённый или сохраненный фильм, для которого {@link Film#id()} не
    возвращает {@code null}
     * @throws IllegalArgumentException если {@code film == null}
     */
    Film saveOne(Film film);
    /**
     * @return Количество фильмов в этой фильмотеке
     */
    long count();
}