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
public class DNode extends Node implements Drawable {

    public DNode(Object obj, Node next) {
        super(obj, next);
    }

    public DNode getNext() {
        return (DNode) next;
    }

    @Override
    public void draw(Graphics g) {
        System.out.print("i am here \n");
        if (this.getObject() instanceof Drawable) {
            Drawable dObj = (Drawable) getObject();
            dObj.draw(g);
        }
    }
}
