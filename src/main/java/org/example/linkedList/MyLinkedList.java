package org.example.linkedList;

public class MyLinkedList<Item> {

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Node previous, Item item, Node next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private int size = 0;
    private Node first = null;
    private Node last = null;

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node currentNode = first;
        while (currentIndex < index) {
            currentIndex++;
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public Item remove(Item item) {
        Node currentNode = first;
        while (currentNode != null && !currentNode.item.equals(item)) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return null;
        }

        Node next = currentNode.next;
        Node previous = currentNode.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        currentNode.next = null;
        currentNode.previous = null;
        return currentNode.item;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            s.append(currentNode.item.toString());
            s.append(", ");
            currentNode = currentNode.next;
        }
        return s.toString();
    }

}
