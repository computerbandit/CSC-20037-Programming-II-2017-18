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
public class emptyStackButtonListener implements ActionListener {

    StackQueue appRef;

    public emptyStackButtonListener(StackQueue appRef) {
        this.appRef = appRef;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(appRef.appState){
            appRef.getStack().clear();
            appRef.updateInfo();
            appRef.getCanvas().repaint();
        }
    }
}
