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
public class reverseButtonListener implements ActionListener {

    StackQueue app;

    public reverseButtonListener(StackQueue app) {
        this.app = app;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (app.appState) {
            app.setStack(Stack.reverseStack(app.getStack()));
        } else {
            app.setQueue(Queue.reverseQueue(app.getQueue()));
        }
        app.getCanvas().repaint();
    }

}
