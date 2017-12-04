package stack.queue;


/*
  Abstract class LList:
    This is the basic body of the stack and queue subclasses.
    And could be used to make any kind of linked list.
 */
public abstract class LList {
    protected Node head;    //head is the current first NODE in the list.
    protected int MAX;      //MAX is the current maximum items allowed in the list strucute.
    
    //constructor(int)
    public LList(int max) {
        head = null;        //head node is set to null by defualt.
        this.MAX = max;     //MAX variable set by consturctor params.
    }//end constructor
    
    //Method peek() used to return the head of the list without effecting the order.
    public Node peek() {
        return isEmpty() ? null : head; // returns null is the list is empty and returns head if not.
    }
    
    //Method size(Node) recursive method which evaluated the number of nodes in the list.
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
    
    //Method atIndex(int) this method returns the node at a given index. **IMPORTANT**
    public Node atIndex(int index) throws LinkedListException {
        if (isEmpty()) {    //if the list is empty then the the exeption will hadle it.
            throw new EmptyListException("The data structure is empty!");
        } else if (index >= size(head)) { //if the index is outside the bounds of the list then it is handled
            throw new ListTraversalException("Index out of bounds of the list");
        }
        Node n = head;                                      //gets the head of the list and assigns it to a new Node object .
        for (int i = size(head) - 1; i >= 0; i--) {         //loop through i from the (size of the list - 1)down to 0.
            if (i == index) {                               //if the index is equal to the current value of i then return the current node
                return n;
            } else {                                        //else the next node overrides the current node.
                n = n.getNext();
            }
        }
        throw new ListTraversalException("Index out of bounds of the list"); //if the list some how did not return a value then this is handled 
    }

    //Method clear() this method dereferances the head of the list which means that the entire list will be destroyed in the system.gc
    public void clear() {
        head = null;
    }
    
    //Method print() this method is used to log out the data in the list.
    public void print() throws LinkedListException {
        StackQueue.log("Size: " + size(head) + "\n");           //prints the size of the list
        for (int i = size(head) - 1; i >= 0; i--) {             
            StackQueue.log(i + ", " + atIndex(i).getData());    //prints each item in the list.
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
