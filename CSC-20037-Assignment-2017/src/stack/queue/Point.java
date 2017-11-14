package stack.queue;

public class Point {

    public static Point add(Point offset, Point xy) {
        return new Point(xy.getX() + offset.getX(), xy.getY() + offset.getY());
    }

    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
}
