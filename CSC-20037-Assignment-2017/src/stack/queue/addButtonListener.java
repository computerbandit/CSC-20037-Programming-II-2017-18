/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author w4f21
 */
public class addButtonListener implements ActionListener {

    StackQueue app;

    public addButtonListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        app.getDStack().push(new Rect(new Point(app.getDStack().getXY()), 100, 20, 10, true));  
        app.getCanvas().repaint();
    }

}
