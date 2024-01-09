package ru.gb;

import java.util.Iterator;
import java.util.List;

public class PositionIterator<T> implements Iterator<T> {
    private int index = 0;
    private List<T> positionList;

    public PositionIterator(List<T> positionList) {
        this.positionList = positionList;
    }

    public boolean hasNext(){
        return positionList.size() > index;
    }

    public T next(){
        return positionList.get(index++);
    }
}
