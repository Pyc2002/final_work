package ru.gb;

public abstract class LibraryRepository {

    protected String title;

    public LibraryRepository(String title) {
        this.title = title;
    }


    public abstract String getAuthor();

    public enum kindOfPosition{
        Article, Book, Dictionary, Magazine
    }
    public abstract String getInfo();
}

