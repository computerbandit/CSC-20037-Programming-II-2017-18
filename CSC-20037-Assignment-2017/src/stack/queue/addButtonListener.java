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
        Stack stack = app.getStack();
        Canvas canvas = app.getCanvas();
        if(stack.isEmpty()){
            stack.push(new Rect(new Point(canvas.getWidth()/2 - 100, canvas.getHeight() - 50), 200, 100));
        }else{
            
        }
        canvas.repaint();
    }

}
