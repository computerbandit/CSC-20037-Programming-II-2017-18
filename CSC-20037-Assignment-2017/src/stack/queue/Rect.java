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
    private String text = "";

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

    public void setText(String text) {
        this.text = text;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHieght(int height) {
        this.height = height;
    }

    public String getText() {
        return text;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void draw(Graphics g) {
        if (getFilled()) {
            g.fillRoundRect(xy.getX(), xy.getY(), width, height, 1, 1);
            g.drawString(text, xy.getX(), xy.getY());
        } else {
            g.drawRoundRect(xy.getX(), xy.getY(), width, height, 1, 1);
            g.drawString(text, xy.getX(), xy.getY());
        }
    }
}
