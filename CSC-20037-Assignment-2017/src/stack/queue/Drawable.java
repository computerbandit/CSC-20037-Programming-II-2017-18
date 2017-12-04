
package stack.queue;

import java.awt.Graphics;

/**
 *
 * @author w4f21
 */

/*
 * Drawable interface:
 * This interface is only used once in the program (Rect class) this is however
 * only used to make any onbject drawable to a canvas.
 */
public interface Drawable {
    
    void draw(Graphics g, StackQueue appRef); // draw method dictates new drawable ojects while passing the graphics object.
    
}
