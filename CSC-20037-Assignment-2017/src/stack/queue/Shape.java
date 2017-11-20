/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

import java.awt.Color;


/**
 *
 * @author w4f21
 */
public abstract class Shape implements Drawable {

    protected Point xy;
    protected Color color;
    protected boolean filled = false;

    public Shape(Point xy) {
        this.xy = xy;
    }

    public Shape(Point xy, Color color) {
        this.xy = xy;
        this.color = color;
    }

    public Shape(Point xy, Color color, boolean filled) {
        this.xy = xy;
        this.color = color;
        this.filled = filled;
    }

    public Point getXY() {
        return this.xy;
    }

    public Color getColor() {
        return this.color;
    }
    
    public boolean getFilled(){
        return this.filled;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setXY(Point xy){
        this.xy = xy;
    }
}
