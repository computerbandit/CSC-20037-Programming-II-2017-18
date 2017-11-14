/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author w4f21
 */
public class CanvasMouseListener implements MouseListener {

    StackQueue app;

    public CanvasMouseListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        Canvas canvas = app.getCanvas();
//
//        app.getDStack().push(new Rect(e.getX(), e.getY(), 10, 10));
//
//        //app.getDStack().print();
//        canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
