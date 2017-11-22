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
public class Queue implements Drawable {

    private Node head;
    private int size;

    private final int MAX;

    public Queue(int MAX) {
        this.MAX = MAX;
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

    public Node peek() {
        return isEmpty() ? null : head;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return (size == MAX);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        Node n = deQueue();
        while (n != null) {
            n = deQueue();
        }
    }

    public void print() {
        System.out.print("Size: " + size + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ", ");
            System.out.print(atIndex(i).getData() + "\n");
        }
        System.out.print("\n");
    }

    public static Queue reverseQueue(Queue queue) {
        Node n = queue.head;
        Queue reverse = new Queue(queue.MAX);
        Stack stack = new Stack(queue.MAX);
        while (n != null) {
            stack.push(n.getData());
            n = n.getNext();
        }
        n = stack.peek();
        while (n != null) {
            reverse.enQueue(n.getData());
            n = n.getNext();
        }
        return reverse;
    }

    public static Stack toStack(Queue queue) {
        Stack stack = new Stack(queue.MAX);
        Node n = queue.deQueue();
        while (n != null) {
            stack.push(n.getData());
            n = queue.deQueue();
        }
        return stack;
    }

    @Override
    public void draw(Graphics g, StackQueue appRef) {

        Canvas canvas = appRef.getCanvas();
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int max = appRef.getQueue().MAX;

        int queueWidth = (max >= 8 ? 8 : max);
        int collumWidth = width / queueWidth;
        int numberOfRows = (max % queueWidth != 0 ? (max / queueWidth) + 1 : (max / queueWidth));
        int rowHeight = height / (numberOfRows == 0 ? 1 : numberOfRows);
        Rect indexTemplate = new Rect(new Point(0, 0), collumWidth, 1 * rowHeight / 3, Color.darkGray, true, false, "0");
        Rect dataTemplate = new Rect(new Point(0, 0), collumWidth, 2 * rowHeight / 3, Color.lightGray, false, false, "0");

        Node n = appRef.getQueue().head;
        int counter = 0;
        while (n != null) {
            Rect index = indexTemplate;
            index.setText("" + counter);
            index.setXY(new Point(((counter % queueWidth) * collumWidth), (counter / queueWidth) * rowHeight));
            Rect data = dataTemplate;
            data.setText("" + n.getData());
            data.setXY(new Point((collumWidth * (counter % queueWidth)), ((counter / queueWidth) * rowHeight) + 1 * rowHeight / 3));
            data.draw(g, appRef);
            index.draw(g, appRef);
            counter++;
            n = n.getNext();
        }
    }

}
