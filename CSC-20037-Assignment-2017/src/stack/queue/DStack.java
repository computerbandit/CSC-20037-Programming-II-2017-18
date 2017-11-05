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
public class DStack extends Stack implements Drawable {

    private DNode head;

    public DStack() {
        super();
    }

    @Override
    public DNode pop() {
        if (!isEmpty()) {
            DNode n = head;
            head = head.getNext();
            size--;
            return n;
        } else {
            return null;
        }
    }

    @Override
    public DNode atIndex(int index) {
        if (isEmpty()) {
            return null;
        } else if (index >= size) {
            return null;
        }
        DNode n = head;
        for (int i = size - 1; i >= 0; i--) {
            if (i == index) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    @Override
    public DNode peek() {
        return isEmpty() ? null : head;
    }

    @Override
    public void push(Object obj) {
        head = new DNode(obj, head);
        size++;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = size() - 1; i >= 0; i--) {
            DNode node = this.atIndex(i);
            Drawable dObj = (Drawable) node.getObject();
            dObj.draw(g);
        }
    }
}
