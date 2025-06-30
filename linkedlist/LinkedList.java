package linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        // empty linked list
        if(length == 0) return null;

        // multiple node linked list
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = head;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        // single node linked list
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length) return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i=0; i<length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() { // Floyd's Tortoise and Hare algorithm
	    // if(head == null) return null;
	    // if(head.next == null) return head;
	    Node fast = head;
	    Node slow = head;
	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    return slow;
	}

    public Boolean hasLoop() {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
	    Node fast = head;
	    Node slow = head;
	    for(int i=0; i<k; i++) {
	        if(fast == null) {
	            return null;
	        }
	        fast = fast.next;
	    }
	    while(fast != null) {
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return slow;
	}

    public void removeDuplicates() {
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while(current != null) {
            num = num*2 + current.value;
            current = current.next;
        }
        return num;
    }

    public void partitionList(int x) {
        if(head == null) return;
        
        Node dummy1 = new Node(0);
        Node prev1 = dummy1;
        Node dummy2 = new Node(0);
        Node prev2 = dummy2;
        Node current = head;
        
        while(current != null) {
            if(current.value < x) {
                prev1.next = current;
                prev1 = prev1.next;
            } else if(current.value >= x) {
                prev2.next = current;
                prev2 = prev2.next;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if(head == null) return;
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        
        for(int i=0; i<startIndex; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for(int i=0; i<(endIndex-startIndex); i++) {
            Node toMove = current.next;
            current.next = toMove.next;
            toMove.next = prev.next;
            prev.next = toMove;
        }
        head = dummy.next;
    }

    public void swapPairs() {
        if(head == null) return;
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node first = head;
        
        while(first != null && first.next != null) {
            Node second = first.next;
            // swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            // move pointers
            prev = first;
            first = first.next;
        }
        head = dummy.next;
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }
}
