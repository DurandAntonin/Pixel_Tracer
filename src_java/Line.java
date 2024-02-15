import java.util.*;

/**
 * 
 */
public class Line extends Shape {
    /**
     * 
     */
    private Point p1;

    /**
     * 
     */
    private Point p2;

    /**
     * @param parP1 
     * @param parP2
     */
    public Line(Point parP1, Point parP2) {
        // TODO implement here
        super(null, null, null, null, null);
    }

    /**
     * @return
     */
    public List<Pixel> draw() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    public Point getP1() {
        return this.p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

}