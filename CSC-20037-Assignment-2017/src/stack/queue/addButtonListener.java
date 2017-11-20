package stack.queue;

import java.awt.Color;
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
        
        //TODO This needs to be on Resize function need to be added
        /*this si so that the stack is repostionsned after the frame is resized insuring that the stack is in the center.*/
        
        Stack stack = app.getStack();
        Canvas canvas = app.getCanvas();
        stack.push(0);
        canvas.repaint();
    }

}
