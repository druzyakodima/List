package org.example;

import org.example.arrayList.MyArrayList;
import org.example.linkedList.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Pety");
        list.add("Vasy");
        list.add("Fedy");
        list.add("Toly");
        System.out.println(list);

        System.out.println(list.remove("Pety"));
        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.indexOf("Vasy") + "\nsize = " + list.size());

        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.add("Pety");
        linkedList.add("Vasy");
        linkedList.add("Fedy");
        linkedList.add("Toly");

        System.out.println(linkedList);

        linkedList.remove("Fedy");
        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
    }
}