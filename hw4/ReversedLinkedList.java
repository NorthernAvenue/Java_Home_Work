package Java.hw4;

import java.util.LinkedList;
import java.util.ListIterator;

public class ReversedLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        LinkedList<String> reversedList = reverseLinkedList(list);
        System.out.println(reversedList);
    }

    public static LinkedList<String> reverseLinkedList(LinkedList<String> list) {
        LinkedList<String> reversedList = new LinkedList<>();
        ListIterator<String> iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            reversedList.add(iterator.previous());
        }

        return reversedList;
    }
}

