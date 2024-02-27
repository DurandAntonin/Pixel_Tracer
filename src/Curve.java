
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
    public Curve(Point parP1, Point parP2, Point parP3, Point parP4) {
        // TODO implement here
        super(null, null, null, null, null);
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        // TODO implement here
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object object){
        return false;
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

