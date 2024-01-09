package ru.gb;

import ru.gb.positions.Articles;
import ru.gb.positions.Books;
import ru.gb.positions.Dictionaries;
import ru.gb.positions.Magazines;

public class Main {
    public static void main(String[] args) {


        ListOfPosition list = new ListOfPosition();
        View view = new View(list);

        list.addPosition(Articles.addArticle("Cтатья 1", "Автор 1"));
        list.addPosition(Articles.addArticle("Статья 2", "Автор 2"));
        list.addPosition(Articles.addArticle("Статья 3", "Автор 1"));
        list.addPosition(Books.addBook("Книга 1", "Автор 3"));
        list.addPosition(Books.addBook("Книга 2", "Автор 2"));
        list.addPosition(Dictionaries.addDictionary("Словарь 1", "Автор 1"));
        list.addPosition(Magazines.addMagazine("Журнал 1", "Автор 1"));
        list.addPosition(Magazines.addMagazine("Журнал 2", "Автор 2"));
        list.getListInfo();

        view.dialog();

    }
}