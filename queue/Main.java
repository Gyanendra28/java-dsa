package queue;

public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(7);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.printQueue();

        System.out.println();
        myQueue.enqueue(3);
        myQueue.printQueue();
        myQueue.getLength();

        System.out.println();
        // 2 items: returns node 7
        System.out.println(myQueue.dequeue().value);
        // 1 item: returns node 3
        System.out.println(myQueue.dequeue().value);
        // 0 items: returns null
        System.out.println(myQueue.dequeue());
        myQueue.getLength();
    }
}
