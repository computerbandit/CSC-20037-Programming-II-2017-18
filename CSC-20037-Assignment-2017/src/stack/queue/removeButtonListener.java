package stack.queue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeButtonListener implements ActionListener {

    StackQueue app;

    public removeButtonListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        app.getStack().pop();
        app.getCanvas().repaint();
    }
}
