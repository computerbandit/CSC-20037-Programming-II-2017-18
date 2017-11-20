/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.Graphics;

/**
 *
 * @author w4f21
 */
public class Stack implements Drawable{

    private int size;
    private Node head;

    public Stack() {
        head = null;
    }

    public Node pop() {
        if (!isEmpty()) {
            Node n = head;
            head = head.getNext();
            size--;
            return n;
        } else {
            return null;
        }
    }

    public void push(Object obj) {
        head = new Node(obj, head);
        size++;
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

    public Node atIndex(int index) {
        if (isEmpty()) {
            return null; //
        } else if (index >= size) {
            return null; //overflow error
        }
        Node n = head;
        for (int i = size - 1; i >= 0; i--) {
            if (i == index) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;//underflow error;
    }

    public void print() {
        System.out.print("Size: " + size + "\n");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(i + ", ");
            System.out.print(atIndex(i).getObject() + "\n");
        }
        System.out.print("\n");
    }

    @Override
    public void draw(Graphics g, StackQueue appRef) {
        Node n = head;

        while(n!=null){
            
            n = n.getNext();
        }
    }
}
