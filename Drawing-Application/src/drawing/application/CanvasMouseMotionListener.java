package drawing.application;

import java.awt.event.MouseEvent;

public class CanvasMouseMotionListener implements java.awt.event.MouseMotionListener {

    DrawingApplication appRef;

    public CanvasMouseMotionListener(DrawingApplication appRef) {
        this.appRef = appRef;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        String mousePos = String.format("%04dpx, %04dpx", e.getX(), e.getY());
        appRef.getMousePosLabel().setText(mousePos);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Canvas canvas = appRef.getCanvas();
        int xpos = e.getX();
        int ypos = e.getY();

        if (appRef.getFreehandTool()) {
            int freehandPixelsCount = canvas.getFreehandPixelsCount();
            canvas.setFreehandColour(canvas.getColorMain(), freehandPixelsCount);
            canvas.setfxy(xpos, freehandPixelsCount, 0);
            canvas.setfxy(ypos, freehandPixelsCount, 1);
            canvas.setfxy(canvas.getFreehandSize(), freehandPixelsCount, 2);
            if (freehandPixelsCount + 1 >= Canvas.MAX_FREEHAND_PIXELS) {
                canvas.setFreehandPixelsCount(0);
            } else {
                canvas.setFreehandPixelsCount(freehandPixelsCount + 1);
            }
        }

        mouseMoved(e);
        canvas.repaint();
    }
}
