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
public class Queue {

    private Node head;
    private int size;

    public Queue() {
        head = null;
        size = 0;
    }

    public Node deQueue() {
        if (!isEmpty()) {
            Node n = head;
            head = head.getNext();
            size--;
            return n;
        } else {
            return null;
        }
    }

    public void enQueue(int val) {
        if (isEmpty()) {
            head = new Node(val, null);
        } else if (size > 0) {
            Node tail = this.atIndex(size - 1);
            tail.setNext(new Node(val, null));
        }
        size++;
    }

    public Node atIndex(int index) {
        if (isEmpty()) {
            return null;
        } else if (index >= size) {
            return null;
        }
        Node n = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    public int find(Object obj) {
        if (isEmpty()) {
            return -2;
        }
        Node n = head;
        for (int i = 0; i < size; i++) {
            if (n.getObject() == obj) {
                return i;
            } else {
                n = n.getNext();
            }
        }
        return -1;
    }

    public Node peek() {
        return isEmpty() ? null : head;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void print() {
        System.out.print("Size: " + size + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ", ");
            System.out.print(atIndex(i).getObject() + "\n");
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        System.out.print("Test\n");

        q.print();

    }

}
