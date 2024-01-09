package ru.gb.positions;

import ru.gb.LibraryRepository;

public class Articles extends LibraryRepository {
    public String author;
    public kindOfPosition kindOfPosition;

    private Articles(String title, String author) {
        super(title);
        this.author = author;
        this.kindOfPosition = LibraryRepository.kindOfPosition.Article;
    }

    @Override
    public String getAuthor() {
        return author;
    }


    public static Articles addArticle(String title, String author) throws RuntimeException{
        if (title == null){
            throw new RuntimeException("Название не указано.");
        }
        if (author == null){
            throw new RuntimeException("Автор не указан.");
        }

        return new Articles(title, author);
    }

    @Override
    public String getInfo() {
        return  "Название: " + title +
                ", автор: " + author +
                ", вид: " + kindOfPosition;
    }
}
