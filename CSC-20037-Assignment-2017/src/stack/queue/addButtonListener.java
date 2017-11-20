package stack.queue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if (!stack.isFull()) {
            Canvas canvas = app.getCanvas();
            try {
                stack.push(Integer.parseInt(app.dataInput().isEmpty() ? "0" : app.dataInput()));
                //StackQueue.log("Item Pushed onto the stack");

            } catch (NumberFormatException error) {
                StackQueue.log("Error " + error.getMessage() + ", try again...");
            }

            canvas.repaint();
        }else{
            StackQueue.log("Stack is full");
        }
    }

}
