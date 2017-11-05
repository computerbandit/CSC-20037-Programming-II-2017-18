/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

/**
 *
 * @author w4f21
 */
public class Node {

    protected Node next;

    private Object obj;

    public Node(Object obj, Node next) {
        this.obj = obj;
        this.next = next;
    }

    public Object getObject() {
        return obj;
    }

    public void setObject(Object object) {
        this.obj = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
