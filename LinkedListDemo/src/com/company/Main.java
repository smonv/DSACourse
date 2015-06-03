package com.company;

import list.linked.doubly.DoublyLinkedList;
import list.linked.singly.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 3, 6, 7, 8};

        /*
        SinglyLinkedList ml = new SinglyLinkedList();
        ml.addMany(a);
        ml.addHead(10);
        ml.addTail(11);
        ml.traverse();
        ml.removeHead();
        ml.removeTail();
        ml.traverse();
        */

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addMany(a);
        dll.addHead(10);
        dll.addTail(11);
        dll.traverse();
        dll.removeHead();
        dll.removeTail();
        dll.traverse();
    }
}
