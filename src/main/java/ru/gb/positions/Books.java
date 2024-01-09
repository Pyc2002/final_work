package ru.gb.positions;

import ru.gb.LibraryRepository;

public class Books extends LibraryRepository {
    public String author;
    public kindOfPosition kindOfPosition;

    private Books(String title, String author) {
        super(title);
        this.author = author;
        this.kindOfPosition = LibraryRepository.kindOfPosition.Book;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public static Books addBook(String title, String author) throws RuntimeException{
        if (title == null){
            throw new RuntimeException("Название не указано.");
        }
        if (author == null){
            throw new RuntimeException("Автор не указан.");
        }

        return new Books(title, author);
    }

    @Override
    public String getInfo() {
        return  "Название: " + title +
                ", автор: " + author +
                ", вид: " + kindOfPosition;
    }
}
