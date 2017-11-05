/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author w4f21
 */
public class Canvas extends JPanel {
    //this is just a quick test
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
        app.getDStack().draw(g);
    }
}
