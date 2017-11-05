/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.application;

/**
 *
 * @author w4f21
 */
public abstract class Node {

    private Node next = null;
    private int index;

    //first node in the list cant have a next node so need so be null.
    public Node(Node next) {
        this.next = next;
        if (next == null) {
            this.index = 0;
        } else {
            this.index = next.getIndex() + 1;
        }
    }
    
    abstract Object getObj();
    abstract void setObj(Object obj);

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}
