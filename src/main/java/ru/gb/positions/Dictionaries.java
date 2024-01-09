package ru.gb.positions;

import ru.gb.LibraryRepository;

public class Dictionaries extends LibraryRepository {
    public String author;
    public kindOfPosition kindOfPosition;

    private Dictionaries(String title, String author) {
        super(title);
        this.author = author;
        this.kindOfPosition = LibraryRepository.kindOfPosition.Dictionary;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public static Dictionaries addDictionary(String title, String author) throws RuntimeException{
        if (title == null){
            throw new RuntimeException("Название не указано.");
        }
        if (author == null){
            throw new RuntimeException("Автор не указан.");
        }

        return new Dictionaries(title, author);
    }

    @Override
    public String getInfo() {
        return "Название: " + title +
                ", автор: " + author +
                ", вид: " + kindOfPosition;
    }
}
