
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Curve extends Shape {

    /**
     * 
     */
    private Point p1;

    /**
     * 
     */
    private Point p2;

    /**
     * 
     */
    private Point p3;

    /**
     * 
     */
    private Point p4;

    /**
     * @param parP1 
     * @param parP2 
     * @param parP3 
     * @param parP4
     */
    public Curve(Integer parP1, Integer parP2, Integer parP3, Integer parP4) {
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

    public Point getP2() {
        return this.p2;
    }

    public Point getP3() {
        return this.p3;
    }

    public Point getP4() {
        return this.p4;
    }
}