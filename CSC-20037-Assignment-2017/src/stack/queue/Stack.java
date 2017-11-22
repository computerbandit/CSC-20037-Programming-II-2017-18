/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author w4f21
 */
public class Stack implements Drawable {

    private int size;
    private Node head;

    private final int MAX;

    public Stack(int max) {
        head = null;
        this.MAX = max;
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

    public void push(int data) {
        head = new Node(data, head);
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

    public boolean isFull() {
        return (size == MAX);
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
    
    public void clear(){
        Node n = pop();
        while(n!=null){
            n = pop();
        }
    }

    public static Stack reverseStack(Stack stack) {
        Node n = stack.head;
        Stack reverse = new Stack(stack.MAX);
        while (n != null) {
            reverse.push(n.getData());
            n = n.getNext();
        }
        return reverse;
    }

    public static Queue toQueue(Stack stack) {
        Queue queue = new Queue(stack.MAX);
        Node n = stack.pop();
        while (n != null) {
            queue.enQueue(n.getData());
            n = stack.pop();
        }
        return queue;
    }

    public void print() {
        System.out.print("Size: " + size + "\n");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(i + ", ");
            System.out.print(atIndex(i).getData() + "\n");
        }
        System.out.print("\n");
    }

    @Override
    public void draw(Graphics g, StackQueue appRef) {

        Canvas canvas = appRef.getCanvas();
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int max = appRef.getStack().MAX;

        int stackHeight = (max >= 8 ? 8 : max);

        int rowHeight = height / stackHeight;
        int numberOfCollums = (max % stackHeight != 0 ? (max / stackHeight) + 1 : (max / stackHeight));
        int collumWidth = width / (numberOfCollums == 0 ? 1 : numberOfCollums);
        Rect indexTemplate = new Rect(new Point(0, 0), 1 * collumWidth / 4, rowHeight, Color.darkGray, true, false, "0");
        Rect dataTemplate = new Rect(new Point(0, 0), 3 * collumWidth / 4, rowHeight, Color.lightGray, false, true, "0");
        Node n = reverseStack(appRef.getStack()).head;
        int counter = 0;
        while (n != null) {
            Rect index = indexTemplate;
            index.setText("" + counter);
            index.setXY(new Point((collumWidth * (counter / 8)), height - ((counter % stackHeight) * rowHeight) - rowHeight));
            Rect data = dataTemplate;
            data.setText("" + n.getData());
            data.setXY(new Point((collumWidth * (counter / 8)) + (1 * collumWidth / 16), height - ((counter % stackHeight) * rowHeight) - rowHeight));
            data.draw(g, appRef);
            index.draw(g, appRef);
            counter++;
            n = n.getNext();
        }
    }
}
