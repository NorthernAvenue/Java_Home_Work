package Java.hw4;

import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> line = new LinkedList<T>();

    public void enqueue(T item) {
        line.addLast(item);
    }

    public T dequeue() {
        return line.poll();
    }

    public T first() {
        return line.peek();
    }
}

class Queues {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue.first());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.first());
    }
}
