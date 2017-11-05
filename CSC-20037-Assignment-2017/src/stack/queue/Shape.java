/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;


/**
 *
 * @author w4f21
 */
public abstract class Shape implements Drawable {

    protected int x, y;
    protected int color = 0x000000;
    protected boolean filled = false;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shape(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape(int x, int y, int color, boolean filled) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.filled = filled;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getColor() {
        return this.color;
    }
    
    public boolean getFilled(){
        return this.filled;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void setColor(int color){
        this.color = color;
    }
    
    
}
