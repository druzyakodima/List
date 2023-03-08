package org.example.arrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyArrayList<Item> {

    private int size = 0;
    private Object[] list = new Object[10];


    public int size() {
        return size;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void resize(int capacity) {
        Object[] temp = new Object[capacity];

        System.arraycopy(list, 0, temp, 0, list.length);
        list = temp;
    }

    public void add(Item item) {

        if (size == list.length) {
            resize(list.length * 2);
        }

        list[size] = item;
        size++;
    }

    public boolean remove(Item item) {
        int index = indexOf(item);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;

        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }

        return true;
    }

    public int indexOf(Item item) {

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.stream(list).filter(Objects::nonNull).toList().toString();
    }
}
