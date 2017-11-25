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
public class stackButtonListener implements ActionListener {

    StackQueue app;

    public stackButtonListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!app.appState) {
            app.appState = true;
            app.setStack(Queue.toStack(app.getQueue()));
            app.getCanvas().repaint();
        }
        app.updateInfo();
    }
}
