package drawing.application;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CanvasMouseListener implements MouseListener {

    DrawingApplication appRef;

    public CanvasMouseListener(DrawingApplication appRef) {
        this.appRef = appRef;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Canvas canvas = appRef.getCanvas();
        int xpos = e.getX();
        int ypos = e.getY();

        if (appRef.getFreehandTool()) {
            int freehandPixelsCount = canvas.getFreehandPixelsCount();
            canvas.setFreehandColour(canvas.getColorMain(), freehandPixelsCount);
            canvas.setfxy(xpos, freehandPixelsCount, 0);
            canvas.setfxy(ypos, freehandPixelsCount, 1);
            canvas.setfxy(canvas.getFreehandSize(), freehandPixelsCount, 2);
            if (freehandPixelsCount + 1 > Canvas.MAX_FREEHAND_PIXELS) {
                canvas.setFreehandPixelsCount(0);
            } else {
                canvas.setFreehandPixelsCount(freehandPixelsCount + 1);
            }
        }else if(appRef.getShapeTool()){
            int squaresCount = canvas.getSquaresCount();
            canvas.setSquareColour(canvas.getColorMain(), squaresCount);
            canvas.setSquareXY(xpos, squaresCount, 0);
            canvas.setSquareXY(ypos, squaresCount, 1);
            canvas.setSquareXY(100, squaresCount, 2);
            canvas.setSquareXY(200, squaresCount, 3);

            if (squaresCount + 1 > Canvas.MAX_SQUARES) {
                canvas.setSquaresCount(0);
            } else {
                canvas.setSquaresCount(squaresCount + 1);
            }
            
        }
        
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
