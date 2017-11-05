package drawing.application;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    private Color colorMain = new Color(0x000000);

    //Freehand stuff
    public static final int MAX_FREEHAND_PIXELS = 1000;
    private Color[] freehandColour = new Color[MAX_FREEHAND_PIXELS];
    private int[][] fxy = new int[MAX_FREEHAND_PIXELS][3];
    private int freehandPixelsCount = 0;
    private int freehandSize = 5;
    

    //Square Stuff;
    public static final int MAX_SQUARES = 10;
    private Color[] squareColour = new Color[MAX_SQUARES];
    private int[][] squarexy = new int[MAX_SQUARES][5];
    private int squaresCount = 0;

    DrawingApplication appRef;

    public Canvas(DrawingApplication appRef) {
        this.appRef = appRef;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void drawFreehand(Graphics g) {
        for (int i = 0; i < freehandPixelsCount; i++) {
            g.setColor(freehandColour[i]);
            g.fillRect(fxy[i][0], fxy[i][1], fxy[i][2], fxy[i][2]);
        }
        for (int i = 0; i < squaresCount; i++) {
            g.setColor(squareColour[i]);
            g.drawRect(squarexy[i][0], squarexy[i][1], squarexy[i][2], squarexy[i][3]);
        }
    }

    private void draw(Graphics g) {
        //Drawing before the grid
        drawFreehand(g);
        //drawing the canvas grid. fine or coarse
        if (appRef.getFineCheckBoxIsSelected()) {
            g.setColor(Color.LIGHT_GRAY);
            drawGrid(g, 10);
        }
        if (appRef.getCoarseCheckBoxIsSelected()) {
            g.setColor(Color.GRAY);
            drawGrid(g, 50);
        }
    }

    private void drawGrid(Graphics g, int n) {
        int w = getWidth();
        int h = getHeight();
        for (int y = 0; y < h; y++) {
            if (y % n == 0) {
                g.drawLine(0, y, w, y);
            }
        }
        for (int x = 0; x < w; x++) {
            if (x % n == 0) {
                g.drawLine(x, 0, x, h);
            }
        }
    }

    public Color[] getFreehandColour() {
        return freehandColour;
    }

    public int getFreehandSize() {
        return freehandSize;
    }

    public void setFreehandSize(int newSize) {
        freehandSize = newSize;
    }

    public void setFreehandColour(Color newColour, int index) {
        freehandColour[index] = newColour;
    }

    public int[][] getfxy() {
        return fxy;
    }

    public void setfxy(int pixelValue, int pixelIndex, int index) {
        fxy[pixelIndex][index] = pixelValue;
    }

    public int getFreehandPixelsCount() {
        return freehandPixelsCount;
    }

    public void setFreehandPixelsCount(int newPixelsCount) {
        freehandPixelsCount = newPixelsCount;
    }

    public int getSquaresCount() {
        return squaresCount;
    }

    public void setSquaresCount(int newSquaresCount) {
        squaresCount = newSquaresCount;
    }

    public void setColorMain(Color newColor) {
        colorMain = newColor;
    }

    public Color getColorMain() {
        return colorMain;
    }

    public void setSquareColour(Color newColor, int index) {
        squareColour[index] = newColor;
    }

    public void setSquareXY(int pixelValue, int pixelIndex, int index) {
        squarexy[pixelIndex][index] = pixelValue;
    }

}
