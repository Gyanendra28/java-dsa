package stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        myStack.getTop();
        myStack.getHeight();
        myStack.printStack();

        System.out.println();
        myStack.push(1);
        myStack.printStack();
        myStack.getHeight();

        System.out.println();
        myStack.pop();
        myStack.printStack();
        myStack.getHeight();
    }
}
