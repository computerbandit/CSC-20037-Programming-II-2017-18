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
public class queueButtonListener implements ActionListener {

    StackQueue app;

    public queueButtonListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (app.appState) {
            app.appState = false;
            app.setQueue(Stack.toQueue(app.getStack()));
            app.getCanvas().repaint();
        }
        app.updateInfo();
    }
}
