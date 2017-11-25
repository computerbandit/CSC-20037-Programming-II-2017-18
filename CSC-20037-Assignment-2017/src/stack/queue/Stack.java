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
public class Stack extends LList implements Drawable {
    
    public Stack(int max) {
        super(max);
    }

    public Node pop() {
        if (!isEmpty()) {
            Node n = head;
            head = head.getNext();
            return n;
        } else {
            return null;
        }
    }

    public void push(int data) {
        head = new Node(data, head);
    }
    
    @Override
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
            data.setXY(new Point((collumWidth * (counter / 8)) + (1 * collumWidth / 4), height - ((counter % stackHeight) * rowHeight) - rowHeight));
            data.draw(g, appRef);
            index.draw(g, appRef);
            counter++;
            n = n.getNext();
        }
    }
}
