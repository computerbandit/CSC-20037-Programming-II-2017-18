package stack.queue;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author w4f21
 */

/*
 * Canvas Class:
 * The Canvas class extends JPanel and is used to call the draw functions
 * of both the stack and queue depending on the state of the program.
 */
public class Canvas extends JPanel {

    StackQueue app;

    public Canvas(StackQueue app) {
        this.app = app;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (app.appState) {
            app.getStack().draw(g, app);
        } else {
            app.getQueue().draw(g, app);
        }
    }
}
