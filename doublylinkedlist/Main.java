package doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        // myDLL.getHead();
        // myDLL.getTail();
        // myDLL.getLength();
        // myDLL.printList();

        myDLL.append(11);
        // myDLL.printList();

        // 2 items: returns node 11
        System.out.println(myDLL.removeLast().value);
        // 1 item: returns node 7
        System.out.println(myDLL.removeLast().value);
        // 0 items: returns null
        System.out.println(myDLL.removeLast() + "\n");

        myDLL.append(2);
        myDLL.prepend(1);
        // myDLL.printList();

        // 2 items: returns node 1
        System.out.println(myDLL.removeFirst().value);
        // 1 item: returns node 2
        System.out.println(myDLL.removeFirst().value);
        // 0 items: returns null
        System.out.println(myDLL.removeFirst() + "\n");

        myDLL.append(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.printList();
        System.out.println("\n" + myDLL.get(1).value);
        System.out.println(myDLL.get(2).value + "\n");

        myDLL.set(2, 7);
        myDLL.printList();

        myDLL.insert(2, 5);
        System.out.println();
        myDLL.printList();

        myDLL.remove(2);
        System.out.println();
        myDLL.printList();

        myDLL.set(2, 1);
        myDLL.set(3, 0);
        System.out.println();
        myDLL.printList();
        System.out.println((myDLL.isPalindrome()));

        myDLL.set(2, 2);
        myDLL.set(3, 3);
        System.out.println();
        myDLL.printList();
        myDLL.reverse();
        System.out.println();
        myDLL.printList();

        System.out.println();
        myDLL.partitionList(1);
        myDLL.printList();

        myDLL.reverseBetween(1, 3);
        System.out.println();
        myDLL.printList();
    }  
}
