package doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if(length == 0) return null;
        Node temp = tail;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            temp.prev = null;
            tail.next = null;
        }        
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = head.prev;
        }        
        length++;
    }

    public Node removeFirst() {
        if(length == 0) return null;
        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }       
        length--;        
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;
        Node temp = head;
        if(index < length/2) {
            for(int i=0; i<index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i=length-1; i>index; i--) {
                temp = temp.prev;
            }
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
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public boolean isPalindrome() {
        if(length <= 1) return true;
        Node left = head;
        Node right = tail;
        for(int i=0; i<length/2; i++) {
            if(left.value != right.value) return false;
            left = left.next;
            right = right.prev;
        }
        return true;
    }

    public void reverse() {
	    Node current = head;
	    Node temp = null;
	    while(current != null) {
	        temp = current.prev;
	        current.prev = current.next;
	        current.next = temp;
	        current = current.prev;
	    }
	    temp = head;
	    head = tail;
	    tail = temp;
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
                current.prev = prev1;
                prev1 = prev1.next;
            } else if(current.value >= x) {
                prev2.next = current;
                current.prev = prev2;
                prev2 = prev2.next;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        if(dummy2.next != null) {
            dummy2.next.prev = prev1;
        }
        
        head = dummy1.next;
        head.prev = null;
    }

    public void reverseBetween(int m, int n) {
        if(head == null || m == n) return;
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;
        Node prev = dummy;
        for(int i=0; i<m; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for(int i=0; i<(n-m); i++) {
            Node toMove = current.next;
            current.next = toMove.next;
            if(toMove.next != null) {
                toMove.next.prev = current;
            }
            toMove.next = prev.next;
            prev.next.prev = toMove;
            prev.next = toMove;
            toMove.prev = prev;
        }
        head = dummy.next;
        head.prev = null;
    }

    public void swapPairs() {
        if(head == null) return;
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;
        Node prev = dummy;
        Node first = head;
        while(first != null && first.next != null) {
            Node second = first.next;
            // swapping
            prev.next = second;
            second.prev = prev;
            first.next = second.next;
            if(second.next != null) {
                second.next.prev = first;
            }
            second.next = first;
            first.prev = second;
            // move pointers
            prev = first;
            first = first.next;
        }
        head = dummy.next;
        head.prev = null;
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
