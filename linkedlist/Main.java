package linkedlist;

public class Main {
    public static void main(String args[]) {
        LinkedList myLinkedList = new LinkedList(4);

        myLinkedList.append(7);

        // myLinkedList.getHead();
        // myLinkedList.getTail();
        //myLinkedList.getLength();
        // myLinkedList.printList();

        // 2 items: returns node 7
        System.out.println(myLinkedList.removeLast().value);
        // 1 item: returns node 4
        System.out.println(myLinkedList.removeLast().value);
        // 0 items: returns null
        System.out.println(myLinkedList.removeLast() + "\n");

        myLinkedList.append(2);
        myLinkedList.prepend(1);

        // 2 items: returns node 1
        System.out.println(myLinkedList.removeFirst().value);
        // 1 item: returns node 2
        System.out.println(myLinkedList.removeFirst().value);
        // 0 items: returns null
        System.out.println(myLinkedList.removeFirst() + "\n");

        myLinkedList.append(0);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.printList();
        System.out.println(myLinkedList.get(2).value + "\n");

        myLinkedList.set(1, 4);
        // myLinkedList.printList();

        myLinkedList.insert(2, 7);
        // myLinkedList.printList();

        myLinkedList.remove(2);
        // myLinkedList.printList();

        myLinkedList.reverse();
        myLinkedList.printList();

        System.out.println("\n" + myLinkedList.findMiddleNode().value);

        System.out.println("\n" + myLinkedList.findKthFromEnd(3).value + "\n");

        // myLinkedList.append(2);
        // myLinkedList.append(4);
        // myLinkedList.printList();
        // myLinkedList.removeDuplicates();
        // myLinkedList.printList();

        myLinkedList.prepend(7);
        myLinkedList.append(5);
        // myLinkedList.printList();
        // myLinkedList.reverseBetween(1, 3);
        myLinkedList.reverseBetween(0, 3);
        myLinkedList.printList();

        System.out.println();
        myLinkedList.partitionList(4);
        myLinkedList.printList();

        System.out.println();
        myLinkedList.swapPairs();
        myLinkedList.printList();
    }
}
