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
        if (app.appState) {
            Stack stack = app.getStack();
            if (!stack.isFull()) {
                try {
                    stack.push(Integer.parseInt(app.dataInput().isEmpty() ? "0" : app.dataInput()));
                    app.getRemoveButton().setBackground(new Color(55, 135, 56));
                    app.getRemoveButton().setForeground(new Color(55, 135, 56));
                    app.getRemoveButton().repaint();
                    //StackQueue.log("Item Pushed onto the stack");

                } catch (NumberFormatException error) {
                    StackQueue.log("Error " + error.getMessage() + ", try again...");
                }

            } else {
                StackQueue.log("The stack is full");
                app.getAddButton().setBackground(Color.RED);
                app.getAddButton().setForeground(Color.RED);
                app.getAddButton().repaint();
            }
        } else {
            Queue queue = app.getQueue();
            if (!queue.isFull()) {
                try {
                    queue.enQueue(Integer.parseInt(app.dataInput().isEmpty() ? "0" : app.dataInput()));
                    app.getRemoveButton().setBackground(new Color(55, 135, 56));
                    app.getRemoveButton().setForeground(new Color(55, 135, 56));
                    app.getRemoveButton().repaint();
                    //StackQueue.log("Item Pushed onto the stack");

                } catch (NumberFormatException error) {
                    StackQueue.log("Error " + error.getMessage() + ", try again...");
                }

            } else {
                StackQueue.log("The stack is full");
                app.getAddButton().setBackground(Color.RED);
                app.getAddButton().setForeground(Color.RED);
                app.getAddButton().repaint();
            }

        }
        app.getCanvas().repaint();
    }

}
