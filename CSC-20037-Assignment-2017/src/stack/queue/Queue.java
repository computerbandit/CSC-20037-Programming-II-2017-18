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
public class Queue extends LList implements Drawable {

    public Queue(int max) {
        super(max);
    }

    public Node deQueue() {
        if (!isEmpty()) {
            Node n = head;
            head = head.getNext();
            return n;
        } else {
            return null;
        }
    }

    public void enQueue(int val) throws LinkedListException{
        if (isEmpty()) {
            head = new Node(val, null);
        } else if (size(head) > 0) {
            Node tail = this.atIndex(size(head) - 1);
            tail.setNext(new Node(val, null));
        }
    }

    @Override
    public Node atIndex(int index) throws LinkedListException {
        if (isEmpty()) {
            throw new EmptyListException("The data structure is empty!");
        } else if (index >= size(head)) {
            throw new ListTraversalException("Index out of bounds of the list");
        }
        Node n = head;
        for (int i = 0; i < size(head); i++) {
            if (i == index) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        throw new ListTraversalException("Index out of bounds of the list");
    }

    public static Queue reverseQueue(Queue queue) throws LinkedListException {
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

    public static Stack toStack(Queue queue) throws LinkedListException {
        Stack stack = new Stack(queue.MAX);
        queue = Queue.reverseQueue(queue);
        Node n = queue.deQueue();
        while (n != null) {
            stack.push(n.getData());
            n = queue.deQueue();
        }
        return stack;
    }

    @Override
    public void setMax(int max) {
        this.MAX = max;
        if (MAX < size(head)) {
            Queue reverse;
            try {
                reverse = Queue.reverseQueue((Queue) this);
                for (int i = 0; i < size(head) - MAX; i++) {
                    reverse.deQueue();
                }
                head = Queue.reverseQueue(reverse).head;
            } catch (LinkedListException ex) {
                StackQueue.log(ex.getMessage());
            }
        }
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
