package stack.queue;


/*
  Abstract class LList:
    This is the basic body of the stack and queue subclasses.
    And could be used to make any kind of linked list.
 */
public abstract class LList {
    protected Node head;    //head is the current first NODE in the list.
    protected int MAX;      //MAX is the current maximum items allowed in the list strucute.
    
    //constructor
    public LList(int max) {
        head = null;        //head node is set to null by defualt.
        this.MAX = max;     //MAX variable set by consturctor params.
    }//end constructor
    
    //Method peek() used to return the head of the list without effecting the order.
    public Node peek() {
        return isEmpty() ? null : head; // returns null is the list is empty and returns head if not.
    }
    
    //Method size() recursive method which evaluated the number of nodes in the list.
    public int size(Node head) {
        //pass the head of the list.
        if (head == null) {
            return 0;   //finally returns 0 when the end of the list has been reached.
                        //this then will backtrack all the other returns adding up the total.
        } else {
            return size(head.getNext()) + 1;    //calling itself with the next node and adding 1 to the stack.
        }
    }

    //Method isEmpty() calls size method and returns a boolean evaluation of wheather it was 0 or not.
    public boolean isEmpty() {
        return (size(head) == 0);
    }
    
    //Method isFull() calls size and returns the boolean evlauation when compared to the MAX variable
    public boolean isFull() {
        return (size(head) == MAX);
    }
    
    //
    public Node atIndex(int index) throws LinkedListException {
        if (isEmpty()) {
            throw new EmptyListException("The data structure is empty!");
        } else if (index >= size(head)) {
            throw new ListTraversalException("Index out of bounds of the list");
        }
        Node n = head;
        for (int i = size(head) - 1; i >= 0; i--) {
            if (i == index) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        throw new ListTraversalException("Index out of bounds of the list");
    }

    public void clear() {
        head = null;
    }

    public void print() throws LinkedListException {
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
