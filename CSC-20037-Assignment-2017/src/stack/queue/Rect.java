/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.Graphics;

/**
 *
 * @author w4f21
 */
public class Rect extends Shape implements Drawable {

    private int width, height;

    public Rect(Point xy, int w, int h, int color, boolean filled) {
        super(xy, color, filled);
        this.width = w;
        this.height = h;
    }

    public Rect(Point xy, int w, int h, int color) {
        super(xy, color);
        this.width = w;
        this.height = h;
    }

    public Rect(Point xy, int w, int h) {
        super(xy);
        this.width = w;
        this.height = h;
    }

    @Override
    public void draw(Graphics g) {
        if (getFilled()) {
            g.fillRect(xy.getX(), xy.getY(), width, height);
        } else {
            g.drawRect(xy.getX(), xy.getY(), width, height);
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHieght(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
