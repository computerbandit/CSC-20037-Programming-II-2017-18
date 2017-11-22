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
public class removeAllButtonListener implements ActionListener {

    StackQueue app;

    public removeAllButtonListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(app.appState){
            app.getStack().clear();
        }else{
            app.getQueue().clear();
        }
        StackQueue.log("Data Cleared!");
        app.getCanvas().repaint();
    }

}
