/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author w4f21
 */
public class Rect extends Shape {

    private int width, height;
    private String text = "";
    private boolean rounded = false;

    public Rect(Point xy, int w, int h, Color color, boolean filled, boolean rounded, String text) {
        super(xy, color, filled);
        this.text = text;
        this.width = w;
        this.height = h;
        this.rounded = rounded;
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

    public Point getCenter() {
        return new Point(xy.getX() + width / 2, xy.getY() + height / 2);
    }

    private boolean getRounded() {
        return rounded;
    }

    @Override
    public void draw(Graphics g, StackQueue appRef) {
        g.setColor(color);
        g.setFont(new Font("Tahoma", Font.BOLD, 18));
        if (getRounded()) {
            if (getFilled()) {
                g.fillRoundRect(xy.getX(), xy.getY(), width, height, 10, 10);
            } else {
                g.drawRoundRect(xy.getX(), xy.getY(), width, height, 10, 10);
            }
        } else {
            if (getFilled()) {
                g.fillRect(xy.getX(), xy.getY(), width, height);
            } else {
                g.drawRect(xy.getX(), xy.getY(), width, height);
            }
        }
        if (!text.isEmpty()) {
            if (color == Color.LIGHT_GRAY) {
                g.setColor(Color.darkGray);
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }
            g.drawString(text, getCenter().getX() - (text.length()), getCenter().getY());
        }
    }
}
