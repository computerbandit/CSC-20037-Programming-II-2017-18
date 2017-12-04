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

    StackQueue appRef;

    public queueButtonListener(StackQueue appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (appRef.appState) {
            appRef.appState = false;
            try {
                appRef.setQueue(Stack.toQueue(appRef.getStack()));
            } catch (LinkedListException ex) {
                StackQueue.log(ex.getCause().getMessage());
            }
            appRef.getEmptyStackButton().setEnabled(false);
            appRef.getCanvas().repaint();
        }
        appRef.updateInfo();
    }
}
