package stack.queue;

public abstract class LList {

    protected Node head;

    protected int MAX;

    public LList(int max) {
        head = null;
        this.MAX = max;
    }

    public Node peek() {
        return isEmpty() ? null : head;
    }

    public int size(Node head) {
        if (head == null) {
            return 0;
        } else {
            return size(head.getNext()) + 1;
        }
    }

    public boolean isEmpty() {
        return (size(head) == 0);
    }

    public boolean isFull() {
        return (size(head) == MAX);
    }

    public Node atIndex(int index) {
        if (isEmpty()) {
            return null; //
        } else if (index >= size(head)) {
            return null; //overflow error
        }
        Node n = head;
        for (int i = size(head) - 1; i >= 0; i--) {
            if (i == index) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;//underflow error;
    }

    public void clear() {
        head = null;
    }

    public void print() {
        StackQueue.log("Size: " + size(head) + "\n");
        for (int i = size(head) - 1; i >= 0; i--) {
            StackQueue.log(i + ", " + atIndex(i).getData());
        }
        System.out.print("\n");
    }

    public void setMax(int max) {
        this.MAX = max;
        if (MAX < size(head)) {
            Stack reverse = Stack.reverseStack((Stack) this);
            for (int i = 0; i < size(head) - MAX; i++) {
                reverse.pop();
            }
            head = Stack.reverseStack(reverse).head;
        }
    }

    public int getMax() {
        return MAX;
    }
}
