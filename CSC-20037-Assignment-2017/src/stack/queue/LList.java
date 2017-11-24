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
        System.out.print("Size: " + size(head) + "\n");
        for (int i = size(head) - 1; i >= 0; i--) {
            System.out.print(i + ", ");
            System.out.print(atIndex(i).getData() + "\n");
        }
        System.out.print("\n");
    }

}
