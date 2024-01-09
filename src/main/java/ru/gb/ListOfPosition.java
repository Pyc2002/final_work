package ru.gb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOfPosition implements Iterable<LibraryRepository>{
    private List<LibraryRepository> positionList;

    public ListOfPosition() {
        positionList = new ArrayList<>();
    }

    public void addPosition(LibraryRepository position){
        positionList.add(position);
    }

    public void findById(int id) {
        if (id >= 0 && id < positionList.size()) {
            System.out.println(positionList.get(id).getInfo());
        }
    }

    public void findByAuthor(String author) {
        List<LibraryRepository> result = new ArrayList<>();

        for (LibraryRepository item : positionList) {
            if (item.getAuthor().equals(author)) {
                System.out.println(item.getInfo());
                result.add(item);
            }
        }
    }

    public void getListInfo(){
        for (LibraryRepository item : positionList) {
            System.out.println("Индекс: " + positionList.indexOf(item) + ", " + item.getInfo());
        }
        System.out.println();
    }

    /**
     * Метод, использующий свой Iterator PositionIterator
     * @return - возвращает инициализированный компоратор PositionIterator для колликции позиций
     */
    @Override
    public Iterator<LibraryRepository> iterator() {
        return new PositionIterator<>(positionList);
    }
}
