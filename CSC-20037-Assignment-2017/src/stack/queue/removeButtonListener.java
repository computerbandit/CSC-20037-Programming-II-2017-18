package stack.queue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class removeButtonListener implements ActionListener {

    StackQueue app;

    public removeButtonListener(StackQueue app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (app.appState) {
            if (app.getStack().isEmpty()) {
                StackQueue.log("The stack is empty!");
                app.getRemoveButton().setBackground(Color.RED);
                app.getRemoveButton().setForeground(Color.RED);
                app.getRemoveButton().repaint();
            } else {
                app.getStack().pop();
            }

            if (!app.getStack().isFull()) {
                app.getAddButton().setBackground(new Color(55, 135, 56));
                app.getAddButton().setForeground(new Color(55, 135, 56));
                app.getAddButton().repaint();
            }
        } else {
            if (app.getQueue().isEmpty()) {
                StackQueue.log("The stack is empty!");
                app.getRemoveButton().setBackground(Color.RED);
                app.getRemoveButton().setForeground(Color.RED);
                app.getRemoveButton().repaint();
            } else {
                app.getQueue().deQueue();
            }

            if (!app.getQueue().isFull()) {
                app.getAddButton().setBackground(new Color(55, 135, 56));
                app.getAddButton().setForeground(new Color(55, 135, 56));
                app.getAddButton().repaint();
            }
        }

        app.getCanvas().repaint();
    }
}
