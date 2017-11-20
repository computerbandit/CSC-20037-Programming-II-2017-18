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
        Stack stack = app.getStack();
        Canvas canvas = app.getCanvas();
        if (stack.isEmpty()) {
            stack.push(new Rect(new Point(canvas.getWidth() / 2 - 100, canvas.getHeight() - 100), 200, 50, 10, false, "999"));
        } else {
            Rect peek = (Rect) stack.peek().getObject();
            stack.push(new Rect(new Point (peek.xy.getX(), peek.xy.getY() - (peek.getHeight() + 20)), peek.getWidth(), peek.getHeight(), 10, false, "999"));
        }
        canvas.repaint();
    }

}
