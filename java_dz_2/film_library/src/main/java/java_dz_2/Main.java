package main.java.java_dz_2;

public class Main {

    public static void main(String[] args) {
        myLibrary library = new myLibrary();

        System.out.println(library.saveOne(new Film(null, "Остров Сокровищ")));
        library.saveOne(new Film(null, "Грань будущего"));
        library.saveOne(new Film(null, "Элизиум"));
        library.saveOne(new Film(null, "Эквилибриум"));
        library.saveOne(new Film(null, "Начало"));
        library.saveOne(new Film(null, "Тихоокеанский рубеж"));

        for (Film film : library.findAll()
             ) {
            System.out.println(film);
        }

    }
}
